package com.herig.week05.job10.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcWorkPrepareStatement {

    private static final String URL = "jdbc:mysql://localhost:3306/zxcs";
    private static final String USER_NAME = "zxcs";
    private static final String USER_PASSWORD = "zxcs";


    public static void main(String[] args) throws Exception {
        //1.获得驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库连接
        Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        //3.statement操作数据库
        String inserSql = " insert into geek_work_detail VALUES(NULL, ?, ? ,now()) ";
        PreparedStatement preparedStatement = connection.prepareStatement(inserSql);
        preparedStatement.setString(1, "week05-work10-1");
        preparedStatement.setString(2, "N");
        preparedStatement.addBatch();

        preparedStatement.setString(1, "week05-work10-2");
        preparedStatement.setString(2, "N");
        preparedStatement.addBatch();

        int[] ints = preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();


    }


}