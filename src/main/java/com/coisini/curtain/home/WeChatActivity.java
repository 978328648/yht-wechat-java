package com.coisini.curtain.home;

import lombok.*;

/**
 * @author liu
 */
@Setter
@Getter
@Data
public class WeChatActivity {
    private int activityId;
    private int index;
    private String activityUrl;
    private String product_price;
    private String product_name;

    public WeChatActivity(int activityId, int index, String activityUrl,String product_price, String product_name) {
        this.activityId = activityId;
        this.index = index;
        this.activityUrl = activityUrl;
        this.product_price = product_price;
        this.product_name = product_name;
    }


}
