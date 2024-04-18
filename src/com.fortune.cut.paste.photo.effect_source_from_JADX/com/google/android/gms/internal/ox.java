package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.oq.C1412a;
import com.google.android.gms.internal.os.C1414a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ox extends jl<oq> {
    private final String CS;
    private final ou anm;
    private final os ann;
    private boolean ano;
    private final Object mH;

    public ox(Context context, ou ouVar) {
        super(context, ouVar, ouVar, new String[0]);
        this.CS = context.getPackageName();
        this.anm = (ou) jx.m5223i(ouVar);
        this.anm.m5732a(this);
        this.ann = new os();
        this.mH = new Object();
        this.ano = true;
    }

    private void m5734c(ov ovVar, or orVar) {
        this.ann.m5729a(ovVar, orVar);
    }

    private void m5735d(ov ovVar, or orVar) {
        try {
            or();
            ((oq) hw()).m5722a(this.CS, ovVar, orVar);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            m5734c(ovVar, orVar);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            m5734c(ovVar, orVar);
        }
    }

    private void or() {
        je.m5079K(!this.ano);
        if (!this.ann.isEmpty()) {
            try {
                List arrayList = new ArrayList();
                Iterator it = this.ann.op().iterator();
                ov ovVar = null;
                while (it.hasNext()) {
                    C1414a c1414a = (C1414a) it.next();
                    if (c1414a.and != null) {
                        ((oq) hw()).m5724a(this.CS, c1414a.anb, qw.m2145f(c1414a.and));
                    } else if (c1414a.anb.equals(ovVar)) {
                        arrayList.add(c1414a.anc);
                    } else {
                        if (!arrayList.isEmpty()) {
                            ((oq) hw()).m5723a(this.CS, ovVar, arrayList);
                            arrayList.clear();
                        }
                        ov ovVar2 = c1414a.anb;
                        arrayList.add(c1414a.anc);
                        ovVar = ovVar2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((oq) hw()).m5723a(this.CS, ovVar, arrayList);
                }
                this.ann.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    void m5736U(boolean z) {
        synchronized (this.mH) {
            boolean z2 = this.ano;
            this.ano = z;
            if (z2 && !this.ano) {
                or();
            }
        }
    }

    protected void m5737a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5143f(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void m5738b(ov ovVar, or orVar) {
        synchronized (this.mH) {
            if (this.ano) {
                m5734c(ovVar, orVar);
            } else {
                m5735d(ovVar, orVar);
            }
        }
    }

    protected oq bJ(IBinder iBinder) {
        return C1412a.bI(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    protected /* synthetic */ IInterface m5739l(IBinder iBinder) {
        return bJ(iBinder);
    }

    public void start() {
        synchronized (this.mH) {
            if (isConnecting() || isConnected()) {
                return;
            }
            this.anm.m5731T(true);
            connect();
        }
    }

    public void stop() {
        synchronized (this.mH) {
            this.anm.m5731T(false);
            disconnect();
        }
    }
}
