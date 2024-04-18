package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.C0371b;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;

public final class bh {
    private final cx oH;
    private final ax oI;
    private bd oJ;
    private String oK;
    private ViewGroup oL;
    private InAppPurchaseListener oM;
    private PlayStorePurchaseListener oN;
    private C0371b oO;
    private AdListener ob;
    private AppEventListener os;
    private AdSize[] ot;
    private String ou;

    public bh(ViewGroup viewGroup) {
        this(viewGroup, null, false, ax.bg());
    }

    public bh(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, ax.bg());
    }

    bh(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, ax axVar) {
        this(viewGroup, attributeSet, z, axVar, null);
    }

    bh(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, ax axVar, bd bdVar) {
        this.oH = new cx();
        this.oL = viewGroup;
        this.oI = axVar;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                bb bbVar = new bb(context, attributeSet);
                this.ot = bbVar.m4207h(z);
                this.ou = bbVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    gq.m4765a(viewGroup, new ay(context, this.ot[0]), "Ads by Google");
                    return;
                }
            } catch (IllegalArgumentException e) {
                gq.m4767a(viewGroup, new ay(context, AdSize.BANNER), e.getMessage(), e.getMessage());
                return;
            }
        }
        this.oJ = bdVar;
    }

    private void bm() {
        try {
            C0752d ab = this.oJ.ab();
            if (ab != null) {
                this.oL.addView((View) C0755e.m2593f(ab));
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to get an ad frame.", e);
        }
    }

    private void bn() throws RemoteException {
        if ((this.ot == null || this.ou == null) && this.oJ == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.oL.getContext();
        this.oJ = au.m4191a(context, new ay(context, this.ot), this.ou, this.oH);
        if (this.ob != null) {
            this.oJ.m4209a(new at(this.ob));
        }
        if (this.os != null) {
            this.oJ.m4210a(new ba(this.os));
        }
        if (this.oM != null) {
            this.oJ.m4212a(new es(this.oM));
        }
        if (this.oN != null) {
            this.oJ.m4213a(new ew(this.oN), this.oK);
        }
        if (this.oO != null) {
            this.oJ.m4211a(new bs(this.oO));
        }
        bm();
    }

    public final void m4249a(bg bgVar) {
        try {
            if (this.oJ == null) {
                bn();
            }
            if (this.oJ.m4214a(this.oI.m4198a(this.oL.getContext(), bgVar))) {
                this.oH.m4386d(bgVar.bj());
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to load ad.", e);
        }
    }

    public final void m4250a(AdSize... adSizeArr) {
        this.ot = adSizeArr;
        try {
            if (this.oJ != null) {
                this.oJ.m4208a(new ay(this.oL.getContext(), this.ot));
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to set the ad size.", e);
        }
        this.oL.requestLayout();
    }

    public final void destroy() {
        try {
            if (this.oJ != null) {
                this.oJ.destroy();
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to destroy AdView.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.ob;
    }

    public final AdSize getAdSize() {
        try {
            if (this.oJ != null) {
                return this.oJ.ac().bh();
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to get the current AdSize.", e);
        }
        return this.ot != null ? this.ot[0] : null;
    }

    public final AdSize[] getAdSizes() {
        return this.ot;
    }

    public final String getAdUnitId() {
        return this.ou;
    }

    public final AppEventListener getAppEventListener() {
        return this.os;
    }

    public final InAppPurchaseListener getInAppPurchaseListener() {
        return this.oM;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.oJ != null) {
                return this.oJ.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final void pause() {
        try {
            if (this.oJ != null) {
                this.oJ.pause();
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to call pause.", e);
        }
    }

    public final void recordManualImpression() {
        try {
            if (this.oJ != null) {
                this.oJ.an();
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to record impression.", e);
        }
    }

    public final void resume() {
        try {
            if (this.oJ != null) {
                this.oJ.resume();
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to call resume.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.ob = adListener;
            if (this.oJ != null) {
                this.oJ.m4209a(adListener != null ? new at(adListener) : null);
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to set the AdListener.", e);
        }
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.ot != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m4250a(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        if (this.ou != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.ou = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.os = appEventListener;
            if (this.oJ != null) {
                this.oJ.m4210a(appEventListener != null ? new ba(appEventListener) : null);
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to set the AppEventListener.", e);
        }
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.oN != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.oM = inAppPurchaseListener;
            if (this.oJ != null) {
                this.oJ.m4212a(inAppPurchaseListener != null ? new es(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.oM != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.oN = playStorePurchaseListener;
            this.oK = str;
            if (this.oJ != null) {
                this.oJ.m4213a(playStorePurchaseListener != null ? new ew(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            gr.m4777d("Failed to set the play store purchase parameter.", e);
        }
    }
}
