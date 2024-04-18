package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.n */
abstract class C0386n<T extends C0381m> {
    Context mContext;
    C0384a<T> yL;

    /* renamed from: com.google.android.gms.analytics.n.a */
    public interface C0384a<U extends C0381m> {
        void m1510c(String str, int i);

        void m1511e(String str, String str2);

        void m1512e(String str, boolean z);

        U er();

        void m1513f(String str, String str2);
    }

    public C0386n(Context context, C0384a<T> c0384a) {
        this.mContext = context;
        this.yL = c0384a;
    }

    private T m1518a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.yL.m1511e(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.yL.m1513f(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.yL.m1512e(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                ae.m1485T("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.yL.m1510c(r0, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                ae.m1485T("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            ae.m1485T("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            ae.m1485T("Error parsing tracker configuration file: " + e4);
        }
        return this.yL.er();
    }

    public T m1519x(int i) {
        try {
            return m1518a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            ae.m1488W("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
