package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cz {

    /* renamed from: com.google.android.gms.tagmanager.cz.1 */
    static class C17981 implements Runnable {
        final /* synthetic */ Editor atL;

        C17981(Editor editor) {
            this.atL = editor;
        }

        public final void run() {
            this.atL.commit();
        }
    }

    static void m6590a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m6591a(edit);
    }

    static void m6591a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C17981(editor)).start();
        }
    }
}
