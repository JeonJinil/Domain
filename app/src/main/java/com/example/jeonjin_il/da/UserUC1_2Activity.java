package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserUC1_2Activity extends AppCompatActivity {
    User u;
    Handler handler;
    TextView tx1,tx2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_uc1_2);
        u = (User)getIntent().getSerializableExtra("user");
        handler = Handler.getInstance();
        tx1 = (TextView)findViewById(R.id.uc1_2text1);
        tx2 = (TextView)findViewById(R.id.uc1_2Text2);
        btn = (Button)findViewById(R.id.uc1_2btn1);



        int price = handler.endSale(u);

        ArrayList<Ticket> tickets = u.tempBuyTicket();
        tx1.setText(String.valueOf(price)+"WON");

        String temp="";
        for(int i=0;i<tickets.size();i++)
            temp += (tickets.get(i).getDate()+" " + tickets.get(i).getTimeType()+" " + String.valueOf(tickets.get(i).getPrice())+"WON")+"\n";
        Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();
        tx2.setText(temp);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(handler.makePayMent(u)) {
                    Toast.makeText(getApplicationContext(), "결제 성공 하였습니다.", Toast.LENGTH_SHORT).show();
                    u.finishPay();
                    Intent intent = new Intent(getApplicationContext(),UserMainActivty.class);
                    intent.putExtra("u",u);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(),"결제 실패 하였습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
