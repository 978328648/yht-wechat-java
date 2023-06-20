package com.coisini.curtain.home;

/**
 * @author liu
 */
public class WeChatSort {
    private  int sortId;
    private  int index;
    private  String sortImg;
    private  String sortName;
    private  String sortHotImg;
    private String sortFatherId;

    public WeChatSort(int sortId, int index, String sortImg, String sortName, String sortHotImg, String sortFatherId) {
        this.sortId = sortId;
        this.index = index;
        this.sortImg = sortImg;
        this.sortName = sortName;
        this.sortHotImg = sortHotImg;
        this.sortFatherId = sortFatherId;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSortImg() {
        return sortImg;
    }

    public void setSortImg(String sortImg) {
        this.sortImg = sortImg;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortHotImg() {
        return sortHotImg;
    }

    public void setSortHotImg(String sortHotImg) {
        this.sortHotImg = sortHotImg;
    }

    public String getSortFatherId() {
        return sortFatherId;
    }

    public void setSortFatherId(String sortFatherId) {
        this.sortFatherId = sortFatherId;
    }
}
