package com.timedancing.easyfirewall.animation;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.Interpolator;

import java.lang.ref.WeakReference;

/**
 * Created by zengzheying on 15/7/10.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SupportAnimatorLollipop extends SupportAnimator {

    WeakReference<Animator> mAnimator;

    SupportAnimatorLollipop(Animator animator, RevealAnimator target) {
        super(target);
        mAnimator = new WeakReference<>(animator);
    }

    @Override
    public boolean isNativeAnimator() {
        return true;
    }

    @Override
    public Object get() {
        return mAnimator.get();
    }

    @Override
    public void start() {
        Animator a = mAnimator.get();
        if (a != null) {
            a.start();
        }
    }

    @Override
    public void setDuration(int duration) {
        Animator a = mAnimator.get();
        if (a != null) {
            a.setDuration(duration);
        }
    }

    @Override
    public void setInterpolator(Interpolator value) {
        Animator a = mAnimator.get();
        if (a != null) {
            a.setInterpolator(value);
        }
    }

    @Override
    public void addListener(final AnimationListener listener) {
        Animator a = mAnimator.get();
        if (a == null) {
            return;
        }

        if (listener == null) {
            a.addListener(null);
            return;
        }

        a.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                listener.onAnimationStart();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                listener.onAnimationEnd();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                listener.onAnimationCancel();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                listener.onAnimationRepeat();
            }
        });
    }

    @Override
    public boolean isRunning() {
        Animator a = mAnimator.get();
        return a != null && a.isRunning();
    }

    @Override
    public void cancel() {
        Animator a = mAnimator.get();
        if (a != null) {
            a.cancel();
        }
    }

    @Override
    public void end() {
        Animator a = mAnimator.get();
        if (a != null) {
            a.end();
        }
    }

    @Override
    public void setupStartValues() {
        Animator a = mAnimator.get();
        if (a != null) {
            a.setupEndValues();
        }
    }

    @Override
    public void setupEndValues() {
        Animator a = mAnimator.get();
        if (a != null) {
            a.setupStartValues();
        }
    }
}
