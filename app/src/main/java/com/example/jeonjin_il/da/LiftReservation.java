package com.example.jeonjin_il.da;

import java.io.Serializable;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class LiftReservation implements Serializable {
    private int liftLevel;
    private String liftname;
    private float liftTime;

    LiftReservation(){

    }

    public void setLiftLevel(int liftLevel) {
        this.liftLevel = liftLevel;
    }

    public void setLiftname(String liftname) {
        this.liftname = liftname;
    }

    public void setLiftTime(float liftTime) {
        this.liftTime = liftTime;
    }

    public int getLiftLevel() {
        return liftLevel;
    }

    public String getLiftname() {
        return liftname;
    }

    public float getLiftTime() {
        return liftTime;
    }
}
