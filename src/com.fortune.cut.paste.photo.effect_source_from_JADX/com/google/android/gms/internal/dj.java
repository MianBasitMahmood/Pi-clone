package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0366R;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dj {
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;

    /* renamed from: com.google.android.gms.internal.dj.1 */
    class C10851 implements OnClickListener {
        final /* synthetic */ String rp;
        final /* synthetic */ String rq;
        final /* synthetic */ dj rr;

        C10851(dj djVar, String str, String str2) {
            this.rr = djVar;
            this.rp = str;
            this.rq = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) this.rr.mContext.getSystemService("download")).enqueue(this.rr.m4429b(this.rp, this.rq));
            } catch (IllegalStateException e) {
                gr.m4771U("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dj.2 */
    class C10862 implements OnClickListener {
        final /* synthetic */ dj rr;

        C10862(dj djVar) {
            this.rr = djVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.rr.mo.m4789b("onStorePictureCanceled", new JSONObject());
        }
    }

    public dj(gu guVar, Map<String, String> map) {
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
    }

    String m4428B(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request m4429b(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        if (ll.ig()) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
        } else {
            request.setShowRunningNotification(true);
        }
        return request;
    }

    public void execute() {
        if (!new bl(this.mContext).bq()) {
            gr.m4773W("Store picture feature is not supported on this device.");
        } else if (TextUtils.isEmpty((CharSequence) this.rd.get("iurl"))) {
            gr.m4773W("Image url cannot be empty.");
        } else {
            String str = (String) this.rd.get("iurl");
            if (URLUtil.isValidUrl(str)) {
                String B = m4428B(str);
                if (gi.m4717N(B)) {
                    Builder builder = new Builder(this.mContext);
                    builder.setTitle(ga.m4689c(C0366R.string.store_picture_title, "Save image"));
                    builder.setMessage(ga.m4689c(C0366R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    builder.setPositiveButton(ga.m4689c(C0366R.string.accept, "Accept"), new C10851(this, str, B));
                    builder.setNegativeButton(ga.m4689c(C0366R.string.decline, "Decline"), new C10862(this));
                    builder.create().show();
                    return;
                }
                gr.m4773W("Image type not recognized:");
                return;
            }
            gr.m4773W("Invalid image url:" + str);
        }
    }
}
