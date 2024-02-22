package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class Header {
    public static final int HEADER_SIZE = 32;
    public static final String HEADER_MAGIC = "BSDIFF40";
    private String magic;
    private int controlLength;
    private int diffLength;
    private int outLength;

    public Header() {
    }

    public Header(InputStream in) throws IOException, InvalidHeaderException {
        InputStream headerIn = new DataInputStream(in);
        byte[] buf = new byte[8];
        headerIn.read(buf);
        this.magic = new String(buf);
        if (!this.magic.equals("BSDIFF40")) {
            throw new InvalidHeaderException("Header missing magic number");
        } else {
            this.controlLength = Offset.readOffset(headerIn);
            this.diffLength = Offset.readOffset(headerIn);
            this.outLength = Offset.readOffset(headerIn);
            this.verify();
        }
    }

    public Header(int controlLength, int diffLength, int outLength) throws InvalidHeaderException {
        this.controlLength = controlLength;
        this.diffLength = diffLength;
        this.outLength = outLength;
        this.verify();
    }

    public void write(OutputStream out) throws IOException {
        out.write("BSDIFF40".getBytes());
        Offset.writeOffset(this.controlLength, out);
        Offset.writeOffset(this.diffLength, out);
        Offset.writeOffset(this.outLength, out);
    }

    private void verify() throws InvalidHeaderException {
        if (this.controlLength < 0) {
            throw new InvalidHeaderException("control block length", this.controlLength);
        } else if (this.diffLength < 0) {
            throw new InvalidHeaderException("diff block length", this.diffLength);
        } else if (this.outLength < 0) {
            throw new InvalidHeaderException("output file length", this.outLength);
        }
    }

    public String toString() {
        String s = "";
        s = s + this.magic + "\n";
        s = s + "control bytes = " + this.controlLength + "\n";
        s = s + "diff bytes = " + this.diffLength + "\n";
        s = s + "output size = " + this.outLength;
        return s;
    }

    public int getControlLength() {
        return this.controlLength;
    }

    public void setControlLength(int length) throws InvalidHeaderException {
        this.controlLength = length;
        this.verify();
    }

    public int getDiffLength() {
        return this.diffLength;
    }

    public void setDiffLength(int length) throws InvalidHeaderException {
        this.diffLength = length;
        this.verify();
    }

    public int getOutputLength() {
        return this.outLength;
    }

    public void setOutputLength(int length) throws InvalidHeaderException {
        this.outLength = length;
        this.verify();
    }
}

