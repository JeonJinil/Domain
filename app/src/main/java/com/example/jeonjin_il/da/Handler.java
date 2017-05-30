package com.example.jeonjin_il.da;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class Handler {

    ArrayList<Integer> makeLiftReservation(Ticket t , Activity act){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(t.isfull())
            return ret;

        ret.add(new Integer(1));
        ret.add(new Integer(2));
        ret.add(new Integer(3));
        t.createLiftReservation();
        return ret;
    }

    public ArrayList<Lift> enterLevel(Ticket t,int liftLevel,Activity act) {
        ArrayList<Lift> ret = new ArrayList<Lift>();

        t.enterLevel(liftLevel);
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        ret = db.getLiftByLevel(liftLevel);
        return ret;
    }

    public void enterName(Ticket t,String liftName) {
        t.enterName(liftName);
    }

    public void enterTime(Ticket t, float time) {
        t.enterTime(time);
    }

    public ArrayList<TicketPrice> buyTicket(Activity act) {
        ArrayList<TicketPrice> ret ;
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        ret = db.getTicketDescription();

        return ret;
    }

    public int enterTicket(String date, String type, int price,User u) {
        return u.makeTicket(date,type,price);
    }

    public String serialNoGen(){ //원래는 외부 시스템이여야하나 지금은 여기 구현
        Random r = new Random();
        String ret= "";
        for(int i=0;i<10;i++) {
            char c = (char)((r.nextInt(128 - 32)) + 32);
            ret += String.valueOf(c);
        }
        return ret;
    }

    public int endSale(User u) {
        int ret=u.getTotal();
        return ret;
    }

    public boolean makePayMent(User u) {
        return u.makePayMent();
    }

    public int getSubTotal(User u) {
        return u.getSubTotal(u.getBasket());
    }
}
