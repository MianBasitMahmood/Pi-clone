package com.chartboost.sdk.impl;

import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.MessageApi;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class aa implements C0181z {
    private final C0180a f317a;
    private final SSLSocketFactory f318b;

    /* renamed from: com.chartboost.sdk.impl.aa.a */
    public interface C0180a {
        String m525a(String str);
    }

    public aa() {
        this(null);
    }

    public aa(C0180a c0180a) {
        this(c0180a, null);
    }

    public aa(C0180a c0180a, SSLSocketFactory sSLSocketFactory) {
        this.f317a = c0180a;
        this.f318b = sSLSocketFactory;
    }

    public HttpResponse m532a(C0182l<?> c0182l, Map<String, String> map) throws IOException, C0179a {
        String a;
        String d = c0182l.m551d();
        HashMap hashMap = new HashMap();
        hashMap.putAll(c0182l.m556i());
        hashMap.putAll(map);
        if (this.f317a != null) {
            a = this.f317a.m525a(d);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + d);
            }
        }
        a = d;
        HttpURLConnection a2 = m527a(new URL(a), (C0182l) c0182l);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        m529a(a2, (C0182l) c0182l);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(m528a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }

    private static HttpEntity m528a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    protected HttpURLConnection m531a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection m527a(URL url, C0182l<?> c0182l) throws IOException {
        HttpURLConnection a = m531a(url);
        int t = c0182l.m567t();
        a.setConnectTimeout(t);
        a.setReadTimeout(t);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f318b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f318b);
        }
        return a;
    }

    static void m529a(HttpURLConnection httpURLConnection, C0182l<?> c0182l) throws IOException, C0179a {
        switch (c0182l.m536a()) {
            case MessageApi.UNKNOWN_REQUEST_ID /*-1*/:
                byte[] m = c0182l.m560m();
                if (m != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", c0182l.m559l());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(m);
                    dataOutputStream.close();
                }
            case WalletFragmentState.UNKNOWN /*0*/:
                httpURLConnection.setRequestMethod("GET");
            case DataEvent.TYPE_CHANGED /*1*/:
                httpURLConnection.setRequestMethod("POST");
                m530b(httpURLConnection, c0182l);
            case DataEvent.TYPE_DELETED /*2*/:
                httpURLConnection.setRequestMethod("PUT");
                m530b(httpURLConnection, c0182l);
            case WalletFragmentState.PROCESSING /*3*/:
                httpURLConnection.setRequestMethod("DELETE");
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                httpURLConnection.setRequestMethod("HEAD");
            case Dimension.UNIT_MM /*5*/:
                httpURLConnection.setRequestMethod("OPTIONS");
            case Error.OTHER /*6*/:
                httpURLConnection.setRequestMethod("TRACE");
            case Error.AVS_DECLINE /*7*/:
                httpURLConnection.setRequestMethod("PATCH");
                m530b(httpURLConnection, c0182l);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m530b(HttpURLConnection httpURLConnection, C0182l<?> c0182l) throws IOException, C0179a {
        byte[] q = c0182l.m564q();
        if (q != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", c0182l.m563p());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(q);
            dataOutputStream.close();
        }
    }
}
