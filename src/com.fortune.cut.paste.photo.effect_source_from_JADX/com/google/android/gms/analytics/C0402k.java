package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.cast.Cast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.k */
class C0402k implements C0379q {
    private static final Object xO;
    private static C0402k yD;
    private final Context mContext;
    private String yE;
    private boolean yF;
    private final Object yG;

    /* renamed from: com.google.android.gms.analytics.k.1 */
    class C04011 extends Thread {
        final /* synthetic */ C0402k yH;

        C04011(C0402k c0402k, String str) {
            this.yH = c0402k;
            super(str);
        }

        public void run() {
            synchronized (this.yH.yG) {
                this.yH.yE = this.yH.eq();
                this.yH.yF = true;
                this.yH.yG.notifyAll();
            }
        }
    }

    static {
        xO = new Object();
    }

    protected C0402k(Context context) {
        this.yF = false;
        this.yG = new Object();
        this.mContext = context;
        ep();
    }

    private boolean ae(String str) {
        try {
            ae.m1487V("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            ae.m1485T("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            ae.m1485T("Error writing to clientId file.");
            return false;
        }
    }

    public static C0402k el() {
        C0402k c0402k;
        synchronized (xO) {
            c0402k = yD;
        }
        return c0402k;
    }

    private String en() {
        if (!this.yF) {
            synchronized (this.yG) {
                if (!this.yF) {
                    ae.m1487V("Waiting for clientId to load");
                    do {
                        try {
                            this.yG.wait();
                        } catch (InterruptedException e) {
                            ae.m1485T("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.yF);
                }
            }
        }
        ae.m1487V("Loaded clientId");
        return this.yE;
    }

    private void ep() {
        new C04011(this, "client_id_fetcher").start();
    }

    public static void m1553y(Context context) {
        synchronized (xO) {
            if (yD == null) {
                yD = new C0402k(context);
            }
        }
    }

    public boolean ac(String str) {
        return "&cid".equals(str);
    }

    String em() {
        String str;
        synchronized (this.yG) {
            this.yE = eo();
            str = this.yE;
        }
        return str;
    }

    protected String eo() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !ae(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    String eq() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[Cast.MAX_NAMESPACE_LENGTH];
            int read = openFileInput.read(bArr, 0, Cast.MAX_NAMESPACE_LENGTH);
            if (openFileInput.available() > 0) {
                ae.m1485T("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                ae.m1485T("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    ae.m1487V("Loaded client id from disk.");
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    ae.m1485T("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            ae.m1485T("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? eo() : str;
    }

    public String getValue(String str) {
        return "&cid".equals(str) ? en() : null;
    }
}
