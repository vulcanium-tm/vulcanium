package dev.vulcanium.core.libs.io.sigpipe.jbsdiff;

import dev.vulcanium.core.libs.io.sigpipe.jbsdiff.sort.SearchResult;
import dev.vulcanium.core.libs.io.sigpipe.jbsdiff.sort.SuffixSort;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Diff {
    public Diff() {
    }

    public static void diff(byte[] oldBytes, byte[] newBytes, OutputStream out) throws CompressorException, InvalidHeaderException, IOException {
        diff(oldBytes, newBytes, out, new DefaultDiffSettings());
    }

    public static void diff(byte[] oldBytes, byte[] newBytes, OutputStream out, DiffSettings settings) throws CompressorException, InvalidHeaderException, IOException {
        CompressorStreamFactory compressor = new CompressorStreamFactory();
        String compression = settings.getCompression();
        int[] I = settings.sort(oldBytes);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        OutputStream patchOut = compressor.createCompressorOutputStream(compression, byteOut);
        SearchResult result = null;
        int scan = 0;
        int len = 0;
        int position = 0;
        int lastScan = 0;
        int lastPos = 0;
        int lastOffset = 0;
        byte[] db = new byte[newBytes.length + 1];
        byte[] eb = new byte[newBytes.length + 1];
        int dblen = 0;
        int eblen = 0;

        while(true) {
            int oldScore;
            do {
                if (scan >= newBytes.length) {
                    patchOut.close();
                    Header header = new Header();
                    header.setControlLength(byteOut.size());
                    patchOut = compressor.createCompressorOutputStream(compression, byteOut);
                    patchOut.write(db);
                    patchOut.close();
                    header.setDiffLength(byteOut.size() - header.getControlLength());
                    patchOut = compressor.createCompressorOutputStream(compression, byteOut);
                    patchOut.write(eb);
                    patchOut.close();
                    header.setOutputLength(newBytes.length);
                    header.write(out);
                    out.write(byteOut.toByteArray());
                    return;
                }

                oldScore = 0;

                for(int scsc = scan += len; scan < newBytes.length; ++scan) {
                    result = SuffixSort.search(I, oldBytes, 0, newBytes, scan, 0, oldBytes.length);
                    len = result.getLength();

                    for(position = result.getPosition(); scsc < scan + len; ++scsc) {
                        if (scsc + lastOffset < oldBytes.length && oldBytes[scsc + lastOffset] == newBytes[scsc]) {
                            ++oldScore;
                        }
                    }

                    if (len == oldScore && len != 0 || len > oldScore + 8) {
                        break;
                    }

                    if (scan + lastOffset < oldBytes.length && oldBytes[scan + lastOffset] == newBytes[scan]) {
                        --oldScore;
                    }
                }
            } while(len == oldScore && scan != newBytes.length);

            int s = 0;
            int Sf = 0;
            int lenf = 0;
            int i = 0;

            while(lastScan + i < scan && lastPos + i < oldBytes.length) {
                if (oldBytes[lastPos + i] == newBytes[lastScan + i]) {
                    ++s;
                }

                ++i;
                if (s * 2 - i > Sf * 2 - lenf) {
                    Sf = s;
                    lenf = i;
                }
            }

            int lenb = 0;
            if (scan < newBytes.length) {
                s = 0;
                int Sb = 0;

                for(i = 1; scan >= lastScan + i && position >= i; ++i) {
                    if (oldBytes[position - i] == newBytes[scan - i]) {
                        ++s;
                    }

                    if (s * 2 - i > Sb * 2 - lenb) {
                        Sb = s;
                        lenb = i;
                    }
                }
            }

            if (lastScan + lenf > scan - lenb) {
                int overlap = lastScan + lenf - (scan - lenb);
                s = 0;
                int Ss = 0;
                int lens = 0;

                for(i = 0; i < overlap; ++i) {
                    if (newBytes[lastScan + lenf - overlap + i] == oldBytes[lastPos + lenf - overlap + i]) {
                        ++s;
                    }

                    if (newBytes[scan - lenb + i] == oldBytes[position - lenb + i]) {
                        --s;
                    }

                    if (s > Ss) {
                        Ss = s;
                        lens = i + 1;
                    }
                }

                lenf += lens - overlap;
                lenb -= lens;
            }

            for(i = 0; i < lenf; ++i) {
                db[dblen + i] = (byte)(db[dblen + i] | newBytes[lastScan + i] - oldBytes[lastPos + i]);
            }

            for(i = 0; i < scan - lenb - (lastScan + lenf); ++i) {
                eb[eblen + i] = newBytes[lastScan + lenf + i];
            }

            dblen += lenf;
            eblen += scan - lenb - (lastScan + lenf);
            ControlBlock control = new ControlBlock();
            control.setDiffLength(lenf);
            control.setExtraLength(scan - lenb - (lastScan + lenf));
            control.setSeekLength(position - lenb - (lastPos + lenf));
            control.write(patchOut);
            lastScan = scan - lenb;
            lastPos = position - lenb;
            lastOffset = position - scan;
        }
    }
}
