package com.chartboost.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import com.chartboost.sdk.C0153b.C0088a;
import com.chartboost.sdk.InPlay.C0100a;
import com.chartboost.sdk.Libraries.C0104a;
import com.chartboost.sdk.Libraries.C0108c;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.C0140k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0145b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C0151a;
import com.chartboost.sdk.impl.C0335m;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.af;
import com.chartboost.sdk.impl.av;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0086d;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.bd;
import com.chartboost.sdk.impl.bg;
import java.util.Locale;

public final class Chartboost {
    protected static Handler f35a;
    protected static C0140k f36b;
    private static volatile Chartboost f37c;
    private static CBImpressionActivity f38d;
    private static C0148a f39e;
    private static ay f40f;
    private static ba f41g;
    private static C0335m f42h;
    private static C0151a f43i;
    private static boolean f44j;
    private static SparseBooleanArray f45k;
    private static C0173e f46l;
    private static C0161c f47m;
    private static boolean f48n;
    private static Runnable f49o;
    private static boolean f50p;
    private static boolean f51q;
    private static Runnable f52r;

    /* renamed from: com.chartboost.sdk.Chartboost.10 */
    static class AnonymousClass10 implements Runnable {
        final /* synthetic */ Activity f15a;

        AnonymousClass10(Activity activity) {
            this.f15a = activity;
        }

