package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import com.chartboost.sdk.C0153b;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.Libraries.k */
public final class C0140k extends WeakReference<Activity> {
    private static C0140k f156b;
    private int f157a;

    private C0140k(Activity activity) {
        super(activity);
        this.f157a = activity.hashCode();
    }

    public static C0140k m275a(Activity activity) {
        if (f156b == null || f156b.f157a != activity.hashCode()) {
            f156b = new C0140k(activity);
        }
        return f156b;
    }

    public final boolean m279b(Activity activity) {
        if (activity != null && activity.hashCode() == this.f157a) {
            return true;
        }
        return false;
    }

    public final boolean m277a(C0140k c0140k) {
        if (c0140k != null && c0140k.m276a() == this.f157a) {
            return true;
        }
        return false;
    }

    public final int m276a() {
        return this.f157a;
    }

    public final int hashCode() {
        return m276a();
    }

    public final Context m278b() {
        Context context = (Context) get();
        if (context == null) {
            return C0153b.m400l();
        }
        return context;
    }
}
