package dev.vulcanium.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;

record FileEntry(byte[] hash, String id, String path) {
    FileEntry(byte[] hash, String id, String path) {
        this.hash = hash;
        this.id = id;
        this.path = path;
    }

    static FileEntry[] parse(BufferedReader reader) throws IOException {
        FileEntry[] result = new FileEntry[8];

        int index;
        String line;
        FileEntry data;
        for(index = 0; (line = reader.readLine()) != null; result[index++] = data) {
            data = parseLine(line);
            if (index == result.length) {
                result = (FileEntry[])Arrays.copyOf(result, index * 2);
            }
        }

        if (index != result.length) {
            return (FileEntry[])Arrays.copyOf(result, index);
        } else {
            return result;
        }
    }

    private static FileEntry parseLine(String line) {
        String[] parts = line.split("\t");
        if (parts.length != 3) {
            throw new IllegalStateException("Malformed library entry: " + line);
        } else {
            return new FileEntry(Util.fromHex(parts[0]), parts[1], parts[2]);
        }
    }

    void extractFile(Map<String, URL> urls, PatchEntry[] patches, String targetName, Path originalRootDir, String baseDir, Path outputDir) throws IOException {
        PatchEntry[] var7 = patches;
        int var8 = patches.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            PatchEntry patch = var7[var9];
            if (patch.location().equals(targetName) && patch.outputPath().equals(this.path)) {
                return;
            }
        }

        Path outputFile = outputDir.resolve(this.path);
        if (Files.exists(outputFile, new LinkOption[0]) && Util.isFileValid(outputFile, this.hash)) {
            urls.put(this.path, outputFile.toUri().toURL());
        } else {
            String var10000 = Util.endingSlash(baseDir);
            String filePath = var10000 + this.path;
            InputStream fileStream = FileEntry.class.getResourceAsStream(filePath);
            if (fileStream == null) {
                if (originalRootDir == null) {
                    throw new IllegalStateException(this.path + " not found in our jar, and no original jar provided");
                }

                Path originalFile = originalRootDir.resolve(filePath);
                if (Files.notExists(originalFile, new LinkOption[0])) {
                    throw new IllegalStateException(this.path + " not found in our jar or in the original jar");
                }

                fileStream = Files.newInputStream(originalFile);
            }

            if (!Files.isDirectory(outputFile.getParent(), new LinkOption[0])) {
                Files.createDirectories(outputFile.getParent());
            }

            Files.deleteIfExists(outputFile);
            InputStream stream = fileStream;

            try {
                ReadableByteChannel inputChannel = Channels.newChannel(stream);

                try {
                    FileChannel outputChannel = FileChannel.open(outputFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

                    try {
                        outputChannel.transferFrom(inputChannel, 0L, Long.MAX_VALUE);
                    } catch (Throwable var18) {
                        if (outputChannel != null) {
                            try {
                                outputChannel.close();
                            } catch (Throwable var17) {
                                var18.addSuppressed(var17);
                            }
                        }

                        throw var18;
                    }

                    if (outputChannel != null) {
                        outputChannel.close();
                    }
                } catch (Throwable var19) {
                    if (inputChannel != null) {
                        try {
                            inputChannel.close();
                        } catch (Throwable var16) {
                            var19.addSuppressed(var16);
                        }
                    }

                    throw var19;
                }

                if (inputChannel != null) {
                    inputChannel.close();
                }
            } catch (Throwable var20) {
                if (fileStream != null) {
                    try {
                        stream.close();
                    } catch (Throwable var15) {
                        var20.addSuppressed(var15);
                    }
                }

                throw var20;
            }

            if (fileStream != null) {
                fileStream.close();
            }

            if (!Util.isFileValid(outputFile, this.hash)) {
                throw new IllegalStateException("Hash check failed for extract filed " + outputFile);
            } else {
                urls.put(this.path, outputFile.toUri().toURL());
            }
        }
    }

    public byte[] hash() {
        return this.hash;
    }

    public String id() {
        return this.id;
    }

    public String path() {
        return this.path;
    }
}
