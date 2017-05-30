package com.example.jeonjin_il.da;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2017. 5. 29..
 */

public class TicketPrice_Adapter extends BaseAdapter {
    private ArrayList<TicketPrice> lifts;
    private User u;
    Handler handler;
    int TotalPrice ;
    TextView tx;
    public TicketPrice_Adapter(ArrayList<TicketPrice> lifts, User u, TextView textview) {
        this.lifts = lifts;
        this.u = u;
        handler = new Handler();
        TotalPrice=0;
        tx = textview;
    }
    @Override
    public int getCount() {
        return lifts.size();
    }

    @Override
    public Object getItem(int position) {
        return lifts.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if ( convertView == null ) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ticketprice_item, parent, false);

//            System.out.print(lifts.get(position).getLiftName() + lifts.get(position).getLiftLevel());
            TextView text = (TextView) convertView.findViewById(R.id.tpText1);
            text.setText(lifts.get(position).getDay());
            Button btn1 = (Button) convertView.findViewById(R.id.tpBtn1);
            Button btn2 = (Button) convertView.findViewById(R.id.tpBtn2);
            Button btn3 = (Button) convertView.findViewById(R.id.tpBtn3);
            btn1.setText(lifts.get(position).getPrice1()+"won");
            btn2.setText(lifts.get(position).getPrice2()+"won");
            btn3.setText(lifts.get(position).getPrice3()+"won");

            btn1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    TotalPrice += handler.enterTicket(lifts.get(position).getDay(),"Morning",lifts.get(position).getPrice1(),u);
                    tx.setText(TotalPrice+"WON");
                    Toast.makeText(context.getApplicationContext(),lifts.get(position).getDay()+" "+lifts.get(position).getPrice1()+"장바구니에 추가 하였습니다.",Toast.LENGTH_SHORT).show();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    TotalPrice += handler.enterTicket(lifts.get(position).getDay(),"Afternoon",lifts.get(position).getPrice2(),u);
                    tx.setText(TotalPrice+"WON");
                    Toast.makeText(context.getApplicationContext(),lifts.get(position).getDay()+" "+lifts.get(position).getPrice2()+"장바구니에 추가 하였습니다.",Toast.LENGTH_SHORT).show();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    TotalPrice += handler.enterTicket(lifts.get(position).getDay(),"Night",lifts.get(position).getPrice3(),u);
                    tx.setText(TotalPrice+"WON");
                    Toast.makeText(context.getApplicationContext(),lifts.get(position).getDay()+" "+lifts.get(position).getPrice3()+"장바구니에 추가 하였습니다.",Toast.LENGTH_SHORT).show();
                }
            });

        }

        return convertView;
    }

}
