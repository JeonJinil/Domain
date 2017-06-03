package com.example.jeonjin_il.da;

/**
 * Created by jeonjin-il on 2017. 6. 3..
 */

public class TicketAdapter {

    public String registerTicket(String serialNumber) {
        String ret ="";
        String ticketdate = "06-11";
        String type = "afternoon";
        String price = "50000";
        ret = ticketdate+":"+type +":"+ price;
        return ret;
    }
}
