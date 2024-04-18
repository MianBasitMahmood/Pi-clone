package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.C1461b;

public class qg implements Payments {

    /* renamed from: com.google.android.gms.internal.qg.1 */
    class C14621 extends C1461b {
        final /* synthetic */ int afG;
        final /* synthetic */ qg awA;

        C14621(qg qgVar, GoogleApiClient googleApiClient, int i) {
            this.awA = qgVar;
            this.afG = i;
            super(googleApiClient);
        }

        protected void m5876a(qh qhVar) {
            qhVar.gk(this.afG);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.qg.2 */
    class C14632 extends C1461b {
        final /* synthetic */ int afG;
        final /* synthetic */ qg awA;
        final /* synthetic */ MaskedWalletRequest awB;

        C14632(qg qgVar, GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
            this.awA = qgVar;
            this.awB = maskedWalletRequest;
            this.afG = i;
            super(googleApiClient);
        }

        protected void m5878a(qh qhVar) {
            qhVar.m5898a(this.awB, this.afG);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.qg.3 */
    class C14643 extends C1461b {
        final /* synthetic */ int afG;
        final /* synthetic */ qg awA;
        final /* synthetic */ FullWalletRequest awC;

        C14643(qg qgVar, GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
            this.awA = qgVar;
            this.awC = fullWalletRequest;
            this.afG = i;
            super(googleApiClient);
        }

        protected void m5880a(qh qhVar) {
            qhVar.m5897a(this.awC, this.afG);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.qg.4 */
    class C14654 extends C1461b {
        final /* synthetic */ int afG;
        final /* synthetic */ qg awA;
        final /* synthetic */ String awD;
        final /* synthetic */ String awE;

        C14654(qg qgVar, GoogleApiClient googleApiClient, String str, String str2, int i) {
            this.awA = qgVar;
            this.awD = str;
            this.awE = str2;
            this.afG = i;
            super(googleApiClient);
        }

        protected void m5882a(qh qhVar) {
            qhVar.m5900d(this.awD, this.awE, this.afG);
            m1615b(Status.Kw);
        }
    }

    /* renamed from: com.google.android.gms.internal.qg.5 */
    class C14665 extends C1461b {
        final /* synthetic */ qg awA;
        final /* synthetic */ NotifyTransactionStatusRequest awF;

        C14665(qg qgVar, GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.awA = qgVar;
            this.awF = notifyTransactionStatusRequest;
            super(googleApiClient);
        }

        protected void m5884a(qh qhVar) {
            qhVar.m5899a(this.awF);
            m1615b(Status.Kw);
        }
    }

    public void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        googleApiClient.m1804a(new C14654(this, googleApiClient, str, str2, i));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        googleApiClient.m1804a(new C14621(this, googleApiClient, i));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        googleApiClient.m1804a(new C14643(this, googleApiClient, fullWalletRequest, i));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        googleApiClient.m1804a(new C14632(this, googleApiClient, maskedWalletRequest, i));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.m1804a(new C14665(this, googleApiClient, notifyTransactionStatusRequest));
    }
}
