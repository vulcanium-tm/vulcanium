package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ControlBlock {
    private int diffLength;
    private int extraLength;
    private int seekLength;

    public ControlBlock() {
    }

    public ControlBlock(InputStream in) throws IOException {
        this.diffLength = Offset.readOffset(in);
        this.extraLength = Offset.readOffset(in);
        this.seekLength = Offset.readOffset(in);
    }

    public ControlBlock(int diffLength, int extraLength, int seekLength) {
        this.diffLength = diffLength;
        this.extraLength = extraLength;
        this.seekLength = seekLength;
    }

    public void write(OutputStream out) throws IOException {
        Offset.writeOffset(this.diffLength, out);
        Offset.writeOffset(this.extraLength, out);
        Offset.writeOffset(this.seekLength, out);
    }

    public String toString() {
        return this.diffLength + ", " + this.extraLength + ", " + this.seekLength;
    }

    public int getDiffLength() {
        return this.diffLength;
    }

    public void setDiffLength(int length) {
        this.diffLength = length;
    }

    public int getExtraLength() {
        return this.extraLength;
    }

    public void setExtraLength(int length) {
        this.extraLength = length;
    }

    public int getSeekLength() {
        return this.seekLength;
    }

    public void setSeekLength(int length) {
        this.seekLength = length;
    }
}
