package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@ey
public final class gp extends gf {
    private final Context mContext;
    private final String mG;
    private final String vf;
    private String wl;

    public gp(Context context, String str, String str2) {
        this.wl = null;
        this.mContext = context;
        this.mG = str;
        this.vf = str2;
    }

    public gp(Context context, String str, String str2, String str3) {
        this.wl = null;
        this.mContext = context;
        this.mG = str;
        this.vf = str2;
        this.wl = str3;
    }

    public final void cx() {
        HttpURLConnection httpURLConnection;
        try {
            gr.m4772V("Pinging URL: " + this.vf);
            httpURLConnection = (HttpURLConnection) new URL(this.vf).openConnection();
            if (this.wl == null) {
                gi.m4726a(this.mContext, this.mG, true, httpURLConnection);
            } else {
                gi.m4727a(this.mContext, this.mG, true, httpURLConnection, this.wl);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                gr.m4773W("Received non-success response code " + responseCode + " from pinging URL: " + this.vf);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            gr.m4773W("Error while parsing ping URL: " + this.vf + ". " + e.getMessage());
        } catch (IOException e2) {
            gr.m4773W("Error while pinging URL: " + this.vf + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public final void onStop() {
    }
}
