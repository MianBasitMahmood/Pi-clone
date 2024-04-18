package com.google.android.gms.internal;

import org.json.JSONObject;

@ey
public class dk {
    private final boolean rs;
    private final boolean rt;
    private final boolean ru;
    private final boolean rv;
    private final boolean rw;

    /* renamed from: com.google.android.gms.internal.dk.a */
    public static final class C1088a {
        private boolean rs;
        private boolean rt;
        private boolean ru;
        private boolean rv;
        private boolean rw;

        public final dk bU() {
            return new dk();
        }

        public final C1088a m4435k(boolean z) {
            this.rs = z;
            return this;
        }

        public final C1088a m4436l(boolean z) {
            this.rt = z;
            return this;
        }

        public final C1088a m4437m(boolean z) {
            this.ru = z;
            return this;
        }

        public final C1088a m4438n(boolean z) {
            this.rv = z;
            return this;
        }

        public final C1088a m4439o(boolean z) {
            this.rw = z;
            return this;
        }
    }

    private dk(C1088a c1088a) {
        this.rs = c1088a.rs;
        this.rt = c1088a.rt;
        this.ru = c1088a.ru;
        this.rv = c1088a.rv;
        this.rw = c1088a.rw;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.rs).put("tel", this.rt).put("calendar", this.ru).put("storePicture", this.rv).put("inlineVideo", this.rw);
        } catch (Throwable e) {
            gr.m4775b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
