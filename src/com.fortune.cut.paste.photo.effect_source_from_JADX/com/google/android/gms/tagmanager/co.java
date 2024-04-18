package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C1048c.C1047j;
import com.google.android.gms.tagmanager.bg.C1763a;
import com.google.android.gms.tagmanager.ce.C1770a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class co implements Runnable {
    private volatile String aqI;
    private final String aqm;
    private final bn asA;
    private final String asB;
    private bg<C1047j> asC;
    private volatile C1824r asD;
    private volatile String asE;
    private final Context mContext;

    co(Context context, String str, bn bnVar, C1824r c1824r) {
        this.mContext = context;
        this.asA = bnVar;
        this.aqm = str;
        this.asD = c1824r;
        this.asB = "/r?id=" + str;
        this.aqI = this.asB;
        this.asE = null;
    }

    public co(Context context, String str, C1824r c1824r) {
        this(context, str, new bn(), c1824r);
    }

    private boolean qd() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m6460V("...no network connectivity");
        return false;
    }

    private void qe() {
        if (qd()) {
            bh.m6460V("Start loading resource from network ...");
            String qf = qf();
            bm pO = this.asA.pO();
            try {
                InputStream cF = pO.cF(qf);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cr.m6547b(cF, byteArrayOutputStream);
                    C1047j b = C1047j.m4330b(byteArrayOutputStream.toByteArray());
                    bh.m6460V("Successfully loaded supplemented resource: " + b);
                    if (b.gs == null && b.gr.length == 0) {
                        bh.m6460V("No change for container: " + this.aqm);
                    }
                    this.asC.m6456l(b);
                    bh.m6460V("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m6463d("Error when parsing downloaded resources from url: " + qf + " " + e.getMessage(), e);
                    this.asC.m6455a(C1763a.SERVER_ERROR);
                    pO.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m6461W("No data is retrieved from the given url: " + qf + ". Make sure container_id: " + this.aqm + " is correct.");
                this.asC.m6455a(C1763a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m6463d("Error when loading resources from url: " + qf + " " + e3.getMessage(), e3);
                this.asC.m6455a(C1763a.IO_ERROR);
            } finally {
                pO.close();
            }
        } else {
            this.asC.m6455a(C1763a.NOT_AVAILABLE);
        }
    }

    void m6514a(bg<C1047j> bgVar) {
        this.asC = bgVar;
    }

    void cL(String str) {
        bh.m6457S("Setting previous container version: " + str);
        this.asE = str;
    }

    void cw(String str) {
        if (str == null) {
            this.aqI = this.asB;
            return;
        }
        bh.m6457S("Setting CTFE URL path: " + str);
        this.aqI = str;
    }

    String qf() {
        String str = this.asD.pu() + this.aqI + "&v=a65833898";
        if (!(this.asE == null || this.asE.trim().equals(""))) {
            str = str + "&pv=" + this.asE;
        }
        return ce.qa().qb().equals(C1770a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.asC == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.asC.ps();
        qe();
    }
}
