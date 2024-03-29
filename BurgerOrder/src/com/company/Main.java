package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    static int a,choice;
    static String userName,pass;
    static String t="true",f="false";
    static Scanner sc;
    static String ans;
    static String username;
    static String password;
    static String conpassword;
    static int contact;
    Login ld;
    Registration rd;
    static AdminController a1=new AdminController();
    static CustomerController c1=new CustomerController();
    static AdminDB adminDao=new AdminDB();

    String loginDetail()
    {
        System.out.println("---LOGIN as ADMIN--");
        sc=new Scanner(System.in);
        System.out.println("Enter the UserName");
        username=sc.next();
        System.out.println("Enter the Password");
        password=sc.next();
        ld=new Login();
        ld.setUsername(username);
        ld.setPassword(password);
        boolean b1=a1.loginController(ld);
        if(b1==true)
            return t;
        else
            return f;
    }

//    String LoginDetailCustomer()
//    {
//        System.out.println("---LOGIN as CUSTOMER---");
//        sc=new Scanner(System.in);
//        System.out.println("Enter the UserName");
//        username=sc.next();
//        System.out.println("Enter the Password");
//        password=sc.next();
//        ld=new Login();
//        ld.setUsername(username);
//        ld.setPassword(password);
//        boolean b1=c1.LoginController(ld);
//        if(b1==true)
//            return t;
//        else
//            return f;
//    }

//    String RegDetail()
//    {
//        System.out.println("---REGISTER AS CUSTOMER--");
//        sc=new Scanner(System.in);
//        System.out.println("Enter the UserName");
//        username=sc.next();
//        System.out.println("Enter the ContactNumber");
//        contact=sc.nextInt();
//        System.out.println("Enter the Password");
//        password=sc.next();
//        System.out.println("Enter the Password again");
//        conpassword=sc.next();
//        if(password.equals(conpassword))
//        {
//            rd=new Registration();
//            rd.setUsername(username);
//            rd.setContact(contact);
//            rd.setPassword(password);
//            rd.setConfirmPassword(conpassword);
//            boolean b1=c1.RegisterController(rd);
//            if(b1==true)
//                return t;
//            else
//                return f;
//        }
//        else
//        {
//            return "Password doesn't matches ConfirmPassword";
//        }
//
//    }

    int showMenu()
    {
        int ch;
        System.out.println("Menu :-");
        System.out.println("---------------Welcome Admin----------------");
        System.out.println("1.Press '1' to Add a pizza\n2.Press '2' to Update a pizza\n3.Press '3' to Delete a pizza\n4.Press '4' to Show all pizza");
        sc=new Scanner(System.in);
        System.out.println("Enter choice");
        ch=sc.nextInt();
        return(ch);
    }

    int showMenuCustomer()
    {
        int ch;
        System.out.println("Menu :-");
        System.out.println("---------------Welcome Customer----------------");
        System.out.println("1.Press '1' to View All Pizza\n2.Press '2' To place an Order\n3.Press '3' To view Order Placed\n4.Press '4' To genereate the bill");
        sc=new Scanner(System.in);
        System.out.println("Enter choice");
        ch=sc.nextInt();
        return(ch);
    }

    public static void main(String args[]) throws java.sql.SQLException, java.lang.ClassNotFoundException
    {
        System.out.println("-------PIZZA ORDER SYSTEM--------");
        sc=new Scanner(System.in);
        Main pr=new Main();
        System.out.println("Press 1 if you are an Administrator");
        System.out.println("Press 2 if you are an Customer");
        a=sc.nextInt();
        switch(a)
        {
            case 1:

                System.out.println("You choose Administrator");
                //String str=pr.loginDetail();

//                if(str.equals(t))
//                {
                    do
                    {
                        choice=pr.showMenu();
                        switch(choice)
                        {
                            case 1:
                                a1.addPizza();
                                break;
                            case 2:
                                a1.updatePizza();
                                break;
                            case 3:
                                a1.deletePizza();
                                break;
                            case 4:
                                a1.showAllPizza();
                                break;
                            default:
                                System.out.println("Not Allowed");
                                break;
                        }

                        System.out.println("Do you want to continue : (Y/N)");
                        ans=sc.next();
                    }while(ans.equals("Y") || ans.equals("y"));

                break;


            case 2:
                System.out.println("You choose Customer");
                do
                {
                    System.out.println("You choose to:\n1.LOGIN\n2.REGISTER");
                    int ch=sc.nextInt();
                    if(ch==1)
                    {
                        //String st=pr.LoginDetailCustomer();
                        do
                        {
                                choice=pr.showMenuCustomer();
                                switch(choice)
                                {
                                    case 1:
                                        c1.showAllBurgers();
                                        break;
                                    case 2:
                                        c1.placeOrder();
                                        break;
                                    case 3:
                                        c1.viewOrder();
                                        break;
                                    case 4:
                                        c1.genBill();
                                        break;
                                    default:
                                        System.out.println("Not Allowed");
                                        break;
                                }

//                           else
//                                break;
                            System.out.println("Do you want to continue : (Y/N)");
                            ans=sc.next();
                        }while(ans.equals("Y") || ans.equals("y"));
                    }

                    else if(ch==2)
                    {
                        //String st2=pr.RegDetail();
                        //if(st2.equals(t))
                        {
                            System.out.println("You may now LOGIN as CUSTOMER");
                        }
                        //else
                            //System.out.println(st2);
                    }
                    else
                        System.out.println("Invalid Choice");

                    System.out.println("Do you want to continue as CUSTOMER : (Y/N)");
                    ans=sc.next();
                }while(ans.equals("Y") || ans.equals("y"));
                break;

            default:
                System.out.println("Not Allowed");
                break;
        }

        System.out.println("Exit");


    }
}

