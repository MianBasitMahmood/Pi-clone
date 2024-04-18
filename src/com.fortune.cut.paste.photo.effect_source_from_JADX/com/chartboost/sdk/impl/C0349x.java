package com.chartboost.sdk.impl;

import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.chartboost.sdk.impl.x */
public class C0349x implements C0181z {
    protected final HttpClient f971a;

    /* renamed from: com.chartboost.sdk.impl.x.a */
    public static final class C0348a extends HttpEntityEnclosingRequestBase {
        public C0348a(String str) {
            setURI(URI.create(str));
        }

        public final String getMethod() {
            return "PATCH";
        }
    }

    public C0349x(HttpClient httpClient) {
        this.f971a = httpClient;
    }

    private static void m1406a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    public HttpResponse m1408a(C0182l<?> c0182l, Map<String, String> map) throws IOException, C0179a {
        HttpUriRequest b = C0349x.m1407b(c0182l, map);
        C0349x.m1406a(b, (Map) map);
        C0349x.m1406a(b, c0182l.m556i());
        m1409a(b);
        HttpParams params = b.getParams();
        int t = c0182l.m567t();
        HttpConnectionParams.setConnectionTimeout(params, FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
        HttpConnectionParams.setSoTimeout(params, t);
        return this.f971a.execute(b);
    }

    static HttpUriRequest m1407b(C0182l<?> c0182l, Map<String, String> map) throws C0179a {
        HttpEntityEnclosingRequestBase httpPost;
        switch (c0182l.m536a()) {
            case MessageApi.UNKNOWN_REQUEST_ID /*-1*/:
                byte[] m = c0182l.m560m();
                if (m == null) {
                    return new HttpGet(c0182l.m551d());
                }
                HttpUriRequest httpPost2 = new HttpPost(c0182l.m551d());
                httpPost2.addHeader("Content-Type", c0182l.m559l());
                httpPost2.setEntity(new ByteArrayEntity(m));
                return httpPost2;
            case WalletFragmentState.UNKNOWN /*0*/:
                return new HttpGet(c0182l.m551d());
            case DataEvent.TYPE_CHANGED /*1*/:
                httpPost = new HttpPost(c0182l.m551d());
                httpPost.addHeader("Content-Type", c0182l.m563p());
                C0349x.m1405a(httpPost, (C0182l) c0182l);
                return httpPost;
            case DataEvent.TYPE_DELETED /*2*/:
                httpPost = new HttpPut(c0182l.m551d());
                httpPost.addHeader("Content-Type", c0182l.m563p());
                C0349x.m1405a(httpPost, (C0182l) c0182l);
                return httpPost;
            case WalletFragmentState.PROCESSING /*3*/:
                return new HttpDelete(c0182l.m551d());
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return new HttpHead(c0182l.m551d());
            case Dimension.UNIT_MM /*5*/:
                return new HttpOptions(c0182l.m551d());
            case Error.OTHER /*6*/:
                return new HttpTrace(c0182l.m551d());
            case Error.AVS_DECLINE /*7*/:
                httpPost = new C0348a(c0182l.m551d());
                httpPost.addHeader("Content-Type", c0182l.m563p());
                C0349x.m1405a(httpPost, (C0182l) c0182l);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void m1405a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, C0182l<?> c0182l) throws C0179a {
        byte[] q = c0182l.m564q();
        if (q != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(q));
        }
    }

    protected void m1409a(HttpUriRequest httpUriRequest) throws IOException {
    }
}
