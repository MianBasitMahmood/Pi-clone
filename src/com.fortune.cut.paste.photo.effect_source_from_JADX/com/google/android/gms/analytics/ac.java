package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ac {
    public static String m1483a(ab abVar, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(abVar.fa());
        if (abVar.fc() > 0) {
            long fc = j - abVar.fc();
            if (fc >= 0) {
                stringBuilder.append("&qt=").append(fc);
            }
        }
        stringBuilder.append("&z=").append(abVar.fb());
        return stringBuilder.toString();
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }

    static Map<String, String> m1484z(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
