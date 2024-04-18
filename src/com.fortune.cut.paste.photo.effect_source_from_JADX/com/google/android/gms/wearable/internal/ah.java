package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ah implements MessageApi {

    /* renamed from: com.google.android.gms.wearable.internal.ah.1 */
    class C19181 extends C1917d<SendMessageResult> {
        final /* synthetic */ byte[] DU;
        final /* synthetic */ String axR;
        final /* synthetic */ String axS;
        final /* synthetic */ ah axT;

        C19181(ah ahVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
            this.axT = ahVar;
            this.axR = str;
            this.axS = str2;
            this.DU = bArr;
            super(googleApiClient);
        }

        protected void m6937a(ba baVar) throws RemoteException {
            baVar.m6988a(this, this.axR, this.axS, this.DU);
        }

        protected SendMessageResult aI(Status status) {
            return new C1921b(status, -1);
        }

        protected /* synthetic */ Result m6938c(Status status) {
            return aI(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.2 */
    class C19192 extends C1917d<Status> {
        final /* synthetic */ ah axT;
        final /* synthetic */ MessageListener axU;

        C19192(ah ahVar, GoogleApiClient googleApiClient, MessageListener messageListener) {
            this.axT = ahVar;
            this.axU = messageListener;
            super(googleApiClient);
        }

        protected void m6940a(ba baVar) throws RemoteException {
            baVar.m6984a((C0433b) this, this.axU);
        }

        public Status m6941b(Status status) {
            return status;
        }

        public /* synthetic */ Result m6942c(Status status) {
            return m6941b(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.a */
    private static final class C1920a extends C1917d<Status> {
        private IntentFilter[] axD;
        private MessageListener axV;

        private C1920a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.axV = messageListener;
            this.axD = intentFilterArr;
        }

        protected final void m6944a(ba baVar) throws RemoteException {
            baVar.m6985a((C0433b) this, this.axV, this.axD);
            this.axV = null;
            this.axD = null;
        }

        public final Status m6945b(Status status) {
            this.axV = null;
            this.axD = null;
            return status;
        }

        public final /* synthetic */ Result m6946c(Status status) {
            return m6945b(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.b */
    public static class C1921b implements SendMessageResult {
        private final Status Eb;
        private final int ve;

        public C1921b(Status status, int i) {
            this.Eb = status;
            this.ve = i;
        }

        public int getRequestId() {
            return this.ve;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private PendingResult<Status> m6947a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.m1804a(new C1920a(messageListener, intentFilterArr, null));
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return m6947a(googleApiClient, messageListener, null);
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return googleApiClient.m1804a(new C19192(this, googleApiClient, messageListener));
    }

    public final PendingResult<SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        return googleApiClient.m1804a(new C19181(this, googleApiClient, str, str2, bArr));
    }
}
