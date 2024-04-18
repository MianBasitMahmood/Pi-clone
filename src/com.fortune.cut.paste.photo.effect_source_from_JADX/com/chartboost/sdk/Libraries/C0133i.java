package com.chartboost.sdk.Libraries;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.i */
public final class C0133i {
    public static boolean m248a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length() && !C0133i.m250b(jSONArray.toString(), jSONArray2.toString())) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object opt = jSONArray.opt(i);
            Object opt2 = jSONArray2.opt(i);
            if (!C0133i.m247a(opt.getClass(), opt2.getClass()) && (!Number.class.isInstance(opt) || !Number.class.isInstance(opt2))) {
                return false;
            }
            if (opt instanceof JSONObject) {
                if (!C0133i.m249a((JSONObject) opt, (JSONObject) opt2)) {
                    return false;
                }
            } else if (opt instanceof JSONArray) {
                if (!C0133i.m248a((JSONArray) opt, (JSONArray) opt2)) {
                    return false;
                }
            } else if (!C0133i.m250b(opt, opt2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m247a(Object obj, Object obj2) {
        return obj == obj2;
    }

    public static boolean m249a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject.length() != jSONObject2.length()) {
            try {
                if (!C0133i.m250b(jSONObject.toString(2), jSONObject2.toString(2))) {
                    return false;
                }
            } catch (JSONException e) {
                return false;
            }
        }
        JSONArray names = jSONObject.names();
        if (names == null && jSONObject2.names() == null) {
            return true;
        }
        for (int i = 0; i < names.length(); i++) {
            String optString = names.optString(i);
            Object opt = jSONObject.opt(optString);
            Object opt2 = jSONObject2.opt(optString);
            if (C0133i.m246a(opt) && !C0133i.m246a(opt2)) {
                return false;
            }
            if (!C0133i.m247a(opt.getClass(), opt2.getClass()) && (!Number.class.isInstance(opt) || !Number.class.isInstance(opt2))) {
                return false;
            }
            if (opt instanceof JSONObject) {
                if (!C0133i.m249a((JSONObject) opt, (JSONObject) opt2)) {
                    return false;
                }
            } else if (opt instanceof JSONArray) {
                if (!C0133i.m248a((JSONArray) opt, (JSONArray) opt2)) {
                    return false;
                }
            } else if (!C0133i.m250b(opt, opt2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m246a(Object obj) {
        return (obj == null || obj == JSONObject.NULL) ? false : true;
    }

    private static BigDecimal m245a(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        }
        if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger) number);
        }
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            return new BigDecimal(number.longValue());
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            return new BigDecimal(number.doubleValue());
        }
        try {
            return new BigDecimal(number.toString());
        } catch (Throwable e) {
            throw new RuntimeException("The given number (\"" + number + "\" of class " + number.getClass().getName() + ") does not have a parsable string representation", e);
        }
    }

    public static boolean m250b(Object obj, Object obj2) {
        if (obj == null || obj == JSONObject.NULL) {
            return obj2 == null || obj2 == JSONObject.NULL;
        } else {
            if (Number.class.isInstance(obj) && Number.class.isInstance(obj2)) {
                try {
                    return C0133i.m245a((Number) obj).compareTo(C0133i.m245a((Number) obj2)) == 0;
                } catch (RuntimeException e) {
                }
            }
            return obj.equals(obj2);
        }
    }
}
