package com.google.android.gms.cast;

import com.google.android.gms.internal.in;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    private static final long[] Gs;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    private JSONObject Ga;
    private MediaInfo Gb;
    private long Gj;
    private double Gk;
    private int Gl;
    private int Gm;
    private long Gn;
    private long Go;
    private double Gp;
    private boolean Gq;
    private long[] Gr;

    static {
        Gs = new long[IDLE_REASON_NONE];
    }

    public MediaStatus(JSONObject jSONObject) throws JSONException {
        m1701a(jSONObject, IDLE_REASON_NONE);
    }

    public final int m1701a(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long b;
        long[] jArr;
        int i3 = PLAYER_STATE_PLAYING;
        Object obj = null;
        Object obj2 = PLAYER_STATE_IDLE;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.Gj) {
            this.Gj = j;
            i2 = PLAYER_STATE_IDLE;
        } else {
            i2 = IDLE_REASON_NONE;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? PLAYER_STATE_IDLE : string.equals("PLAYING") ? PLAYER_STATE_PLAYING : string.equals("PAUSED") ? PLAYER_STATE_PAUSED : string.equals("BUFFERING") ? PLAYER_STATE_BUFFERING : IDLE_REASON_NONE;
            if (i4 != this.Gl) {
                this.Gl = i4;
                i2 |= PLAYER_STATE_PLAYING;
            }
            if (i4 == PLAYER_STATE_IDLE && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i3 = string.equals("INTERRUPTED") ? PLAYER_STATE_PAUSED : string.equals("FINISHED") ? PLAYER_STATE_IDLE : string.equals("ERROR") ? PLAYER_STATE_BUFFERING : IDLE_REASON_NONE;
                }
                if (i3 != this.Gm) {
                    this.Gm = i3;
                    i2 |= PLAYER_STATE_PLAYING;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.Gk != d) {
                this.Gk = d;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("currentTime") && (i & PLAYER_STATE_PLAYING) == 0) {
            b = in.m5028b(jSONObject.getDouble("currentTime"));
            if (b != this.Gn) {
                this.Gn = b;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            b = jSONObject.getLong("supportedMediaCommands");
            if (b != this.Go) {
                this.Go = b;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("volume") && (i & PLAYER_STATE_IDLE) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.Gp) {
                this.Gp = d2;
                i2 |= PLAYER_STATE_PLAYING;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.Gq) {
                this.Gq = z;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i3 = IDLE_REASON_NONE; i3 < length; i3 += PLAYER_STATE_IDLE) {
                jArr2[i3] = jSONArray.getLong(i3);
            }
            if (this.Gr != null && this.Gr.length == length) {
                for (i3 = IDLE_REASON_NONE; i3 < length; i3 += PLAYER_STATE_IDLE) {
                    if (this.Gr[i3] != jArr2[i3]) {
                        break;
                    }
                }
                obj2 = IDLE_REASON_NONE;
            }
            if (obj2 != null) {
                this.Gr = jArr2;
            }
            obj = obj2;
            jArr = jArr2;
        } else if (this.Gr != null) {
            obj = PLAYER_STATE_IDLE;
            jArr = null;
        } else {
            jArr = null;
        }
        if (obj != null) {
            this.Gr = jArr;
            i2 |= PLAYER_STATE_PLAYING;
        }
        if (jSONObject.has("customData")) {
            this.Ga = jSONObject.getJSONObject("customData");
            i2 |= PLAYER_STATE_PLAYING;
        }
        if (!jSONObject.has("media")) {
            return i2;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("media");
        this.Gb = new MediaInfo(jSONObject3);
        i2 |= PLAYER_STATE_PLAYING;
        return jSONObject3.has("metadata") ? i2 | PLAYER_STATE_BUFFERING : i2;
    }

    public final long fR() {
        return this.Gj;
    }

    public final long[] getActiveTrackIds() {
        return this.Gr != null ? this.Gr : Gs;
    }

    public final JSONObject getCustomData() {
        return this.Ga;
    }

    public final int getIdleReason() {
        return this.Gm;
    }

    public final MediaInfo getMediaInfo() {
        return this.Gb;
    }

    public final double getPlaybackRate() {
        return this.Gk;
    }

    public final int getPlayerState() {
        return this.Gl;
    }

    public final long getStreamPosition() {
        return this.Gn;
    }

    public final double getStreamVolume() {
        return this.Gp;
    }

    public final boolean isMediaCommandSupported(long j) {
        return (this.Go & j) != 0;
    }

    public final boolean isMute() {
        return this.Gq;
    }
}
