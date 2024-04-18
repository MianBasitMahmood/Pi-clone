package com.chartboost.sdk.impl;

class bx extends bw {
    private dd<cb> f793a;

    bx() {
        this.f793a = new dd();
    }

    void m1158a(Class cls, cb cbVar) {
        this.f793a.m1333a(cls, cbVar);
    }

    public void m1159a(Object obj, StringBuilder stringBuilder) {
        Object a = cg.m1152a(obj);
        if (a == null) {
            stringBuilder.append(" null ");
            return;
        }
        cb cbVar = null;
        for (Object a2 : dd.m1330a(a.getClass())) {
            cbVar = (cb) this.f793a.m1334a(a2);
            if (cbVar != null) {
                break;
            }
        }
        if (cbVar == null && a.getClass().isArray()) {
            cbVar = (cb) this.f793a.m1334a((Object) Object[].class);
        }
        if (cbVar == null) {
            throw new RuntimeException("json can't serialize type : " + a.getClass());
        }
        cbVar.m1157a(a, stringBuilder);
    }
}
