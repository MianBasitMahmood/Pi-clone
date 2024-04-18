package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.C0104a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.C0131g.C0101a;
import com.chartboost.sdk.Libraries.C0131g.C0125k;
import com.google.android.gms.plus.PlusShare;

/* renamed from: com.chartboost.sdk.Model.b */
public class C0149b {
    public static C0101a f213a;
    public static C0101a f214b;
    public static C0101a f215c;
    public static C0101a f216d;
    private static C0101a f217e;
    private static C0101a f218f;
    private static C0101a f219g;
    private static C0101a f220h;
    private static C0101a f221i;

    static {
        f217e = C0131g.m221a(C0131g.m223a(PlusShare.KEY_CALL_TO_ACTION_URL, C0131g.m217a()), C0131g.m223a("id", C0131g.m217a()), C0131g.m223a("local-file", C0131g.m217a()), C0131g.m223a("buffer", C0131g.m218a(C0131g.m224b())));
        C0125k[] c0125kArr = new C0125k[3];
        c0125kArr[0] = C0131g.m223a(PlusShare.KEY_CALL_TO_ACTION_URL, C0131g.m217a());
        c0125kArr[1] = C0131g.m223a("scale", C0131g.m218a(C0131g.m224b()));
        c0125kArr[2] = C0131g.m223a("offset", C0131g.m218a(C0131g.m226b(C0131g.m223a("x", C0131g.m224b()), C0131g.m223a("y", C0131g.m224b()))));
        f218f = C0131g.m221a(c0125kArr);
        f219g = C0131g.m221a(C0131g.m223a("video-landscape", C0131g.m218a(f217e)), C0131g.m223a("video-portrait", C0131g.m218a(f217e)), C0131g.m223a("ad-landscape", C0131g.m218a(f218f)), C0131g.m223a("frame-landscape", C0131g.m218a(f218f)), C0131g.m223a("close-landscape", C0131g.m218a(f218f)), C0131g.m223a("replay-landscape", C0131g.m218a(f218f)), C0131g.m223a("ad-portrait", C0131g.m218a(f218f)), C0131g.m223a("frame-portrait", C0131g.m218a(f218f)), C0131g.m223a("close-portrait", C0131g.m218a(f218f)), C0131g.m223a("replay-portrait", C0131g.m218a(f218f)), C0131g.m223a("video-click-button", C0131g.m218a(f218f)), C0131g.m223a("post-video-icon", C0131g.m218a(f218f)), C0131g.m223a("post-video-button", C0131g.m218a(f218f)), C0131g.m223a("video-confirmation-icon", C0131g.m218a(f218f)), C0131g.m223a("video-confirmation-button", C0131g.m218a(f218f)), C0131g.m223a("post-video-reward-icon", C0131g.m218a(f218f)), C0131g.m223a("blur-background", C0131g.m218a(f218f)));
        c0125kArr = new C0125k[11];
        c0125kArr[0] = C0131g.m223a("progress", C0131g.m218a(C0131g.m226b(C0131g.m223a("delay", C0131g.m224b()), C0131g.m223a("background-color", C0131g.m217a()), C0131g.m223a("progress-color", C0131g.m217a()), C0131g.m223a("border-color", C0131g.m217a()), C0131g.m223a("radius", C0131g.m224b()))));
        c0125kArr[1] = C0131g.m223a("video-controls-togglable", C0131g.m218a(C0131g.m227c()));
        c0125kArr[2] = C0131g.m223a("video-controls-background", C0131g.m226b(C0131g.m223a("color", C0131g.m217a()), C0131g.m223a("border-color", C0131g.m217a())));
        c0125kArr[3] = C0131g.m223a("post-video-toaster", C0131g.m218a(C0131g.m226b(C0131g.m223a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0131g.m217a()), C0131g.m223a("tagline", C0131g.m217a()))));
        c0125kArr[4] = C0131g.m223a("pre-popup", C0131g.m218a(C0131g.m226b(C0131g.m223a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0131g.m217a()), C0131g.m223a("text", C0131g.m217a()), C0131g.m223a("confirm", C0131g.m217a()), C0131g.m223a("cancel", C0131g.m217a()))));
        c0125kArr[5] = C0131g.m223a("post-popup", C0131g.m218a(C0131g.m226b(C0131g.m223a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0131g.m217a()), C0131g.m223a("text", C0131g.m217a()), C0131g.m223a("confirm", C0131g.m217a()))));
        c0125kArr[6] = C0131g.m223a("cancel-popup", C0131g.m218a(C0131g.m226b(C0131g.m223a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0131g.m217a()), C0131g.m223a("text", C0131g.m217a()), C0131g.m223a("confirm", C0131g.m217a()), C0131g.m223a("cancel", C0131g.m217a()))));
        c0125kArr[7] = C0131g.m223a("confirmation", C0131g.m218a(C0131g.m226b(C0131g.m223a("text", C0131g.m217a()), C0131g.m223a("color", C0131g.m217a()))));
        c0125kArr[8] = C0131g.m223a("video-progress-timer-enabled", C0131g.m218a(C0131g.m227c()));
        C0125k[] c0125kArr2 = new C0125k[2];
        c0125kArr2[0] = C0131g.m223a("text", C0131g.m217a());
        c0125kArr2[1] = C0131g.m223a("position", C0131g.m222a("inside-top", "outside-bottom"));
        c0125kArr[9] = C0131g.m223a("post-video-reward-toaster", C0131g.m218a(C0131g.m226b(c0125kArr2)));
        c0125kArr[10] = C0131g.m223a("play-another-popup", C0131g.m218a(C0131g.m226b(C0131g.m223a("skip-confirmation", C0131g.m227c()), C0131g.m223a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0131g.m217a()), C0131g.m223a("text", C0131g.m217a()), C0131g.m223a("cancel", C0131g.m217a()), C0131g.m223a("confirm", C0131g.m217a()))));
        f220h = C0131g.m218a(C0131g.m221a(c0125kArr));
        c0125kArr = new C0125k[14];
        c0125kArr[0] = C0131g.m223a("close", C0131g.m218a(f218f));
        c0125kArr[1] = C0131g.m223a("header-center", C0131g.m218a(f218f));
        c0125kArr[2] = C0131g.m223a("header-tile", C0131g.m218a(f218f));
        c0125kArr[3] = C0131g.m223a("header-height", C0131g.m218a(C0131g.m224b()));
        c0125kArr[4] = C0131g.m223a("background-color", C0131g.m218a(C0131g.m217a()));
        c0125kArr[5] = C0131g.m223a("header-text", C0131g.m218a(C0131g.m217a()));
        c0125kArr[6] = C0131g.m223a("text-color", C0131g.m218a(C0131g.m217a()));
        c0125kArr[7] = C0131g.m223a("close-landscape", C0131g.m218a(f218f));
        c0125kArr[8] = C0131g.m223a("header-landscape", C0131g.m218a(f218f));
        c0125kArr[9] = C0131g.m223a("close-portrait", C0131g.m218a(f218f));
        c0125kArr[10] = C0131g.m223a("header-portrait", C0131g.m218a(f218f));
        c0125kArr[11] = C0131g.m223a("install-button", C0131g.m218a(f218f));
        c0125kArr[12] = C0131g.m223a("play-button", C0131g.m218a(f218f));
        c0125kArr[13] = C0131g.m223a("offset", C0131g.m218a(C0131g.m226b(C0131g.m223a("x", C0131g.m224b()), C0131g.m223a("y", C0131g.m224b()))));
        f213a = C0131g.m221a(c0125kArr);
        c0125kArr = new C0125k[12];
        c0125kArr[4] = C0131g.m223a("assets", C0131g.m221a(C0131g.m223a("icon", f218f)));
        c0125kArr[5] = C0131g.m223a("text", C0131g.m218a(C0131g.m217a()));
        c0125kArr[6] = C0131g.m223a("link", C0131g.m218a(C0131g.m217a()));
        c0125kArr[7] = C0131g.m223a("deep-link", C0131g.m218a(C0131g.m217a()));
        c0125kArr[8] = C0131g.m223a("itunes_id", C0131g.m218a(C0131g.m217a()));
        c0125kArr[9] = C0131g.m223a("publisher", C0131g.m218a(C0131g.m217a()));
        c0125kArr[10] = C0131g.m223a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0131g.m218a(C0131g.m217a()));
        c0125kArr[11] = C0131g.m223a("border-color", C0131g.m218a(C0131g.m217a()));
        f221i = C0131g.m225b(C0131g.m221a(c0125kArr));
        f214b = C0131g.m221a(C0131g.m223a("status", C0104a.f83a), C0131g.m223a("ad_id", C0131g.m217a()), C0131g.m223a("to", C0131g.m217a()), C0131g.m223a("type", C0131g.m217a()), C0131g.m223a("native", C0131g.m218a(C0131g.m217a())), C0131g.m223a("message", C0131g.m217a()), C0131g.m223a("link", C0131g.m217a()), C0131g.m223a("deep-link", C0131g.m218a(C0131g.m217a())), C0131g.m223a("cgn", C0131g.m217a()), C0131g.m223a("creative", C0131g.m217a()), C0131g.m223a("assets", f219g), C0131g.m223a("ux", f220h), C0131g.m223a("reward", C0131g.m218a(C0131g.m219a(Object.class))));
        f215c = C0131g.m221a(C0131g.m223a("status", C0104a.f83a), C0131g.m223a("message", C0131g.m217a()), C0131g.m223a("type", C0131g.m217a()), C0131g.m223a("assets", f213a), C0131g.m223a("cells", f221i));
        c0125kArr = new C0125k[12];
        c0125kArr[0] = C0131g.m223a("status", C0104a.f83a);
        c0125kArr[1] = C0131g.m223a("ad_id", C0131g.m217a());
        c0125kArr[2] = C0131g.m223a("to", C0131g.m218a(C0131g.m217a()));
        c0125kArr[3] = C0131g.m223a("type", C0131g.m218a(C0131g.m217a()));
        c0125kArr[4] = C0131g.m223a("native", C0131g.m218a(C0131g.m217a()));
        c0125kArr[5] = C0131g.m223a("message", C0131g.m218a(C0131g.m217a()));
        c0125kArr[6] = C0131g.m223a("link", C0131g.m217a());
        c0125kArr[7] = C0131g.m223a("name", C0131g.m217a());
        c0125kArr[8] = C0131g.m223a("deep-link", C0131g.m218a(C0131g.m217a()));
        c0125kArr[9] = C0131g.m223a("cgn", C0131g.m217a());
        c0125kArr[10] = C0131g.m223a("creative", C0131g.m217a());
        c0125kArr[11] = C0131g.m223a("icons", C0131g.m221a(C0131g.m223a("sm", C0131g.m217a()), C0131g.m223a("md", C0131g.m217a()), C0131g.m223a("lg", C0131g.m217a())));
        f216d = C0131g.m221a(c0125kArr);
    }
}
