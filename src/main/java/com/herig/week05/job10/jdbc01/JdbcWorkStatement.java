package com.herig.week05.job10.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcWorkStatement {

    private static final String URL = "jdbc:mysql://192.168.2.101:3306/zxcs";
    private static final String USER_NAME = "zxcs";
    private static final String USER_PASSWORD = "zxcs";

    public static void main(String[] args) throws Exception {

        //1.获得驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库连接
        Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        //3.statement操作数据库
        Statement statement = connection.createStatement();

        int i = statement.executeUpdate(" insert into geek_work_detail VALUES(NULL, 'work01-使用 JDBC 原生接口，实现数据库的增删改查操作。', 'Y' ,now()) ");

        System.out.println("插入条数：" + i);

        ResultSet resultSet = statement.executeQuery("select * from geek_work_detail  ");
        while (resultSet.next()) {
            System.out.println("查询结果：" +resultSet.getString("geek_id") + "," + resultSet.getString("geek_work_name") + "," + resultSet.getString("geek_work_status") + "," + resultSet.getString("complete_date"));
        }

        int j = statement.executeUpdate(" update geek_work_detail a set a.geek_work_name ='update cussess' where a. geek_work_name = 'work01-使用 JDBC 原生接口，实现数据库的增删改查操作。'");
        System.out.println("更新条数：" + j);


        int x = statement.executeUpdate(" delete from geek_work_detail where  geek_work_name = 'update cussess'");
        System.out.println("删除条数：" + x);


        //关闭
        resultSet.close();
        statement.close();
        connection.close();


    }


}