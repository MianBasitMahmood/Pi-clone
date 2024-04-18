package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hd.C1187a;
import com.google.android.gms.internal.hp.C1190a;
import com.google.android.gms.internal.mv.C1352a;
import com.google.android.gms.internal.mv.C1352a.C1351a;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.zip.CRC32;

public class hr implements SafeParcelable {
    public static final hs CREATOR;
    final int CK;
    final hf Dw;
    final long Dx;
    final int Dy;
    final hd Dz;
    public final String pc;

    static {
        CREATOR = new hs();
    }

    hr(int i, hf hfVar, long j, int i2, String str, hd hdVar) {
        this.CK = i;
        this.Dw = hfVar;
        this.Dx = j;
        this.Dy = i2;
        this.pc = str;
        this.Dz = hdVar;
    }

    public hr(hf hfVar, long j, int i) {
        this(1, hfVar, j, i, null, null);
    }

    public hr(hf hfVar, long j, int i, String str, hd hdVar) {
        this(1, hfVar, j, i, str, hdVar);
    }

    public hr(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list) {
        this(1, m4860a(str, intent), System.currentTimeMillis(), 0, null, m4859a(intent, str2, uri, str3, list).fD());
    }

    public static C1187a m4859a(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        C1187a c1187a = new C1187a();
        c1187a.m4833a(av(str));
        if (uri != null) {
            c1187a.m4833a(m4862f(uri));
        }
        if (list != null) {
            c1187a.m4833a(m4861b(list));
        }
        String action = intent.getAction();
        if (action != null) {
            c1187a.m4833a(m4865i("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            c1187a.m4833a(m4865i("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            c1187a.m4833a(m4865i("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                c1187a.m4833a(m4865i("intent_extra_data", action));
            }
        }
        return c1187a.ar(str2).m4832F(true);
    }

    public static hf m4860a(String str, Intent intent) {
        return m4864h(str, m4863g(intent));
    }

    private static hh av(String str) {
        return new hh(str, new C1190a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).m4855Q(1).m4854H(true).au("name").fG(), "text1");
    }

    private static hh m4861b(List<AppIndexingLink> list) {
        qw c1352a = new C1352a();
        C1351a[] c1351aArr = new C1351a[list.size()];
        for (int i = 0; i < c1351aArr.length; i++) {
            c1351aArr[i] = new C1351a();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            c1351aArr[i].afw = appIndexingLink.appIndexingUrl.toString();
            c1351aArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                c1351aArr[i].afx = appIndexingLink.webUrl.toString();
            }
        }
        c1352a.afu = c1351aArr;
        return new hh(qw.m2145f(c1352a), new C1190a("outlinks").m4853G(true).au(".private:outLinks").at("blob").fG());
    }

    private static hh m4862f(Uri uri) {
        return new hh(uri.toString(), new C1190a("web_url").m4855Q(4).m4853G(true).au(PlusShare.KEY_CALL_TO_ACTION_URL).fG());
    }

    private static String m4863g(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static hf m4864h(String str, String str2) {
        return new hf(str, "", str2);
    }

    private static hh m4865i(String str, String str2) {
        return new hh(str2, new C1190a(str).m4853G(true).fG(), str);
    }

    public int describeContents() {
        hs hsVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.Dw, Long.valueOf(this.Dx), Integer.valueOf(this.Dy)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        hs hsVar = CREATOR;
        hs.m4866a(this, parcel, i);
    }
}
