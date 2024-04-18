package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0757g;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C1717c.C1719a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C1733g extends C0757g<C1717c> {
    private static final C1733g anP;

    static {
        anP = new C1733g();
    }

    private C1733g() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View m6353a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0755e.m2593f(((C1717c) anP.m2595L(context)).m6295a(C0755e.m2594k(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    protected final C1717c bO(IBinder iBinder) {
        return C1719a.bL(iBinder);
    }

    protected final /* synthetic */ Object m6354d(IBinder iBinder) {
        return bO(iBinder);
    }
}
