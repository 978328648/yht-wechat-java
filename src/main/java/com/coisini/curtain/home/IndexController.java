package com.coisini.curtain.home;

import com.coisini.curtain.sql.DatabaseUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
            WeChatBannerImg bannerImg = new WeChatBannerImg(id, index, bannerId,link,type,url);
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
            WeChatActivity activity = new WeChatActivity(activityId,index,activityUrl);
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