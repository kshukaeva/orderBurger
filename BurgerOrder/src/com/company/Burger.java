package com.company;

public class Burger {
    private int BurgerId;
    private String BurgerName;
    private String BurgerSize;
    private float BurgerPrice;
    private String BurgerType;

    public Burger() {
        super();
    }
    Burger(int BurgerId, String BurgerName, String BurgerSize, float BurgerPrice,
              String BurgerType) {
        super();
        this.BurgerId = BurgerId;
        this.BurgerName = BurgerName;
        this.BurgerSize = BurgerSize;
        this.BurgerPrice = BurgerPrice;
        this.BurgerType = BurgerType;
    }
    public int getBurgerId() {
        return BurgerId;
    }
    public void setBurgerId(int BurgerId) {
        this.BurgerId = BurgerId;
    }
    public String getBurgerName() {
        return BurgerName;
    }
    public void setBurgerName(String BurgerName) {
        this.BurgerName = BurgerName;
    }
    public String getBurgerSize() {
        return BurgerSize;
    }
    public void setBurgerSize(String BurgerSize) {
        this.BurgerSize = BurgerSize;
    }
    public float getBurgerPrice() {
        return BurgerPrice;
    }
    public void setBurgerPrice(float BurgerPrice) {
        this.BurgerPrice = BurgerPrice;
    }
    public String getBurgerType() {
        return BurgerType;
    }
    public void setBurgerType(String BurgerType) {
        this.BurgerType = BurgerType;
    }

    public String toString()
    {
        return ("Burger id :"+BurgerId+"\nBurger name :"+BurgerName+"\nBurger type :"+BurgerType+"\nBurger size :"+BurgerSize+"\nBurger price :"+BurgerPrice+"\n");

    }

}

