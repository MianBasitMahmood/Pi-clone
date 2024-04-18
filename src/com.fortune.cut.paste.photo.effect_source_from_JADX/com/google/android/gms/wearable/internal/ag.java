package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.google.android.gms.wearable.internal.az.C1911a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

abstract class ag<T> {
    private final HashMap<T, bb> agU;

    /* renamed from: com.google.android.gms.wearable.internal.ag.a */
    private static class C1912a<T> extends C1911a<Status> {
        private WeakReference<Map<T, bb>> axP;
        private WeakReference<T> axQ;

        C1912a(Map<T, bb> map, T t, C0433b<Status> c0433b) {
            super(c0433b);
            this.axP = new WeakReference(map);
            this.axQ = new WeakReference(t);
        }

        public void m6924a(Status status) {
            Map map = (Map) this.axP.get();
            Object obj = this.axQ.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    bb bbVar = (bb) map.remove(obj);
                    if (bbVar != null) {
                        bbVar.clear();
                    }
                }
            }
            m6923A(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag.b */
    static final class C1913b extends ag<DataListener> {
        C1913b() {
        }

        final bb m6929a(DataListener dataListener, IntentFilter[] intentFilterArr) {
            return bb.m6998b(dataListener, intentFilterArr);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag.c */
    static final class C1914c extends ag<MessageListener> {
        C1914c() {
        }

        final bb m6931a(MessageListener messageListener, IntentFilter[] intentFilterArr) {
            return bb.m6999b(messageListener, intentFilterArr);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag.d */
    static final class C1915d extends ag<NodeListener> {
        C1915d() {
        }

        final bb m6933a(NodeListener nodeListener, IntentFilter[] intentFilterArr) {
            return bb.m6997a(nodeListener);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag.e */
    private static class C1916e<T> extends C1911a<Status> {
        private WeakReference<Map<T, bb>> axP;
        private WeakReference<T> axQ;

        C1916e(Map<T, bb> map, T t, C0433b<Status> c0433b) {
            super(c0433b);
            this.axP = new WeakReference(map);
            this.axQ = new WeakReference(t);
        }

        public void m6935a(Status status) {
            Map map = (Map) this.axP.get();
            Object obj = this.axQ.get();
            if (!(status.getStatus().getStatusCode() != WearableStatusCodes.UNKNOWN_LISTENER || map == null || obj == null)) {
                synchronized (map) {
                    bb bbVar = (bb) map.remove(obj);
                    if (bbVar != null) {
                        bbVar.clear();
                    }
                }
            }
            m6923A(status);
        }
    }

    ag() {
        this.agU = new HashMap();
    }

    abstract bb m6925a(T t, IntentFilter[] intentFilterArr);

    public void m6926a(ba baVar, C0433b<Status> c0433b, T t) throws RemoteException {
        synchronized (this.agU) {
            bb bbVar = (bb) this.agU.remove(t);
            if (bbVar == null) {
                c0433b.m1609b(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
                return;
            }
            bbVar.clear();
            ((af) baVar.hw()).m6880a(new C1916e(this.agU, t, c0433b), new ar(bbVar));
        }
    }

    public void m6927a(ba baVar, C0433b<Status> c0433b, T t, IntentFilter[] intentFilterArr) throws RemoteException {
        bb a = m6925a(t, intentFilterArr);
        synchronized (this.agU) {
            if (this.agU.get(t) != null) {
                c0433b.m1609b(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                return;
            }
            this.agU.put(t, a);
            try {
                ((af) baVar.hw()).m6881a(new C1912a(this.agU, t, c0433b), new C1937b(a));
            } catch (RemoteException e) {
                this.agU.remove(t);
                throw e;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6928b(com.google.android.gms.wearable.internal.ba r9) {
        /*
        r8 = this;
        r3 = r8.agU;
        monitor-enter(r3);
        r4 = new com.google.android.gms.wearable.internal.az$h;	 Catch:{ all -> 0x008d }
        r4.<init>();	 Catch:{ all -> 0x008d }
        r0 = r8.agU;	 Catch:{ all -> 0x008d }
        r0 = r0.entrySet();	 Catch:{ all -> 0x008d }
        r5 = r0.iterator();	 Catch:{ all -> 0x008d }
    L_0x0012:
        r0 = r5.hasNext();	 Catch:{ all -> 0x008d }
        if (r0 == 0) goto L_0x0090;
    L_0x0018:
        r0 = r5.next();	 Catch:{ all -> 0x008d }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x008d }
        r1 = r0.getValue();	 Catch:{ all -> 0x008d }
        r1 = (com.google.android.gms.wearable.internal.bb) r1;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0012;
    L_0x0026:
        r1.clear();	 Catch:{ all -> 0x008d }
        r2 = r9.isConnected();	 Catch:{ all -> 0x008d }
        if (r2 == 0) goto L_0x0012;
    L_0x002f:
        r2 = r9.hw();	 Catch:{ RemoteException -> 0x0069 }
        r2 = (com.google.android.gms.wearable.internal.af) r2;	 Catch:{ RemoteException -> 0x0069 }
        r6 = new com.google.android.gms.wearable.internal.ar;	 Catch:{ RemoteException -> 0x0069 }
        r6.<init>(r1);	 Catch:{ RemoteException -> 0x0069 }
        r2.m6880a(r4, r6);	 Catch:{ RemoteException -> 0x0069 }
        r2 = "WearableClient";
        r6 = 2;
        r2 = android.util.Log.isLoggable(r2, r6);	 Catch:{ RemoteException -> 0x0069 }
        if (r2 == 0) goto L_0x0012;
    L_0x0046:
        r2 = "WearableClient";
        r6 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0069 }
        r7 = "disconnect: removed: ";
        r6.<init>(r7);	 Catch:{ RemoteException -> 0x0069 }
        r7 = r0.getKey();	 Catch:{ RemoteException -> 0x0069 }
        r6 = r6.append(r7);	 Catch:{ RemoteException -> 0x0069 }
        r7 = "/";
        r6 = r6.append(r7);	 Catch:{ RemoteException -> 0x0069 }
        r6 = r6.append(r1);	 Catch:{ RemoteException -> 0x0069 }
        r6 = r6.toString();	 Catch:{ RemoteException -> 0x0069 }
        android.util.Log.d(r2, r6);	 Catch:{ RemoteException -> 0x0069 }
        goto L_0x0012;
    L_0x0069:
        r2 = move-exception;
        r2 = "WearableClient";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r7 = "disconnect: Didn't remove: ";
        r6.<init>(r7);	 Catch:{ all -> 0x008d }
        r0 = r0.getKey();	 Catch:{ all -> 0x008d }
        r0 = r6.append(r0);	 Catch:{ all -> 0x008d }
        r6 = "/";
        r0 = r0.append(r6);	 Catch:{ all -> 0x008d }
        r0 = r0.append(r1);	 Catch:{ all -> 0x008d }
        r0 = r0.toString();	 Catch:{ all -> 0x008d }
        android.util.Log.w(r2, r0);	 Catch:{ all -> 0x008d }
        goto L_0x0012;
    L_0x008d:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
    L_0x0090:
        r0 = r8.agU;	 Catch:{ all -> 0x008d }
        r0.clear();	 Catch:{ all -> 0x008d }
        monitor-exit(r3);	 Catch:{ all -> 0x008d }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ag.b(com.google.android.gms.wearable.internal.ba):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ca(android.os.IBinder r10) {
        /*
        r9 = this;
        r2 = r9.agU;
        monitor-enter(r2);
        r3 = com.google.android.gms.wearable.internal.af.C1910a.bZ(r10);	 Catch:{ all -> 0x0080 }
        r4 = new com.google.android.gms.wearable.internal.az$h;	 Catch:{ all -> 0x0080 }
        r4.<init>();	 Catch:{ all -> 0x0080 }
        r0 = r9.agU;	 Catch:{ all -> 0x0080 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0080 }
        r5 = r0.iterator();	 Catch:{ all -> 0x0080 }
    L_0x0016:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x0083;
    L_0x001c:
        r0 = r5.next();	 Catch:{ all -> 0x0080 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0080 }
        r1 = r0.getValue();	 Catch:{ all -> 0x0080 }
        r1 = (com.google.android.gms.wearable.internal.bb) r1;	 Catch:{ all -> 0x0080 }
        r6 = new com.google.android.gms.wearable.internal.b;	 Catch:{ RemoteException -> 0x005c }
        r6.<init>(r1);	 Catch:{ RemoteException -> 0x005c }
        r3.m6881a(r4, r6);	 Catch:{ RemoteException -> 0x005c }
        r6 = "WearableClient";
        r7 = 2;
        r6 = android.util.Log.isLoggable(r6, r7);	 Catch:{ RemoteException -> 0x005c }
        if (r6 == 0) goto L_0x0016;
    L_0x0039:
        r6 = "WearableClient";
        r7 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x005c }
        r8 = "onPostInitHandler: added: ";
        r7.<init>(r8);	 Catch:{ RemoteException -> 0x005c }
        r8 = r0.getKey();	 Catch:{ RemoteException -> 0x005c }
        r7 = r7.append(r8);	 Catch:{ RemoteException -> 0x005c }
        r8 = "/";
        r7 = r7.append(r8);	 Catch:{ RemoteException -> 0x005c }
        r7 = r7.append(r1);	 Catch:{ RemoteException -> 0x005c }
        r7 = r7.toString();	 Catch:{ RemoteException -> 0x005c }
        android.util.Log.d(r6, r7);	 Catch:{ RemoteException -> 0x005c }
        goto L_0x0016;
    L_0x005c:
        r6 = move-exception;
        r6 = "WearableClient";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r8 = "onPostInitHandler: Didn't add: ";
        r7.<init>(r8);	 Catch:{ all -> 0x0080 }
        r0 = r0.getKey();	 Catch:{ all -> 0x0080 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0080 }
        r7 = "/";
        r0 = r0.append(r7);	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r0 = r0.toString();	 Catch:{ all -> 0x0080 }
        android.util.Log.d(r6, r0);	 Catch:{ all -> 0x0080 }
        goto L_0x0016;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0083:
        monitor-exit(r2);	 Catch:{ all -> 0x0080 }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ag.ca(android.os.IBinder):void");
    }
}
