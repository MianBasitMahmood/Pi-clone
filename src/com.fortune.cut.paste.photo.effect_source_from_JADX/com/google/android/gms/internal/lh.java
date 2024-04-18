package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class lh {
    public static long m5326a(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return m5327a(inputStream, outputStream, z, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
    }

    public static long m5327a(InputStream inputStream, OutputStream outputStream, boolean z, int i) throws IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    m5330b(inputStream);
                    m5330b(outputStream);
                }
            }
        }
        return j;
    }

    public static void m5328a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m5329a(InputStream inputStream, boolean z) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m5326a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    public static void m5330b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m5331d(InputStream inputStream) throws IOException {
        return m5329a(inputStream, true);
    }
}
