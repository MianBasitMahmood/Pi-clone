package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService arF;
    Context arG;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String str) {
        super(str);
    }

    private void m6387a(Context context, Intent intent) {
        if (this.arF == null) {
            this.arF = new CampaignTrackingService();
        }
        this.arF.processIntent(context, intent);
    }

    protected final void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.arG != null ? this.arG : getApplicationContext();
        ay.m6438d(applicationContext, stringExtra);
        m6387a(applicationContext, intent);
    }
}
