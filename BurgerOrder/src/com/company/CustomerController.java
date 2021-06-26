package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    int BurgerId;
    String BurgerName;
    String BurgerSize;
    float BurgerPrice;
    String BurgerType;
    int count=0;
    static int id=0;
    Burger[] br1;
    Burger br;
    Scanner sc = new Scanner(System.in);
    public static CustomerDB cus=new CustomerDB();

//    public boolean LoginController(Login ld)
//    {
//        boolean b1=cus.isLogin(ld);
//        if(b1==true)
//        {
//            System.out.println("Successfully login");
//            return true;
//        }
//        else
//        {
//            System.out.println("login failed");
//            return false;
//        }
//    }
//
//    public boolean RegisterController(Registration rd)
//    {
//        boolean b1=cus.isRegister(rd);
//        if(b1==true)
//        {
//            System.out.println("Successfully Registered");
//            return true;
//        }
//        else
//        {
//            System.out.println("Registration failed");
//            return false;
//        }
//    }

    public int showAllBurgers()
    {
        System.out.println("Burger's list:");
        ArrayList<Burger> BurgerList=cus.getAllBurger();
        for(int i=0;i<BurgerList.size();i++)
        {
            Burger burger=BurgerList.get(i);
            System.out.println(burger);
        }
        return 0;
    }

    public void placeOrder()
    {
        String brName;
        String st;
        ArrayList <String> burgerArr=new ArrayList<String>();
        System.out.println("Place Your Order: ");
        do
        {
            System.out.println("Enter the BurgerName you want to Order: ");
            brName=sc.next();
            burgerArr.add(brName);
            System.out.println("DO you Want add More Burger: (Y/N)");
            st=sc.next();
        }while(st.equals("Y") || st.equals("y"));
        boolean b1=cus.makeOrder(burgerArr);
        if(b1==true)
            System.out.println("Order is Placed");
        else
            System.out.println("Order not Placed");
    }

    public int viewOrder()
    {
        System.out.println("View your Order");
        ArrayList <Burger> BurgerList=cus.getOrder();
        if(BurgerList!=null)
        {
            for(int i=0;i<BurgerList.size();i++)
            {
                Burger burger=BurgerList.get(i);
                System.out.println(burger);
            }
        }
        else
            System.out.println("Please place the order first");
        return 0;
    }


    public void genBill()
    {

        float amount=cus.getBillAmount();
        if(amount!=0)
            System.out.println("Total Amount to be paid: "+amount);
        else
            System.out.println("No bill generated");
    }



}
