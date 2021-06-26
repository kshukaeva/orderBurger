package com.company;
import java.sql.*;
import java.util.ArrayList;

public class AdminDB extends MainDB{
    private int BurgerId;
    private String BurgerName;
    private String BurgerSize;
    private float BurgerPrice;
    private String BurgerType;


    public int addBurgerDB(Burger burger)
    {
        Connection con=null;
        PreparedStatement ps=null;
        int r=0;
        try
        {
            ps=con.prepareStatement("insert into burgers values(?,?,?,?,?)");
            BurgerId=burger.getBurgerId();
            BurgerName=burger.getBurgerName();
            BurgerType=burger.getBurgerType();
            BurgerSize=burger.getBurgerSize();
            BurgerPrice=burger.getBurgerPrice();
            ps.setInt(1, BurgerId);
            ps.setString(2, BurgerName);
            ps.setString(3, BurgerType);
            ps.setString(4, BurgerSize);
            ps.setFloat(5, BurgerPrice);

            r = ps.executeUpdate();
            return r;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public boolean updateBurgerDataDB(Burger burger,int burgerId)
    {
        Connection con=null;
        PreparedStatement ps=null;
        int r;
        try {
            ps=con.prepareStatement("update burgers set BurgerName = ?, BurgerType = ?, BurgerSize = ?, BurgerPrice = ? where BurgerId = ?");
            BurgerId=burgerId;
            BurgerName=burger.getBurgerName();
            BurgerType=burger.getBurgerType();
            BurgerSize=burger.getBurgerSize();
            BurgerPrice=burger.getBurgerPrice();


            ps.setString(1, BurgerName);
            ps.setString(2, BurgerType);
            ps.setString(3, BurgerSize);
            ps.setFloat(4, BurgerPrice);
            ps.setInt(5, BurgerId);

            r = ps.executeUpdate();
            System.out.println(r);
            if(r==1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    public int deleteBurgerDB(int burgerId)
    {
        Connection con=null;
        PreparedStatement ps=null;
        int r;
        try
        {
            ps=con.prepareStatement("delete from burgers where burgerId=?");

            ps.setInt(1, burgerId);
            r = ps.executeUpdate();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public ArrayList getAllBurger()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ArrayList<Burger> BurgerList;
        try {
            BurgerList = new ArrayList<Burger>();
            ps=con.prepareStatement("select * from burgers order by burgerId");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Burger burger=new Burger();
                burger.setBurgerId(rs.getInt(1));
                burger.setBurgerName(rs.getString(2));
                burger.setBurgerType(rs.getString(3));
                burger.setBurgerSize(rs.getString(4));
                burger.setBurgerPrice(rs.getFloat(5));
                BurgerList.add(burger);
            }
            return BurgerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public int checkBurgerId(int burgerId)
    {
        Connection con=null;
        PreparedStatement ps=null;
        int r;
        try
        {
            ps=con.prepareStatement("select BurgerName from burgers where burgerId=?");

            ps.setInt(1, burgerId);
            r = ps.executeUpdate();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Burger getBurger(int burgerId)
    {
        Connection con=null;
        PreparedStatement ps=null;
        try
        {
            ps=con.prepareStatement("select * from burgers");
            ResultSet rs=ps.executeQuery();
            Burger bg=new Burger();
            while(rs.next())
            {
                Burger burger=new Burger();
                burger.setBurgerId(rs.getInt(1));
                burger.setBurgerName(rs.getString(2));
                burger.setBurgerType(rs.getString(3));
                burger.setBurgerSize(rs.getString(4));
                burger.setBurgerPrice(rs.getFloat(5));
            }
            return bg;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Boolean isLogin(Login data)
    {
        String user=data.getUsername();
        String pass=data.getPassword();
        String tablePassword="123Abc";
        Connection con=null;
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement("select password from AdminDB where username = ?");
            ps.setString(1,user);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                tablePassword=rs.getString(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(pass.equals(tablePassword))
        {
            //System.out.println(tablePassword);
            System.out.println("Match found");
            return true;
        }
        else
        {
            //System.out.println(tablePassword);
            System.out.println("Match not Found");
            return false;
        }
    }
}
