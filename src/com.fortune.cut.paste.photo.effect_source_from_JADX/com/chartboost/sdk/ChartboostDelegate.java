package com.chartboost.sdk;

import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public abstract class ChartboostDelegate implements C0092a {
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

    public void didCacheMoreApps(String str) {
    }

    public boolean shouldDisplayMoreApps(String str) {
        return true;
    }

    public void didFailToLoadMoreApps(String str, CBImpressionError cBImpressionError) {
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
