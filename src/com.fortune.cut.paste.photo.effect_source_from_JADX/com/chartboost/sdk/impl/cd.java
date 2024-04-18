package com.chartboost.sdk.impl;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class cd {
    public static final char f815a;
    public static final String f816b;

    static {
        f815a = File.separatorChar;
        Writer cfVar = new cf(4);
        PrintWriter printWriter = new PrintWriter(cfVar);
        printWriter.println();
        f816b = cfVar.toString();
        printWriter.close();
    }

    public static void m1193a(InputStream inputStream) {
        m1192a((Closeable) inputStream);
    }

    public static void m1194a(OutputStream outputStream) {
        m1192a((Closeable) outputStream);
    }

    public static void m1192a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m1198b(InputStream inputStream) throws IOException {
        OutputStream ceVar = new ce();
        m1190a(inputStream, ceVar);
        return ceVar.m1200a();
    }

    public static byte[] m1196a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return m1195a(inputStream, (int) j);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    public static byte[] m1195a(InputStream inputStream, int i) throws IOException {
        int i2 = 0;
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        } else if (i == 0) {
            return new byte[0];
        } else {
            byte[] bArr = new byte[i];
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
        }
    }

    public static int m1190a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long b = m1197b(inputStream, outputStream);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    public static long m1197b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m1191a(inputStream, outputStream, new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD]);
    }

    public static long m1191a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
