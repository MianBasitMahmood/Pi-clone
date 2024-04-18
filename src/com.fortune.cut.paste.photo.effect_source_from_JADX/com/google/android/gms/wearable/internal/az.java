package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.internal.C1953f.C1950b;
import com.google.android.gms.wearable.internal.C1953f.C1951c;
import com.google.android.gms.wearable.internal.C1953f.C1952d;
import com.google.android.gms.wearable.internal.ah.C1921b;
import com.google.android.gms.wearable.internal.ak.C1926b;
import com.google.android.gms.wearable.internal.ak.C1927c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class az {

    /* renamed from: com.google.android.gms.wearable.internal.az.a */
    static abstract class C1911a<T> extends C1906a {
        private C0433b<T> DA;

        public C1911a(C0433b<T> c0433b) {
            this.DA = c0433b;
        }

        public void m6923A(T t) {
            C0433b c0433b = this.DA;
            if (c0433b != null) {
                c0433b.m1609b(t);
                this.DA = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.b */
    static final class C1928b extends C1911a<DeleteDataItemsResult> {
        public C1928b(C0433b<DeleteDataItemsResult> c0433b) {
            super(c0433b);
        }

        public final void m6969a(C1963p c1963p) {
            m6923A(new C1951c(av.gN(c1963p.statusCode), c1963p.axI));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.c */
    static final class C1929c extends C1911a<GetConnectedNodesResult> {
        public C1929c(C0433b<GetConnectedNodesResult> c0433b) {
            super(c0433b);
        }

        public final void m6970a(C1969v c1969v) {
            List arrayList = new ArrayList();
            arrayList.addAll(c1969v.axL);
            m6923A(new C1926b(av.gN(c1969v.statusCode), arrayList));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.d */
    static final class C1930d extends C1911a<DataItemResult> {
        public C1930d(C0433b<DataItemResult> c0433b) {
            super(c0433b);
        }

        public final void m6971a(C1971x c1971x) {
            m6923A(new C1950b(av.gN(c1971x.statusCode), c1971x.axM));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.e */
    static final class C1931e extends C1911a<DataItemBuffer> {
        public C1931e(C0433b<DataItemBuffer> c0433b) {
            super(c0433b);
        }

        public final void ab(DataHolder dataHolder) {
            m6923A(new DataItemBuffer(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.f */
    static final class C1932f extends C1911a<GetFdForAssetResult> {
        public C1932f(C0433b<GetFdForAssetResult> c0433b) {
            super(c0433b);
        }

        public final void m6972a(C1973z c1973z) {
            m6923A(new C1952d(av.gN(c1973z.statusCode), c1973z.axN));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.g */
    static final class C1933g extends C1911a<GetLocalNodeResult> {
        public C1933g(C0433b<GetLocalNodeResult> c0433b) {
            super(c0433b);
        }

        public final void m6973a(ab abVar) {
            m6923A(new C1927c(av.gN(abVar.statusCode), abVar.axO));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.h */
    static final class C1934h extends C1906a {
        C1934h() {
        }

        public final void m6974a(Status status) {
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.i */
    static final class C1935i extends C1911a<DataItemResult> {
        private final List<FutureTask<Boolean>> ayf;

        C1935i(C0433b<DataItemResult> c0433b, List<FutureTask<Boolean>> list) {
            super(c0433b);
            this.ayf = list;
        }

        public final void m6975a(ap apVar) {
            m6923A(new C1950b(av.gN(apVar.statusCode), apVar.axM));
            if (apVar.statusCode != 0) {
                for (FutureTask cancel : this.ayf) {
                    cancel.cancel(true);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az.j */
    static final class C1936j extends C1911a<SendMessageResult> {
        public C1936j(C0433b<SendMessageResult> c0433b) {
            super(c0433b);
        }

        public final void m6976a(at atVar) {
            m6923A(new C1921b(av.gN(atVar.statusCode), atVar.ayd));
        }
    }
}
