package dev.vulcanium.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class Util {
    public static MessageDigest sha256Digest = getSha256Digest();

    private Util() {
    }

    private static MessageDigest getSha256Digest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException var1) {
            throw fail("Could not create hashing instance", var1);
        }
    }

    static byte[] readBytes(Path file) {
        try {
            return readFully(Files.newInputStream(file));
        } catch (IOException var2) {
            throw fail("Failed to read all of the data from " + file.toAbsolutePath(), var2);
        }
    }

    static byte[] readFully(InputStream in) throws IOException {
        InputStream var1 = in;

        byte[] var5;
        try {
            byte[] buffer = new byte[16384];
            int off = 0;

            int read;
            while((read = in.read(buffer, off, buffer.length - off)) != -1) {
                off += read;
                if (off == buffer.length) {
                    buffer = Arrays.copyOf(buffer, buffer.length * 2);
                }
            }

            var5 = Arrays.copyOfRange(buffer, 0, off);
        } catch (Throwable var7) {
            if (in != null) {
                try {
                    var1.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }
            }

            throw var7;
        }

        if (in != null) {
            in.close();
        }

        return var5;
    }

    static String readResourceText(String path) throws IOException {
        String p;
        if (path.startsWith("/")) {
            p = path;
        } else {
            p = "/" + path;
        }

        InputStream stream = Util.class.getResourceAsStream(p);
        if (stream == null) {
            return null;
        } else {
            StringWriter writer = new StringWriter();
            InputStream var4 = stream;

            try {
                Reader reader = new InputStreamReader(stream);
                reader.transferTo(writer);
            } catch (Throwable var8) {
                if (stream != null) {
                    try {
                        var4.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (stream != null) {
                stream.close();
            }

            return writer.toString();
        }
    }

    static boolean isDataValid(byte[] data, byte[] hash) {
        return Arrays.equals(hash, sha256Digest.digest(data));
    }

    static boolean isFileValid(Path file, byte[] hash) {
        if (Files.exists(file, new LinkOption[0])) {
            byte[] fileBytes = readBytes(file);
            return isDataValid(fileBytes, hash);
        } else {
            return false;
        }
    }

    static byte[] fromHex(String s) {
        if (s.length() % 2 != 0) {
            throw new IllegalArgumentException("Length of hex " + s + " must be divisible by two");
        } else {
            try {
                byte[] bytes = new byte[s.length() / 2];

                for(int i = 0; i < bytes.length; ++i) {
                    char left = s.charAt(i * 2);
                    char right = s.charAt(i * 2 + 1);
                    byte b = (byte)(getHexValue(left) << 4 | getHexValue(right) & 15);
                    bytes[i] = b;
                }

                return bytes;
            } catch (Exception var6) {
                throw new IllegalArgumentException("Cannot convert non-hex string: " + s);
            }
        }
    }

    private static int getHexValue(char c) {
        int i = Character.digit(c, 16);
        if (i < 0) {
            throw new IllegalArgumentException("Invalid hex char: " + c);
        } else {
            return i;
        }
    }

    static RuntimeException fail(String message, Throwable err) {
        System.err.println(message);
        if (err != null) {
            err.printStackTrace();
        }

        System.exit(1);
        throw new InternalError();
    }

    static <X extends Throwable> RuntimeException sneakyThrow(Throwable ex) throws Throwable {
        throw ex;
    }

    static String endingSlash(String dir) {
        return dir.endsWith("/") ? dir : dir + "/";
    }
}
