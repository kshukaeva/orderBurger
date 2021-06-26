package com.company;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDB extends MainDB {
    private int BurgerId;
    private String BurgerName;
    private String BurgerSize;
    private float BurgerPrice;
    private String BurgerType;
    private float amt = 0;
    private int count = 0;

//    public boolean isLogin(Login data) {
//        String username = data.getUsername();
//        String password = data.getPassword();
//        String tablePassword = "";
//        Connection con=null;
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement("select password from CustomerData where username = ?");
//            ps.setString(1, username);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                tablePassword = rs.getString(1);
//
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        if (password.equals(tablePassword)) {
//            //System.out.println(tablePassword);
//            System.out.println("Match found");
//            return true;
//        } else {
//            //System.out.println(tablePassword);
//            System.out.println("Match not Found");
//            return false;
//        }
//    }
//
//
//    public boolean isRegister(Registration rd) {
//
//        String username = rd.getUsername();
//        int contact = rd.getContact();
//        String password = rd.getPassword();
//        String confirmPassword = rd.getConfirmPassword();
//
//        Connection con=null;
//        PreparedStatement ps = null;
//
//        try {
//            ps = con.prepareStatement("insert into CustomerData values(?,?,?,?)");
//            ps.setString(1, username);
//            ps.setInt(2, contact);
//            ps.setString(3, password);
//            ps.setString(4, confirmPassword);
//
//            int i = ps.executeUpdate();
//            if (i == 1)
//                return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public ArrayList getAllBurger() {
        Connection con=null;
        PreparedStatement ps = null;
        ArrayList<Burger> BurgerList;
        try {
            BurgerList = new ArrayList<Burger>();
            ps = con.prepareStatement("select * from burger order by burgerid");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Burger burger = new Burger();
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

    public boolean makeOrder(ArrayList ar) {
        Connection con=null;
        PreparedStatement ps = null, ps1 = null;
        Burger burger = new Burger();
        int id = 0, j = 0;
        for (int i = 0; i < ar.size(); i++) {
            BurgerName = (String) ar.get(i);
            // System.out.println(BurgerName);
            try {
                ps = con.prepareStatement("select * from burgers where burgername=?");
                ps.setString(1, BurgerName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    id = (rs.getInt(1));
                    //System.out.println(id);
                }


                if (id != 0) {
                    ps1 = con.prepareStatement("insert into burgers values(?,?,?,?,?)");
                    burger = getBurgerId(id);
                    ps1.setInt(1, burger.getBurgerId());
                    ps1.setString(2, burger.getBurgerName());
                    ps1.setString(3, burger.getBurgerType());
                    ps1.setString(4, burger.getBurgerSize());
                    ps1.setFloat(5, burger.getBurgerPrice());

                    j = ps1.executeUpdate();
                    j++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (j != 0) {
            return true;
        } else
            return false;
    }

    public Burger getBurgerId(int pzId) {
        Connection con=null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("select * from burgers where BurgerId=?");
            Burger burger = null;
            ps.setInt(1, BurgerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                burger = new Burger();
                burger.setBurgerId(rs.getInt(1));
                burger.setBurgerName(rs.getString(2));
                burger.setBurgerType(rs.getString(3));
                burger.setBurgerSize(rs.getString(4));
                burger.setBurgerPrice(rs.getFloat(5));
            }
            return burger;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getOrder() {
        Connection con=null;
        PreparedStatement ps = null;
        ArrayList<Burger> BurgerList = null;
        try {
            ps = con.prepareStatement("select * from placedorder");
            ResultSet rs = ps.executeQuery();
            BurgerList = new ArrayList<Burger>();
            while (rs.next()) {
                Burger burger = new Burger();
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


    public float getBillAmount() {
        Connection con=null;
        PreparedStatement ps = null;
        try {
            count = 0;
            ps = con.prepareStatement("select count(burgerid), sum(burgerprice) from placedorder");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                amt = rs.getInt(2);
            }
            System.out.println("Total Burger Ordered are: " + count);

            if (amt != 0) {
							/*pstmt1=conn1.prepareStatement("delete placedorder");
							pstmt.executeUpdate();
							pstmt1=conn1.prepareStatement("commit");
							pstmt.executeUpdate();
							*/
                Statement st = con.createStatement();
                st.execute("delete placedorder");
                return amt;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }
}
