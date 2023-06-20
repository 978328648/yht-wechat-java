package com.coisini.curtain.home;

/**
 * @author liu
 */
public class WeChatBannerImg {
    private int id;
    private int index;
    private int bannerId;
    private String type;
    private String link;
    private String url;

    public WeChatBannerImg(int id,int index,int bannerId, String link, String type, String url) {
        this.id = id;
        this.index = index;
        this.bannerId = bannerId;
        this.link = link;
        this.type = type;
        this.url = url;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
