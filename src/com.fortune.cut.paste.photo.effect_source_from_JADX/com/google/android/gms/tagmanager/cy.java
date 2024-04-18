package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cy extends cx {
    private static cy atJ;
    private static final Object yT;
    private at atA;
    private volatile ar atB;
    private int atC;
    private boolean atD;
    private boolean atE;
    private boolean atF;
    private au atG;
    private bo atH;
    private boolean atI;
    private Context atz;
    private boolean connected;
    private Handler handler;

    /* renamed from: com.google.android.gms.tagmanager.cy.1 */
    class C17951 implements au {
        final /* synthetic */ cy atK;

        C17951(cy cyVar) {
            this.atK = cyVar;
        }

        public void m6581B(boolean z) {
            this.atK.m6589a(z, this.atK.connected);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cy.2 */
    class C17962 implements Callback {
        final /* synthetic */ cy atK;

        C17962(cy cyVar) {
            this.atK = cyVar;
        }

        public boolean handleMessage(Message message) {
            if (1 == message.what && cy.yT.equals(message.obj)) {
                this.atK.dispatch();
                if (this.atK.atC > 0 && !this.atK.atI) {
                    this.atK.handler.sendMessageDelayed(this.atK.handler.obtainMessage(1, cy.yT), (long) this.atK.atC);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cy.3 */
    class C17973 implements Runnable {
        final /* synthetic */ cy atK;

        C17973(cy cyVar) {
            this.atK = cyVar;
        }

        public void run() {
            this.atK.atA.dispatch();
        }
    }

    static {
        yT = new Object();
    }

    private cy() {
        this.atC = 1800000;
        this.atD = true;
        this.atE = false;
        this.connected = true;
        this.atF = true;
        this.atG = new C17951(this);
        this.atI = false;
    }

    private void ev() {
        this.atH = new bo(this);
        this.atH.m6474z(this.atz);
    }

    private void ew() {
        this.handler = new Handler(this.atz.getMainLooper(), new C17962(this));
        if (this.atC > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long) this.atC);
        }
    }

    public static cy qN() {
        if (atJ == null) {
            atJ = new cy();
        }
        return atJ;
    }

    synchronized void m6587C(boolean z) {
        m6589a(this.atI, z);
    }

    synchronized void m6588a(Context context, ar arVar) {
        if (this.atz == null) {
            this.atz = context.getApplicationContext();
            if (this.atB == null) {
                this.atB = arVar;
            }
        }
    }

    synchronized void m6589a(boolean z, boolean z2) {
        if (!(this.atI == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.atC > 0) {
                    this.handler.removeMessages(1, yT);
                }
            }
            if (!z && z2 && this.atC > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long) this.atC);
            }
            StringBuilder stringBuilder = new StringBuilder("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.m6460V(stringBuilder.append(str).toString());
            this.atI = z;
            this.connected = z2;
        }
    }

    public synchronized void dispatch() {
        if (this.atE) {
            this.atB.m6423b(new C17973(this));
        } else {
            bh.m6460V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.atD = true;
        }
    }

    synchronized void ey() {
        if (!this.atI && this.connected && this.atC > 0) {
            this.handler.removeMessages(1, yT);
            this.handler.sendMessage(this.handler.obtainMessage(1, yT));
        }
    }

    synchronized at qO() {
        if (this.atA == null) {
            if (this.atz == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.atA = new cb(this.atG, this.atz);
        }
        if (this.handler == null) {
            ew();
        }
        this.atE = true;
        if (this.atD) {
            dispatch();
            this.atD = false;
        }
        if (this.atH == null && this.atF) {
            ev();
        }
        return this.atA;
    }
}
