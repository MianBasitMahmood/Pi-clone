package com.google.android.gms.games.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LibjingleNativeSocket implements RealTimeSocket {
    private static final String TAG;
    private final ParcelFileDescriptor LG;
    private final InputStream ZO;
    private final OutputStream ZP;

    static {
        TAG = LibjingleNativeSocket.class.getSimpleName();
    }

    LibjingleNativeSocket(ParcelFileDescriptor parcelFileDescriptor) {
        this.LG = parcelFileDescriptor;
        this.ZO = new AutoCloseInputStream(parcelFileDescriptor);
        this.ZP = new AutoCloseOutputStream(parcelFileDescriptor);
    }

    public final void close() throws IOException {
        this.LG.close();
    }

    public final InputStream getInputStream() throws IOException {
        return this.ZO;
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.ZP;
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        return this.LG;
    }

    public final boolean isClosed() {
        try {
            this.ZO.available();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
