package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bv.C1036a;
import com.google.android.gms.internal.fn.C1154a;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fo implements C1154a<bt> {
    public /* synthetic */ C1036a m4624a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return m4625b(fnVar, jSONObject);
    }

    public bt m4625b(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new bt(jSONObject.getString("headline"), (Drawable) fnVar.m4620a(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) fnVar.m4620a(jSONObject, "app_icon", true).get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"));
    }
}
