package com.chartboost.sdk.impl;

public class by {
    public static String m1160a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        m1161a(obj, stringBuilder);
        return stringBuilder.toString();
    }

    public static void m1161a(Object obj, StringBuilder stringBuilder) {
        bz.m1180a().m1157a(obj, stringBuilder);
    }

    static void m1162a(StringBuilder stringBuilder, String str) {
        stringBuilder.append("\"");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                stringBuilder.append("\\\\");
            } else if (charAt == '\"') {
                stringBuilder.append("\\\"");
            } else if (charAt == '\n') {
                stringBuilder.append("\\n");
            } else if (charAt == '\r') {
                stringBuilder.append("\\r");
            } else if (charAt == '\t') {
                stringBuilder.append("\\t");
            } else if (charAt == '\b') {
                stringBuilder.append("\\b");
            } else if (charAt >= ' ') {
                stringBuilder.append(charAt);
            }
        }
        stringBuilder.append("\"");
    }
}
