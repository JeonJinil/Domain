package com.example.jeonjin_il.da;

import java.io.Serializable;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class Ticket implements Serializable {
    private String serialNumber;
    private String date;
    private String timeType;
    private int price;
    private LiftReservation liftReservation[];
    private LiftReservation r;


    public Ticket(String serialNumber, String date, String timeType, int price) {
        this.serialNumber = serialNumber;
        this.date = date;
        this.timeType = timeType;
        this.price = price;
        liftReservation = new LiftReservation[2];
    }

    public boolean isfull(){
        if(liftReservation[1] != null)
            return true;
        return false;
    }
    public void createLiftReservation(){
        r = new LiftReservation();
    }

    public void enterLevel(int liftLevel) {
        r.setLiftLevel(liftLevel);
    }

    public void enterName(String liftName) { r.setLiftname(liftName);}

    public void enterTime(float lifttime) {
        r.setLiftTime(lifttime);
        if(liftReservation[0] == null)
            liftReservation[0] = r;
        else
            liftReservation[1] = r;
    }

    public LiftReservation[] getLiftReservation() {
        return liftReservation;
    }


    //getter
    public String getSerialNumber() {
        return serialNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTimeType() {
        return timeType;
    }

    public int getPrice() {
        return price;
    }

    public LiftReservation getR() {
        return r;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLiftReservation(LiftReservation[] liftReservation) {
        this.liftReservation = liftReservation;
    }

    public void setR(LiftReservation r) {
        this.r = r;
    }
}

