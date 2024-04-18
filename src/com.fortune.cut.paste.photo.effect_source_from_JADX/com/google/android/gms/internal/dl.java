package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.dk.C1088a;
import org.json.JSONObject;

@ey
public class dl {
    private final Context mContext;
    private final WindowManager mR;
    private final gu mo;
    int rA;
    int rB;
    private int rC;
    private int rD;
    private int rE;
    private int[] rF;
    private final bl rx;
    DisplayMetrics ry;
    private float rz;

    public dl(gu guVar, Context context, bl blVar) {
        this.rA = -1;
        this.rB = -1;
        this.rD = -1;
        this.rE = -1;
        this.rF = new int[2];
        this.mo = guVar;
        this.mContext = context;
        this.rx = blVar;
        this.mR = (WindowManager) context.getSystemService("window");
        bV();
        bW();
        bX();
    }

    private void bV() {
        this.ry = new DisplayMetrics();
        Display defaultDisplay = this.mR.getDefaultDisplay();
        defaultDisplay.getMetrics(this.ry);
        this.rz = this.ry.density;
        this.rC = defaultDisplay.getRotation();
    }

    private void bX() {
        this.mo.getLocationOnScreen(this.rF);
        this.mo.measure(0, 0);
        float f = 160.0f / ((float) this.ry.densityDpi);
        this.rD = Math.round(((float) this.mo.getMeasuredWidth()) * f);
        this.rE = Math.round(f * ((float) this.mo.getMeasuredHeight()));
    }

    private dk cd() {
        return new C1088a().m4436l(this.rx.bo()).m4435k(this.rx.bp()).m4437m(this.rx.bt()).m4438n(this.rx.bq()).m4439o(this.rx.br()).bU();
    }

    void bW() {
        int s = gi.m4742s(this.mContext);
        float f = 160.0f / ((float) this.ry.densityDpi);
        this.rA = Math.round(((float) this.ry.widthPixels) * f);
        this.rB = Math.round(((float) (this.ry.heightPixels - s)) * f);
    }

    public void bY() {
        cb();
        cc();
        ca();
        bZ();
    }

    public void bZ() {
        if (gr.m4778v(2)) {
            gr.m4771U("Dispatching Ready Event.");
        }
        this.mo.m4789b("onReadyEventReceived", new JSONObject());
    }

    public void ca() {
        try {
            this.mo.m4789b("onDefaultPositionReceived", new JSONObject().put("x", this.rF[0]).put("y", this.rF[1]).put("width", this.rD).put("height", this.rE));
        } catch (Throwable e) {
            gr.m4775b("Error occured while dispatching default position.", e);
        }
    }

    public void cb() {
        try {
            this.mo.m4789b("onScreenInfoChanged", new JSONObject().put("width", this.rA).put("height", this.rB).put("density", (double) this.rz).put("rotation", this.rC));
        } catch (Throwable e) {
            gr.m4775b("Error occured while obtaining screen information.", e);
        }
    }

    public void cc() {
        this.mo.m4789b("onDeviceFeaturesReceived", cd().toJson());
    }
}
