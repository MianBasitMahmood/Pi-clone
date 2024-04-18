package com.google.android.gms.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.C1201i.C1200a;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.j */
public class C1240j extends C1201i {
    private static AdvertisingIdClient kO;
    private static CountDownLatch kP;
    private static boolean kQ;

    /* renamed from: com.google.android.gms.internal.j.1 */
    static class C12381 extends AsyncTask<Void, Void, Void> {
        C12381() {
        }

        protected final Void m5066a(Void... voidArr) {
            try {
                C1240j.kO.start();
            } catch (GooglePlayServicesNotAvailableException e) {
                C1240j.kQ = true;
                C1240j.kO = null;
            } catch (IOException e2) {
                C1240j.kO = null;
            } catch (GooglePlayServicesRepairableException e3) {
                C1240j.kO = null;
            }
            C1240j.kP.countDown();
            return null;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m5066a((Void[]) objArr);
        }
    }

    /* renamed from: com.google.android.gms.internal.j.a */
    class C1239a {
        private String kR;
        private boolean kS;
        final /* synthetic */ C1240j kT;

        public C1239a(C1240j c1240j, String str, boolean z) {
            this.kT = c1240j;
            this.kR = str;
            this.kS = z;
        }

        public String getId() {
            return this.kR;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kS;
        }
    }

    static {
        kP = new CountDownLatch(1);
    }

    protected C1240j(Context context, C1101m c1101m, C1361n c1361n) {
        super(context, c1101m, c1361n);
    }

    public static C1240j m5070a(String str, Context context) {
        C1101m c1102e = new C1102e();
        C1201i.m4912a(str, context, c1102e);
        synchronized (C1240j.class) {
            if (kO == null) {
                kO = new AdvertisingIdClient(context);
                new C12381().execute(new Void[0]);
            }
        }
        return new C1240j(context, c1102e, new C1419p(239));
    }

    protected void m5072b(Context context) {
        super.m4923b(context);
        try {
            if (kQ) {
                m4820a(24, C1201i.m4915d(context));
                return;
            }
            C1239a z = m5073z();
            m4819a(28, z.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = z.getId();
            if (id != null) {
                m4819a(26, 5);
                m4820a(24, id);
            }
        } catch (IOException e) {
        } catch (C1200a e2) {
        }
    }

    C1239a m5073z() throws IOException {
        int i = 0;
        synchronized (C1240j.class) {
            try {
                C1239a c1239a;
                if (!kP.await(2, TimeUnit.SECONDS)) {
                    c1239a = new C1239a(this, null, false);
                    return c1239a;
                } else if (kO == null) {
                    c1239a = new C1239a(this, null, false);
                    return c1239a;
                } else {
                    String str;
                    Info info = kO.getInfo();
                    String id = info.getId();
                    if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                        str = id;
                    } else {
                        byte[] bArr = new byte[16];
                        int i2 = 0;
                        while (i < id.length()) {
                            if (i == 8 || i == 13 || i == 18 || i == 23) {
                                i++;
                            }
                            bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                            i2++;
                            i += 2;
                        }
                        str = this.ky.m4482a(bArr, true);
                    }
                    return new C1239a(this, str, info.isLimitAdTrackingEnabled());
                }
            } catch (InterruptedException e) {
                return new C1239a(this, null, false);
            }
        }
    }
}
