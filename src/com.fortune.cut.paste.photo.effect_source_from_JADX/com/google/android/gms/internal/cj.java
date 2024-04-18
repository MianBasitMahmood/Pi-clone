package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.Map;

@ey
public final class cj implements cd {
    private static int m4353a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = gq.m4764a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                gr.m4773W("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public final void m4354a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            gr.m4773W("Action missing from video GMSG.");
            return;
        }
        dp dC = guVar.dC();
        if (dC == null) {
            gr.m4773W("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = guVar.getContext().getResources().getDisplayMetrics();
            a = m4353a(displayMetrics, map, "x", 0);
            int a2 = m4353a(displayMetrics, map, "y", 0);
            int a3 = m4353a(displayMetrics, map, "w", -1);
            int a4 = m4353a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && dC.ce() == null) {
                dC.m4452c(a, a2, a3, a4);
                return;
            } else {
                dC.m4451b(a, a2, a3, a4);
                return;
            }
        }
        dt ce = dC.ce();
        if (ce == null) {
            dt.m4463a(guVar, "no_video_view", null);
        } else if (Promotion.ACTION_CLICK.equalsIgnoreCase(str)) {
            displayMetrics = guVar.getContext().getResources().getDisplayMetrics();
            int a5 = m4353a(displayMetrics, map, "x", 0);
            a = m4353a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            ce.m4467b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                gr.m4773W("Enabled parameter missing from controls video GMSG.");
            } else {
                ce.m4468s(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                gr.m4773W("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                ce.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                gr.m4773W("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            ce.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            ce.cq();
        } else if ("pause".equalsIgnoreCase(str)) {
            ce.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            ce.play();
        } else if ("show".equalsIgnoreCase(str)) {
            ce.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            ce.m4466C((String) map.get("src"));
        } else {
            gr.m4773W("Unknown video action: " + str);
        }
    }
}
