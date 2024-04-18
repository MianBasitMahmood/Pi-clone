package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private long Eg;
    private String FR;
    private String FT;
    private String FV;
    private JSONObject Ga;
    private int Gt;
    private int Gu;
    private String mName;

    public static class Builder {
        private final MediaTrack Gv;

        public Builder(long j, int i) throws IllegalArgumentException {
            this.Gv = new MediaTrack(j, i);
        }

        public MediaTrack build() {
            return this.Gv;
        }

        public Builder setContentId(String str) {
            this.Gv.setContentId(str);
            return this;
        }

        public Builder setContentType(String str) {
            this.Gv.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.Gv.setCustomData(jSONObject);
            return this;
        }

        public Builder setLanguage(String str) {
            this.Gv.setLanguage(str);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.Gv.setLanguage(in.m5029b(locale));
            return this;
        }

        public Builder setName(String str) {
            this.Gv.setName(str);
            return this;
        }

        public Builder setSubtype(int i) throws IllegalArgumentException {
            this.Gv.ab(i);
            return this;
        }
    }

    MediaTrack(long j, int i) throws IllegalArgumentException {
        clear();
        this.Eg = j;
        if (i <= 0 || i > TYPE_VIDEO) {
            throw new IllegalArgumentException("invalid type " + i);
        }
        this.Gt = i;
    }

    MediaTrack(JSONObject jSONObject) throws JSONException {
        m1702c(jSONObject);
    }

    private void m1702c(JSONObject jSONObject) throws JSONException {
        clear();
        this.Eg = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.Gt = TYPE_TEXT;
        } else if ("AUDIO".equals(string)) {
            this.Gt = TYPE_AUDIO;
        } else if ("VIDEO".equals(string)) {
            this.Gt = TYPE_VIDEO;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.FT = jSONObject.optString("trackContentId", null);
        this.FV = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.FR = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.Gu = TYPE_TEXT;
            } else if ("CAPTIONS".equals(string)) {
                this.Gu = TYPE_AUDIO;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.Gu = TYPE_VIDEO;
            } else if ("CHAPTERS".equals(string)) {
                this.Gu = SUBTYPE_CHAPTERS;
            } else if ("METADATA".equals(string)) {
                this.Gu = SUBTYPE_METADATA;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.Gu = TYPE_UNKNOWN;
        this.Ga = jSONObject.optJSONObject("customData");
    }

    private void clear() {
        this.Eg = 0;
        this.Gt = TYPE_UNKNOWN;
        this.FT = null;
        this.mName = null;
        this.FR = null;
        this.Gu = SUBTYPE_UNKNOWN;
        this.Ga = null;
    }

    final void ab(int i) throws IllegalArgumentException {
        if (i < 0 || i > SUBTYPE_METADATA) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.Gt == TYPE_TEXT) {
            this.Gu = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        return (this.Ga == null ? TYPE_TEXT : false) == (mediaTrack.Ga == null ? TYPE_TEXT : false) ? (this.Ga == null || mediaTrack.Ga == null || li.m5332d(this.Ga, mediaTrack.Ga)) && this.Eg == mediaTrack.Eg && this.Gt == mediaTrack.Gt && in.m5027a(this.FT, mediaTrack.FT) && in.m5027a(this.FV, mediaTrack.FV) && in.m5027a(this.mName, mediaTrack.mName) && in.m5027a(this.FR, mediaTrack.FR) && this.Gu == mediaTrack.Gu : false;
    }

    public final String getContentId() {
        return this.FT;
    }

    public final String getContentType() {
        return this.FV;
    }

    public final JSONObject getCustomData() {
        return this.Ga;
    }

    public final long getId() {
        return this.Eg;
    }

    public final String getLanguage() {
        return this.FR;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getSubtype() {
        return this.Gu;
    }

    public final int getType() {
        return this.Gt;
    }

    public final int hashCode() {
        return jv.hashCode(Long.valueOf(this.Eg), Integer.valueOf(this.Gt), this.FT, this.FV, this.mName, this.FR, Integer.valueOf(this.Gu), this.Ga);
    }

    public final void setContentId(String str) {
        this.FT = str;
    }

    public final void setContentType(String str) {
        this.FV = str;
    }

    final void setCustomData(JSONObject jSONObject) {
        this.Ga = jSONObject;
    }

    final void setLanguage(String str) {
        this.FR = str;
    }

    final void setName(String str) {
        this.mName = str;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.Eg);
            switch (this.Gt) {
                case TYPE_TEXT /*1*/:
                    jSONObject.put("type", "TEXT");
                    break;
                case TYPE_AUDIO /*2*/:
                    jSONObject.put("type", "AUDIO");
                    break;
                case TYPE_VIDEO /*3*/:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.FT != null) {
                jSONObject.put("trackContentId", this.FT);
            }
            if (this.FV != null) {
                jSONObject.put("trackContentType", this.FV);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.FR)) {
                jSONObject.put("language", this.FR);
            }
            switch (this.Gu) {
                case TYPE_TEXT /*1*/:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case TYPE_AUDIO /*2*/:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case TYPE_VIDEO /*3*/:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case SUBTYPE_CHAPTERS /*4*/:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case SUBTYPE_METADATA /*5*/:
                    jSONObject.put("subtype", "METADATA");
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
