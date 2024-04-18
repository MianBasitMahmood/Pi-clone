package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.ll;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private float GT;
    private int GU;
    private int GV;
    private int GW;
    private int GX;
    private int GY;
    private int GZ;
    private JSONObject Ga;
    private String Ha;
    private int Hb;
    private int Hc;
    private int xB;

    public TextTrackStyle() {
        clear();
    }

    private int aC(String str) {
        int i = WINDOW_TYPE_NONE;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(WINDOW_TYPE_NORMAL, FONT_STYLE_BOLD_ITALIC), 16), Integer.parseInt(str.substring(FONT_STYLE_BOLD_ITALIC, FONT_FAMILY_CURSIVE), 16), Integer.parseInt(str.substring(FONT_FAMILY_CURSIVE, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private void clear() {
        this.GT = DEFAULT_FONT_SCALE;
        this.GU = WINDOW_TYPE_NONE;
        this.xB = WINDOW_TYPE_NONE;
        this.GV = WINDOW_TYPE_UNSPECIFIED;
        this.GW = WINDOW_TYPE_NONE;
        this.GX = WINDOW_TYPE_UNSPECIFIED;
        this.GY = WINDOW_TYPE_NONE;
        this.GZ = WINDOW_TYPE_NONE;
        this.Ha = null;
        this.Hb = WINDOW_TYPE_UNSPECIFIED;
        this.Hc = WINDOW_TYPE_UNSPECIFIED;
        this.Ga = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!ll.im()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.GT = captioningManager.getFontScale();
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.xB = userStyle.backgroundColor;
        textTrackStyle.GU = userStyle.foregroundColor;
        switch (userStyle.edgeType) {
            case WINDOW_TYPE_NORMAL /*1*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NORMAL);
                break;
            case WINDOW_TYPE_ROUNDED /*2*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_ROUNDED);
                break;
            default:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NONE);
                break;
        }
        textTrackStyle.GW = userStyle.edgeColor;
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NORMAL);
            } else if (Typeface.SANS_SERIF.equals(typeface) || !Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            } else {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_ROUNDED);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(FONT_STYLE_BOLD_ITALIC);
            } else if (isBold) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NORMAL);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NONE);
            }
        }
        return textTrackStyle;
    }

    private String m1757u(int i) {
        Object[] objArr = new Object[FONT_FAMILY_CASUAL];
        objArr[WINDOW_TYPE_NONE] = Integer.valueOf(Color.red(i));
        objArr[WINDOW_TYPE_NORMAL] = Integer.valueOf(Color.green(i));
        objArr[WINDOW_TYPE_ROUNDED] = Integer.valueOf(Color.blue(i));
        objArr[FONT_STYLE_BOLD_ITALIC] = Integer.valueOf(Color.alpha(i));
        return String.format("#%02X%02X%02X%02X", objArr);
    }

    public final void m1758c(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.GT = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.GU = aC(jSONObject.optString("foregroundColor"));
        this.xB = aC(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.GV = WINDOW_TYPE_NONE;
            } else if ("OUTLINE".equals(string)) {
                this.GV = WINDOW_TYPE_NORMAL;
            } else if ("DROP_SHADOW".equals(string)) {
                this.GV = WINDOW_TYPE_ROUNDED;
            } else if ("RAISED".equals(string)) {
                this.GV = FONT_STYLE_BOLD_ITALIC;
            } else if ("DEPRESSED".equals(string)) {
                this.GV = FONT_FAMILY_CASUAL;
            }
        }
        this.GW = aC(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.GX = WINDOW_TYPE_NONE;
            } else if ("NORMAL".equals(string)) {
                this.GX = WINDOW_TYPE_NORMAL;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.GX = WINDOW_TYPE_ROUNDED;
            }
        }
        this.GY = aC(jSONObject.optString("windowColor"));
        if (this.GX == WINDOW_TYPE_ROUNDED) {
            this.GZ = jSONObject.optInt("windowRoundedCornerRadius", WINDOW_TYPE_NONE);
        }
        this.Ha = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.Hb = WINDOW_TYPE_NONE;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.Hb = WINDOW_TYPE_NORMAL;
            } else if ("SERIF".equals(string)) {
                this.Hb = WINDOW_TYPE_ROUNDED;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.Hb = FONT_STYLE_BOLD_ITALIC;
            } else if ("CASUAL".equals(string)) {
                this.Hb = FONT_FAMILY_CASUAL;
            } else if ("CURSIVE".equals(string)) {
                this.Hb = FONT_FAMILY_CURSIVE;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.Hb = FONT_FAMILY_SMALL_CAPITALS;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.Hc = WINDOW_TYPE_NONE;
            } else if ("BOLD".equals(string)) {
                this.Hc = WINDOW_TYPE_NORMAL;
            } else if ("ITALIC".equals(string)) {
                this.Hc = WINDOW_TYPE_ROUNDED;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.Hc = FONT_STYLE_BOLD_ITALIC;
            }
        }
        this.Ga = jSONObject.optJSONObject("customData");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        return (this.Ga == null ? WINDOW_TYPE_NORMAL : false) == (textTrackStyle.Ga == null ? WINDOW_TYPE_NORMAL : false) ? (this.Ga == null || textTrackStyle.Ga == null || li.m5332d(this.Ga, textTrackStyle.Ga)) && this.GT == textTrackStyle.GT && this.GU == textTrackStyle.GU && this.xB == textTrackStyle.xB && this.GV == textTrackStyle.GV && this.GW == textTrackStyle.GW && this.GX == textTrackStyle.GX && this.GZ == textTrackStyle.GZ && in.m5027a(this.Ha, textTrackStyle.Ha) && this.Hb == textTrackStyle.Hb && this.Hc == textTrackStyle.Hc : false;
    }

    public final int getBackgroundColor() {
        return this.xB;
    }

    public final JSONObject getCustomData() {
        return this.Ga;
    }

    public final int getEdgeColor() {
        return this.GW;
    }

    public final int getEdgeType() {
        return this.GV;
    }

    public final String getFontFamily() {
        return this.Ha;
    }

    public final int getFontGenericFamily() {
        return this.Hb;
    }

    public final float getFontScale() {
        return this.GT;
    }

    public final int getFontStyle() {
        return this.Hc;
    }

    public final int getForegroundColor() {
        return this.GU;
    }

    public final int getWindowColor() {
        return this.GY;
    }

    public final int getWindowCornerRadius() {
        return this.GZ;
    }

    public final int getWindowType() {
        return this.GX;
    }

    public final int hashCode() {
        return jv.hashCode(Float.valueOf(this.GT), Integer.valueOf(this.GU), Integer.valueOf(this.xB), Integer.valueOf(this.GV), Integer.valueOf(this.GW), Integer.valueOf(this.GX), Integer.valueOf(this.GY), Integer.valueOf(this.GZ), this.Ha, Integer.valueOf(this.Hb), Integer.valueOf(this.Hc), this.Ga);
    }

    public final void setBackgroundColor(int i) {
        this.xB = i;
    }

    public final void setCustomData(JSONObject jSONObject) {
        this.Ga = jSONObject;
    }

    public final void setEdgeColor(int i) {
        this.GW = i;
    }

    public final void setEdgeType(int i) {
        if (i < 0 || i > FONT_FAMILY_CASUAL) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.GV = i;
    }

    public final void setFontFamily(String str) {
        this.Ha = str;
    }

    public final void setFontGenericFamily(int i) {
        if (i < 0 || i > FONT_FAMILY_SMALL_CAPITALS) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.Hb = i;
    }

    public final void setFontScale(float f) {
        this.GT = f;
    }

    public final void setFontStyle(int i) {
        if (i < 0 || i > FONT_STYLE_BOLD_ITALIC) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.Hc = i;
    }

    public final void setForegroundColor(int i) {
        this.GU = i;
    }

    public final void setWindowColor(int i) {
        this.GY = i;
    }

    public final void setWindowCornerRadius(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.GZ = i;
    }

    public final void setWindowType(int i) {
        if (i < 0 || i > WINDOW_TYPE_ROUNDED) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.GX = i;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.GT);
            if (this.GU != 0) {
                jSONObject.put("foregroundColor", m1757u(this.GU));
            }
            if (this.xB != 0) {
                jSONObject.put("backgroundColor", m1757u(this.xB));
            }
            switch (this.GV) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.GW != 0) {
                jSONObject.put("edgeColor", m1757u(this.GW));
            }
            switch (this.GX) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("windowType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.GY != 0) {
                jSONObject.put("windowColor", m1757u(this.GY));
            }
            if (this.GX == WINDOW_TYPE_ROUNDED) {
                jSONObject.put("windowRoundedCornerRadius", this.GZ);
            }
            if (this.Ha != null) {
                jSONObject.put("fontFamily", this.Ha);
            }
            switch (this.Hb) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case FONT_FAMILY_CURSIVE /*5*/:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case FONT_FAMILY_SMALL_CAPITALS /*6*/:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.Hc) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.Ga != null) {
                jSONObject.put("customData", this.Ga);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
