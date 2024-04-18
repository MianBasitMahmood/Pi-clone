package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.plus.PlusShare;

public class aq extends ap {
    private ImageView f487a;

    public aq(aw awVar, Context context) {
        super(context);
        this.f487a = new ImageView(context);
        addView(this.f487a, new LayoutParams(-1, -1));
    }

    public void m797a(C0111a c0111a, int i) {
        C0111a a = c0111a.m151a("assets").m151a(CBUtility.m118c().m189b() ? "portrait" : "landscape");
        if (a.m158c()) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            String str = "";
            if (!(a.m162e("checksum") == null || a.m162e("checksum").isEmpty())) {
                str = a.m162e("checksum");
            }
            bc.m973a().m979a(a.m162e(PlusShare.KEY_CALL_TO_ACTION_URL), str, null, this.f487a, bundle);
        }
    }

    public int m796a() {
        return CBUtility.m109a(110, getContext());
    }
}
