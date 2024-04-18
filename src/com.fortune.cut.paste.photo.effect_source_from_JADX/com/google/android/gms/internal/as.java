package com.google.android.gms.internal;

import java.util.PriorityQueue;

public class as {

    /* renamed from: com.google.android.gms.internal.as.a */
    public static class C1020a {
        final String oa;
        final long value;

        C1020a(long j, String str) {
            this.value = j;
            this.oa = str;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof C1020a) && ((C1020a) obj).value == this.value;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    static long m4184a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long m4185a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? m4185a((j * j) % 1073807359, i / 2) % 1073807359 : ((m4185a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String m4186a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            gr.m4770T("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void m4187a(int i, long j, String str, PriorityQueue<C1020a> priorityQueue) {
        C1020a c1020a = new C1020a(j, str);
        if ((priorityQueue.size() != i || ((C1020a) priorityQueue.peek()).value <= c1020a.value) && !priorityQueue.contains(c1020a)) {
            priorityQueue.add(c1020a);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void m4188a(String[] strArr, int i, int i2, PriorityQueue<C1020a> priorityQueue) {
        long b = m4189b(strArr, 0, i2);
        m4187a(i, b, m4186a(strArr, 0, i2), (PriorityQueue) priorityQueue);
        long a = m4185a(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            b = m4184a(aq.m4179o(strArr[i3 - 1]), aq.m4179o(strArr[(i3 + i2) - 1]), b, a, 16785407);
            m4187a(i, b, m4186a(strArr, i3, i2), (PriorityQueue) priorityQueue);
        }
    }

    private static long m4189b(String[] strArr, int i, int i2) {
        long o = (((long) aq.m4179o(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            o = (((o * 16785407) % 1073807359) + ((((long) aq.m4179o(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return o;
    }
}
