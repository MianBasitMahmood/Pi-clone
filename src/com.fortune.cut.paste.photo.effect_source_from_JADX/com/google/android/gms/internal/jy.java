package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0757g;
import com.google.android.gms.dynamic.C0757g.C0756a;
import com.google.android.gms.internal.ju.C1263a;

public final class jy extends C0757g<ju> {
    private static final jy Nt;

    static {
        Nt = new jy();
    }

    private jy() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m5224b(Context context, int i, int i2) throws C0756a {
        return Nt.m5225c(context, i, i2);
    }

    private View m5225c(Context context, int i, int i2) throws C0756a {
        try {
            return (View) C0755e.m2593f(((ju) m2595L(context)).m5208a(C0755e.m2594k(context), i, i2));
        } catch (Throwable e) {
            throw new C0756a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public final ju m5226S(IBinder iBinder) {
        return C1263a.m5210R(iBinder);
    }

    public final /* synthetic */ Object m5227d(IBinder iBinder) {
        return m5226S(iBinder);
    }
}
