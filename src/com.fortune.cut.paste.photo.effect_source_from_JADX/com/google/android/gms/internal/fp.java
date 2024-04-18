package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bv.C1036a;
import com.google.android.gms.internal.fn.C1154a;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fp implements C1154a<bu> {
    public /* synthetic */ C1036a m4626a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return m4627c(fnVar, jSONObject);
    }

    public bu m4627c(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new bu(jSONObject.getString("headline"), (Drawable) fnVar.m4620a(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) fnVar.m4620a(jSONObject, "secondary_image", false).get(), jSONObject.getString("call_to_action"), jSONObject.getString("attribution"));
    }
}
