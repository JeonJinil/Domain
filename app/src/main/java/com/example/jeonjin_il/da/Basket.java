package com.example.jeonjin_il.da;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2017. 5. 28..
 */

public class Basket implements Serializable{
    ArrayList<Ticket> ticket;

    public Basket() {
        ticket = new ArrayList<Ticket>();
    }

    public ArrayList<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(ArrayList<Ticket> ticket) {
        this.ticket = ticket;
    }

    public int add(Ticket temp) {
        ticket.add(temp);
        int ret= 0;
        for(int i=0;i<ticket.size();i++)
            ret +=ticket.get(i).getPrice();
        return ret;
    }

    public int getTotal() {
        int ret= 0;
        for(int i=0;i<ticket.size();i++)
            ret +=ticket.get(i).getPrice();
        return ret;
    }

    public int getSubTotal() {
        int ret= 0;
        for(int i=0;i<ticket.size();i++)
            ret +=ticket.get(i).getPrice();
        return ret;
    }
}
