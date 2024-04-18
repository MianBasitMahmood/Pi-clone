package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.internal.em.C1104a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ey
public final class ed extends C1104a {
    private Context mContext;
    private String mG;
    private String sM;
    private ArrayList<String> sN;

    public ed(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.sM = str;
        this.sN = arrayList;
        this.mG = str2;
        this.mContext = context;
    }

    private void cz() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.sM, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            gr.m4773W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            gr.m4773W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            gr.m4777d("Fail to report a conversion.", e3);
        }
    }

    protected final String m4500a(String str, HashMap<String, String> hashMap) {
        Object obj;
        Object obj2 = "";
        try {
            obj = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            gr.m4777d("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - ga.dh().dq();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{ga.vY})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{r2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.mG})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public final String getProductId() {
        return this.sM;
    }

    protected final int m4501p(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    public final void recordPlayBillingResolution(int i) {
        if (i == 0) {
            cz();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.sM);
        hashMap.put("status", String.valueOf(m4501p(i)));
        Iterator it = this.sN.iterator();
        while (it.hasNext()) {
            new gp(this.mContext, this.mG, m4500a((String) it.next(), hashMap)).start();
        }
    }

    public final void recordResolution(int i) {
        if (i == 1) {
            cz();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(i));
        hashMap.put("sku", this.sM);
        Iterator it = this.sN.iterator();
        while (it.hasNext()) {
            new gp(this.mContext, this.mG, m4500a((String) it.next(), hashMap)).start();
        }
    }
}
