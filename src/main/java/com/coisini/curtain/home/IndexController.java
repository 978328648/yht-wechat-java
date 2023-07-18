package com.coisini.curtain.home;

import com.coisini.curtain.sql.DatabaseUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@SpringBootApplication
@RequestMapping("/*")
public class IndexController {
    @RequestMapping("/getHomeBanner")
    /*
      首页轮播图
     */
    public Map<String,Object> getHomeBanner() throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        List<WeChatBannerImg> bannerImgs = new ArrayList<>();
        String sql = "SELECT * FROM wechat_bannerimg";
        ResultSet rs = DatabaseUtil.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            int index = rs.getInt("index");
            int bannerId = rs.getInt("bannerId");
            String link = rs.getString("link");
            String type = rs.getString("type");
            String url = rs.getString("url");
            String background = rs.getString("background");
            WeChatBannerImg bannerImg = new WeChatBannerImg(id, index, bannerId,link,type,url,background);
            bannerImgs.add(bannerImg);
        }
        map.put("data",bannerImgs);
        map.put("success",true);
        return map;
    }
    @RequestMapping("/getActivityList")
    /*
      活动列表
     */
    public Map<String,Object> getActivityList() throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        List<WeChatActivity> activityList = new ArrayList<>();
        String sql = "SELECT * FROM wechat_activity";
        ResultSet rs = DatabaseUtil.executeQuery(sql);
        while (rs.next()) {
            int activityId = rs.getInt("activityId");
            int index = rs.getInt("index");
            String activityUrl = rs.getString("activityUrl");
            String product_price = rs.getString("product_price");
            String product_name = rs.getString("product_name");
            WeChatActivity activity = new WeChatActivity(activityId,index,activityUrl,product_price,product_name);
            activityList.add(activity);
        }
        map.put("data",activityList);
        map.put("success",true);
        return map;
    }
    @RequestMapping("/getSortList")
    /*
      分类列表
     */
    public Map<String,Object> getSortList() throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        List<WeChatSort> sortList = new ArrayList<>();
        String sql = "SELECT * FROM wechat_sort";
        ResultSet rs = DatabaseUtil.executeQuery(sql);
        while (rs.next()) {
            int sortId = rs.getInt("sortId");
            int index = rs.getInt("index");
            String sortImg = rs.getString("sortImg");
            String sortName = rs.getString("sortName");
            String sortHotImg = rs.getString("sortHotImg");
            String sortFatherId = rs.getString("sortFatherId");
            WeChatSort sort = new WeChatSort(sortId,index,sortImg,sortName,sortHotImg,sortFatherId);
            sortList.add(sort);
        }
        map.put("data",sortList);
        map.put("success",true);
        return map;
    }
    @PostMapping("/getProductList")
    /*
      产品列表
     */
    public Map<String,Object> getProductList(@RequestParam Map<String, Object> data,int page,int pageSize) throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        List<WeChatProductList> sortList = new ArrayList<>();
//        获得总页数
        String sqlAll = "select count(*) as result from wechat_product";
        ResultSet rsAll = DatabaseUtil.executeQuery(sqlAll);
        int count=0;
        while(rsAll.next())
        {
            count=rsAll.getInt(1);
        }
//        按页数查询
        String sql = "SELECT * FROM wechat_product limit  " + pageFun(page,pageSize,count) +"," + pageSize;
        ResultSet rs = DatabaseUtil.executeQuery(sql);
        while (rs.next()) {
            int product_id = rs.getInt("product_id");
            int product_sales = rs.getInt("product_sales");
            int sortId = rs.getInt("sortId");
            int label_id = rs.getInt("label_id");
            int index = rs.getInt("index");
            String product_price = rs.getString("product_price");
            String product_name = rs.getString("product_name");
            String product_img_list = rs.getString("product_img_list");
            String product_specs = rs.getString("product_specs");
            String product_remark = rs.getString("product_remark");
            String product_profile = rs.getString("product_profile");
            Boolean isHot = Boolean.valueOf(rs.getString("isHot"));
            Boolean isNew = Boolean.valueOf(rs.getString("isNew"));
            Boolean isRecommend = Boolean.valueOf(rs.getString("isRecommend"));
            WeChatProductList sort = new WeChatProductList(product_specs,product_remark,product_profile,label_id,product_sales,product_id,sortId,index,product_name,product_img_list,isHot,isNew,isRecommend,product_price);
            sortList.add(sort);
        }
        map.put("data",sortList);
        map.put("success",true);
        map.put("total",count);
        return map;
    }
    //    计算页数
    private int pageFun(int page, int pageSize, int count) {
        int max =  (int)Math.ceil((double)count / pageSize);
        if( page > max){
            return max * 10 - 10;
        }else if(page == 1 ){
            return 1;
        }else{
            int d = page;
            return d * 10 - 10;
        }
    }

//    @RequestMapping("/getUser")
//    public Map<String,Object> getUser(){
//        System.out.println("微信小程序正在调用...");
//        Map<String,Object> map = new HashMap<String, Object>();
//        List<String> list = new ArrayList<String>();
//        list.add("Amy");
//        list.add("Cathy");
//        map.put("list",list);
//        System.out.println("微信小程序调用完成...");
//        return map;
//    }
//    @PostMapping("/add")
//    public String save(@RequestParam Map<String, Object> map){
//        System.out.println("书名：" + map + ", 作者: " + map.get("author"));
//        return "书名：" + map.get("name") + ", 作者: " + map.get("author");
//    }
//
//    @RequestMapping("/getTest")
//    public String getTest(){
//        return "Hello world";
//    }

}