package dev.vulcanium.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class VulcaniumCore {
    public VulcaniumCore() {
    }

    public static void main(String[] args) {
        if (Path.of("").toAbsolutePath().toString().contains("!")) {
            System.err.println("VulcaniumCore may not run in a directory containing '!'. Please rename the affected folder.");
            System.exit(1);
        }

        URL[] classpathUrls = setupClasspath();
        ClassLoader parentClassLoader = VulcaniumCore.class.getClassLoader().getParent();
        URLClassLoader classLoader = new URLClassLoader(classpathUrls, parentClassLoader);
        String mainClassName = findMainClass();
        System.out.println("Starting " + mainClassName);
        Thread runThread = new Thread(() -> {
            try {
                Class<?> mainClass = Class.forName(mainClassName, true, classLoader);
                MethodHandle mainHandle = MethodHandles.lookup().findStatic(mainClass, "main", MethodType.methodType(Void.TYPE, String[].class)).asFixedArity();
                mainHandle.invoke(args);
            } catch (Throwable var5) {
                try {
                    throw Util.<Throwable>sneakyThrow(var5);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }, "ServerMain");
        runThread.setContextClassLoader(classLoader);
        runThread.start();
    }

    private static URL[] setupClasspath() {
        Path repoDir = Path.of(System.getProperty("bundlerRepoDir", ""));
        PatchEntry[] patches = findPatches();
        DownloadContext downloadContext = findDownloadContext();
        if (patches.length > 0 && downloadContext == null) {
            throw new IllegalArgumentException("patches.list file found without a corresponding original-url file");
        } else {
            Path baseFile;
            if (downloadContext != null) {
                try {
                    downloadContext.download(repoDir);
                } catch (IOException var9) {
                    throw Util.fail("Failed to download original jar", var9);
                }

                baseFile = downloadContext.getOutputFile(repoDir);
            } else {
                baseFile = null;
            }

            Map<String, Map<String, URL>> classpathUrls = extractAndApplyPatches(baseFile, patches, repoDir);
            if (Boolean.getBoolean("paperclip.patchonly")) {
                System.exit(0);
            }

            Collection<URL> versionUrls = ((Map)classpathUrls.get("versions")).values();
            Collection<URL> libraryUrls = ((Map)classpathUrls.get("libraries")).values();
            URL[] emptyArray = new URL[0];
            URL[] urls = new URL[versionUrls.size() + libraryUrls.size()];
            System.arraycopy(versionUrls.toArray(emptyArray), 0, urls, 0, versionUrls.size());
            System.arraycopy(libraryUrls.toArray(emptyArray), 0, urls, versionUrls.size(), libraryUrls.size());
            return urls;
        }
    }

    private static PatchEntry[] findPatches() {
        InputStream patchListStream = VulcaniumCore.class.getResourceAsStream("/META-INF/patches.list");
        if (patchListStream == null) {
            return new PatchEntry[0];
        } else {
            try {
                InputStream var1 = patchListStream;

                PatchEntry[] var2;
                try {
                    var2 = PatchEntry.parse(new BufferedReader(new InputStreamReader(patchListStream)));
                } catch (Throwable var5) {
                    if (patchListStream != null) {
                        try {
                            var1.close();
                        } catch (Throwable var4) {
                            var5.addSuppressed(var4);
                        }
                    }

                    throw var5;
                }

                if (patchListStream != null) {
                    patchListStream.close();
                }

                return var2;
            } catch (IOException var6) {
                throw Util.fail("Failed to read patches.list file", var6);
            }
        }
    }

    private static DownloadContext findDownloadContext() {
        String line;
        try {
            line = Util.readResourceText("/META-INF/download-context");
        } catch (IOException var2) {
            throw Util.fail("Failed to read download-context file", var2);
        }

        return DownloadContext.parseLine(line);
    }

    private static FileEntry[] findVersionEntries() {
        return findFileEntries("versions.list");
    }

    private static FileEntry[] findLibraryEntries() {
        return findFileEntries("libraries.list");
    }

    private static FileEntry[] findFileEntries(String fileName) {
        InputStream libListStream = VulcaniumCore.class.getResourceAsStream("/META-INF/" + fileName);
        if (libListStream == null) {
            return null;
        } else {
            try {
                InputStream var2 = libListStream;

                FileEntry[] var3;
                try {
                    var3 = FileEntry.parse(new BufferedReader(new InputStreamReader(libListStream)));
                } catch (Throwable var6) {
                    if (libListStream != null) {
                        try {
                            var2.close();
                        } catch (Throwable var5) {
                            var6.addSuppressed(var5);
                        }
                    }

                    throw var6;
                }

                if (libListStream != null) {
                    libListStream.close();
                }

                return var3;
            } catch (IOException var7) {
                throw Util.fail("Failed to read " + fileName + " file", var7);
            }
        }
    }

    private static String findMainClass() {
        String mainClassName = System.getProperty("bundlerMainClass");
        if (mainClassName != null) {
            return mainClassName;
        } else {
            try {
                return Util.readResourceText("/META-INF/main-class");
            } catch (IOException var2) {
                throw Util.fail("Failed to read main-class file", var2);
            }
        }
    }

    private static Map<String, Map<String, URL>> extractAndApplyPatches(Path originalJar, PatchEntry[] patches, Path repoDir) {
        if (originalJar == null && patches.length > 0) {
            throw new IllegalArgumentException("Patch data found without patch target");
        } else {
            Map<String, Map<String, URL>> urls = extractFiles(patches, originalJar, repoDir);
            applyPatches(urls, patches, originalJar, repoDir);
            return urls;
        }
    }

    private static Map<String, Map<String, URL>> extractFiles(PatchEntry[] patches, Path originalJar, Path repoDir) {
        HashMap<String, Map<String, URL>> urls = new HashMap();

        try {
            FileSystem originalJarFs;
            if (originalJar == null) {
                originalJarFs = null;
            } else {
                originalJarFs = FileSystems.newFileSystem(originalJar);
            }

            try {
                Path originalRootDir;
                if (originalJarFs == null) {
                    originalRootDir = null;
                } else {
                    originalRootDir = originalJarFs.getPath("/");
                }

                HashMap<String, URL> versionsMap = new HashMap();
                urls.putIfAbsent("versions", versionsMap);
                FileEntry[] versionEntries = findVersionEntries();
                extractEntries(versionsMap, patches, originalRootDir, repoDir, versionEntries, "versions");
                FileEntry[] libraryEntries = findLibraryEntries();
                HashMap<String, URL> librariesMap = new HashMap();
                urls.putIfAbsent("libraries", librariesMap);
                extractEntries(librariesMap, patches, originalRootDir, repoDir, libraryEntries, "libraries");
            } finally {
                if (originalJarFs != null) {
                    originalJarFs.close();
                }

            }

            return urls;
        } catch (IOException var14) {
            throw Util.fail("Failed to extract jar files", var14);
        }
    }

    private static void extractEntries(Map<String, URL> urls, PatchEntry[] patches, Path originalRootDir, Path repoDir, FileEntry[] entries, String targetName) throws IOException {
        if (entries != null) {
            String targetPath = "/META-INF/" + targetName;
            Path targetDir = repoDir.resolve(targetName);
            FileEntry[] var8 = entries;
            int var9 = entries.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                FileEntry entry = var8[var10];
                entry.extractFile(urls, patches, targetName, originalRootDir, targetPath, targetDir);
            }

        }
    }

    private static void applyPatches(Map<String, Map<String, URL>> urls, PatchEntry[] patches, Path originalJar, Path repoDir) {
        if (patches.length != 0) {
            if (originalJar == null) {
                throw new IllegalStateException("Patches provided without patch target");
            } else {
                try {
                    FileSystem originalFs = FileSystems.newFileSystem(originalJar);

                    try {
                        Path originalRootDir = originalFs.getPath("/");
                        PatchEntry[] var6 = patches;
                        int var7 = patches.length;

                        for(int var8 = 0; var8 < var7; ++var8) {
                            PatchEntry patch = var6[var8];
                            patch.applyPatch(urls, originalRootDir, repoDir);
                        }
                    } catch (Throwable var11) {
                        if (originalFs != null) {
                            try {
                                originalFs.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (originalFs != null) {
                        originalFs.close();
                    }

                } catch (IOException var12) {
                    throw Util.fail("Failed to apply patches", var12);
                }
            }
        }
    }
}
