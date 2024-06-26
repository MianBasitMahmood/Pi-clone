package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    public static final SnapshotContentsEntityCreator CREATOR;
    private static final Object aeY;
    private final int CK;
    private Contents PW;

    static {
        aeY = new Object();
        CREATOR = new SnapshotContentsEntityCreator();
    }

    SnapshotContentsEntity(int i, Contents contents) {
        this.CK = i;
        this.PW = contents;
    }

    public SnapshotContentsEntity(Contents contents) {
        this(1, contents);
    }

    private boolean m4084a(int i, byte[] bArr, int i2, int i3, boolean z) {
        jx.m5217a(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (aeY) {
            OutputStream fileOutputStream = new FileOutputStream(this.PW.getParcelFileDescriptor().getFileDescriptor());
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (Throwable e) {
                GamesLog.m3238a("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    public final void close() {
        this.PW = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() {
        jx.m5217a(!isClosed(), "Cannot mutate closed contents!");
        return this.PW.getParcelFileDescriptor();
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final Contents ir() {
        return this.PW;
    }

    public final boolean isClosed() {
        return this.PW == null;
    }

    public final boolean modifyBytes(int i, byte[] bArr, int i2, int i3) {
        return m4084a(i, bArr, i2, bArr.length, false);
    }

    public final byte[] readFully() throws IOException {
        byte[] a;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        jx.m5217a(z, "Must provide a previously opened Snapshot");
        synchronized (aeY) {
            InputStream fileInputStream = new FileInputStream(this.PW.getParcelFileDescriptor().getFileDescriptor());
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                a = lh.m5329a(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (Throwable e) {
                GamesLog.m3239b("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return a;
    }

    public final boolean writeBytes(byte[] bArr) {
        return m4084a(0, bArr, 0, bArr.length, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        SnapshotContentsEntityCreator.m4085a(this, parcel, i);
    }
}
