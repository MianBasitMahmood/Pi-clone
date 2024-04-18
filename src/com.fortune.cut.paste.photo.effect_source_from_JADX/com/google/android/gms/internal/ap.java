package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.as.C1020a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class ap {
    private final int nT;
    private final int nU;
    private final ao nV;
    private Base64OutputStream nW;
    private ByteArrayOutputStream nX;

    /* renamed from: com.google.android.gms.internal.ap.1 */
    class C10181 implements Comparator<String> {
        final /* synthetic */ ap nY;

        C10181(ap apVar) {
            this.nY = apVar;
        }

        public int compare(String str, String str2) {
            return str2.length() - str.length();
        }
    }

    /* renamed from: com.google.android.gms.internal.ap.2 */
    class C10192 implements Comparator<C1020a> {
        final /* synthetic */ ap nY;

        C10192(ap apVar) {
            this.nY = apVar;
        }

        public int m4173a(C1020a c1020a, C1020a c1020a2) {
            return (int) (c1020a.value - c1020a2.value);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4173a((C1020a) obj, (C1020a) obj2);
        }
    }

    public ap(int i) {
        this.nV = new ar();
        this.nU = i;
        this.nT = 6;
    }

    private String m4174m(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.nX = new ByteArrayOutputStream();
        this.nW = new Base64OutputStream(this.nX, 10);
        Arrays.sort(split, new C10181(this));
        int i = 0;
        while (i < split.length && i < this.nU) {
            if (split[i].trim().length() != 0) {
                try {
                    this.nW.write(this.nV.m4172l(split[i]));
                } catch (Throwable e) {
                    gr.m4775b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        try {
            this.nW.flush();
            this.nW.close();
            return this.nX.toString();
        } catch (Throwable e2) {
            gr.m4775b("HashManager: Unable to convert to base 64", e2);
            return "";
        }
    }

    public String m4175a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return m4176n(stringBuffer.toString());
    }

    String m4176n(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.nX = new ByteArrayOutputStream();
        this.nW = new Base64OutputStream(this.nX, 10);
        PriorityQueue priorityQueue = new PriorityQueue(this.nU, new C10192(this));
        for (String p : split) {
            String[] p2 = aq.m4180p(p);
            if (p2.length >= this.nT) {
                as.m4188a(p2, this.nU, this.nT, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                this.nW.write(this.nV.m4172l(((C1020a) it.next()).oa));
            } catch (Throwable e) {
                gr.m4775b("Error while writing hash to byteStream", e);
            }
        }
        try {
            this.nW.flush();
            this.nW.close();
            return this.nX.toString();
        } catch (Throwable e2) {
            gr.m4775b("HashManager: unable to convert to base 64", e2);
            return "";
        }
    }
}
