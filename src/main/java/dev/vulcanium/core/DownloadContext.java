package dev.vulcanium.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

record DownloadContext(byte[] hash, URL url, String fileName) {
    DownloadContext(byte[] hash, URL url, String fileName) {
        this.hash = hash;
        this.url = url;
        this.fileName = fileName;
    }

    public Path getOutputFile(Path outputDir) {
        Path cacheDir = outputDir.resolve("cache");
        return cacheDir.resolve(this.fileName);
    }

    public static DownloadContext parseLine(String line) {
        if (line != null && !line.isBlank()) {
            String[] parts = line.split("\t");
            if (parts.length != 3) {
                throw new IllegalStateException("Invalid download-context line: " + line);
            } else {
                try {
                    return new DownloadContext(Util.fromHex(parts[0]), URI.create(parts[1]).toURL(), parts[2]);
                } catch (MalformedURLException var3) {
                    throw new IllegalStateException("Unable to parse URL in download-context", var3);
                }
            }
        } else {
            return null;
        }
    }

    public void download(Path outputDir) throws IOException {
        Path outputFile = this.getOutputFile(outputDir);
        if (!Files.exists(outputFile, new LinkOption[0]) || !Util.isFileValid(outputFile, this.hash)) {
            if (!Files.isDirectory(outputFile.getParent(), new LinkOption[0])) {
                Files.createDirectories(outputFile.getParent());
            }

            Files.deleteIfExists(outputFile);
            System.out.println("Downloading " + this.fileName);

            try {
                ReadableByteChannel source = Channels.newChannel(this.url.openStream());

                try {
                    FileChannel fileChannel = FileChannel.open(outputFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

                    try {
                        fileChannel.transferFrom(source, 0L, Long.MAX_VALUE);
                    } catch (Throwable var9) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (Throwable var8) {
                                var9.addSuppressed(var8);
                            }
                        }

                        throw var9;
                    }

                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Throwable var10) {
                    if (source != null) {
                        try {
                            source.close();
                        } catch (Throwable var7) {
                            var10.addSuppressed(var7);
                        }
                    }

                    throw var10;
                }

                if (source != null) {
                    source.close();
                }
            } catch (IOException var11) {
                System.err.println("Failed to download " + this.fileName);
                var11.printStackTrace();
                System.exit(1);
            }

            if (!Util.isFileValid(outputFile, this.hash)) {
                throw new IllegalStateException("Hash check failed for downloaded file " + this.fileName);
            }
        }
    }

    public byte[] hash() {
        return this.hash;
    }

    public URL url() {
        return this.url;
    }

    public String fileName() {
        return this.fileName;
    }
}
