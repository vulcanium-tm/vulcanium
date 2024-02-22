package dev.vulcanium.core.libs.io.sigpipe.jbsdiff.sort;

public class SuffixSort {
    public SuffixSort() {
    }

    public static void qsufsort(int[] I, int[] V, byte[] data) {
        int[] buckets = new int[256];

        int i;
        for(i = 0; i < data.length; ++i) {
            ++buckets[data[i] & 255];
        }

        for(i = 1; i < 256; ++i) {
            buckets[i] += buckets[i - 1];
        }

        for(i = 255; i > 0; --i) {
            buckets[i] = buckets[i - 1];
        }

        buckets[0] = 0;

        for(i = 0; i < data.length; I[++buckets[data[i] & 255]] = i++) {
        }

        I[0] = data.length;

        for(i = 0; i < data.length; ++i) {
            V[i] = buckets[data[i] & 255];
        }

        V[data.length] = 0;

        for(i = 1; i < 256; ++i) {
            if (buckets[i] == buckets[i - 1] + 1) {
                I[buckets[i]] = -1;
            }
        }

        I[0] = -1;

        for(int h = 1; I[0] != -(data.length + 1); h += h) {
            int len = 0;
            i = 0;

            while(i < data.length + 1) {
                if (I[i] < 0) {
                    len -= I[i];
                    i -= I[i];
                } else {
                    if (len != 0) {
                        I[i - len] = -len;
                    }

                    len = V[I[i]] + 1 - i;
                    split(I, V, i, len, h);
                    i += len;
                    len = 0;
                }
            }

            if (len != 0) {
                I[i - len] = -len;
            }
        }

        for(i = 0; i < data.length + 1; I[V[i]] = i++) {
        }

    }

    public static void split(int[] I, int[] V, int start, int len, int h) {
        int i;
        int j;
        int k;
        int x;
        int tmp;
        if (len < 16) {
            for(k = start; k < start + len; k += j) {
                j = 1;
                x = V[I[k] + h];

                for(i = 1; k + i < start + len; ++i) {
                    if (V[I[k + i] + h] < x) {
                        x = V[I[k + i] + h];
                        j = 0;
                    }

                    if (V[I[k + i] + h] == x) {
                        tmp = I[k + j];
                        I[k + j] = I[k + i];
                        I[k + i] = tmp;
                        ++j;
                    }
                }

                for(i = 0; i < j; ++i) {
                    V[I[k + i]] = k + j - 1;
                }

                if (j == 1) {
                    I[k] = -1;
                }
            }

        } else {
            x = V[I[start + len / 2] + h];
            int jj = 0;
            int kk = 0;

            for(i = start; i < start + len; ++i) {
                if (V[I[i] + h] < x) {
                    ++jj;
                }

                if (V[I[i] + h] == x) {
                    ++kk;
                }
            }

            jj += start;
            kk += jj;
            i = start;
            j = 0;
            k = 0;

            while(i < jj) {
                if (V[I[i] + h] < x) {
                    ++i;
                } else if (V[I[i] + h] == x) {
                    tmp = I[i];
                    I[i] = I[jj + j];
                    I[jj + j] = tmp;
                    ++j;
                } else {
                    tmp = I[i];
                    I[i] = I[kk + k];
                    I[kk + k] = tmp;
                    ++k;
                }
            }

            while(jj + j < kk) {
                if (V[I[jj + j] + h] == x) {
                    ++j;
                } else {
                    tmp = I[jj + j];
                    I[jj + j] = I[kk + k];
                    I[kk + k] = tmp;
                    ++k;
                }
            }

            if (jj > start) {
                split(I, V, start, jj - start, h);
            }

            for(i = 0; i < kk - jj; ++i) {
                V[I[jj + i]] = kk - 1;
            }

            if (jj == kk - 1) {
                I[jj] = -1;
            }

            if (start + len > kk) {
                split(I, V, kk, start + len - kk, h);
            }

        }
    }

    private static int matchLength(byte[] bytesA, int offsetA, byte[] bytesB, int offsetB) {
        int oldLimit = bytesA.length - offsetA;
        int newLimit = bytesB.length - offsetB;

        int i;
        for(i = 0; i < oldLimit && i < newLimit && bytesA[i + offsetA] == bytesB[i + offsetB]; ++i) {
        }

        return i;
    }

    public static SearchResult search(int[] I, byte[] oldBytes, int oldOffset, byte[] newBytes, int newOffset, int start, int end) {
        int center;
        if (end - start < 2) {
            center = matchLength(oldBytes, I[start], newBytes, newOffset);
            int y = matchLength(oldBytes, I[end], newBytes, newOffset);
            return center > y ? new SearchResult(center, I[start]) : new SearchResult(y, I[end]);
        } else {
            center = start + (end - start) / 2;
            return compareBytes(oldBytes, I[center], newBytes, newOffset) < 0 ? search(I, oldBytes, 0, newBytes, newOffset, center, end) : search(I, oldBytes, 0, newBytes, newOffset, start, center);
        }
    }

    private static int compareBytes(byte[] bytesA, int offsetA, byte[] bytesB, int offsetB) {
        int length = Math.min(bytesA.length - offsetA, bytesB.length - offsetB);
        int valA = 0;
        int valB = 0;

        for(int i = 0; i < length; ++i) {
            valA = bytesA[i + offsetA] & 255;
            valB = bytesB[i + offsetB] & 255;
            if (valA != valB) {
                break;
            }
        }

        return valA - valB;
    }
}
