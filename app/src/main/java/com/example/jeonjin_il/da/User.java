package com.example.jeonjin_il.da;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class User implements Serializable{
    private static final long serialVersionUID = 123124124124124L;

    private String id;
    private String pw;
    private Ticket ticket;
    private Basket basket;
    private Card card;
    private ArrayList<Ticket> TicketBox;   //구입한 티켓들

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
        //ticket = new Ticket("testserialNo","06-01","Afternoon",10000); //임시생성
        card = new Card("1234-1234-1234-1234",12,20,10000000);   // 이미 카드가지고 있다고 가정
        TicketBox = new ArrayList<Ticket>();
    }

    boolean hasTicket(){
        return ticket == null ? false: true;
    }

    public void finishPay(){
        ArrayList<Ticket> temp = basket.getTicket();
        for(int i=0;i<temp.size();i++) {
            temp.get(i).setSerialNumber(serialNoGen());
            TicketBox.add(temp.get(i));
        }
        basket = null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void makeBasket() {
        basket = new Basket();
    }

    public boolean makeTicket(String serial, String date, String timeType, String price) {
        ticket = new Ticket(serial,date,timeType,Integer.valueOf(price));
        return true;
    }
    public int makeTicket( String date, String timeType, int price) {
        Ticket t = new Ticket("",date,timeType, price);

        return basket.add(t);
    }

    public int getTotal() {
        int ret = basket.getTotal();
        return ret;
    }

    public Card getCard() {
        return card;
    }

    public ArrayList<Ticket> getBuyTicket() {
        return TicketBox;
    }
    public ArrayList<Ticket> tempBuyTicket(){
        return basket.getTicket();
    }

    public String serialNoGen(){ //원래는 외부 시스템이여야하나 지금은 여기 구현
        Random r = new Random();
        String ret= "";
        for(int i=0;i<12;i++) {
            char c = (char)((r.nextInt(10)) + 48);
            ret += String.valueOf(c);
        }
        return ret;
    }

    public boolean makePayMent() {
        Payment p = new Payment();
        return p.pay(card);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setBuyTicket(ArrayList<Ticket> buyTicket) {
        this.TicketBox = buyTicket;
    }

    public int getSubTotal(Basket basket) {
        return basket.getSubTotal();
    }
}
