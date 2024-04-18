package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

/* renamed from: com.google.android.gms.analytics.h */
public class C0397h implements C0396r {
    private final Context mContext;
    private final String wl;
    private final HttpClient yf;
    private URL yg;
    private int yh;
    private int yi;
    private int yj;
    private String yk;
    private String yl;
    private C0398i ym;
    private C0403l yn;
    private Set<Integer> yo;
    private boolean yp;
    private long yq;
    private long yr;
    private C0399o ys;
    private volatile boolean yt;

    /* renamed from: com.google.android.gms.analytics.h.1 */
    static /* synthetic */ class C03951 {
        static final /* synthetic */ int[] yu;
        static final /* synthetic */ int[] yv;

        static {
            yv = new int[C0398i.values().length];
            try {
                yv[C0398i.BATCH_BY_COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yv[C0398i.BATCH_BY_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yv[C0398i.BATCH_BY_SESSION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yv[C0398i.BATCH_BY_SIZE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                yv[C0398i.BATCH_BY_BRUTE_FORCE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            yu = new int[C0403l.values().length];
            try {
                yu[C0403l.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                yu[C0403l.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    C0397h(HttpClient httpClient, Context context, C0399o c0399o) {
        this.yo = new HashSet();
        this.yp = false;
        this.yt = false;
        this.mContext = context.getApplicationContext();
        this.ys = c0399o;
        this.wl = m1548a("GoogleAnalytics", "4.0", VERSION.RELEASE, an.m1523a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.yf = httpClient;
    }

    private String m1540a(ab abVar, List<String> list, C0398i c0398i) {
        if (c0398i == C0398i.NONE) {
            CharSequence fa = (abVar.fa() == null || abVar.fa().length() == 0) ? "" : abVar.fa();
            return TextUtils.isEmpty(fa) ? "" : ac.m1483a(abVar, System.currentTimeMillis());
        } else {
            String str = "";
            for (String str2 : list) {
                if (str2.length() != 0) {
                    if (str.length() != 0) {
                        str = str + "\n";
                    }
                    str = str + str2;
                }
            }
            return str;
        }
    }

    private URL m1541a(ab abVar) {
        if (this.yg != null) {
            return this.yg;
        }
        try {
            return new URL("http:".equals(abVar.fd()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            ae.m1485T("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    private void m1542a(af afVar, HttpHost httpHost, C0398i c0398i, C0403l c0403l) {
        afVar.m1490g("_bs", c0398i.toString());
        afVar.m1490g("_cs", c0403l.toString());
        Object fg = afVar.fg();
        if (!TextUtils.isEmpty(fg)) {
            HttpHost httpHost2;
            if (httpHost == null) {
                try {
                    URL url = new URL("https://ssl.google-analytics.com");
                    httpHost2 = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                } catch (MalformedURLException e) {
                    return;
                }
            }
            httpHost2 = httpHost;
            m1544a(fg, httpHost2, 1, afVar, C0403l.NONE);
        }
    }

    private void m1543a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                ae.m1488W("Error Writing hit to log...");
            }
        }
        ae.m1486U(stringBuffer.toString());
    }

    private boolean m1544a(String str, HttpHost httpHost, int i, af afVar, C0403l c0403l) {
        boolean z = i > 1;
        if (str.getBytes().length > this.yj || str.getBytes().length > this.yi) {
            ae.m1488W("Request too long (> " + Math.min(this.yi, this.yj) + " bytes)--not sent");
            return true;
        } else if (this.yt) {
            ae.m1486U("Dry run enabled. Hit not actually sent.");
            return true;
        } else {
            HttpEntityEnclosingRequest d = m1545d(str, z);
            if (d == null) {
                return true;
            }
            int length;
            int length2;
            if (d.getRequestLine().getMethod().equals("GET")) {
                length = str.getBytes().length;
                length2 = str.getBytes().length;
            } else {
                try {
                    switch (C03951.yu[c0403l.ordinal()]) {
                        case DataEvent.TYPE_CHANGED /*1*/:
                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str.getBytes());
                            gZIPOutputStream.close();
                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                            length2 = toByteArray.length + 0;
                            d.setEntity(new ByteArrayEntity(toByteArray));
                            d.addHeader("Content-Encoding", "gzip");
                            break;
                        default:
                            length2 = str.getBytes().length;
                            d.setEntity(new StringEntity(str));
                            break;
                    }
                    length = str.getBytes().length;
                } catch (UnsupportedEncodingException e) {
                    ae.m1485T("Encoding error, hit will be discarded");
                    return true;
                } catch (IOException e2) {
                    ae.m1485T("Unexpected IOException: " + e2.getMessage());
                    ae.m1485T("Request will be discarded");
                    return true;
                }
            }
            d.addHeader("Host", httpHost.toHostString());
            if (ae.ff()) {
                m1543a(d);
            }
            try {
                HttpResponse execute = this.yf.execute(httpHost, d);
                afVar.m1489e("_td", length);
                afVar.m1489e("_cd", length2);
                length2 = execute.getStatusLine().getStatusCode();
                HttpEntity entity = execute.getEntity();
                if (entity != null) {
                    entity.consumeContent();
                }
                if (length2 == 200) {
                    return true;
                }
                if (z && this.yo.contains(Integer.valueOf(length2))) {
                    ae.m1486U("Falling back to single hit per request mode.");
                    this.yp = true;
                    this.yq = System.currentTimeMillis();
                    return false;
                }
                ae.m1488W("Bad response: " + execute.getStatusLine().getStatusCode());
                return true;
            } catch (ClientProtocolException e3) {
                ae.m1488W("ClientProtocolException sending hit; discarding hit...");
                return true;
            } catch (IOException e22) {
                ae.m1488W("Exception sending hit: " + e22.getClass().getSimpleName());
                ae.m1488W(e22.getMessage());
                return false;
            }
        }
    }

    private HttpEntityEnclosingRequest m1545d(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            System.out.println("Empty hit, discarding.");
            return null;
        }
        String str2 = this.yk + "?" + str;
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest = (str2.length() >= this.yh || z) ? z ? new BasicHttpEntityEnclosingRequest("POST", this.yl) : new BasicHttpEntityEnclosingRequest("POST", this.yk) : new BasicHttpEntityEnclosingRequest("GET", str2);
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.wl);
        return basicHttpEntityEnclosingRequest;
    }

    int m1546a(List<ab> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        if (i > list.size()) {
            i = list.size();
        }
        int i2 = i - 1;
        long j = 0;
        int i3 = i;
        while (i2 > 0) {
            int i4;
            ab abVar = (ab) list.get(i2);
            long fc = ((ab) list.get(i2 - 1)).fc();
            long fc2 = abVar.fc();
            if (fc == 0 || fc2 == 0 || fc2 - fc <= j) {
                fc2 = j;
                i4 = i3;
            } else {
                fc2 -= fc;
                i4 = i2;
            }
            i2--;
            i3 = i4;
            j = fc2;
        }
        return i3;
    }

    public int m1547a(List<ab> list, af afVar, boolean z) {
        C0403l c0403l;
        C0398i c0398i;
        long j;
        ab abVar;
        int i;
        int i2;
        String str;
        List subList;
        HttpHost httpHost;
        int i3;
        URL a;
        int max;
        this.yh = this.ys.eb();
        this.yi = this.ys.ec();
        this.yj = this.ys.ed();
        int ee = this.ys.ee();
        this.yk = this.ys.eg();
        this.yl = this.ys.eh();
        this.ym = this.ys.ei();
        this.yn = this.ys.ej();
        this.yo.clear();
        this.yo.addAll(this.ys.ek());
        this.yr = this.ys.ef();
        if (!this.yp && this.yo.isEmpty()) {
            this.yp = true;
            this.yq = System.currentTimeMillis();
        }
        if (this.yp && System.currentTimeMillis() - this.yq > 1000 * this.yr) {
            this.yp = false;
        }
        C0398i c0398i2;
        if (this.yp) {
            c0398i2 = C0398i.NONE;
            c0403l = C0403l.NONE;
            c0398i = c0398i2;
        } else {
            c0398i2 = this.ym;
            c0403l = this.yn;
            c0398i = c0398i2;
        }
        int i4 = 0;
        int min = Math.min(list.size(), ee);
        afVar.m1489e("_hr", list.size());
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (c0398i != C0398i.NONE) {
            j = 0;
            ee = 0;
            for (ab abVar2 : list) {
                Object a2 = TextUtils.isEmpty(abVar2.fa()) ? "" : ac.m1483a(abVar2, currentTimeMillis);
                if (a2.getBytes().length > this.yi) {
                    a2 = "";
                }
                arrayList.add(a2);
                if (!TextUtils.isEmpty(a2)) {
                    j += (long) ((ee == 0 ? 0 : 1) + a2.getBytes().length);
                }
                arrayList2.add(Long.valueOf(j));
                i = j <= ((long) this.yj) ? ee + 1 : ee;
                if (i == min) {
                    ee = i;
                    i2 = 1;
                    break;
                }
                ee = i;
            }
            i2 = 1;
        } else {
            i2 = min;
            j = 0;
            ee = 0;
        }
        while (ee > 1 && ((Long) arrayList2.get(ee - 1)).longValue() > ((long) this.yj)) {
            ee--;
        }
        if (j > ((long) this.yj)) {
            switch (C03951.yv[c0398i.ordinal()]) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = arrayList.size() / 2;
                    if (ee <= i) {
                        i = ee;
                        break;
                    }
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = m1546a(list, ee);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = m1549b(list, ee);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    if (j >= ((long) (this.yj * 2))) {
                        i = ee;
                        break;
                    }
                    ee = arrayList2.size() - 1;
                    while (ee > 0 && ((Long) arrayList2.get(ee)).longValue() > j / 2) {
                        ee--;
                    }
                    i = ee;
                    break;
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = ee;
                    break;
                default:
                    ae.m1488W("Unexpected batching strategy encountered; sending a single hit.");
                    str = (String) arrayList.get(0);
                    arrayList.clear();
                    arrayList.add(str);
                    i = 1;
                    break;
            }
            if (i < arrayList.size()) {
                subList = arrayList.subList(0, i);
                min = 0;
                httpHost = null;
                i3 = 0;
                while (i3 < i2) {
                    abVar2 = (ab) list.get(i3);
                    a = m1541a(abVar2);
                    max = Math.max(1, r9.size());
                    if (a != null) {
                        ae.m1488W("No destination: discarding hit.");
                        ee = min + max;
                        i = i4 + max;
                    } else {
                        httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                        if (m1544a(m1540a(abVar2, (List) r9, c0398i), httpHost, max, afVar, c0403l)) {
                            afVar.m1489e("_de", 1);
                            afVar.m1489e("_hd", min);
                            afVar.m1489e("_hs", i4);
                            m1542a(afVar, httpHost, c0398i, c0403l);
                            return i4;
                        }
                        ee = min;
                        for (String str2 : r9) {
                            ee = TextUtils.isEmpty(str2) ? ee + 1 : ee;
                        }
                        afVar.m1489e("_rs", 1);
                        i = i4 + max;
                    }
                    i3++;
                    min = ee;
                    i4 = i;
                }
                afVar.m1489e("_hd", min);
                afVar.m1489e("_hs", i4);
                if (z) {
                    m1542a(afVar, httpHost, c0398i, c0403l);
                }
                return i4;
            }
        }
        subList = arrayList;
        min = 0;
        httpHost = null;
        i3 = 0;
        while (i3 < i2) {
            abVar2 = (ab) list.get(i3);
            a = m1541a(abVar2);
            max = Math.max(1, r9.size());
            if (a != null) {
                httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                if (m1544a(m1540a(abVar2, (List) r9, c0398i), httpHost, max, afVar, c0403l)) {
                    ee = min;
                    while (r6.hasNext()) {
                        if (TextUtils.isEmpty(str2)) {
                        }
                        ee = TextUtils.isEmpty(str2) ? ee + 1 : ee;
                    }
                    afVar.m1489e("_rs", 1);
                    i = i4 + max;
                } else {
                    afVar.m1489e("_de", 1);
                    afVar.m1489e("_hd", min);
                    afVar.m1489e("_hs", i4);
                    m1542a(afVar, httpHost, c0398i, c0403l);
                    return i4;
                }
            }
            ae.m1488W("No destination: discarding hit.");
            ee = min + max;
            i = i4 + max;
            i3++;
            min = ee;
            i4 = i;
        }
        afVar.m1489e("_hd", min);
        afVar.m1489e("_hs", i4);
        if (z) {
            m1542a(afVar, httpHost, c0398i, c0403l);
        }
        return i4;
    }

    String m1548a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public void ad(String str) {
        try {
            this.yg = new URL(str);
        } catch (MalformedURLException e) {
            this.yg = null;
        }
    }

    int m1549b(List<ab> list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        for (int i2 = i - 1; i2 > 0; i2--) {
            String fa = ((ab) list.get(i2)).fa();
            if (!TextUtils.isEmpty(fa)) {
                if (fa.contains("sc=start")) {
                    return i2;
                }
                if (fa.contains("sc=end")) {
                    return i2 + 1;
                }
            }
        }
        return i;
    }

    public boolean ea() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        ae.m1487V("...no network connectivity");
        return false;
    }

    public void setDryRun(boolean z) {
        this.yt = z;
    }
}
