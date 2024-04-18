package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dh {
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;
    private String re;
    private long rf;
    private long rg;
    private String rh;
    private String ri;

    /* renamed from: com.google.android.gms.internal.dh.1 */
    class C10831 implements OnClickListener {
        final /* synthetic */ dh rj;

        C10831(dh dhVar) {
            this.rj = dhVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.rj.mContext.startActivity(this.rj.createIntent());
        }
    }

    /* renamed from: com.google.android.gms.internal.dh.2 */
    class C10842 implements OnClickListener {
        final /* synthetic */ dh rj;

        C10842(dh dhVar) {
            this.rj = dhVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.rj.mo.m4789b("onCalendarEventCanceled", new JSONObject());
        }
    }

    public dh(gu guVar, Map<String, String> map) {
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
        bQ();
    }

    private String m4421A(String str) {
        return TextUtils.isEmpty((CharSequence) this.rd.get(str)) ? "" : (String) this.rd.get(str);
    }

    private void bQ() {
        this.re = m4421A(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.rh = m4421A("summary");
        this.rf = gi.m4718O((String) this.rd.get("start"));
        this.rg = gi.m4718O((String) this.rd.get("end"));
        this.ri = m4421A("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.rh);
        data.putExtra("eventLocation", this.ri);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.re);
        data.putExtra("beginTime", this.rf);
        data.putExtra("endTime", this.rg);
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (new bl(this.mContext).bt()) {
            Builder builder = new Builder(this.mContext);
            builder.setTitle(ga.m4689c(C0366R.string.create_calendar_title, "Create calendar event"));
            builder.setMessage(ga.m4689c(C0366R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(ga.m4689c(C0366R.string.accept, "Accept"), new C10831(this));
            builder.setNegativeButton(ga.m4689c(C0366R.string.decline, "Decline"), new C10842(this));
            builder.create().show();
            return;
        }
        gr.m4773W("This feature is not available on this version of the device.");
    }
}
