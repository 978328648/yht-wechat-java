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
@RequestMapping("/user/*")
public class IndexController {
    @RequestMapping("/getHomeBanner")
    public Map<String,Object> getHomeBanner() throws SQLException {
        System.out.println("getHomeBanner正在调用...");
        Map<String,Object> map = new HashMap<String, Object>();
        List<String> userList = new ArrayList<>();
        String sql = "SELECT * FROM wechat_bannerimg WHERE url";
        ResultSet rs = DatabaseUtil.executeQuery(sql);
        System.out.println("111122223333");
        System.out.println(rs.next());
        while (rs.next()) {
            String url = rs.getString("url");
//            int userAge = rs.getInt("age");
//            User user = new User(url);
            userList.add(url);
        }
        map.put("imgList",userList);
        System.out.println("getHomeBanner调用完成...");
        return map;
    }
    @RequestMapping("/getUser")
    public Map<String,Object> getUser(){
        System.out.println("微信小程序正在调用...");
        Map<String,Object> map = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("Amy");
        list.add("Cathy");
        map.put("list",list);
        System.out.println("微信小程序调用完成...");
        return map;
    }
    @PostMapping("/add")
    public String save(@RequestParam Map<String, Object> map){
        System.out.println("书名：" + map + ", 作者: " + map.get("author"));
        return "书名：" + map.get("name") + ", 作者: " + map.get("author");
    }

    @RequestMapping("/getTest")
    public String getTest(){
        return "Hello world";
    }

}