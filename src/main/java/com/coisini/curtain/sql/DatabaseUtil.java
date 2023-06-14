package com.coisini.curtain.sql;

import java.sql.*;

/**
 * @author liu
 * 该代码定义了一个名为DatabaseUtil的公共类，
 * 其中包含一个名为executeQuery的公共方法。
 * 该方法接受一个SQL查询语句，以及可变数量的查询参数，
 * 并通过JDBC API执行查询操作。在方法中，
 * 先使用JDBC API获取数据库连接，再通过PreparedStatement类设置查询参数，
 * 最后执行查询操作，并返回查询结果集ResultSet。
 * 该方法可以在其他Java类中调用，以实现数据库查询的代码复用。
 */
public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://www.a57521.com/curtain?characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    private static final String USER = "curtain";
    private static final String PASSWORD = "demaxiya789.";

    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        int index = 0;
        for (Object param : params) {
            pstmt.setObject(index, param);
            index++;
        }

        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}

