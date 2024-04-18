package com.chartboost.sdk.impl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

public class bl {
    private static final String[] f747a;
    private C0184b f748b;

    /* renamed from: com.chartboost.sdk.impl.bl.b */
    public static abstract class C0184b {
        public abstract void m602a(bl blVar, int i);

        public void m601a(bl blVar) {
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bl.1 */
    class C02671 implements OnShowListener {
        final /* synthetic */ AlertDialog f740a;
        final /* synthetic */ int f741b;
        final /* synthetic */ ArrayList f742c;
        final /* synthetic */ int f743d;
        final /* synthetic */ bl f744e;

        /* renamed from: com.chartboost.sdk.impl.bl.1.1 */
        class C02661 implements OnClickListener {
            final /* synthetic */ int f738a;
            final /* synthetic */ C02671 f739b;

            C02661(C02671 c02671, int i) {
                this.f739b = c02671;
                this.f738a = i;
            }

            public void onClick(View view) {
                if (this.f739b.f744e.f748b != null) {
                    this.f739b.f744e.f748b.m602a(this.f739b.f744e, this.f738a);
                }
                this.f739b.f740a.dismiss();
            }
        }

        C02671(bl blVar, AlertDialog alertDialog, int i, ArrayList arrayList, int i2) {
            this.f744e = blVar;
            this.f740a = alertDialog;
            this.f741b = i;
            this.f742c = arrayList;
            this.f743d = i2;
        }

        public void onShow(DialogInterface dialogInterface) {
            Button[] a = bl.m1120b(this.f740a);
            for (int i = 0; i < this.f741b; i++) {
                CharSequence charSequence = (CharSequence) this.f742c.get(i);
                Button button = a[i];
                if (this.f743d == i) {
                    button.setTypeface(null, 1);
                }
                button.setText(charSequence);
                button.setOnClickListener(new C02661(this, i));
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bl.2 */
    class C02682 implements OnCancelListener {
        final /* synthetic */ bl f745a;

        C02682(bl blVar) {
            this.f745a = blVar;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f745a.f748b.m601a(this.f745a);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bl.a */
    public static class C0269a {
        private final Bundle f746a;

        public C0269a() {
            this.f746a = new Bundle();
        }

        public C0269a m1113a(String str) {
            this.f746a.putString("arg:title", str);
            return this;
        }

        public C0269a m1115b(String str) {
            this.f746a.putString("arg:message", str);
            return this;
        }

        public C0269a m1116c(String str) {
            this.f746a.putString("arg:left", str);
            return this;
        }

        public C0269a m1117d(String str) {
            this.f746a.putString("arg:right", str);
            return this;
        }

        public bl m1114a(Context context, C0184b c0184b) {
            return new bl(context, this.f746a, c0184b);
        }
    }

    static {
        f747a = new String[]{"arg:left", "arg:center", "arg:right"};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bl(android.content.Context r10, android.os.Bundle r11, com.chartboost.sdk.impl.bl.C0184b r12) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 0;
        r9.<init>();
        r9.f748b = r12;
        r0 = "arg:title";
        r2 = r11.getString(r0);
        r0 = "arg:message";
        r3 = r11.getString(r0);
        r0 = "arg:default";
        r4 = -1;
        r5 = r11.getInt(r0, r4);
        r4 = new java.util.ArrayList;
        r4.<init>();
        r0 = r1;
    L_0x0020:
        r6 = 3;
        if (r0 >= r6) goto L_0x0037;
    L_0x0023:
        r6 = f747a;
        r6 = r6[r0];
        r6 = r11.getString(r6);
        r7 = android.text.TextUtils.isEmpty(r6);
        if (r7 != 0) goto L_0x0034;
    L_0x0031:
        r4.add(r6);
    L_0x0034:
        r0 = r0 + 1;
        goto L_0x0020;
    L_0x0037:
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r10);
        r0 = r0.setTitle(r2);
        r2 = r0.setMessage(r3);
        r3 = r4.size();
        switch(r3) {
            case 1: goto L_0x0078;
            case 2: goto L_0x006e;
            case 3: goto L_0x0064;
            default: goto L_0x004b;
        };
    L_0x004b:
        r2 = r2.create();
        r0 = new com.chartboost.sdk.impl.bl$1;
        r1 = r9;
        r0.<init>(r1, r2, r3, r4, r5);
        r2.setOnShowListener(r0);
        r0 = new com.chartboost.sdk.impl.bl$2;
        r0.<init>(r9);
        r2.setOnCancelListener(r0);
        r2.show();
        return;
    L_0x0064:
        r0 = 2;
        r0 = r4.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r2.setNegativeButton(r0, r8);
    L_0x006e:
        r0 = 1;
        r0 = r4.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r2.setNeutralButton(r0, r8);
    L_0x0078:
        r0 = r4.get(r1);
        r0 = (java.lang.CharSequence) r0;
        r2.setPositiveButton(r0, r8);
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.bl.<init>(android.content.Context, android.os.Bundle, com.chartboost.sdk.impl.bl$b):void");
    }

    private static final Button[] m1120b(AlertDialog alertDialog) {
        ViewGroup viewGroup = (ViewGroup) alertDialog.getButton(-1).getParent();
        int childCount = viewGroup.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && (childAt instanceof Button)) {
                arrayList.add((Button) childAt);
            }
        }
        Button[] buttonArr = new Button[arrayList.size()];
        arrayList.toArray(buttonArr);
        return buttonArr;
    }
}
