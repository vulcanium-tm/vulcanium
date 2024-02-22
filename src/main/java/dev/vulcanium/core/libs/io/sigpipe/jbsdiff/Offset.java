package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class Offset {
    public static final int OFFSET_SIZE = 8;

    Offset() {
    }

    public static int readOffset(InputStream in) throws IOException {
        byte[] buf = new byte[8];
        int bytesRead = in.read(buf);
        if (bytesRead < 8) {
            throw new IOException("Could not read offset.");
        } else {
            int y = buf[7] & 127;
            y *= 256;
            y += buf[6] & 255;
            y *= 256;
            y += buf[5] & 255;
            y *= 256;
            y += buf[4] & 255;
            y *= 256;
            y += buf[3] & 255;
            y *= 256;
            y += buf[2] & 255;
            y *= 256;
            y += buf[1] & 255;
            y *= 256;
            y += buf[0] & 255;
            if (y < 0) {
                throw new IOException("Integer overflow: 64-bit offsets not supported.");
            } else {
                if ((buf[7] & 128) != 0) {
                    y = -y;
                }

                return y;
            }
        }
    }

    public static void writeOffset(int value, OutputStream out) throws IOException {
        byte[] buf = new byte[8];
        int y;
        if (value < 0) {
            y = -value;
            buf[7] = (byte)(buf[7] | 128);
        } else {
            y = value;
        }

        buf[0] = (byte)(buf[0] | y % 256);
        y -= buf[0] & 255;
        y /= 256;
        buf[1] = (byte)(buf[1] | y % 256);
        y -= buf[1] & 255;
        y /= 256;
        buf[2] = (byte)(buf[2] | y % 256);
        y -= buf[2] & 255;
        y /= 256;
        buf[3] = (byte)(buf[3] | y % 256);
        y -= buf[3] & 255;
        y /= 256;
        buf[4] = (byte)(buf[4] | y % 256);
        y -= buf[4] & 255;
        y /= 256;
        buf[5] = (byte)(buf[5] | y % 256);
        y -= buf[5] & 255;
        y /= 256;
        buf[6] = (byte)(buf[6] | y % 256);
        y -= buf[6] & 255;
        y /= 256;
        buf[7] = (byte)(buf[7] | y % 256);
        out.write(buf);
    }
}
