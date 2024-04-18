package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0738f;
import com.google.android.gms.dynamic.C0747a;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0758h;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb.C1451a;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private final Fragment Mx;
    private C1852b awa;
    private final C0758h awb;
    private final C1853c awc;
    private C1851a awd;
    private WalletFragmentOptions awe;
    private WalletFragmentInitParams awf;
    private MaskedWalletRequest awg;
    private MaskedWallet awh;
    private Boolean awi;
    private boolean mCreated;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment.a */
    static class C1851a extends C1451a {
        private OnStateChangedListener awj;
        private final SupportWalletFragment awk;

        C1851a(SupportWalletFragment supportWalletFragment) {
            this.awk = supportWalletFragment;
        }

        public void m6719a(int i, int i2, Bundle bundle) {
            if (this.awj != null) {
                this.awj.onStateChanged(this.awk, i, i2, bundle);
            }
        }

        public void m6720a(OnStateChangedListener onStateChangedListener) {
            this.awj = onStateChangedListener;
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment.b */
    private static class C1852b implements LifecycleDelegate {
        private final qa awl;

        private C1852b(qa qaVar) {
            this.awl = qaVar;
        }

        private int getState() {
            try {
                return this.awl.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.awl.initialize(walletFragmentInitParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int i, int i2, Intent intent) {
            try {
                this.awl.onActivityResult(i, i2, intent);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean z) {
            try {
                this.awl.setEnabled(z);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.awl.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.awl.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.awl.onCreate(bundle);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C0755e.m2593f(this.awl.onCreateView(C0755e.m2594k(layoutInflater), C0755e.m2594k(viewGroup), bundle));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.awl.m5835a(C0755e.m2594k(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.awl.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.awl.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.awl.onSaveInstanceState(bundle);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.awl.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.awl.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment.c */
    private class C1853c extends C0747a<C1852b> implements OnClickListener {
        final /* synthetic */ SupportWalletFragment awm;

        private C1853c(SupportWalletFragment supportWalletFragment) {
            this.awm = supportWalletFragment;
        }

        protected void m6727a(FrameLayout frameLayout) {
            int i = -1;
            int i2 = -2;
            View button = new Button(this.awm.Mx.getActivity());
            button.setText(C0366R.string.wallet_buy_button_place_holder);
            if (this.awm.awe != null) {
                WalletFragmentStyle fragmentStyle = this.awm.awe.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.awm.Mx.getResources().getDisplayMetrics();
                    i = fragmentStyle.m6786a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.m6786a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void m6728a(C0738f<C1852b> c0738f) {
            Activity activity = this.awm.Mx.getActivity();
            if (this.awm.awa == null && this.awm.mCreated && activity != null) {
                try {
                    this.awm.awa = new C1852b(null);
                    this.awm.awe = null;
                    c0738f.m2570a(this.awm.awa);
                    if (this.awm.awf != null) {
                        this.awm.awa.initialize(this.awm.awf);
                        this.awm.awf = null;
                    }
                    if (this.awm.awg != null) {
                        this.awm.awa.updateMaskedWalletRequest(this.awm.awg);
                        this.awm.awg = null;
                    }
                    if (this.awm.awh != null) {
                        this.awm.awa.updateMaskedWallet(this.awm.awh);
                        this.awm.awh = null;
                    }
                    if (this.awm.awi != null) {
                        this.awm.awa.setEnabled(this.awm.awi.booleanValue());
                        this.awm.awi = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.awm.Mx.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public SupportWalletFragment() {
        this.mCreated = false;
        this.awb = C0758h.m2597a(this);
        this.awc = new C1853c();
        this.awd = new C1851a(this);
        this.Mx = this;
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        supportWalletFragment.Mx.setArguments(bundle);
        return supportWalletFragment;
    }

    public final int getState() {
        return this.awa != null ? this.awa.getState() : 0;
    }

    public final void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        if (this.awa != null) {
            this.awa.initialize(walletFragmentInitParams);
            this.awf = null;
        } else if (this.awf == null) {
            this.awf = walletFragmentInitParams;
            if (this.awg != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.awh != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.awa != null) {
            this.awa.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.awf != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.awf = walletFragmentInitParams;
            }
            if (this.awg == null) {
                this.awg = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.awh == null) {
                this.awh = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.awe = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.awi = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (this.Mx.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.Mx.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.ab(this.Mx.getActivity());
                this.awe = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.awc.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.awc.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.awe == null) {
            this.awe = WalletFragmentOptions.m6779a((Context) activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.awe);
        this.awc.onInflate(activity, bundle2, bundle);
    }

    public final void onPause() {
        super.onPause();
        this.awc.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.awc.onResume();
        FragmentManager supportFragmentManager = this.Mx.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mx.getActivity()), this.Mx.getActivity(), -1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.awc.onSaveInstanceState(bundle);
        if (this.awf != null) {
            bundle.putParcelable("walletFragmentInitParams", this.awf);
            this.awf = null;
        }
        if (this.awg != null) {
            bundle.putParcelable("maskedWalletRequest", this.awg);
            this.awg = null;
        }
        if (this.awh != null) {
            bundle.putParcelable("maskedWallet", this.awh);
            this.awh = null;
        }
        if (this.awe != null) {
            bundle.putParcelable("walletFragmentOptions", this.awe);
            this.awe = null;
        }
        if (this.awi != null) {
            bundle.putBoolean("enabled", this.awi.booleanValue());
            this.awi = null;
        }
    }

    public final void onStart() {
        super.onStart();
        this.awc.onStart();
    }

    public final void onStop() {
        super.onStop();
        this.awc.onStop();
    }

    public final void setEnabled(boolean z) {
        if (this.awa != null) {
            this.awa.setEnabled(z);
            this.awi = null;
            return;
        }
        this.awi = Boolean.valueOf(z);
    }

    public final void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.awd.m6720a(onStateChangedListener);
    }

    public final void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.awa != null) {
            this.awa.updateMaskedWallet(maskedWallet);
            this.awh = null;
            return;
        }
        this.awh = maskedWallet;
    }

    public final void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.awa != null) {
            this.awa.updateMaskedWalletRequest(maskedWalletRequest);
            this.awg = null;
            return;
        }
        this.awg = maskedWalletRequest;
    }
}
