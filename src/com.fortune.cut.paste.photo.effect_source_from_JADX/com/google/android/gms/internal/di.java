package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@ey
public class di {
    static final Set<String> rk;
    private int li;
    private int lj;
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;
    private int rl;
    private int rm;
    private boolean rn;
    private String ro;

    static {
        rk = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
    }

    public di(gu guVar, Map<String, String> map) {
        this.li = -1;
        this.lj = -1;
        this.rl = 0;
        this.rm = 0;
        this.rn = true;
        this.ro = "top-right";
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
    }

    private void bQ() {
        int M;
        int[] t = gi.m4744t(this.mContext);
        if (!TextUtils.isEmpty((CharSequence) this.rd.get("width"))) {
            M = gi.m4716M((String) this.rd.get("width"));
            if (m4424b(M, t[0])) {
                this.li = M;
            }
        }
        if (!TextUtils.isEmpty((CharSequence) this.rd.get("height"))) {
            M = gi.m4716M((String) this.rd.get("height"));
            if (m4425c(M, t[1])) {
                this.lj = M;
            }
        }
        if (!TextUtils.isEmpty((CharSequence) this.rd.get("offsetX"))) {
            this.rl = gi.m4716M((String) this.rd.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) this.rd.get("offsetY"))) {
            this.rm = gi.m4716M((String) this.rd.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) this.rd.get("allowOffscreen"))) {
            this.rn = Boolean.parseBoolean((String) this.rd.get("allowOffscreen"));
        }
        String str = (String) this.rd.get("customClosePosition");
        if (!TextUtils.isEmpty(str) && rk.contains(str)) {
            this.ro = str;
        }
    }

    boolean m4424b(int i, int i2) {
        return i >= 50 && i < i2;
    }

    boolean bR() {
        return this.li >= 0 && this.lj >= 0;
    }

    void bS() {
        try {
            this.mo.m4789b("onSizeChanged", new JSONObject().put("x", this.rl).put("y", this.rm).put("width", this.li).put("height", this.lj));
        } catch (Throwable e) {
            gr.m4775b("Error occured while dispatching size change.", e);
        }
    }

    void bT() {
        try {
            this.mo.m4789b("onStateChanged", new JSONObject().put("state", "resized"));
        } catch (Throwable e) {
            gr.m4775b("Error occured while dispatching state change.", e);
        }
    }

    boolean m4425c(int i, int i2) {
        return i >= 50 && i < i2;
    }

    public void execute() {
        gr.m4771U("PLEASE IMPLEMENT mraid.resize()");
        if (this.mContext == null) {
            gr.m4773W("Not an activity context. Cannot resize.");
        } else if (this.mo.ac().oq) {
            gr.m4773W("Is interstitial. Cannot resize an interstitial.");
        } else if (this.mo.dH()) {
            gr.m4773W("Is expanded. Cannot resize an expanded banner.");
        } else {
            bQ();
            if (bR()) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int a = gq.m4764a(displayMetrics, this.li) + 16;
                int a2 = gq.m4764a(displayMetrics, this.lj) + 16;
                ViewParent parent = this.mo.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.mo);
                }
                View linearLayout = new LinearLayout(this.mContext);
                linearLayout.setBackgroundColor(0);
                PopupWindow popupWindow = new PopupWindow(this.mContext);
                popupWindow.setHeight(a2);
                popupWindow.setWidth(a);
                popupWindow.setClippingEnabled(!this.rn);
                popupWindow.setContentView(linearLayout);
                linearLayout.addView(this.mo, -1, -1);
                popupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 0, this.rl, this.rm);
                this.mo.m4785a(new ay(this.mContext, new AdSize(this.li, this.lj)));
                bS();
                bT();
                return;
            }
            gr.m4773W("Invalid width and height options. Cannot resize.");
        }
    }
}
