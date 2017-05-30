package com.example.jeonjin_il.da;

import java.io.Serializable;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class TimeBlock implements Serializable {
    private static final long serialVersionUID = 123124124124125L;

    private float time;
    private int capacity;

    public TimeBlock(float time,int capacity) {
        this.time = time;
        this.capacity = capacity;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    boolean isfull(){
        return capacity<2 ? false:true;
    }

    public void increase() {
        this.capacity++;
    }
}
