package com.company;
import com.company.Login;
import com.company.Burger;
import com.company.Service;
import java.util.ArrayList;
import java.util.Scanner;
public class AdminController {
    int BurgerId;
    String BurgerName;
    String BurgerSize;
    float BurgerPrice;
    String BurgerType;
    static int id=0;
    Service adm = new Service();
    Burger[] br1;
    Burger br;
    Scanner sc = new Scanner(System.in);



    public boolean loginController(Login ld)
    {
        boolean b1=adm.validLogin(ld);
        if(b1==true)
        {
            System.out.println("Successfully login");
            return true;
        }
        else
        {
            System.out.println("login failed");
            return false;
        }
    }

    public int addPizza()
    {
        System.out.println("Add a Burger");

        br=new Burger();
        br.setBurgerId(id);
        System.out.println("Enter the Details of Burger \n:");
        System.out.println("Enter the BurgerId: ");
        BurgerId=sc.nextInt();
        System.out.println("Enter the BurgerName: ");
        BurgerName=sc.next();
        System.out.println("Enter the BurgerType: (veg/non-veg)");
        BurgerType=sc.next();
        System.out.println("Enter the BurgerSize : (R/M/L)");
        BurgerSize=sc.next();
        System.out.println("Enter the BurgerPrice: ");
        BurgerPrice=sc.nextInt();
        br.setBurgerId(BurgerId);
        br.setBurgerName(BurgerName);
        br.setBurgerType(BurgerType);
        br.setBurgerSize(BurgerSize);
        br.setBurgerPrice(BurgerPrice);
        int i =adm.validAdd(br);
        if(i!=0)
            System.out.println("Total rows inserted: "+i);
        else
            System.out.println("Object can not be null");
        return 0;
    }


    public int updatePizza()
    {
        System.out.println("Update a Burger");
        System.out.println("Enter the burger Id you want to update");
        int BurgerId=sc.nextInt();
        int b1=adm.checkBurger(BurgerId);
        if(b1!=0)
        {
            System.out.println("Enter the New Details of burger having id = "+BurgerId);
            System.out.println("Enter the BurgerName");
            BurgerName=sc.next();
            System.out.println("Enter the BurgerType");
            BurgerType=sc.next();
            System.out.println("Enter the BurgerSize : (R/M/L)");
            BurgerSize=sc.next();
            System.out.println("Enter the BurgerPrice");
            BurgerPrice=sc.nextInt();
            br=new Burger();
            br.setBurgerName(BurgerName);
            br.setBurgerType(BurgerType);
            br.setBurgerSize(BurgerSize);
            br.setBurgerPrice(BurgerPrice);
            boolean str=adm.validUpdate(br,BurgerId);
            if(str==(true))
                System.out.println("Update successfully");
            else
                System.out.println("Object can not be null");
        }
        else
            System.out.println("Invalid BurgerId");
        return 0;
    }

    public int deletePizza()
    {
        System.out.println("Delete a Burger");
        System.out.println("Enter the burger Id you want to Delete");
        int BurgerId=sc.nextInt();
        int b1=adm.checkBurger(BurgerId);
        if(b1!=0)
        {
            System.out.println("Id found in Table");
            int b2=adm.validDelete(BurgerId);
            if(b2!=0)
                System.out.println("Delete successfully");
            else
                System.out.println("Object can not be null");
        }
        else
            System.out.println("Invalid BurgerId or No Burger Present");

        return 0;
    }

    public int showAllPizza()
    {
        System.out.println("Show All Burgers");
        ArrayList<Burger> BurgerList=adm.validDisplay();
        for(int i=0;i<BurgerList.size();i++)
        {
            Burger burger=BurgerList.get(i);
            System.out.println(burger);
        }
        return 0;
    }

}

