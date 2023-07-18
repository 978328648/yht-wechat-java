package com.coisini.curtain.home;

import lombok.*;

/**
 * @author liu
 */
@Setter
@Getter
@Data
public class WeChatBannerImg {
    private int id;
    private int index;
    private int bannerId;
    private String type;
    private String link;
    private String url;

    public WeChatBannerImg(int id, int index, int bannerId, String link, String type, String url, String background) {
        this.id = id;
        this.index = index;
        this.bannerId = bannerId;
        this.link = link;
        this.type = type;
        this.url = url;
    }

}
