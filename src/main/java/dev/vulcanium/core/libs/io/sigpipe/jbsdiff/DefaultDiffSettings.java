package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import dev.vulcanium.core.libs.io.sigpipe.jbsdiff.sort.SuffixSort;

public class DefaultDiffSettings implements DiffSettings {
    private String compression;

    public DefaultDiffSettings() {
        this.compression = "bzip2";
    }

    public DefaultDiffSettings(String compression) {
        this.compression = compression;
    }

    public String getCompression() {
        return this.compression;
    }

    public int[] sort(byte[] input) {
        int[] I = new int[input.length + 1];
        int[] V = new int[input.length + 1];
        SuffixSort.qsufsort(I, V, input);
        return I;
    }
}
