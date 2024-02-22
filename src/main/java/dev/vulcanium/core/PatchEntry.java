package dev.vulcanium.core;

import io.sigpipe.jbsdiff.InvalidHeaderException;
import io.sigpipe.jbsdiff.Patch;
import org.apache.commons.compress.compressors.CompressorException;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;

record PatchEntry(String location, byte[] originalHash, byte[] patchHash, byte[] outputHash, String originalPath, String patchPath, String outputPath) {
    private static boolean announced = false;

    PatchEntry(String location, byte[] originalHash, byte[] patchHash, byte[] outputHash, String originalPath, String patchPath, String outputPath) {
        this.location = location;
        this.originalHash = originalHash;
        this.patchHash = patchHash;
        this.outputHash = outputHash;
        this.originalPath = originalPath;
        this.patchPath = patchPath;
        this.outputPath = outputPath;
    }

    static PatchEntry[] parse(BufferedReader reader) throws IOException {
        PatchEntry[] result = new PatchEntry[8];
        int index = 0;

        String line;
        while((line = reader.readLine()) != null) {
            PatchEntry data = parseLine(line);
            if (data != null) {
                if (index == result.length) {
                    result = (PatchEntry[])Arrays.copyOf(result, index * 2);
                }

                result[index++] = data;
            }
        }

        if (index != result.length) {
            return (PatchEntry[])Arrays.copyOf(result, index);
        } else {
            return result;
        }
    }

    private static PatchEntry parseLine(String line) {
        if (line.isBlank()) {
            return null;
        } else if (line.startsWith("#")) {
            return null;
        } else {
            String[] parts = line.split("\t");
            if (parts.length != 7) {
                throw new IllegalStateException("Invalid patch data line: " + line);
            } else {
                return new PatchEntry(parts[0], Util.fromHex(parts[1]), Util.fromHex(parts[2]), Util.fromHex(parts[3]), parts[4], parts[5], parts[6]);
            }
        }
    }

    void applyPatch(Map<String, Map<String, URL>> urls, Path originalRootDir, Path repoDir) throws IOException {
        Path inputDir = originalRootDir.resolve("META-INF").resolve(this.location);
        Path targetDir = repoDir.resolve(this.location);
        Path inputFile = inputDir.resolve(this.originalPath);
        Path outputFile = targetDir.resolve(this.outputPath);
        if (Files.exists(outputFile, new LinkOption[0]) && Util.isFileValid(outputFile, this.outputHash)) {
            ((Map)urls.get(this.location)).put(this.originalPath, outputFile.toUri().toURL());
        } else {
            if (!announced) {
                System.out.println("Applying patches");
                announced = true;
            }

            if (Files.notExists(inputFile, new LinkOption[0])) {
                throw new IllegalStateException("Input file not found: " + inputFile);
            } else if (!Util.isFileValid(inputFile, this.originalHash)) {
                throw new IllegalStateException("Hash check of input file failed for " + inputFile);
            } else {
                String var10000 = Util.endingSlash(this.location);
                String fullPatchPath = "/META-INF/" + var10000 + this.patchPath;
                InputStream patchStream = PatchEntry.class.getResourceAsStream(fullPatchPath);
                if (patchStream == null) {
                    throw new IllegalStateException("Patch file not found: " + fullPatchPath);
                } else {
                    byte[] patchBytes = Util.readFully(patchStream);
                    if (!Util.isDataValid(patchBytes, this.patchHash)) {
                        throw new IllegalStateException("Hash check of patch file failed for " + fullPatchPath);
                    } else {
                        byte[] originalBytes = Util.readBytes(inputFile);

                        try {
                            if (!Files.isDirectory(outputFile.getParent(), new LinkOption[0])) {
                                Files.createDirectories(outputFile.getParent());
                            }

                            OutputStream outStream = new BufferedOutputStream(Files.newOutputStream(outputFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING));

                            try {
                                Patch.patch(originalBytes, patchBytes, outStream);
                            } catch (Throwable var16) {
                                try {
                                    outStream.close();
                                } catch (Throwable var15) {
                                    var16.addSuppressed(var15);
                                }

                                throw var16;
                            }

                            outStream.close();
                        } catch (InvalidHeaderException | IOException | CompressorException var17) {
                            throw Util.fail("Failed to patch " + inputFile, var17);
                        }

                        if (!Util.isFileValid(outputFile, this.outputHash)) {
                            throw new IllegalStateException("Patch not applied correctly for " + this.outputPath);
                        } else {
                            ((Map)urls.get(this.location)).put(this.originalPath, outputFile.toUri().toURL());
                        }
                    }
                }
            }
        }
    }

    public String location() {
        return this.location;
    }

    public byte[] originalHash() {
        return this.originalHash;
    }

    public byte[] patchHash() {
        return this.patchHash;
    }

    public byte[] outputHash() {
        return this.outputHash;
    }

    public String originalPath() {
        return this.originalPath;
    }

    public String patchPath() {
        return this.patchPath;
    }

    public String outputPath() {
        return this.outputPath;
    }
}
