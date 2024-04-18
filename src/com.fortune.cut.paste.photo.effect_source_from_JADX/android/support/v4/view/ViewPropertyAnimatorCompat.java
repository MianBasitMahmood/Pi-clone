package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl IMPL;
    private static final String TAG = "ViewAnimatorCompat";
    private WeakReference<View> mView;

    interface ViewPropertyAnimatorCompatImpl {
        void alpha(View view, float f);

        void alphaBy(View view, float f);

        void cancel(View view);

        long getDuration(View view);

        Interpolator getInterpolator(View view);

        long getStartDelay(View view);

        void rotation(View view, float f);

        void rotationBy(View view, float f);

        void rotationX(View view, float f);

        void rotationXBy(View view, float f);

        void rotationY(View view, float f);

        void rotationYBy(View view, float f);

        void scaleX(View view, float f);

        void scaleXBy(View view, float f);

        void scaleY(View view, float f);

        void scaleYBy(View view, float f);

        void setDuration(View view, long j);

        void setInterpolator(View view, Interpolator interpolator);

        void setListener(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(View view, long j);

        void start(View view);

        void translationX(View view, float f);

        void translationXBy(View view, float f);

        void translationY(View view, float f);

        void translationYBy(View view, float f);

        void withEndAction(View view, Runnable runnable);

        void withLayer(View view);

        void withStartAction(View view, Runnable runnable);

        void m0x(View view, float f);

        void xBy(View view, float f);

        void m1y(View view, float f);

        void yBy(View view, float f);
    }

    static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        BaseViewPropertyAnimatorCompatImpl() {
        }

        public void setDuration(View view, long j) {
        }

        public void alpha(View view, float f) {
        }

        public void translationX(View view, float f) {
        }

        public void translationY(View view, float f) {
        }

        public void withEndAction(View view, Runnable runnable) {
            runnable.run();
        }

        public long getDuration(View view) {
            return 0;
        }

        public void setInterpolator(View view, Interpolator interpolator) {
        }

        public Interpolator getInterpolator(View view) {
            return null;
        }

        public void setStartDelay(View view, long j) {
        }

        public long getStartDelay(View view) {
            return 0;
        }

        public void alphaBy(View view, float f) {
        }

        public void rotation(View view, float f) {
        }

        public void rotationBy(View view, float f) {
        }

        public void rotationX(View view, float f) {
        }

        public void rotationXBy(View view, float f) {
        }

        public void rotationY(View view, float f) {
        }

        public void rotationYBy(View view, float f) {
        }

        public void scaleX(View view, float f) {
        }

        public void scaleXBy(View view, float f) {
        }

        public void scaleY(View view, float f) {
        }

        public void scaleYBy(View view, float f) {
        }

        public void cancel(View view) {
        }

        public void m2x(View view, float f) {
        }

        public void xBy(View view, float f) {
        }

        public void m3y(View view, float f) {
        }

        public void yBy(View view, float f) {
        }

        public void translationXBy(View view, float f) {
        }

        public void translationYBy(View view, float f) {
        }

        public void start(View view) {
        }

        public void withLayer(View view) {
        }

        public void withStartAction(View view, Runnable runnable) {
            runnable.run();
        }

        public void setListener(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        }
    }

    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.1 */
        class C00471 implements ViewPropertyAnimatorListener {
            final /* synthetic */ Runnable val$runnable;

            C00471(Runnable runnable) {
                this.val$runnable = runnable;
            }

            public void onAnimationStart(View view) {
            }

            public void onAnimationEnd(View view) {
                this.val$runnable.run();
                ICSViewPropertyAnimatorCompatImpl.this.setListener(view, null);
            }

            public void onAnimationCancel(View view) {
            }
        }

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.2 */
        class C00482 implements ViewPropertyAnimatorListener {
            final /* synthetic */ Runnable val$runnable;

            C00482(Runnable runnable) {
                this.val$runnable = runnable;
            }

            public void onAnimationStart(View view) {
                this.val$runnable.run();
                ICSViewPropertyAnimatorCompatImpl.this.setListener(view, null);
            }

            public void onAnimationEnd(View view) {
            }

            public void onAnimationCancel(View view) {
            }
        }

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.3 */
        class C00493 implements ViewPropertyAnimatorListener {
            final /* synthetic */ int val$currentLayerType;

            C00493(int i) {
                this.val$currentLayerType = i;
            }

            public void onAnimationStart(View view) {
                ViewCompat.setLayerType(view, 2, null);
            }

            public void onAnimationEnd(View view) {
                ViewCompat.setLayerType(view, this.val$currentLayerType, null);
                ICSViewPropertyAnimatorCompatImpl.this.setListener(view, null);
            }

            public void onAnimationCancel(View view) {
            }
        }

        ICSViewPropertyAnimatorCompatImpl() {
        }

        public void setDuration(View view, long j) {
            ViewPropertyAnimatorCompatICS.setDuration(view, j);
        }

        public void alpha(View view, float f) {
            ViewPropertyAnimatorCompatICS.alpha(view, f);
        }

        public void translationX(View view, float f) {
            ViewPropertyAnimatorCompatICS.translationX(view, f);
        }

        public void translationY(View view, float f) {
            ViewPropertyAnimatorCompatICS.translationY(view, f);
        }

        public long getDuration(View view) {
            return ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        public void setInterpolator(View view, Interpolator interpolator) {
            ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
        }

        public void setStartDelay(View view, long j) {
            ViewPropertyAnimatorCompatICS.setStartDelay(view, j);
        }

        public long getStartDelay(View view) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        public void alphaBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.alphaBy(view, f);
        }

        public void rotation(View view, float f) {
            ViewPropertyAnimatorCompatICS.rotation(view, f);
        }

        public void rotationBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationBy(view, f);
        }

        public void rotationX(View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationX(view, f);
        }

        public void rotationXBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationXBy(view, f);
        }

        public void rotationY(View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationY(view, f);
        }

        public void rotationYBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationYBy(view, f);
        }

        public void scaleX(View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleX(view, f);
        }

        public void scaleXBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleXBy(view, f);
        }

        public void scaleY(View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleY(view, f);
        }

        public void scaleYBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleYBy(view, f);
        }

        public void cancel(View view) {
            ViewPropertyAnimatorCompatICS.cancel(view);
        }

        public void m4x(View view, float f) {
            ViewPropertyAnimatorCompatICS.m8x(view, f);
        }

        public void xBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.xBy(view, f);
        }

        public void m5y(View view, float f) {
            ViewPropertyAnimatorCompatICS.m9y(view, f);
        }

        public void yBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.yBy(view, f);
        }

        public void translationXBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.translationXBy(view, f);
        }

        public void translationYBy(View view, float f) {
            ViewPropertyAnimatorCompatICS.translationYBy(view, f);
        }

        public void start(View view) {
            ViewPropertyAnimatorCompatICS.start(view);
        }

        public void setListener(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompatICS.setListener(view, viewPropertyAnimatorListener);
        }

        public void withEndAction(View view, Runnable runnable) {
            setListener(view, new C00471(runnable));
        }

        public void withStartAction(View view, Runnable runnable) {
            setListener(view, new C00482(runnable));
        }

        public void withLayer(View view) {
            setListener(view, new C00493(ViewCompat.getLayerType(view)));
        }
    }

    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        public void withStartAction(View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }

        public void withEndAction(View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        public void withLayer(View view) {
            ViewPropertyAnimatorCompatJB.withLayer(view);
        }
    }

    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        public Interpolator getInterpolator(View view) {
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            IMPL = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            IMPL = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setDuration(view, j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.alpha(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.alphaBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationX(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationY(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withEndAction(view, runnable);
        }
        return this;
    }

    public long getDuration() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getDuration(view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setInterpolator(view, interpolator);
        }
        return this;
    }

    public Interpolator getInterpolator() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getInterpolator(view);
        }
        return null;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setStartDelay(view, j);
        }
        return this;
    }

    public long getStartDelay() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getStartDelay(view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotation(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationX(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationXBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationY(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationYBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleX(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleXBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleY(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleYBy(view, f);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.cancel(view);
        }
    }

    public ViewPropertyAnimatorCompat m6x(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.m0x(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.xBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat m7y(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.m1y(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.yBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationXBy(view, f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationYBy(view, f);
        }
        return this;
    }

    public void start() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.start(view);
        }
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withLayer(view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withStartAction(view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setListener(view, viewPropertyAnimatorListener);
        }
        return this;
    }
}
