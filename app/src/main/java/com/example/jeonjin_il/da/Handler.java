package com.example.jeonjin_il.da;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class Handler {
    final int OPEN =  1;
    final int CLOSE = 0;
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

    public ArrayList<String> ManageLift() {
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("REGISTER LIFT");
        ret.add("OPEN LIFT");
        ret.add("CLOSE LIFT");
        return ret;
    }

    public void RegisterLift(String LiftName, int LiftLevel, int LiftLength, int LiftSpeed,Activity act) {
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        db.Lift_Insert(LiftName,LiftLevel,LiftLength,LiftSpeed, OPEN);
    }

    public void changeLiftState(int liftId, int state, Activity act) {
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        if(state == OPEN)
            db.changeLiftState(liftId,CLOSE);
        else
            db.changeLiftState(liftId,OPEN);
    }

    public ArrayList<Lift> openLift(int state,Activity act) {
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        return db.getLiftByState(state);
    }

    public ArrayList<Lift> closeLift(int state, Activity act) {
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        return db.getLiftByState(state);
    }
}
