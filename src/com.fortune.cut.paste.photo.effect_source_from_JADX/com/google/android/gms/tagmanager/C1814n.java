package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.tagmanager.n */
class C1814n implements ContainerHolder {
    private Status Eb;
    private final Looper JF;
    private boolean Pf;
    private Container aqu;
    private Container aqv;
    private C1813b aqw;
    private C1812a aqx;
    private TagManager aqy;

    /* renamed from: com.google.android.gms.tagmanager.n.a */
    public interface C1812a {
        void ct(String str);

        String pl();

        void pn();
    }

    /* renamed from: com.google.android.gms.tagmanager.n.b */
    private class C1813b extends Handler {
        final /* synthetic */ C1814n aqA;
        private final ContainerAvailableListener aqz;

        public C1813b(C1814n c1814n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.aqA = c1814n;
            super(looper);
            this.aqz = containerAvailableListener;
        }

        public void cu(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void cv(String str) {
            this.aqz.onContainerAvailable(this.aqA, str);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    cv((String) message.obj);
                default:
                    bh.m6458T("Don't know how to handle this message.");
            }
        }
    }

    public C1814n(Status status) {
        this.Eb = status;
        this.JF = null;
    }

    public C1814n(TagManager tagManager, Looper looper, Container container, C1812a c1812a) {
        this.aqy = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.JF = looper;
        this.aqu = container;
        this.aqx = c1812a;
        this.Eb = Status.Kw;
        tagManager.m6393a(this);
    }

    private void pm() {
        if (this.aqw != null) {
            this.aqw.cu(this.aqv.pj());
        }
    }

    public synchronized void m6649a(Container container) {
        if (!this.Pf) {
            if (container == null) {
                bh.m6458T("Unexpected null container.");
            } else {
                this.aqv = container;
                pm();
            }
        }
    }

    public synchronized void cr(String str) {
        if (!this.Pf) {
            this.aqu.cr(str);
        }
    }

    void ct(String str) {
        if (this.Pf) {
            bh.m6458T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aqx.ct(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.Pf) {
                bh.m6458T("ContainerHolder is released.");
            } else {
                if (this.aqv != null) {
                    this.aqu = this.aqv;
                    this.aqv = null;
                }
                container = this.aqu;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.Pf) {
            return this.aqu.getContainerId();
        }
        bh.m6458T("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.Eb;
    }

    String pl() {
        if (!this.Pf) {
            return this.aqx.pl();
        }
        bh.m6458T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.Pf) {
            bh.m6458T("Refreshing a released ContainerHolder.");
        } else {
            this.aqx.pn();
        }
    }

    public synchronized void release() {
        if (this.Pf) {
            bh.m6458T("Releasing a released ContainerHolder.");
        } else {
            this.Pf = true;
            this.aqy.m6394b(this);
            this.aqu.release();
            this.aqu = null;
            this.aqv = null;
            this.aqx = null;
            this.aqw = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener containerAvailableListener) {
        if (this.Pf) {
            bh.m6458T("ContainerHolder is released.");
        } else if (containerAvailableListener == null) {
            this.aqw = null;
        } else {
            this.aqw = new C1813b(this, containerAvailableListener, this.JF);
            if (this.aqv != null) {
                pm();
            }
        }
    }
}
