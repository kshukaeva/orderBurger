package com.company;
import java.sql.*;

public class MainDB {
    private static MainDB jdbc;
    public static MainDB getInstance() {
        if (jdbc==null)
        {
            jdbc=new MainDB();
        }
        return jdbc;
    }
    private static Connection getConnection()throws ClassNotFoundException, SQLException
    {

        Connection con=null;
        Class.forName("org.postgresql.Driver");
        con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/burger","postgres", "1234");
        return con;

    }
}

