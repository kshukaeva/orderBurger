package com.company;

public class Database {
    private static Burger burgers[]=new Burger[4];
    public static int count,flag,i,index;

    //to keep count of pizza
    public String addBurgerCount(Burger pizza_1)
    {
        if(count>=4)
        {
            return ("Can't add more pizza");
        }
        else
        {
            burgers[count]=pizza_1;
            //System.out.println("Pizza Name added :"+pizza[count].getPizzaName());
            count++;

            return ("Pizza "+count+" added Successfully");
        }
    }

    public boolean deleteBurgerCount(int burgerId)
    {
        flag=0;
        for(i=0;i<count;i++)
        {
            if(burgers[i]!=null && burgers[i].getBurgerId()==burgerId)
            {
                flag=1;
                index=i;
                //System.out.println("id found for deletion having index : "+index+" and count :"+count);
                break;
            }
        }
        if(flag==0)
        {
            return false;
        }
        else
        {	if(index==count-1)
        {
            burgers[index]=null;
            count--;
            //System.out.println("count :"+count);
            return true;
        }
        else
        {
            burgers[index]=null;
            for(i=index;i<count-1;i++)
            {
                burgers[i]=burgers[i+1];
            }
            burgers[i]=null;
            count=i;
            System.out.println("count :"+count);
            return true;
        }
        }
    }

    public Burger[] displayAllPizza()
    {
        System.out.println(burgers);
        return burgers;
    }

    public boolean updatePizzaData(Burger pz,int pzId)
    {
        for(int i=0;i<burgers.length;i++)
        {
            if(burgers[i]!=null && burgers[i].getBurgerId()==pzId)
            {
                burgers[i].setBurgerName(pz.getBurgerName());
                burgers[i].setBurgerType(pz.getBurgerType());
                burgers[i].setBurgerSize(pz.getBurgerSize());
                burgers[i].setBurgerPrice(pz.getBurgerPrice());
                return true;
            }
        }
        return false;

    }

    public boolean checkPizzaName(int pzId)
    {
        for(int i=0;i<burgers.length;i++)
        {
            if(burgers[i]!=null && burgers[i].getBurgerId()==pzId)
            {
                return true;
            }
        }
        return false;
    }

    public Burger getObject(int pzId)
    {
        for(int i=0;i<burgers.length;i++)
        {
            if(burgers[i]!=null && burgers[i].getBurgerId()==pzId)
            {
                return burgers[i];
            }
        }
        return null;
    }

}

