package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String FT;
    private int FU;
    private String FV;
    private MediaMetadata FW;
    private long FX;
    private List<MediaTrack> FY;
    private TextTrackStyle FZ;
    private JSONObject Ga;

    public static class Builder {
        private final MediaInfo Gb;

        public Builder(String str) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.Gb = new MediaInfo(str);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.Gb.fQ();
            return this.Gb;
        }

        public Builder setContentType(String str) throws IllegalArgumentException {
            this.Gb.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.Gb.setCustomData(jSONObject);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.Gb.m1693d(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.Gb.m1692a(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) throws IllegalArgumentException {
            this.Gb.m1694m(j);
            return this;
        }

        public Builder setStreamType(int i) throws IllegalArgumentException {
            this.Gb.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.Gb.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.FT = str;
        this.FU = STREAM_TYPE_INVALID;
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        int i = STREAM_TYPE_NONE;
        this.FT = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.FU = STREAM_TYPE_NONE;
        } else if ("BUFFERED".equals(string)) {
            this.FU = STREAM_TYPE_BUFFERED;
        } else if ("LIVE".equals(string)) {
            this.FU = STREAM_TYPE_LIVE;
        } else {
            this.FU = STREAM_TYPE_INVALID;
        }
        this.FV = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.FW = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.FW.m1700c(jSONObject2);
        }
        this.FX = UNKNOWN_DURATION;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.FX = in.m5028b(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.FY = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.FY.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i += STREAM_TYPE_BUFFERED;
            }
        } else {
            this.FY = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.m1758c(jSONObject3);
            this.FZ = textTrackStyle;
        } else {
            this.FZ = null;
        }
        this.Ga = jSONObject.optJSONObject("customData");
    }

    final void m1692a(MediaMetadata mediaMetadata) {
        this.FW = mediaMetadata;
    }

    final void m1693d(List<MediaTrack> list) {
        this.FY = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        return (this.Ga == null ? STREAM_TYPE_BUFFERED : false) == (mediaInfo.Ga == null ? STREAM_TYPE_BUFFERED : false) ? (this.Ga == null || mediaInfo.Ga == null || li.m5332d(this.Ga, mediaInfo.Ga)) && in.m5027a(this.FT, mediaInfo.FT) && this.FU == mediaInfo.FU && in.m5027a(this.FV, mediaInfo.FV) && in.m5027a(this.FW, mediaInfo.FW) && this.FX == mediaInfo.FX : false;
    }

    final void fQ() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.FT)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.FV)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.FU == STREAM_TYPE_INVALID) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
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

    public final List<MediaTrack> getMediaTracks() {
        return this.FY;
    }

    public final MediaMetadata getMetadata() {
        return this.FW;
    }

    public final long getStreamDuration() {
        return this.FX;
    }

    public final int getStreamType() {
        return this.FU;
    }

    public final TextTrackStyle getTextTrackStyle() {
        return this.FZ;
    }

    public final int hashCode() {
        return jv.hashCode(this.FT, Integer.valueOf(this.FU), this.FV, this.FW, Long.valueOf(this.FX), String.valueOf(this.Ga));
    }

    final void m1694m(long j) throws IllegalArgumentException {
        if (j < 0) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        }
        this.FX = j;
    }

    final void setContentType(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.FV = str;
    }

    final void setCustomData(JSONObject jSONObject) {
        this.Ga = jSONObject;
    }

    final void setStreamType(int i) throws IllegalArgumentException {
        if (i < STREAM_TYPE_INVALID || i > STREAM_TYPE_LIVE) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.FU = i;
    }

    public final void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.FZ = textTrackStyle;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.FT);
            switch (this.FU) {
                case STREAM_TYPE_BUFFERED /*1*/:
                    obj = "BUFFERED";
                    break;
                case STREAM_TYPE_LIVE /*2*/:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.FV != null) {
                jSONObject.put("contentType", this.FV);
            }
            if (this.FW != null) {
                jSONObject.put("metadata", this.FW.toJson());
            }
            jSONObject.put("duration", in.m5030o(this.FX));
            if (this.FY != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.FY) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.FZ != null) {
                jSONObject.put("textTrackStyle", this.FZ.toJson());
            }
            if (this.Ga != null) {
                jSONObject.put("customData", this.Ga);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