        public final void run() {
            C0140k a = C0140k.m275a(this.f15a);
            if (Chartboost.m51d(a)) {
                Chartboost.m43b(a);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.11 */
    static class AnonymousClass11 implements Runnable {
        final /* synthetic */ Activity f16a;

        AnonymousClass11(Activity activity) {
            this.f16a = activity;
        }

        public final void run() {
            C0140k a = C0140k.m275a(this.f16a);
            if (Chartboost.m51d(a)) {
                Chartboost.m56f(a);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.12 */
    static class AnonymousClass12 implements Runnable {
        final /* synthetic */ C0161c f17a;

        AnonymousClass12(C0161c c0161c) {
            this.f17a = c0161c;
        }

        public final void run() {
            this.f17a.m426b();
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.1 */
    static class C00781 implements Runnable {
        final /* synthetic */ Activity f18a;
        final /* synthetic */ String f19b;
        final /* synthetic */ String f20c;

        C00781(Activity activity, String str, String str2) {
            this.f18a = activity;
            this.f19b = str;
            this.f20c = str2;
        }

        public final void run() {
            Chartboost.f37c = new Chartboost(this.f19b, this.f20c, null);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.2 */
    static class C00792 implements Runnable {
        final /* synthetic */ C0173e f21a;
        final /* synthetic */ C0161c f22b;

        C00792(C0173e c0173e, C0161c c0161c) {
            this.f21a = c0173e;
            this.f22b = c0161c;
        }

        public final void run() {
            this.f21a.m484a(this.f22b.m427c(), true);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.3 */
    static class C00803 implements Runnable {
        final /* synthetic */ Activity f23a;

        C00803(Activity activity) {
            this.f23a = activity;
        }

        public final void run() {
            if (Chartboost.f36b == null || Chartboost.f36b.m279b(this.f23a)) {
                Chartboost.f35a.removeCallbacks(Chartboost.f49o);
                Chartboost.f49o = new C0091a();
                Chartboost.f35a.postDelayed(Chartboost.f49o, 10000);
            }
            Chartboost.m41b(this.f23a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.4 */
    static class C00814 implements Runnable {
        final /* synthetic */ Activity f24a;

        C00814(Activity activity) {
            this.f24a = activity;
        }

        public final void run() {
            CBLogging.m107e("VideoInit", "preparing activity for video surface");
            this.f24a.addContentView(new SurfaceView(this.f24a), new LayoutParams(0, 0));
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.5 */
    static class C00825 implements Runnable {
        final /* synthetic */ Activity f25a;

        C00825(Activity activity) {
            this.f25a = activity;
        }

        public final void run() {
            Chartboost.m49d(this.f25a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.6 */
    static class C00836 implements Runnable {
        final /* synthetic */ Activity f26a;

        C00836(Activity activity) {
            this.f26a = activity;
        }

        public final void run() {
            Chartboost.f35a.removeCallbacks(Chartboost.f49o);
            if (!(Chartboost.f36b == null || Chartboost.f36b.m279b(this.f26a) || !Chartboost.m67p())) {
                Chartboost.m56f(Chartboost.f36b);
                Chartboost.m48c(Chartboost.f36b, false);
            }
            Chartboost.m42b(this.f26a, true);
            Chartboost.f36b = C0140k.m275a(this.f26a);
            Chartboost.m28a();
            Chartboost.m30a(this.f26a);
            Chartboost.f40f.m875b(C0153b.f238a);
            if (!C0153b.m390e()) {
                Chartboost.f42h.m1354a();
            }
            Chartboost.f41g.m954f();
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.7 */
    static class C00847 implements Runnable {
        C00847() {
        }

        public final void run() {
            if (!Chartboost.f51q) {
                Chartboost.m45c();
            }
            Chartboost.f51q = false;
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.8 */
    static class C00898 implements C0088a {
        final /* synthetic */ boolean f28a;

        /* renamed from: com.chartboost.sdk.Chartboost.8.1 */
        class C00871 extends C0086d {
            final /* synthetic */ C00898 f27a;

            C00871(C00898 c00898) {
                this.f27a = c00898;
            }

            public void m23a(C0111a c0111a, az azVar) {
                if (CBUtility.m115a(C0153b.m400l())) {
                    Object e = c0111a.m162e("latest-sdk-version");
                    if (!TextUtils.isEmpty(e) && !e.equals("5.1.2")) {
                        CBLogging.m99a(String.format(Locale.US, "Chartboost SDK is not up to date. (Current: %s, Latest: %s)\n Download latest SDK at:\n\thttps://www.chartboost.com/support/sdk_download/?os=ios", new Object[]{"5.1.2", e}));
                    }
                }
            }
        }

        C00898(boolean z) {
            this.f28a = z;
        }

        public final void m25a() {
            if (this.f28a) {
                bd.m1000b();
                az azVar = new az("api/install");
                azVar.m896b(Chartboost.getValidContext());
                azVar.m893a(true);
                azVar.m894a(C0131g.m223a("status", C0104a.f83a));
                azVar.m886a(new C00871(this));
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.9 */
    static class C00909 implements Runnable {
        final /* synthetic */ Activity f29a;

        C00909(Activity activity) {
            this.f29a = activity;
        }

        public final void run() {
            C0140k a = C0140k.m275a(this.f29a);
            if (Chartboost.m51d(a)) {
                Chartboost.m33a(a);
            } else if (C0153b.m373a() != null && C0153b.m373a().ordinal() == CBFramework.CBFrameworkUnity.ordinal()) {
                Chartboost.m28a();
            }
        }
    }

    public enum CBFramework {
        CBFrameworkUnity("Unity"),
        CBFrameworkCorona("Corona"),
        CBFrameworkAir("AIR"),
        CBFrameworkGameSalad("GameSalad"),
        CBFrameworkCordova("Cordova"),
        CBFrameworkCocoonJS("CocoonJS"),
        CBFrameworkCocos2dx("Cocos2dx"),
        CBFrameworkMoPub("MoPub"),
        CBFrameworkFyber("Fyber"),
        CBFrameworkPrime31Unreal("Prime31Unreal");
        
        private final String f31a;

        private CBFramework(String str) {
            this.f31a = str;
        }

        public final String toString() {
            return this.f31a;
        }

        public final boolean doesWrapperUseCustomShouldDisplayBehavior() {
            return this == CBFrameworkAir || this == CBFrameworkCocos2dx;
        }

        public final boolean doesWrapperUseCustomBackgroundingBehavior() {
            return this == CBFrameworkAir;
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.a */
    private static class C0091a implements Runnable {
        private int f32a;
        private int f33b;
        private int f34c;

        private C0092a m26a() {
            return C0153b.m387d();
        }

        private C0091a() {
            int i = -1;
            C0092a a = m26a();
            this.f32a = Chartboost.f38d == null ? -1 : Chartboost.f38d.hashCode();
            this.f33b = Chartboost.f36b == null ? -1 : Chartboost.f36b.hashCode();
            if (a != null) {
                i = a.hashCode();
            }
            this.f34c = i;
        }

        public void run() {
            C0092a a = m26a();
            if (C0153b.m400l() != null) {
                Chartboost.clearCache();
            }
            if (Chartboost.f36b != null && Chartboost.f36b.hashCode() == this.f33b) {
                Chartboost.f36b = null;
            }
            if (Chartboost.f38d != null && Chartboost.f38d.hashCode() == this.f32a) {
                Chartboost.f38d = null;
            }
            if (a != null && a.hashCode() == this.f34c) {
                C0153b.m377a(null);
            }
        }
    }

    static {
        f37c = null;
        f38d = null;
        f39e = null;
        f40f = null;
        f41g = null;
        f42h = null;
        f43i = null;
        f44j = false;
        f45k = new SparseBooleanArray();
        f46l = null;
        f47m = null;
        f48n = false;
        f36b = null;
        f50p = false;
        f51q = false;
        f52r = new C00847();
    }

    private Chartboost(Activity activity, String str, String str2) {
        C0153b.f239b = activity.getApplication();
        C0153b.f238a = activity.getApplicationContext();
        f37c = this;
        Handler handler = new Handler();
        f35a = handler;
        CBUtility.m112a(handler);
        f40f = ay.m871a();
        f46l = C0173e.m479a();
        ba a = ba.m938a(C0153b.f238a);
        f41g = a;
        f42h = a.m949a();
        f47m = C0161c.m420a();
        f43i = C0151a.m323a();
        f40f.m872a(C0153b.f238a);
        bd.m992a();
        f49o = new C0091a();
        C0153b.m379a(str);
        C0153b.m382b(str2);
        C0108c.m130a();
    }

    public static void startWithAppId(Activity activity, String str, String str2) {
        if (f37c == null) {
            synchronized (Chartboost.class) {
                if (f37c == null) {
                    if (activity == null && !(activity instanceof Activity)) {
                        throw new RuntimeException("Activity object is null. Please pass a valid activity object");
                    } else if (str == null || str2 == null) {
                        throw new RuntimeException("appId or appSignature is null. Please pass a valid id's");
                    } else {
                        m36a(new C00781(activity, str, str2));
                    }
                }
            }
        }
    }

    public static void onCreate(Activity activity) {
        C0153b.m404p();
        m36a(new C00825(activity));
    }

    private static void m49d(Activity activity) {
        if (!(f36b == null || f36b.m279b(activity) || !m67p())) {
            m56f(f36b);
            m48c(f36b, false);
        }
        f35a.removeCallbacks(f49o);
        f36b = C0140k.m275a(activity);
        if (!getImpressionsUseActivities()) {
            createSurfaceView(activity);
        }
        ba.m945d();
    }

    public static void onStart(Activity activity) {
        C0153b.m404p();
        m36a(new C00836(activity));
    }

    protected static void m30a(Activity activity) {
        boolean z;
        C0153b.f238a = activity.getApplicationContext();
        if (activity instanceof CBImpressionActivity) {
            m32a((CBImpressionActivity) activity);
        } else {
            C0140k a = C0140k.m275a(activity);
            f36b = a;
            m48c(a, true);
        }
        f35a.removeCallbacks(f49o);
        if (C0153b.m373a() == null || !C0153b.m373a().doesWrapperUseCustomBackgroundingBehavior()) {
            z = false;
        } else {
            z = true;
        }
        if (activity == null) {
            return;
        }
        if (z || m54e(activity)) {
            C0140k.m275a(activity);
            if (activity instanceof CBImpressionActivity) {
                f48n = false;
            }
            if (f47m.m424a(activity, f39e)) {
                f39e = null;
            }
            C0148a c = f47m.m427c();
            if (c != null) {
                c.m314u();
            }
        }
    }

    protected static void m28a() {
        if (C0153b.f238a == null) {
            throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling startSession().");
        } else if (!C0153b.m390e() || !C0153b.m401m()) {
            m66o();
        } else if (f50p) {
            f51q = true;
        } else {
            f51q = false;
            m66o();
        }
    }

    protected static void m40b() {
        if (C0153b.m390e()) {
            f35a.postDelayed(f52r, 500);
        } else {
            m45c();
        }
    }

    private static void m66o() {
        f50p = true;
        C0153b.m386c(true);
        f43i.m362h();
        C0151a.m337b();
        C0153b.m378a(new C00898(C0151a.m352i()));
    }

    protected static void m45c() {
        f50p = false;
        if (f43i == null) {
            f43i = C0151a.m323a();
        }
        f43i.m359c();
    }

    public static void onResume(Activity activity) {
        C0153b.m404p();
        m36a(new C00909(activity));
    }

    protected static void m33a(C0140k c0140k) {
        C0148a c = C0161c.m420a().m427c();
        if (C0153b.m373a() != null && C0153b.m373a().ordinal() == CBFramework.CBFrameworkUnity.ordinal()) {
            m28a();
        }
        if (c != null) {
            c.m313t();
        }
    }

    public static void onPause(Activity activity) {
        C0153b.m404p();
        m36a(new AnonymousClass10(activity));
    }

    protected static void m43b(C0140k c0140k) {
        C0148a c = C0161c.m420a().m427c();
        if (c != null) {
            c.m315v();
        }
    }

    public static void onStop(Activity activity) {
        C0153b.m404p();
        m36a(new AnonymousClass11(activity));
    }

    private static void m56f(C0140k c0140k) {
        if (!C0153b.m390e()) {
            m47c(c0140k);
        }
        if (!(c0140k.get() instanceof CBImpressionActivity)) {
            m48c(c0140k, false);
        }
        f40f.m877c(C0153b.f238a);
        if (!C0153b.m390e()) {
            f42h.m1358b();
        }
        f41g.m955g();
        m40b();
    }

    protected static void m47c(C0140k c0140k) {
        C0173e g = m57g();
        if (m58g(c0140k) && g != null) {
            C0148a c = C0161c.m420a().m427c();
            if (c != null) {
                g.m487c(c);
                f39e = c;
            }
            if (c0140k.get() instanceof CBImpressionActivity) {
                m55f();
            }
        }
        if (!(c0140k.get() instanceof CBImpressionActivity)) {
            m48c(c0140k, false);
        }
    }

    public static boolean onBackPressed() {
        C0153b.m404p();
        if (f36b == null) {
            throw new IllegalStateException("The Chartboost methods onCreate(), onStart(), onStop(), and onDestroy() must be called in the corresponding methods of your activity in order for Chartboost to function properly.");
        } else if (!C0153b.m390e()) {
            return m50d();
        } else {
            if (!f48n) {
                return false;
            }
            f48n = false;
            m50d();
            return true;
        }
    }

    protected static boolean m50d() {
        C0161c a = C0161c.m420a();
        C0148a c = a.m427c();
        if (c == null || c.f191b != C0145b.DISPLAYED) {
            C0173e g = m57g();
            if (g == null || !g.m486b()) {
                return false;
            }
            m36a(new C00792(g, a));
            return true;
        } else if (c.m312s()) {
            return true;
        } else {
            m36a(new AnonymousClass12(a));
            return true;
        }
    }

    public static void onDestroy(Activity activity) {
        C0153b.m404p();
        m36a(new C00803(activity));
    }

    protected static void m41b(Activity activity) {
        C0140k.m275a(activity);
    }

    public static void didPassAgeGate(boolean z) {
        C0153b.m388d(z);
    }

    public static void setShouldPauseClickForConfirmation(boolean z) {
        C0153b.m389e(z);
    }

    public static void clearCache() {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (C0153b.f238a == null) {
            throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling clearImageCache().");
        }
        bc.m973a().m980b();
        af.m620h().m444a();
        ae.m590f().m444a();
        av.m827f().m829a();
        C0100a.m87b();
    }

    public static boolean hasRewardedVideo(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        return af.m620h().m456c(str);
    }

    public static void cacheRewardedVideo(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b("Chartboost", "cacheRewardedVideo location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadRewardedVideo(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        af.m620h().m451b(str);
    }

    public static void showRewardedVideo(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b("Chartboost", "showRewardedVideo location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadRewardedVideo(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        af.m620h().m449a(str);
    }

    public static boolean hasInterstitial(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        return ae.m590f().m456c(str);
    }

    public static void cacheInterstitial(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b("Chartboost", "cacheInterstitial location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInterstitial(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        ae.m590f().m451b(str);
    }

    public static void showInterstitial(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b("Chartboost", "showInterstitial location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInterstitial(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        ae.m590f().m449a(str);
    }

    public static boolean hasMoreApps(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        return av.m827f().m456c(str);
    }

    public static void cacheMoreApps(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b("Chartboost", "cacheMoreApps location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadMoreApps(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        av.m827f().m451b(str);
    }

    public static void showMoreApps(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b("Chartboost", "showMoreApps location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadMoreApps(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        av.m827f().m831a(str);
    }

    public static boolean isAnyViewVisible() {
        C0173e g = m57g();
        if (g == null) {
            return false;
        }
        return g.m488c();
    }

    public static void setFramework(CBFramework cBFramework) {
        C0153b.m374a(cBFramework);
    }

    public static String getCustomId() {
        return C0153b.m399k();
    }

    public static void setCustomId(String str) {
        C0153b.m385c(str);
    }

    public static void setLoggingLevel(Level level) {
        C0153b.m375a(level);
    }

    public static Level getLoggingLevel() {
        return C0153b.m398j();
    }

    public static C0092a getDelegate() {
        return C0153b.m387d();
    }

    public static void setDelegate(ChartboostDelegate chartboostDelegate) {
        C0153b.m377a((C0092a) chartboostDelegate);
    }

    public static boolean getAutoCacheAds() {
        return C0153b.m394g();
    }

    public static void setAutoCacheAds(boolean z) {
        C0153b.m383b(z);
    }

    public static void setShouldRequestInterstitialsInFirstSession(boolean z) {
        C0153b.m391f(z);
    }

    public static void setShouldDisplayLoadingViewForMoreApps(boolean z) {
        C0153b.m393g(z);
    }

    public static void setShouldPrefetchVideoContent(boolean z) {
        C0153b.m396h(z);
        if (z) {
            bd.m1000b();
        } else {
            bd.m1006d();
        }
    }

    protected static Activity m52e() {
        if (C0153b.m390e()) {
            return f38d;
        }
        return getHostActivity();
    }

    private static boolean m54e(Activity activity) {
        if (C0153b.m390e()) {
            if (f38d == activity) {
                return true;
            }
            return false;
        } else if (f36b != null) {
            return f36b.m279b(activity);
        } else {
            if (activity != null) {
                return false;
            }
            return true;
        }
    }

    private static boolean m58g(C0140k c0140k) {
        if (C0153b.m390e()) {
            if (c0140k != null) {
                return c0140k.m279b(f38d);
            }
            if (f38d == null) {
                return true;
            }
            return false;
        } else if (f36b != null) {
            return f36b.m277a(c0140k);
        } else {
            if (c0140k != null) {
                return false;
            }
            return true;
        }
    }

    protected static void m32a(CBImpressionActivity cBImpressionActivity) {
        if (!f44j) {
            C0153b.f238a = cBImpressionActivity.getApplicationContext();
            f38d = cBImpressionActivity;
            f44j = true;
        }
        f35a.removeCallbacks(f49o);
    }

    protected static void m55f() {
        if (f44j) {
            f38d = null;
            f44j = false;
        }
    }

    protected static void m35a(C0148a c0148a) {
        boolean z = true;
        C0173e g = m57g();
        if (g != null && g.m488c() && g.m489d().m1130h() != c0148a) {
            c0148a.m291a(CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        } else if (!C0153b.m390e()) {
            g = m57g();
            if (g == null || !m67p()) {
                c0148a.m291a(CBImpressionError.NO_HOST_ACTIVITY);
            } else {
                g.m483a(c0148a);
            }
        } else if (f44j) {
            if (m52e() == null || g == null) {
                if (m52e() == null) {
                    CBLogging.m101b("Chartboost", "Activity not found to display the view");
                    c0148a.m291a(CBImpressionError.NO_HOST_ACTIVITY);
                } else {
                    CBLogging.m101b("Chartboost", "Missing view controller to manage the open impression activity");
                }
                c0148a.m291a(CBImpressionError.ERROR_DISPLAYING_VIEW);
                return;
            }
            g.m483a(c0148a);
        } else if (m67p()) {
            Context hostActivity = getHostActivity();
            if (hostActivity == null) {
                CBLogging.m101b("Chartboost", "Failed to display impression as the host activity reference has been lost!");
                c0148a.m291a(CBImpressionError.NO_HOST_ACTIVITY);
            } else if (f39e == null || f39e == c0148a) {
                f39e = c0148a;
                Intent intent = new Intent(hostActivity, CBImpressionActivity.class);
                boolean z2 = (hostActivity.getWindow().getAttributes().flags & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) != 0;
                boolean z3;
                if ((hostActivity.getWindow().getAttributes().flags & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                String str = "paramFullscreen";
                if (!z2 || r3) {
                    z = false;
                }
                intent.putExtra(str, z);
                try {
                    hostActivity.startActivity(intent);
                    f48n = true;
                } catch (ActivityNotFoundException e) {
                    throw new RuntimeException("Chartboost impression activity not declared in manifest. Please add the following inside your manifest's <application> tag: \n<activity android:name=\"com.chartboost.sdk.CBImpressionActivity\" android:theme=\"@android:style/Theme.Translucent.NoTitleBar\" android:excludeFromRecents=\"true\" />");
                }
            } else {
                c0148a.m291a(CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
            }
        } else {
            c0148a.m291a(CBImpressionError.NO_HOST_ACTIVITY);
        }
    }

    protected static Activity getHostActivity() {
        return f36b != null ? (Activity) f36b.get() : null;
    }

    protected static void m36a(Runnable runnable) {
        if (CBUtility.m117b()) {
            runnable.run();
        } else {
            f35a.post(runnable);
        }
    }

    protected static Context getValidContext() {
        return f36b != null ? f36b.m278b() : C0153b.m400l();
    }

    private static void m44b(C0140k c0140k, boolean z) {
    }

    private static boolean m67p() {
        return m51d(f36b);
    }

    protected static boolean m51d(C0140k c0140k) {
        if (c0140k == null) {
            return false;
        }
        Boolean valueOf = Boolean.valueOf(f45k.get(c0140k.m276a()));
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        return false;
    }

    private static void m42b(Activity activity, boolean z) {
        if (activity != null) {
            m29a(activity.hashCode(), z);
        }
    }

    private static void m48c(C0140k c0140k, boolean z) {
        if (c0140k != null) {
            m29a(c0140k.m276a(), z);
        }
    }

    private static void m29a(int i, boolean z) {
        f45k.put(i, z);
    }

    protected static C0173e m57g() {
        if (m52e() == null) {
            return null;
        }
        return f46l;
    }

    public static boolean getImpressionsUseActivities() {
        return C0153b.m390e();
    }

    public static void setImpressionsUseActivities(boolean z) {
        C0153b.m380a(z);
    }

    public static void createSurfaceView(Activity activity) {
        if (!bg.m1097a(activity)) {
            f35a.post(new C00814(activity));
        }
    }

    private static void showInterstitialAIR(String str, boolean z) {
        ae.m590f().m452b(str, z);
    }

    private static void showMoreAppsAIR(String str, boolean z) {
        av.m827f().m452b(str, z);
    }

    private static void showRewardedVideoAIR(String str, boolean z) {
        af.m620h().m452b(str, z);
    }
}
