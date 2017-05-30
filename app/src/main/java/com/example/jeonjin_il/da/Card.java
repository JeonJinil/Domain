package com.example.jeonjin_il.da;

import java.io.Serializable;

/**
 * Created by jeonjin-il on 2017. 5. 29..
 */

public class Card implements Serializable {
    private String cardNo;
    private int vaildMonth;
    private int vaildYear;
    private int balance;

    public Card(String cardNo, int vaildMonth, int vaildYear,int balance) {
        this.cardNo = cardNo;
        this.vaildMonth = vaildMonth;
        this.vaildYear = vaildYear;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getVaildMonth() {
        return vaildMonth;
    }

    public void setVaildMonth(int vaildMonth) {
        this.vaildMonth = vaildMonth;
    }

    public int getVaildYear() {
        return vaildYear;
    }

    public void setVaildYear(int vaildYear) {
        this.vaildYear = vaildYear;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
