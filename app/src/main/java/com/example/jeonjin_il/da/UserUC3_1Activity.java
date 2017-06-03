package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class UserUC3_1Activity extends AppCompatActivity {
    User u;
    Handler handler;
    ArrayList<Integer> liftlevel;
    LinearLayout lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_uc3_1);

        u = (User)getIntent().getSerializableExtra("user");

        handler = Handler.getInstance();
        if(u.getTicket() == null){
            Toast.makeText(getApplicationContext(),"티켓을 등록해주세요.",Toast.LENGTH_LONG).show();
            this.finish();
        }
        else {
            liftlevel = handler.makeLiftReservation(u.getTicket(), this);
            if (liftlevel.size() == 0) {
                Toast.makeText(getApplicationContext(), "예약이 2개 다 찾습니다.", Toast.LENGTH_LONG).show();
                this.finish();
            }


            Button btn1 = (Button) findViewById(R.id.uc3_1btn1);
            Button btn2 = (Button) findViewById(R.id.uc3_1btn2);
            Button btn3 = (Button) findViewById(R.id.uc3_1btn3);
            btn1.setText(String.valueOf(liftlevel.get(0)));
            btn2.setText(String.valueOf(liftlevel.get(1)));
            btn3.setText(String.valueOf(liftlevel.get(2)));

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), UserUC3_2Activity.class);
                    intent.putExtra("user", u);
                    intent.putExtra("liftLevel", liftlevel.get(0));
                    startActivity(intent);
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), UserUC3_2Activity.class);
                    intent.putExtra("user", u);
                    intent.putExtra("liftLevel", liftlevel.get(1));
                    startActivity(intent);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), UserUC3_2Activity.class);
                    intent.putExtra("user", u);
                    intent.putExtra("liftLevel", liftlevel.get(2));
                    startActivity(intent);
                }
            });

        }
    }

}
