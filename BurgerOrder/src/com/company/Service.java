package com.company;

import java.util.ArrayList;

public class Service {
    private static AdminDB adao=new AdminDB();


    public boolean validLogin(Login ld)
    {
        return adao.isLogin(ld);
    }


    public int validAdd(Burger br)
    {
        int i=0;
        try
        {
            if(br==null)
            {
                throw new NullPointerException();
            }
            else if(br.getBurgerId()<=0)
            {
                throw new InvalidIdException();
            }
            else if(br.getBurgerName().equals(null) || br.getBurgerName().equals(" ") || br.getBurgerName().matches(".*\\d.*"))
            {
                throw new InvalidNameException();
            }
            else if(!(br.getBurgerType().equals("veg")) && !(br.getBurgerType().equals("non-veg")))
            {
                throw new InvalidTypeException();
            }
            else if(!(br.getBurgerSize().equals("R")) && !(br.getBurgerSize().equals("M")) && !(br.getBurgerSize().equals("L")))
            {
                throw new InvalidSizeException();
            }
            else
                i=adao.addBurgerDB(br);
        }
        catch(NullPointerException npe)
        {
            return (0);
        }
        catch(InvalidIdException ine)
        {
            ine.idInvalid();
        }
        catch(InvalidNameException ine)
        {
            ine.nameInvalid();
        }
        catch(InvalidTypeException ine)
        {
            ine.typeInvalid();
        }
        catch(InvalidSizeException ine)
        {
            ine.sizeInvalid();
        }
        return i;
    }


    public ArrayList validDisplay()
    {
        return adao.getAllBurger();

    }

    public boolean validUpdate(Burger pz,int pzId)
    {
        try
        {
            if(pz==null)
            {
                throw new NullPointerException();
            }
            return adao.updateBurgerDataDB(pz,pzId);
        }
        catch(NullPointerException npe)
        {
            return false;
        }
    }

    public int checkBurger(int pzId)
    {
        return adao.checkBurgerId(pzId);

    }



    public int validDelete(int pzId)
    {

        try
        {
            Burger pz=adao.getBurger(pzId);
            if(pz==null)
            {
                throw new NullPointerException();
            }
            return adao.deleteBurgerDB(pzId);

        }
        catch(NullPointerException npe)
        {
            return 0;
        }

    }
}
