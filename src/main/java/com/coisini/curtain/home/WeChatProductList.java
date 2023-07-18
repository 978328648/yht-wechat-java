package com.coisini.curtain.home;

import lombok.*;

@Data
public class WeChatProductList {
    private String product_specs;
    private String product_remark;
    private String product_profile;
    private int label_id;
    private int product_sales;
    private int product_id;
    private int sortId;
    private int index;
    private String product_name;
    private String product_img_list;
    private Boolean isHot;
    private Boolean isNew;
    private Boolean isRecommend;
    private String product_price;

    public WeChatProductList(String product_specs, String product_remark, String product_profile, int label_id, int product_sales, int product_id, int sortId, int index, String product_name, String product_img_list, Boolean isHot, Boolean isNew, Boolean isRecommend, String product_price) {
        this.product_specs = product_specs;
        this.product_remark = product_remark;
        this.product_profile = product_profile;
        this.label_id = label_id;
        this.product_sales = product_sales;
        this.product_id = product_id;
        this.sortId = sortId;
        this.index = index;
        this.product_name = product_name;
        this.product_img_list = product_img_list;
        this.isHot = isHot;
        this.isNew = isNew;
        this.isRecommend = isRecommend;
        this.product_price = product_price;
    }
}
