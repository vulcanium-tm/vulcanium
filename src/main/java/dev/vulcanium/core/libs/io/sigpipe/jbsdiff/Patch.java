package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Patch {
    public Patch() {
    }

    public static void patch(byte[] old, byte[] patch, OutputStream out) throws CompressorException, InvalidHeaderException, IOException {
        InputStream headerIn = new ByteArrayInputStream(patch);
        Header header = new Header(headerIn);
        headerIn.close();
        InputStream controlIn = new ByteArrayInputStream(patch);
        InputStream dataIn = new ByteArrayInputStream(patch);
        InputStream extraIn = new ByteArrayInputStream(patch);

        try {
            ((InputStream)controlIn).skip(32L);
            ((InputStream)dataIn).skip((long)(32 + header.getControlLength()));
            ((InputStream)extraIn).skip((long)(32 + header.getControlLength() + header.getDiffLength()));
            CompressorStreamFactory compressor = new CompressorStreamFactory();
            controlIn = compressor.createCompressorInputStream((InputStream)controlIn);
            dataIn = compressor.createCompressorInputStream((InputStream)dataIn);
            extraIn = compressor.createCompressorInputStream((InputStream)extraIn);
            int newPointer = 0;
            int oldPointer = 0;

            byte[] output;
            ControlBlock control;
            for(output = new byte[header.getOutputLength()]; newPointer < output.length; oldPointer += control.getSeekLength()) {
                control = new ControlBlock((InputStream)controlIn);
                read((InputStream)dataIn, output, newPointer, control.getDiffLength());

                for(int i = 0; i < control.getDiffLength(); ++i) {
                    if (oldPointer + i >= 0 && oldPointer + i < old.length) {
                        output[newPointer + i] += old[oldPointer + i];
                    }
                }

                newPointer += control.getDiffLength();
                oldPointer += control.getDiffLength();
                read((InputStream)extraIn, output, newPointer, control.getExtraLength());
                newPointer += control.getExtraLength();
            }

            out.write(output);
        } finally {
            ((InputStream)controlIn).close();
            ((InputStream)dataIn).close();
            ((InputStream)extraIn).close();
        }
    }

    private static void read(InputStream in, byte[] dest, int off, int len) throws IOException {
        if (len != 0) {
            int read = in.read(dest, off, len);
            if (read < len) {
                throw new IOException("Corrupt patch; bytes expected = " + len + " bytes read = " + read);
            }
        }
    }
}
