package com.chartboost.sdk.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.chartboost.sdk.C0173e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0148a;
import com.google.android.gms.cast.TextTrackStyle;

public final class bh {

    /* renamed from: com.chartboost.sdk.impl.bh.a */
    public interface C0167a {
        void m476a(C0148a c0148a);
    }

    /* renamed from: com.chartboost.sdk.impl.bh.1 */
    static class C02591 implements OnGlobalLayoutListener {
        final /* synthetic */ View f716a;
        final /* synthetic */ C0262b f717b;
        final /* synthetic */ C0148a f718c;
        final /* synthetic */ C0167a f719d;
        final /* synthetic */ boolean f720e;

        C02591(View view, C0262b c0262b, C0148a c0148a, C0167a c0167a, boolean z) {
            this.f716a = view;
            this.f717b = c0262b;
            this.f718c = c0148a;
            this.f719d = c0167a;
            this.f720e = z;
        }

        public final void onGlobalLayout() {
            this.f716a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            bh.m1109c(this.f717b, this.f718c, this.f719d, this.f720e);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bh.2 */
    static class C02602 implements Runnable {
        final /* synthetic */ C0167a f721a;
        final /* synthetic */ C0148a f722b;

        C02602(C0167a c0167a, C0148a c0148a) {
            this.f721a = c0167a;
            this.f722b = c0148a;
        }

        public final void run() {
            this.f721a.m476a(this.f722b);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bh.3 */
    static /* synthetic */ class C02613 {
        static final /* synthetic */ int[] f723a;

        static {
            f723a = new int[C0262b.values().length];
            try {
                f723a[C0262b.CBAnimationTypeFade.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f723a[C0262b.CBAnimationTypePerspectiveZoom.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f723a[C0262b.CBAnimationTypePerspectiveRotate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f723a[C0262b.CBAnimationTypeSlideFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f723a[C0262b.CBAnimationTypeSlideFromTop.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f723a[C0262b.CBAnimationTypeSlideFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f723a[C0262b.CBAnimationTypeSlideFromRight.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f723a[C0262b.CBAnimationTypeBounce.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bh.b */
    public enum C0262b {
        CBAnimationTypePerspectiveRotate,
        CBAnimationTypeBounce,
        CBAnimationTypePerspectiveZoom,
        CBAnimationTypeSlideFromTop,
        CBAnimationTypeSlideFromBottom,
        CBAnimationTypeFade,
        CBAnimationTypeNone,
        CBAnimationTypeSlideFromLeft,
        CBAnimationTypeSlideFromRight;

        public static C0262b m1102a(int i) {
            if (i != 0 && i > 0 && i <= C0262b.values().length) {
                return C0262b.values()[i - 1];
            }
            return null;
        }
    }

    public static void m1103a(C0262b c0262b, C0148a c0148a, C0167a c0167a) {
        m1108b(c0262b, c0148a, c0167a, true);
    }

    public static void m1107b(C0262b c0262b, C0148a c0148a, C0167a c0167a) {
        m1109c(c0262b, c0148a, c0167a, false);
    }

    private static void m1108b(C0262b c0262b, C0148a c0148a, C0167a c0167a, boolean z) {
        if (c0262b == C0262b.CBAnimationTypeNone) {
            if (c0167a != null) {
                c0167a.m476a(c0148a);
            }
        } else if (c0148a == null || c0148a.f197h == null) {
            CBLogging.m97a("AnimationManager", "Transition of impression canceled due to lack of container");
        } else {
            View f = c0148a.f197h.m1128f();
            if (f == null) {
                C0173e.m479a().m490d(c0148a);
                CBLogging.m97a("AnimationManager", "Transition of impression canceled due to lack of view");
                return;
            }
            ViewTreeObserver viewTreeObserver = f.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new C02591(f, c0262b, c0148a, c0167a, z));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m1109c(com.chartboost.sdk.impl.bh.C0262b r11, com.chartboost.sdk.Model.C0148a r12, com.chartboost.sdk.impl.bh.C0167a r13, boolean r14) {
        /*
        r10 = new android.view.animation.AnimationSet;
        r0 = 1;
        r10.<init>(r0);
        r0 = new android.view.animation.AlphaAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r1, r2);
        r10.addAnimation(r0);
        if (r12 == 0) goto L_0x0018;
    L_0x0014:
        r0 = r12.f197h;
        if (r0 != 0) goto L_0x0020;
    L_0x0018:
        r0 = "AnimationManager";
        r1 = "Transition of impression canceled due to lack of container";
        com.chartboost.sdk.Libraries.CBLogging.m97a(r0, r1);
    L_0x001f:
        return;
    L_0x0020:
        r0 = r12.f197h;
        r0 = r0.m1128f();
        if (r0 != 0) goto L_0x0030;
    L_0x0028:
        r0 = "AnimationManager";
        r1 = "Transition of impression canceled due to lack of view";
        com.chartboost.sdk.Libraries.CBLogging.m97a(r0, r1);
        goto L_0x001f;
    L_0x0030:
        r1 = r12.f194e;
        r2 = com.chartboost.sdk.Model.C0148a.C0147d.INTERSTITIAL_REWARD_VIDEO;
        if (r1 == r2) goto L_0x003c;
    L_0x0036:
        r1 = r12.f194e;
        r2 = com.chartboost.sdk.Model.C0148a.C0147d.INTERSTITIAL_VIDEO;
        if (r1 != r2) goto L_0x02ef;
    L_0x003c:
        r0 = r12.f197h;
        r9 = r0;
    L_0x003f:
        r0 = r9.getWidth();
        r7 = (float) r0;
        r0 = r9.getHeight();
        r6 = (float) r0;
        r0 = com.chartboost.sdk.impl.bh.C02613.f723a;
        r1 = r11.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x005f;
            case 2: goto L_0x0086;
            case 3: goto L_0x0111;
            case 4: goto L_0x019c;
            case 5: goto L_0x01bd;
            case 6: goto L_0x01df;
            case 7: goto L_0x0200;
            case 8: goto L_0x0222;
            default: goto L_0x0054;
        };
    L_0x0054:
        r0 = r10;
    L_0x0055:
        r1 = com.chartboost.sdk.impl.bh.C0262b.CBAnimationTypeNone;
        if (r11 != r1) goto L_0x02da;
    L_0x0059:
        if (r13 == 0) goto L_0x001f;
    L_0x005b:
        r13.m476a(r12);
        goto L_0x001f;
    L_0x005f:
        if (r14 == 0) goto L_0x007d;
    L_0x0061:
        r0 = new android.view.animation.AlphaAnimation;
        r1 = 0;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r1, r2);
    L_0x0069:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r1 = new android.view.animation.AnimationSet;
        r2 = 1;
        r1.<init>(r2);
        r1.addAnimation(r0);
        r0 = r1;
        goto L_0x0055;
    L_0x007d:
        r0 = new android.view.animation.AlphaAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 0;
        r0.<init>(r1, r2);
        goto L_0x0069;
    L_0x0086:
        if (r14 == 0) goto L_0x00e3;
    L_0x0088:
        r0 = new com.chartboost.sdk.impl.bm;
        r1 = -1032847360; // 0xffffffffc2700000 float:-60.0 double:NaN;
        r2 = 0;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r7 / r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r6 / r4;
        r5 = 0;
        r0.<init>(r1, r2, r3, r4, r5);
    L_0x0099:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        if (r14 == 0) goto L_0x00f5;
    L_0x00a7:
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r1, r2, r3, r4);
    L_0x00b6:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        if (r14 == 0) goto L_0x0105;
    L_0x00c4:
        r0 = new android.view.animation.TranslateAnimation;
        r1 = 1050253722; // 0x3e99999a float:0.3 double:5.188942835E-315;
        r1 = r1 * r7;
        r2 = 0;
        r3 = -r6;
        r4 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r3 = r3 * r4;
        r4 = 0;
        r0.<init>(r1, r2, r3, r4);
    L_0x00d4:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        r0 = r10;
        goto L_0x0055;
    L_0x00e3:
        r0 = new com.chartboost.sdk.impl.bm;
        r1 = 0;
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r7 / r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r6 / r4;
        r5 = 0;
        r0.<init>(r1, r2, r3, r4, r5);
        goto L_0x0099;
    L_0x00f5:
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r0.<init>(r1, r2, r3, r4);
        goto L_0x00b6;
    L_0x0105:
        r0 = new android.view.animation.TranslateAnimation;
        r1 = 0;
        r2 = 1050253722; // 0x3e99999a float:0.3 double:5.188942835E-315;
        r2 = r2 * r7;
        r3 = 0;
        r0.<init>(r1, r2, r3, r6);
        goto L_0x00d4;
    L_0x0111:
        if (r14 == 0) goto L_0x016e;
    L_0x0113:
        r0 = new com.chartboost.sdk.impl.bm;
        r1 = -1032847360; // 0xffffffffc2700000 float:-60.0 double:NaN;
        r2 = 0;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r7 / r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r6 / r4;
        r5 = 1;
        r0.<init>(r1, r2, r3, r4, r5);
    L_0x0124:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        if (r14 == 0) goto L_0x0180;
    L_0x0132:
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r1, r2, r3, r4);
    L_0x0141:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        if (r14 == 0) goto L_0x0190;
    L_0x014f:
        r0 = new android.view.animation.TranslateAnimation;
        r1 = -r7;
        r2 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r1 = r1 * r2;
        r2 = 0;
        r3 = 1050253722; // 0x3e99999a float:0.3 double:5.188942835E-315;
        r3 = r3 * r6;
        r4 = 0;
        r0.<init>(r1, r2, r3, r4);
    L_0x015f:
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        r0 = r10;
        goto L_0x0055;
    L_0x016e:
        r0 = new com.chartboost.sdk.impl.bm;
        r1 = 0;
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r7 / r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r6 / r4;
        r5 = 1;
        r0.<init>(r1, r2, r3, r4, r5);
        goto L_0x0124;
    L_0x0180:
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = 1053609165; // 0x3ecccccd float:0.4 double:5.205520926E-315;
        r0.<init>(r1, r2, r3, r4);
        goto L_0x0141;
    L_0x0190:
        r0 = new android.view.animation.TranslateAnimation;
        r1 = 0;
        r2 = 0;
        r3 = 1050253722; // 0x3e99999a float:0.3 double:5.188942835E-315;
        r3 = r3 * r6;
        r0.<init>(r1, r7, r2, r3);
        goto L_0x015f;
    L_0x019c:
        if (r14 == 0) goto L_0x01b8;
    L_0x019e:
        r1 = r6;
    L_0x019f:
        if (r14 == 0) goto L_0x01bb;
    L_0x01a1:
        r0 = 0;
    L_0x01a2:
        r2 = new android.view.animation.TranslateAnimation;
        r3 = 0;
        r4 = 0;
        r2.<init>(r3, r4, r1, r0);
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r2.setDuration(r0);
        r0 = 1;
        r2.setFillAfter(r0);
        r10.addAnimation(r2);
        r0 = r10;
        goto L_0x0055;
    L_0x01b8:
        r0 = 0;
        r1 = r0;
        goto L_0x019f;
    L_0x01bb:
        r0 = r6;
        goto L_0x01a2;
    L_0x01bd:
        if (r14 == 0) goto L_0x01da;
    L_0x01bf:
        r0 = -r6;
        r1 = r0;
    L_0x01c1:
        if (r14 == 0) goto L_0x01dd;
    L_0x01c3:
        r0 = 0;
    L_0x01c4:
        r2 = new android.view.animation.TranslateAnimation;
        r3 = 0;
        r4 = 0;
        r2.<init>(r3, r4, r1, r0);
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r2.setDuration(r0);
        r0 = 1;
        r2.setFillAfter(r0);
        r10.addAnimation(r2);
        r0 = r10;
        goto L_0x0055;
    L_0x01da:
        r0 = 0;
        r1 = r0;
        goto L_0x01c1;
    L_0x01dd:
        r0 = -r6;
        goto L_0x01c4;
    L_0x01df:
        if (r14 == 0) goto L_0x01fb;
    L_0x01e1:
        r1 = r7;
    L_0x01e2:
        if (r14 == 0) goto L_0x01fe;
    L_0x01e4:
        r0 = 0;
    L_0x01e5:
        r2 = new android.view.animation.TranslateAnimation;
        r3 = 0;
        r4 = 0;
        r2.<init>(r1, r0, r3, r4);
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r2.setDuration(r0);
        r0 = 1;
        r2.setFillAfter(r0);
        r10.addAnimation(r2);
        r0 = r10;
        goto L_0x0055;
    L_0x01fb:
        r0 = 0;
        r1 = r0;
        goto L_0x01e2;
    L_0x01fe:
        r0 = r7;
        goto L_0x01e5;
    L_0x0200:
        if (r14 == 0) goto L_0x021d;
    L_0x0202:
        r0 = -r7;
        r1 = r0;
    L_0x0204:
        if (r14 == 0) goto L_0x0220;
    L_0x0206:
        r0 = 0;
    L_0x0207:
        r2 = new android.view.animation.TranslateAnimation;
        r3 = 0;
        r4 = 0;
        r2.<init>(r1, r0, r3, r4);
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r2.setDuration(r0);
        r0 = 1;
        r2.setFillAfter(r0);
        r10.addAnimation(r2);
        r0 = r10;
        goto L_0x0055;
    L_0x021d:
        r0 = 0;
        r1 = r0;
        goto L_0x0204;
    L_0x0220:
        r0 = -r7;
        goto L_0x0207;
    L_0x0222:
        if (r14 == 0) goto L_0x02b6;
    L_0x0224:
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1058642330; // 0x3f19999a float:0.6 double:5.230388065E-315;
        r2 = 1066192077; // 0x3f8ccccd float:1.1 double:5.26768877E-315;
        r3 = 1058642330; // 0x3f19999a float:0.6 double:5.230388065E-315;
        r4 = 1066192077; // 0x3f8ccccd float:1.1 double:5.26768877E-315;
        r5 = 1;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = 1;
        r8 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        r1 = 1125515264; // 0x43160000 float:150.0 double:5.56078426E-315;
        r1 = java.lang.Math.round(r1);
        r1 = (long) r1;
        r0.setDuration(r1);
        r1 = 0;
        r0.setStartOffset(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 1062302812; // 0x3f51745c float:0.81818175 double:5.24847325E-315;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = 1062302812; // 0x3f51745c float:0.81818175 double:5.24847325E-315;
        r5 = 1;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = 1;
        r8 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        r1 = 1112014847; // 0x4247ffff float:49.999996 double:5.494083336E-315;
        r1 = java.lang.Math.round(r1);
        r1 = (long) r1;
        r0.setDuration(r1);
        r1 = 1125515264; // 0x43160000 float:150.0 double:5.56078426E-315;
        r1 = java.lang.Math.round(r1);
        r1 = (long) r1;
        r0.setStartOffset(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 1066285284; // 0x3f8e38e4 float:1.1111112 double:5.268149275E-315;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = 1066285284; // 0x3f8e38e4 float:1.1111112 double:5.268149275E-315;
        r5 = 1;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = 1;
        r8 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        r1 = 1103626235; // 0x41c7fffb float:24.99999 double:5.452638086E-315;
        r1 = java.lang.Math.round(r1);
        r1 = (long) r1;
        r0.setDuration(r1);
        r1 = 1128792064; // 0x43480000 float:200.0 double:5.5769738E-315;
        r1 = java.lang.Math.round(r1);
        r1 = (long) r1;
        r0.setStartOffset(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        r0 = r10;
        goto L_0x0055;
    L_0x02b6:
        r0 = new android.view.animation.ScaleAnimation;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = 0;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = 0;
        r5 = 1;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r7 = 1;
        r8 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r1 = 0;
        r0.setStartOffset(r1);
        r1 = 1;
        r0.setFillAfter(r1);
        r10.addAnimation(r0);
        goto L_0x0054;
    L_0x02da:
        if (r13 == 0) goto L_0x02ea;
    L_0x02dc:
        r1 = com.chartboost.sdk.Libraries.CBUtility.m120e();
        r2 = new com.chartboost.sdk.impl.bh$2;
        r2.<init>(r13, r12);
        r3 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r1.postDelayed(r2, r3);
    L_0x02ea:
        r9.startAnimation(r0);
        goto L_0x001f;
    L_0x02ef:
        r9 = r0;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.bh.c(com.chartboost.sdk.impl.bh$b, com.chartboost.sdk.Model.a, com.chartboost.sdk.impl.bh$a, boolean):void");
    }

    public static void m1105a(boolean z, View view) {
        m1106a(z, view, 250);
    }

    public static void m1106a(boolean z, View view, long j) {
        float f;
        float f2 = TextTrackStyle.DEFAULT_FONT_SCALE;
        view.clearAnimation();
        if (z) {
            view.setVisibility(0);
        }
        if (z) {
            f = 0.0f;
        } else {
            f = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        if (!z) {
            f2 = 0.0f;
        }
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(250);
        alphaAnimation.setFillBefore(true);
        view.startAnimation(alphaAnimation);
    }
}
