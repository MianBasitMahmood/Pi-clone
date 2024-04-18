package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C0748c.C0749a;

/* renamed from: com.google.android.gms.dynamic.h */
public final class C0758h extends C0749a {
    private Fragment Mx;

    private C0758h(Fragment fragment) {
        this.Mx = fragment;
    }

    public static C0758h m2597a(Fragment fragment) {
        return fragment != null ? new C0758h(fragment) : null;
    }

    public final void m2598d(C0752d c0752d) {
        this.Mx.registerForContextMenu((View) C0755e.m2593f(c0752d));
    }

    public final void m2599e(C0752d c0752d) {
        this.Mx.unregisterForContextMenu((View) C0755e.m2593f(c0752d));
    }

    public final Bundle getArguments() {
        return this.Mx.getArguments();
    }

    public final int getId() {
        return this.Mx.getId();
    }

    public final boolean getRetainInstance() {
        return this.Mx.getRetainInstance();
    }

    public final String getTag() {
        return this.Mx.getTag();
    }

    public final int getTargetRequestCode() {
        return this.Mx.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.Mx.getUserVisibleHint();
    }

    public final C0752d getView() {
        return C0755e.m2594k(this.Mx.getView());
    }

    public final boolean isAdded() {
        return this.Mx.isAdded();
    }

    public final boolean isDetached() {
        return this.Mx.isDetached();
    }

    public final boolean isHidden() {
        return this.Mx.isHidden();
    }

    public final boolean isInLayout() {
        return this.Mx.isInLayout();
    }

    public final boolean isRemoving() {
        return this.Mx.isRemoving();
    }

    public final boolean isResumed() {
        return this.Mx.isResumed();
    }

    public final boolean isVisible() {
        return this.Mx.isVisible();
    }

    public final C0752d jf() {
        return C0755e.m2594k(this.Mx.getActivity());
    }

    public final C0748c jg() {
        return C0758h.m2597a(this.Mx.getParentFragment());
    }

    public final C0752d jh() {
        return C0755e.m2594k(this.Mx.getResources());
    }

    public final C0748c ji() {
        return C0758h.m2597a(this.Mx.getTargetFragment());
    }

    public final void setHasOptionsMenu(boolean z) {
        this.Mx.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.Mx.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.Mx.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.Mx.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.Mx.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.Mx.startActivityForResult(intent, i);
    }
}
