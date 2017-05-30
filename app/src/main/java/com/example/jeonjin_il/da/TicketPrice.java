package com.example.jeonjin_il.da;

import java.io.Serializable;

/**
 * Created by jeonjin-il on 2017. 5. 28..
 */

public class TicketPrice implements Serializable{
    private String day;
    private int price1;
    private int price2;
    private int price3;

    public TicketPrice(String day, int price1, int price2, int price3) {
        this.day = day;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public int getPrice3() {
        return price3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }
}
