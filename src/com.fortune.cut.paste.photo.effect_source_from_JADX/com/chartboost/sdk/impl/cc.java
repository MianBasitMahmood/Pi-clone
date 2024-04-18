package com.chartboost.sdk.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class cc {
    public static final BigInteger f805a;
    public static final BigInteger f806b;
    public static final BigInteger f807c;
    public static final BigInteger f808d;
    public static final BigInteger f809e;
    public static final BigInteger f810f;
    public static final BigInteger f811g;
    public static final BigInteger f812h;
    public static final File[] f813i;
    private static final Charset f814j;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        f805a = valueOf;
        f806b = valueOf.multiply(valueOf);
        f807c = f805a.multiply(f806b);
        f808d = f805a.multiply(f807c);
        f809e = f805a.multiply(f808d);
        f810f = f805a.multiply(f809e);
        f811g = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        f812h = f805a.multiply(f811g);
        f813i = new File[0];
        f814j = Charset.forName("UTF-8");
    }

    public static FileInputStream m1185a(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream m1186a(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.mkdirs() || parentFile.isDirectory())) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static byte[] m1189b(File file) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = m1185a(file);
            byte[] a = cd.m1196a(inputStream, file.length());
            return a;
        } finally {
            cd.m1193a(inputStream);
        }
    }

    public static void m1187a(File file, byte[] bArr) throws IOException {
        m1188a(file, bArr, false);
    }

    public static void m1188a(File file, byte[] bArr, boolean z) throws IOException {
        OutputStream outputStream = null;
        try {
            outputStream = m1186a(file, z);
            outputStream.write(bArr);
            outputStream.close();
        } finally {
            cd.m1194a(outputStream);
        }
    }
}
