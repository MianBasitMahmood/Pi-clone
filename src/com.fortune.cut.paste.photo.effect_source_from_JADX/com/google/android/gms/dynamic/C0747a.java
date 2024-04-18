package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0747a<T extends LifecycleDelegate> {
    private T Tu;
    private Bundle Tv;
    private LinkedList<C0740a> Tw;
    private final C0738f<T> Tx;

    /* renamed from: com.google.android.gms.dynamic.a.1 */
    class C07391 implements C0738f<T> {
        final /* synthetic */ C0747a Ty;

        C07391(C0747a c0747a) {
            this.Ty = c0747a;
        }

        public void m2571a(T t) {
            this.Ty.Tu = t;
            Iterator it = this.Ty.Tw.iterator();
            while (it.hasNext()) {
                ((C0740a) it.next()).m2572b(this.Ty.Tu);
            }
            this.Ty.Tw.clear();
            this.Ty.Tv = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.a */
    private interface C0740a {
        void m2572b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a.2 */
    class C07412 implements C0740a {
        final /* synthetic */ Bundle TA;
        final /* synthetic */ Bundle TB;
        final /* synthetic */ C0747a Ty;
        final /* synthetic */ Activity Tz;

        C07412(C0747a c0747a, Activity activity, Bundle bundle, Bundle bundle2) {
            this.Ty = c0747a;
            this.Tz = activity;
            this.TA = bundle;
            this.TB = bundle2;
        }

        public void m2573b(LifecycleDelegate lifecycleDelegate) {
            this.Ty.Tu.onInflate(this.Tz, this.TA, this.TB);
        }

        public int getState() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.3 */
    class C07423 implements C0740a {
        final /* synthetic */ Bundle TB;
        final /* synthetic */ C0747a Ty;

        C07423(C0747a c0747a, Bundle bundle) {
            this.Ty = c0747a;
            this.TB = bundle;
        }

        public void m2574b(LifecycleDelegate lifecycleDelegate) {
            this.Ty.Tu.onCreate(this.TB);
        }

        public int getState() {
            return 1;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.4 */
    class C07434 implements C0740a {
        final /* synthetic */ Bundle TB;
        final /* synthetic */ FrameLayout TC;
        final /* synthetic */ LayoutInflater TD;
        final /* synthetic */ ViewGroup TE;
        final /* synthetic */ C0747a Ty;

        C07434(C0747a c0747a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Ty = c0747a;
            this.TC = frameLayout;
            this.TD = layoutInflater;
            this.TE = viewGroup;
            this.TB = bundle;
        }

        public void m2575b(LifecycleDelegate lifecycleDelegate) {
            this.TC.removeAllViews();
            this.TC.addView(this.Ty.Tu.onCreateView(this.TD, this.TE, this.TB));
        }

        public int getState() {
            return 2;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.5 */
    static class C07445 implements OnClickListener {
        final /* synthetic */ int TF;
        final /* synthetic */ Context nf;

        C07445(Context context, int i) {
            this.nf = context;
            this.TF = i;
        }

        public final void onClick(View view) {
            this.nf.startActivity(GooglePlayServicesUtil.aj(this.TF));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.6 */
    class C07456 implements C0740a {
        final /* synthetic */ C0747a Ty;

        C07456(C0747a c0747a) {
            this.Ty = c0747a;
        }

        public void m2576b(LifecycleDelegate lifecycleDelegate) {
            this.Ty.Tu.onStart();
        }

        public int getState() {
            return 4;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.7 */
    class C07467 implements C0740a {
        final /* synthetic */ C0747a Ty;

        C07467(C0747a c0747a) {
            this.Ty = c0747a;
        }

        public void m2577b(LifecycleDelegate lifecycleDelegate) {
            this.Ty.Tu.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    public C0747a() {
        this.Tx = new C07391(this);
    }

    private void m2581a(Bundle bundle, C0740a c0740a) {
        if (this.Tu != null) {
            c0740a.m2572b(this.Tu);
            return;
        }
        if (this.Tw == null) {
            this.Tw = new LinkedList();
        }
        this.Tw.add(c0740a);
        if (bundle != null) {
            if (this.Tv == null) {
                this.Tv = (Bundle) bundle.clone();
            } else {
                this.Tv.putAll(bundle);
            }
        }
        m2585a(this.Tx);
    }

    public static void m2583b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence b = GooglePlayServicesUtil.m1779b(context, isGooglePlayServicesAvailable);
        CharSequence c = GooglePlayServicesUtil.m1784c(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (c != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(c);
            linearLayout.addView(button);
            button.setOnClickListener(new C07445(context, isGooglePlayServicesAvailable));
        }
    }

    private void cG(int i) {
        while (!this.Tw.isEmpty() && ((C0740a) this.Tw.getLast()).getState() >= i) {
            this.Tw.removeLast();
        }
    }

    protected void m2584a(FrameLayout frameLayout) {
        C0747a.m2583b(frameLayout);
    }

    protected abstract void m2585a(C0738f<T> c0738f);

    public T je() {
        return this.Tu;
    }

    public void onCreate(Bundle bundle) {
        m2581a(bundle, new C07423(this, bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m2581a(bundle, new C07434(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.Tu == null) {
            m2584a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Tu != null) {
            this.Tu.onDestroy();
        } else {
            cG(1);
        }
    }

    public void onDestroyView() {
        if (this.Tu != null) {
            this.Tu.onDestroyView();
        } else {
            cG(2);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        m2581a(bundle2, new C07412(this, activity, bundle, bundle2));
    }

    public void onLowMemory() {
        if (this.Tu != null) {
            this.Tu.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Tu != null) {
            this.Tu.onPause();
        } else {
            cG(5);
        }
    }

    public void onResume() {
        m2581a(null, new C07467(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.Tu != null) {
            this.Tu.onSaveInstanceState(bundle);
        } else if (this.Tv != null) {
            bundle.putAll(this.Tv);
        }
    }

    public void onStart() {
        m2581a(null, new C07456(this));
    }

    public void onStop() {
        if (this.Tu != null) {
            this.Tu.onStop();
        } else {
            cG(4);
        }
    }
}
