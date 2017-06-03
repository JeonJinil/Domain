package com.example.jeonjin_il.da;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2017. 5. 31..
 */

public class LiftState_Adapter extends BaseAdapter {
    private ArrayList<Lift> m_List;
    private User u;
    Handler handler;
    int state ;
    final int OPEN = 1;
    final int CLOSE = 0;
    Activity act;
    public LiftState_Adapter(ArrayList<Lift> lifts,int state, Activity act) {
        this.m_List = lifts;
        handler = Handler.getInstance();
        this.state = state;
        this.act = act;
    }
    @Override
    public int getCount() {
        return m_List.size();
    }

    @Override
    public Object getItem(int position) {
        return m_List.get(position);
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
            convertView = inflater.inflate(R.layout.lift_item, parent, false);

            System.out.print(m_List.get(position).getLiftName() + m_List.get(position).getLiftLevel());

            TextView text1 = (TextView) convertView.findViewById(R.id.listText1);
            text1.setText("Lift Name : "+m_List.get(position).getLiftName());
            TextView text2 = (TextView) convertView.findViewById(R.id.listText2);
            text2.setText("Lift Level : "+String.valueOf(m_List.get(position).getLiftLevel()));
            TextView text3 = (TextView) convertView.findViewById(R.id.listText3);
            text3.setText("Lift Length : "+String.valueOf(m_List.get(position).getLiftLength()));
            TextView text4 = (TextView) convertView.findViewById(R.id.listText4);
            text4.setText("Lift Spped : "+String.valueOf(m_List.get(position).getLiftSpeed()));

            // 리스트 아이템을 터치 했을 때 이벤트 발생
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert_confirm = new AlertDialog.Builder(act);
                    if(state == OPEN) {
                        alert_confirm.setMessage("리프트를 닫으시겠습니까?").setCancelable(false).setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        handler.changeLiftState(m_List.get(position).getLiftId(),OPEN,act);
                                        Toast.makeText(context, "리프트를 닫았습니다.", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(context.getApplicationContext(),AdminMainActivity.class);
                                        context.startActivity(intent);
                                    }
                                }).setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        return;
                                    }
                                });
                        AlertDialog alert = alert_confirm.create();
                        alert.show();
                    }
                    else{
                        alert_confirm.setMessage("리프트를 여시겠습니까?").setCancelable(false).setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        handler.changeLiftState(m_List.get(position).getLiftId(),CLOSE,act);
                                        Toast.makeText(context, "리프트를 열었습니다.", Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(context.getApplicationContext(),AdminMainActivity.class);
                                        context.startActivity(intent);
                                    }
                                }).setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        return;
                                    }
                                });
                        AlertDialog alert = alert_confirm.create();
                        alert.show();
                    }



                }
            });
        }

        return convertView;
    }

}