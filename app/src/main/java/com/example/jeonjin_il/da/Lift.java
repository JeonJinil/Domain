package com.example.jeonjin_il.da;

import android.app.Activity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class Lift implements Serializable {
    private static final long serialVersionUID = 123124124124121L;
    private int liftId;
    private int liftLevel;
    private String liftName;
    private int liftLength;
    private int liftSpeed;
    private int state; // true : open , false : close (DB 에 boolean 이 없음)
    private ArrayList<TimeBlock> timeblock;
    public Lift(int liftId,int liftLevel, String liftName, int liftLength, int liftSpeed,int state,ArrayList<TimeBlock> timeblock) {
        this.liftId = liftId;
        this.liftLevel = liftLevel;
        this.liftName = liftName;
        this.liftLength = liftLength;
        this.liftSpeed = liftSpeed;
        this.timeblock = timeblock;
        this.state = state;
    }

    public int isOpen() { return state;}

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public ArrayList<TimeBlock> getTimeblock() {
        return timeblock;
    }

    public int getLiftLevel() {
        return liftLevel;
    }

    public void setLiftLevel(int liftLevel) {
        this.liftLevel = liftLevel;
    }

    public String getLiftName() {
        return liftName;
    }

    public void setLiftName(String liftName) {
        this.liftName = liftName;
    }

    public int getLiftLength() {
        return liftLength;
    }

    public void setLiftLength(int liftLength) {
        this.liftLength = liftLength;
    }

    public int getLiftSpeed() {
        return liftSpeed;
    }

    public void setLiftSpeed(int liftSpeed) {
        this.liftSpeed = liftSpeed;
    }

    public void increaseCapacity(float time, Activity act) {
        int turn = (int) (time*2);
        if((int)time == time)
            turn = (int) (time*2+0.4);
        timeblock.get(turn).increase();
        DBHandler db = new DBHandler(act.getApplicationContext(),"SNL.db",null,1);
        db.increase(timeblock.get(turn).getCapacity(),liftId,time);
    }
}
