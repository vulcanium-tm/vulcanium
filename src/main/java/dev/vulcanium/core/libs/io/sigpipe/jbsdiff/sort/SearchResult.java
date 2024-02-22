package dev.vulcanium.core.libs.io.sigpipe.jbsdiff.sort;

public class SearchResult {
    private int length;
    private int position;

    public SearchResult(int length, int position) {
        this.length = length;
        this.position = position;
    }

    public String toString() {
        return new String("length = " + this.length + ", position = " + this.position);
    }

    public int getLength() {
        return this.length;
    }

    public int getPosition() {
        return this.position;
    }
}
