package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.C0748c.C0749a;

/* renamed from: com.google.android.gms.dynamic.b */
public final class C0750b extends C0749a {
    private Fragment TG;

    private C0750b(Fragment fragment) {
        this.TG = fragment;
    }

    public static C0750b m2588a(Fragment fragment) {
        return fragment != null ? new C0750b(fragment) : null;
    }

    public final void m2589d(C0752d c0752d) {
        this.TG.registerForContextMenu((View) C0755e.m2593f(c0752d));
    }

    public final void m2590e(C0752d c0752d) {
        this.TG.unregisterForContextMenu((View) C0755e.m2593f(c0752d));
    }

    public final Bundle getArguments() {
        return this.TG.getArguments();
    }

    public final int getId() {
        return this.TG.getId();
    }

    public final boolean getRetainInstance() {
        return this.TG.getRetainInstance();
    }

    public final String getTag() {
        return this.TG.getTag();
    }

    public final int getTargetRequestCode() {
        return this.TG.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.TG.getUserVisibleHint();
    }

    public final C0752d getView() {
        return C0755e.m2594k(this.TG.getView());
    }

    public final boolean isAdded() {
        return this.TG.isAdded();
    }

    public final boolean isDetached() {
        return this.TG.isDetached();
    }

    public final boolean isHidden() {
        return this.TG.isHidden();
    }

    public final boolean isInLayout() {
        return this.TG.isInLayout();
    }

    public final boolean isRemoving() {
        return this.TG.isRemoving();
    }

    public final boolean isResumed() {
        return this.TG.isResumed();
    }

    public final boolean isVisible() {
        return this.TG.isVisible();
    }

    public final C0752d jf() {
        return C0755e.m2594k(this.TG.getActivity());
    }

    public final C0748c jg() {
        return C0750b.m2588a(this.TG.getParentFragment());
    }

    public final C0752d jh() {
        return C0755e.m2594k(this.TG.getResources());
    }

    public final C0748c ji() {
        return C0750b.m2588a(this.TG.getTargetFragment());
    }

    public final void setHasOptionsMenu(boolean z) {
        this.TG.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.TG.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.TG.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.TG.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.TG.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.TG.startActivityForResult(intent, i);
    }
}
