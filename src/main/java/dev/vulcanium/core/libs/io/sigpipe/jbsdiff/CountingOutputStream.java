package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends OutputStream {
    private OutputStream out;
    private int counter;

    public CountingOutputStream(OutputStream out) {
        this.out = out;
    }

    public void write(int b) throws IOException {
        ++this.counter;
        this.out.write(b);
    }

    public int getCount() {
        return this.counter;
    }
}
