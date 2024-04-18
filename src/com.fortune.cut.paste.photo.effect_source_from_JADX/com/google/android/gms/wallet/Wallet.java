package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.pv;
import com.google.android.gms.internal.qg;
import com.google.android.gms.internal.qh;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qk;
import com.google.android.gms.wallet.wobs.C1470r;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API;
    private static final C0490c<qh> DQ;
    private static final C0430b<qh, WalletOptions> DR;
    public static final Payments Payments;
    public static final C1470r avT;
    public static final pv avU;

    /* renamed from: com.google.android.gms.wallet.Wallet.a */
    public static abstract class C1460a<R extends Result> extends C0435a<R, qh> {
        public C1460a(GoogleApiClient googleApiClient) {
            super(Wallet.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.b */
    public static abstract class C1461b extends C1460a<Status> {
        public C1461b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status m5873b(Status status) {
            return status;
        }

        protected /* synthetic */ Result m5874c(Status status) {
            return m5873b(status);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.1 */
    static class C18431 implements C0430b<qh, WalletOptions> {
        C18431() {
        }

        public final qh m6707a(Context context, Looper looper, jg jgVar, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m5221b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new qh(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, jgVar.getAccountName(), walletOptions.theme);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int avV;
            private int mTheme;

            public Builder() {
                this.avV = 0;
                this.mTheme = 0;
            }

            public final WalletOptions build() {
                return new WalletOptions();
            }

            public final Builder setEnvironment(int i) {
                if (i == 0 || i == 2 || i == 1) {
                    this.avV = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(i)}));
            }

            public final Builder setTheme(int i) {
                if (i == 0 || i == 1) {
                    this.mTheme = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(i)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.avV;
            this.theme = builder.mTheme;
        }
    }

    static {
        DQ = new C0490c();
        DR = new C18431();
        API = new Api(DR, DQ, new Scope[0]);
        Payments = new qg();
        avT = new qk();
        avU = new qj();
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        Payments.changeMaskedWallet(googleApiClient, str, str2, i);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        Payments.checkForPreAuthorization(googleApiClient, i);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        Payments.loadFullWallet(googleApiClient, fullWalletRequest, i);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        Payments.loadMaskedWallet(googleApiClient, maskedWalletRequest, i);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Payments.notifyTransactionStatus(googleApiClient, notifyTransactionStatusRequest);
    }
}
