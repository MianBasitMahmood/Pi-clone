package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.drive.ExecutionOptions;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cc {
    public static final cd pQ;
    public static final cd pR;
    public static final cd pS;
    public static final cd pT;
    public static final cd pU;
    public static final cd pV;
    public static final cd pW;
    public static final cd pX;
    public static final cd pY;
    public static final cd pZ;

    /* renamed from: com.google.android.gms.internal.cc.1 */
    static class C10491 implements cd {
        C10491() {
        }

        public final void m4337a(gu guVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.2 */
    static class C10502 implements cd {
        C10502() {
        }

        public final void m4338a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                gr.m4773W("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = guVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null));
            }
            guVar.m4787a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.3 */
    static class C10513 implements cd {
        C10513() {
        }

        public final void m4339a(gu guVar, Map<String, String> map) {
            PackageManager packageManager = guVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null);
                            } catch (Throwable e) {
                                gr.m4775b("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            gr.m4775b("Error parsing the intent data.", e2);
                        }
                    }
                    guVar.m4789b("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    guVar.m4789b("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                guVar.m4789b("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.4 */
    static class C10524 implements cd {
        C10524() {
        }

        public final void m4340a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                gr.m4773W("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C1266k dF = guVar.dF();
                if (dF != null && dF.m5240b(parse)) {
                    a = dF.m5237a(parse, guVar.getContext());
                    new gp(guVar.getContext(), guVar.dG().wS, a.toString()).start();
                }
            } catch (C1280l e) {
                gr.m4773W("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new gp(guVar.getContext(), guVar.dG().wS, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.5 */
    static class C10535 implements cd {
        C10535() {
        }

        public final void m4341a(gu guVar, Map<String, String> map) {
            dp dC = guVar.dC();
            if (dC == null) {
                gr.m4773W("A GMSG tried to close something that wasn't an overlay.");
            } else {
                dC.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.6 */
    static class C10546 implements cd {
        C10546() {
        }

        public final void m4342a(gu guVar, Map<String, String> map) {
            guVar.m4790q("1".equals(map.get("custom_close")));
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.7 */
    static class C10557 implements cd {
        C10557() {
        }

        public final void m4343a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                gr.m4773W("URL missing from httpTrack GMSG.");
            } else {
                new gp(guVar.getContext(), guVar.dG().wS, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.8 */
    static class C10568 implements cd {
        C10568() {
        }

        public final void m4344a(gu guVar, Map<String, String> map) {
            gr.m4771U("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.cc.9 */
    static class C10579 implements cd {
        C10579() {
        }

        public final void m4345a(gu guVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C1266k dF = guVar.dF();
                if (dF != null) {
                    dF.m5236C().m4683a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                gr.m4773W("Could not parse touch parameters from gmsg.");
            }
        }
    }

    static {
        pQ = new C10491();
        pR = new C10502();
        pS = new C10513();
        pT = new C10524();
        pU = new C10535();
        pV = new C10546();
        pW = new C10557();
        pX = new C10568();
        pY = new C10579();
        pZ = new cj();
    }
}
