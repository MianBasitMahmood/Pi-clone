package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.gms.dynamic.C0750b;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb.C1451a;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private final Fragment TG;
    private WalletFragmentOptions awe;
    private WalletFragmentInitParams awf;
    private MaskedWalletRequest awg;
    private MaskedWallet awh;
    private Boolean awi;
    private C1856b awn;
    private final C0750b awo;
    private final C1857c awp;
    private C1855a awq;
    private boolean mCreated;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.a */
    static class C1855a extends C1451a {
        private OnStateChangedListener awr;
        private final WalletFragment aws;

        C1855a(WalletFragment walletFragment) {
            this.aws = walletFragment;
        }

        public void m6745a(int i, int i2, Bundle bundle) {
            if (this.awr != null) {
                this.awr.onStateChanged(this.aws, i, i2, bundle);
            }
        }

        public void m6746a(OnStateChangedListener onStateChangedListener) {
            this.awr = onStateChangedListener;
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.b */
    private static class C1856b implements LifecycleDelegate {
        private final qa awl;

        private C1856b(qa qaVar) {
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

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.c */
    private class C1857c extends C0747a<C1856b> implements OnClickListener {
        final /* synthetic */ WalletFragment awt;

        private C1857c(WalletFragment walletFragment) {
            this.awt = walletFragment;
        }

        protected void m6753a(FrameLayout frameLayout) {
            int i = -1;
            int i2 = -2;
            View button = new Button(this.awt.TG.getActivity());
            button.setText(C0366R.string.wallet_buy_button_place_holder);
            if (this.awt.awe != null) {
                WalletFragmentStyle fragmentStyle = this.awt.awe.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.awt.TG.getResources().getDisplayMetrics();
                    i = fragmentStyle.m6786a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.m6786a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void m6754a(C0738f<C1856b> c0738f) {
            Activity activity = this.awt.TG.getActivity();
            if (this.awt.awn == null && this.awt.mCreated && activity != null) {
                try {
                    this.awt.awn = new C1856b(null);
                    this.awt.awe = null;
                    c0738f.m2570a(this.awt.awn);
                    if (this.awt.awf != null) {
                        this.awt.awn.initialize(this.awt.awf);
                        this.awt.awf = null;
                    }
                    if (this.awt.awg != null) {
                        this.awt.awn.updateMaskedWalletRequest(this.awt.awg);
                        this.awt.awg = null;
                    }
                    if (this.awt.awh != null) {
                        this.awt.awn.updateMaskedWallet(this.awt.awh);
                        this.awt.awh = null;
                    }
                    if (this.awt.awi != null) {
                        this.awt.awn.setEnabled(this.awt.awi.booleanValue());
                        this.awt.awi = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.awt.TG.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public WalletFragment() {
        this.mCreated = false;
        this.awo = C0750b.m2588a(this);
        this.awp = new C1857c();
        this.awq = new C1855a(this);
        this.TG = this;
    }

    public static WalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        walletFragment.TG.setArguments(bundle);
        return walletFragment;
    }

    public final int getState() {
        return this.awn != null ? this.awn.getState() : 0;
    }

    public final void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        if (this.awn != null) {
            this.awn.initialize(walletFragmentInitParams);
            this.awf = null;
        } else if (this.awf == null) {
            this.awf = walletFragmentInitParams;
            if (this.awg != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.awh != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.awn != null) {
            this.awn.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.awf != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.TG.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.TG.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.ab(this.TG.getActivity());
                this.awe = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.awp.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.awp.onCreateView(layoutInflater, viewGroup, bundle);
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
        this.awp.onInflate(activity, bundle2, bundle);
    }

    public final void onPause() {
        super.onPause();
        this.awp.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.awp.onResume();
        FragmentManager fragmentManager = this.TG.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.TG.getActivity()), this.TG.getActivity(), -1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.awp.onSaveInstanceState(bundle);
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
        this.awp.onStart();
    }

    public final void onStop() {
        super.onStop();
        this.awp.onStop();
    }

    public final void setEnabled(boolean z) {
        if (this.awn != null) {
            this.awn.setEnabled(z);
            this.awi = null;
            return;
        }
        this.awi = Boolean.valueOf(z);
    }

    public final void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.awq.m6746a(onStateChangedListener);
    }

    public final void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.awn != null) {
            this.awn.updateMaskedWallet(maskedWallet);
            this.awh = null;
            return;
        }
        this.awh = maskedWallet;
    }

    public final void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.awn != null) {
            this.awn.updateMaskedWalletRequest(maskedWalletRequest);
            this.awg = null;
            return;
        }
        this.awg = maskedWalletRequest;
    }
}
