package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

public class aq {
    private static boolean m4177a(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || unicodeBlock == UnicodeBlock.CJK_RADICALS_SUPPLEMENT || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_FORMS || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == UnicodeBlock.BOPOMOFO || unicodeBlock == UnicodeBlock.HIRAGANA || unicodeBlock == UnicodeBlock.KATAKANA || unicodeBlock == UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == UnicodeBlock.HANGUL_JAMO;
    }

    static boolean m4178d(int i) {
        return Character.isLetter(i) && m4177a(UnicodeBlock.of(i));
    }

    public static int m4179o(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return lk.m5334a(bytes, 0, bytes.length, 0);
    }

    public static String[] m4180p(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] toCharArray = str.toCharArray();
        int length = str.length();
        Object obj = null;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            Object obj2;
            Object obj3;
            int codePointAt = Character.codePointAt(toCharArray, i2);
            int charCount = Character.charCount(codePointAt);
            if (m4178d(codePointAt)) {
                if (obj != null) {
                    arrayList.add(new String(toCharArray, i, i2 - i));
                }
                arrayList.add(new String(toCharArray, i2, charCount));
                i3 = i;
                obj2 = null;
            } else if (Character.isLetterOrDigit(codePointAt)) {
                if (obj == null) {
                    i = i2;
                }
                i3 = i;
                i = 1;
            } else if (obj != null) {
                arrayList.add(new String(toCharArray, i, i2 - i));
                i3 = i;
                obj2 = null;
            } else {
                obj3 = obj;
                i3 = i;
                obj2 = obj3;
            }
            i2 += charCount;
            obj3 = obj2;
            i = i3;
            obj = obj3;
        }
        if (obj != null) {
            arrayList.add(new String(toCharArray, i, i2 - i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
