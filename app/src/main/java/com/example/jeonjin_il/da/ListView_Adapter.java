package com.example.jeonjin_il.da;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class ListView_Adapter extends BaseAdapter{
    private ArrayList<Lift> m_List;
    private User u;
    public ListView_Adapter(ArrayList<Lift> lifts,User u) {
        this.m_List = lifts;
        this.u = u;
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
                    Intent intent = new Intent(context,UserUC3_3Activity.class);
                    Lift l = m_List.get(position);
//                    Toast.makeText(context.getApplicationContext(),l.getLiftName(),Toast.LENGTH_SHORT).show();
                    intent.putExtra("l",l);
                    intent.putExtra("u",u);
                    context.startActivity(intent);

                }
            });
        }

        return convertView;
    }

}
