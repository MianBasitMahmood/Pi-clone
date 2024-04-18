package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

class df {
    private Context mContext;
    private Tracker yO;
    private GoogleAnalytics yQ;

    /* renamed from: com.google.android.gms.tagmanager.df.a */
    static class C1800a implements Logger {
        C1800a() {
        }

        private static int fP(int i) {
            switch (i) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return 0;
                case WalletFragmentState.PROCESSING /*3*/:
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    return 1;
                case Dimension.UNIT_MM /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.m6462b("", exception);
        }

        public void error(String str) {
            bh.m6458T(str);
        }

        public int getLogLevel() {
            return C1800a.fP(bh.getLogLevel());
        }

        public void info(String str) {
            bh.m6459U(str);
        }

        public void setLogLevel(int i) {
            bh.m6461W("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            bh.m6460V(str);
        }

        public void warn(String str) {
            bh.m6461W(str);
        }
    }

    df(Context context) {
        this.mContext = context;
    }

    private synchronized void cX(String str) {
        if (this.yQ == null) {
            this.yQ = GoogleAnalytics.getInstance(this.mContext);
            this.yQ.setLogger(new C1800a());
            this.yO = this.yQ.newTracker(str);
        }
    }

    public Tracker cW(String str) {
        cX(str);
        return this.yO;
    }
}
