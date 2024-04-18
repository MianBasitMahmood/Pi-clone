package com.chartboost.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public abstract class ChartboostActivity extends Activity implements C0092a {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0153b.m377a((C0092a) this);
        Chartboost.onCreate(this);
    }

    protected void onStart() {
        super.onStart();
        Chartboost.onStart(this);
    }

    protected void onStop() {
        super.onStop();
        Chartboost.onStop(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        Chartboost.onDestroy(this);
    }

    protected void onPause() {
        super.onPause();
        Chartboost.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        Chartboost.onResume(this);
    }

    public void onBackPressed() {
        if (!Chartboost.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public boolean shouldRequestInterstitial(String str) {
        return true;
    }

    public boolean shouldDisplayInterstitial(String str) {
        return true;
    }

    public void didCacheInterstitial(String str) {
    }

    public void didFailToLoadInterstitial(String str, CBImpressionError cBImpressionError) {
    }

    public void didDismissInterstitial(String str) {
    }

    public void didCloseInterstitial(String str) {
    }

    public void didClickInterstitial(String str) {
    }

    public void didDisplayInterstitial(String str) {
    }

    public boolean shouldRequestMoreApps(String str) {
        return true;
    }

    public boolean shouldDisplayMoreApps(String str) {
        return true;
    }

    public void didFailToLoadMoreApps(String str, CBImpressionError cBImpressionError) {
    }

    public void didCacheMoreApps(String str) {
    }

    public void didDismissMoreApps(String str) {
    }

    public void didCloseMoreApps(String str) {
    }

    public void didClickMoreApps(String str) {
    }

    public void didDisplayMoreApps(String str) {
    }

    public void didFailToRecordClick(String str, CBClickError cBClickError) {
    }

    public void didPauseClickForConfirmation() {
    }

    public boolean shouldDisplayRewardedVideo(String str) {
        return true;
    }

    public void didCacheRewardedVideo(String str) {
    }

    public void didFailToLoadRewardedVideo(String str, CBImpressionError cBImpressionError) {
    }

    public void didDismissRewardedVideo(String str) {
    }

    public void didCloseRewardedVideo(String str) {
    }

    public void didClickRewardedVideo(String str) {
    }

    public void didCompleteRewardedVideo(String str, int i) {
    }

    public void didDisplayRewardedVideo(String str) {
    }

    public void willDisplayVideo(String str) {
    }

    public void didCacheInPlay(String str) {
    }

    public void didFailToLoadInPlay(String str, CBImpressionError cBImpressionError) {
    }
}
