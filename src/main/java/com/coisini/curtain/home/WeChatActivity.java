package com.coisini.curtain.home;

/**
 * @author liu
 */
public class WeChatActivity {
    private int activityId;
    private int index;
    private String activityUrl;
    public WeChatActivity(int activityId, int index, String activityUrl) {
        this.activityId = activityId;
        this.index = index;
        this.activityUrl = activityUrl;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }
}
