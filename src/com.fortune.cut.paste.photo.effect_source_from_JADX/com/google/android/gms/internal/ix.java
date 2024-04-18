package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.ads.AdSize;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ix {
    private static final is Hh;
    private static final String[] Iq;
    private static final String Ir;

    static {
        Hh = new is("MetadataUtils");
        Iq = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
        Ir = "yyyyMMdd'T'HHmmss" + Iq[0];
    }

    public static String m5059a(Calendar calendar) {
        if (calendar == null) {
            Hh.m5050b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = Ir;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        str = simpleDateFormat.format(calendar.getTime());
        return str.endsWith("+0000") ? str.replace("+0000", Iq[0]) : str;
    }

    public static void m5060a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void m5061a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage toJson : list) {
                jSONArray.put(toJson.toJson());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }

    public static Calendar aL(String str) {
        if (TextUtils.isEmpty(str)) {
            Hh.m5050b("Input string is empty or null", new Object[0]);
            return null;
        }
        String aM = aM(str);
        if (TextUtils.isEmpty(aM)) {
            Hh.m5050b("Invalid date format", new Object[0]);
            return null;
        }
        String aN = aN(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(aN)) {
            aM = aM + "T" + aN;
            str2 = aN.length() == 6 ? "yyyyMMdd'T'HHmmss" : Ir;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(aM));
            return instance;
        } catch (ParseException e) {
            Hh.m5050b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String aM(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            Hh.m5050b("Input string is empty or null", new Object[0]);
        } else {
            try {
                str2 = str.substring(0, 8);
            } catch (IndexOutOfBoundsException e) {
                Hh.m5051c("Error extracting the date: %s", e.getMessage());
            }
        }
        return str2;
    }

    private static String aN(String str) {
        if (TextUtils.isEmpty(str)) {
            Hh.m5050b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != 8) {
            Hh.m5050b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == 6) {
                return substring;
            }
            switch (substring.charAt(6)) {
                case '+':
                case '-':
                    return aO(substring) ? substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
                case AdSize.LARGE_AD_HEIGHT /*90*/:
                    return substring.length() == Iq[0].length() + 6 ? substring.substring(0, substring.length() - 1) + "+0000" : null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            Hh.m5050b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean aO(String str) {
        int length = str.length();
        return length == Iq[1].length() + 6 || length == Iq[2].length() + 6 || length == Iq[3].length() + 6;
    }
}
