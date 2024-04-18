package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dj extends dg {
    private static final String ID;
    private static final String aul;
    private static final String aum;
    private static final String aun;
    private static final String auo;
    private static final String aup;
    private static final String auq;
    private static final String aur;
    private static final String aus;
    private static final String aut;
    private static final List<String> auu;
    private static final Pattern auv;
    private static final Pattern auw;
    private static Map<String, String> aux;
    private static Map<String, String> auy;
    private final DataLayer aqn;
    private final df auA;
    private final Set<String> auz;

    static {
        ID = C0997a.UNIVERSAL_ANALYTICS.toString();
        aul = C1022b.ACCOUNT.toString();
        aum = C1022b.ANALYTICS_PASS_THROUGH.toString();
        aun = C1022b.ENABLE_ECOMMERCE.toString();
        auo = C1022b.ECOMMERCE_USE_DATA_LAYER.toString();
        aup = C1022b.ECOMMERCE_MACRO_DATA.toString();
        auq = C1022b.ANALYTICS_FIELDS.toString();
        aur = C1022b.TRACK_TRANSACTION.toString();
        aus = C1022b.TRANSACTION_DATALAYER_MAP.toString();
        aut = C1022b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
        auu = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, Promotion.ACTION_CLICK, ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
        auv = Pattern.compile("dimension(\\d+)");
        auw = Pattern.compile("metric(\\d+)");
    }

    public dj(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new df(context));
    }

    dj(Context context, DataLayer dataLayer, df dfVar) {
        super(ID, new String[0]);
        this.aqn = dataLayer;
        this.auA = dfVar;
        this.auz = new HashSet();
        this.auz.add("");
        this.auz.add("0");
        this.auz.add("false");
    }

    private Promotion m6622L(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = (String) map.get("id");
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        str = (String) map.get("name");
        if (str != null) {
            promotion.setName(String.valueOf(str));
        }
        str = (String) map.get("creative");
        if (str != null) {
            promotion.setCreative(String.valueOf(str));
        }
        str = (String) map.get("position");
        if (str != null) {
            promotion.setPosition(String.valueOf(str));
        }
        return promotion;
    }

    private Product m6623M(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null) {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null) {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null) {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null) {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null) {
            product.setPosition(m6634z(obj).intValue());
        }
        obj = map.get("price");
        if (obj != null) {
            product.setPrice(m6633y(obj).doubleValue());
        }
        obj = map.get("quantity");
        if (obj != null) {
            product.setQuantity(m6634z(obj).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = auv.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException e) {
                    bh.m6461W("illegal number in custom dimension value: " + str);
                }
            } else {
                matcher = auw.matcher(str);
                if (matcher.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher.group(1)), m6634z(map.get(str)).intValue());
                    } catch (NumberFormatException e2) {
                        bh.m6461W("illegal number in custom metric value: " + str);
                    }
                }
            }
        }
        return product;
    }

    private Map<String, String> m6624N(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(aus);
        if (c1070a != null) {
            return m6630c(c1070a);
        }
        if (aux == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            aux = hashMap;
        }
        return aux;
    }

    private Map<String, String> m6625O(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(aut);
        if (c1070a != null) {
            return m6630c(c1070a);
        }
        if (auy == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            auy = hashMap;
        }
        return auy;
    }

    private void m6626a(Tracker tracker, Map<String, C1070a> map) {
        String de = de("transactionId");
        if (de == null) {
            bh.m6458T("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = m6632p((C1070a) map.get(auq));
            p.put("&t", "transaction");
            for (Entry entry : m6624N(map).entrySet()) {
                m6628b(p, (String) entry.getValue(), de((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> df = df("transactionProducts");
            if (df != null) {
                for (Map p2 : df) {
                    if (p2.get("name") == null) {
                        bh.m6458T("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p3 = m6632p((C1070a) map.get(auq));
                    p3.put("&t", "item");
                    p3.put("&ti", de);
                    for (Entry entry2 : m6625O(map).entrySet()) {
                        m6628b(p3, (String) entry2.getValue(), (String) p2.get(entry2.getKey()));
                    }
                    linkedList.add(p3);
                }
            }
            for (Map send : linkedList) {
                tracker.send(send);
            }
        } catch (Throwable e) {
            bh.m6462b("Unable to send transaction", e);
        }
    }

    private void m6627b(Tracker tracker, Map<String, C1070a> map) {
        Object obj;
        Map map2;
        ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
        Map p = m6632p((C1070a) map.get(auq));
        screenViewBuilder.setAll(p);
        if (m6631f(map, auo)) {
            obj = this.aqn.get("ecommerce");
            map2 = obj instanceof Map ? (Map) obj : null;
        } else {
            obj = di.m6612o((C1070a) map.get(aup));
            map2 = obj instanceof Map ? (Map) obj : null;
        }
        if (map2 != null) {
            Map map3;
            List<Map> list;
            String str = (String) p.get("&cu");
            if (str == null) {
                str = (String) map2.get("currencyCode");
            }
            if (str != null) {
                screenViewBuilder.set("&cu", str);
            }
            obj = map2.get("impressions");
            if (obj instanceof List) {
                for (Map map4 : (List) obj) {
                    try {
                        screenViewBuilder.addImpression(m6623M(map4), (String) map4.get("list"));
                    } catch (RuntimeException e) {
                        bh.m6458T("Failed to extract a product from DataLayer. " + e.getMessage());
                    }
                }
            }
            List list2 = map2.containsKey("promoClick") ? (List) ((Map) map2.get("promoClick")).get("promotions") : map2.containsKey("promoView") ? (List) ((Map) map2.get("promoView")).get("promotions") : null;
            if (r0 != null) {
                for (Map map42 : r0) {
                    try {
                        screenViewBuilder.addPromotion(m6622L(map42));
                    } catch (RuntimeException e2) {
                        bh.m6458T("Failed to extract a promotion from DataLayer. " + e2.getMessage());
                    }
                }
                if (map2.containsKey("promoClick")) {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_CLICK);
                    obj = null;
                    if (obj != null) {
                        for (String str2 : auu) {
                            if (map2.containsKey(str2)) {
                                map3 = (Map) map2.get(str2);
                                list = (List) map3.get("products");
                                if (list != null) {
                                    for (Map map22 : list) {
                                        try {
                                            screenViewBuilder.addProduct(m6623M(map22));
                                        } catch (RuntimeException e3) {
                                            bh.m6458T("Failed to extract a product from DataLayer. " + e3.getMessage());
                                        }
                                    }
                                }
                                try {
                                    screenViewBuilder.setProductAction(map3.containsKey("actionField") ? m6629c(str2, (Map) map3.get("actionField")) : new ProductAction(str2));
                                } catch (RuntimeException e22) {
                                    bh.m6458T("Failed to extract a product action from DataLayer. " + e22.getMessage());
                                }
                            }
                        }
                    }
                } else {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                }
            }
            int i = 1;
            if (obj != null) {
                for (String str22 : auu) {
                    if (map22.containsKey(str22)) {
                        map3 = (Map) map22.get(str22);
                        list = (List) map3.get("products");
                        if (list != null) {
                            while (r4.hasNext()) {
                                screenViewBuilder.addProduct(m6623M(map22));
                            }
                        }
                        if (map3.containsKey("actionField")) {
                        }
                        screenViewBuilder.setProductAction(map3.containsKey("actionField") ? m6629c(str22, (Map) map3.get("actionField")) : new ProductAction(str22));
                    }
                }
            }
        }
        tracker.send(screenViewBuilder.build());
    }

    private void m6628b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private ProductAction m6629c(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get("id");
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null) {
            productAction.setProductActionList(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null) {
            productAction.setCheckoutOptions(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null) {
            productAction.setTransactionRevenue(m6633y(obj).doubleValue());
        }
        obj = map.get("tax");
        if (obj != null) {
            productAction.setTransactionTax(m6633y(obj).doubleValue());
        }
        obj = map.get("shipping");
        if (obj != null) {
            productAction.setTransactionShipping(m6633y(obj).doubleValue());
        }
        obj = map.get("step");
        if (obj != null) {
            productAction.setCheckoutStep(m6634z(obj).intValue());
        }
        return productAction;
    }

    private Map<String, String> m6630c(C1070a c1070a) {
        Object o = di.m6612o(c1070a);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private String de(String str) {
        Object obj = this.aqn.get(str);
        return obj == null ? null : obj.toString();
    }

    private List<Map<String, String>> df(String str) {
        Object obj = this.aqn.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private boolean m6631f(Map<String, C1070a> map, String str) {
        C1070a c1070a = (C1070a) map.get(str);
        return c1070a == null ? false : di.m6611n(c1070a).booleanValue();
    }

    private Map<String, String> m6632p(C1070a c1070a) {
        if (c1070a == null) {
            return new HashMap();
        }
        Map<String, String> c = m6630c(c1070a);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.auz.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    private Double m6633y(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Double: " + e.getMessage());
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            throw new RuntimeException("Cannot convert the object to Double: " + obj.toString());
        }
    }

    private Integer m6634z(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Integer: " + e.getMessage());
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            throw new RuntimeException("Cannot convert the object to Integer: " + obj.toString());
        }
    }

    public void m6635D(Map<String, C1070a> map) {
        Tracker cW = this.auA.cW("_GTM_DEFAULT_TRACKER_");
        cW.enableAdvertisingIdCollection(m6631f(map, "collect_adid"));
        if (m6631f(map, aun)) {
            m6627b(cW, map);
        } else if (m6631f(map, aum)) {
            cW.send(m6632p((C1070a) map.get(auq)));
        } else if (m6631f(map, aur)) {
            m6626a(cW, map);
        } else {
            bh.m6461W("Ignoring unknown tag.");
        }
    }
}
