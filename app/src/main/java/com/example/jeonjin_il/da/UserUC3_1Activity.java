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

        handler = new Handler();
        liftlevel = handler.makeLiftReservation(u.getTicket(),this);
        if( liftlevel.size() == 0) {
            Toast.makeText(getApplicationContext(),"예약이 2개 다 찾습니다.",Toast.LENGTH_LONG).show();
            this.finish();
        }



        lm = (LinearLayout) findViewById(R.id.ll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        // 동적 버튼 생성 (level 버튼생성)
        for (int j = 0; j < liftlevel.size(); j++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            final Button btn = new Button(this);
            btn.setId(j + 1);
            btn.setTextSize(30);
            btn.setText("난이도 :  "+liftlevel.get(j)+" ");
            btn.setLayoutParams(params);

            final int position = j;

            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),UserUC3_2Activity.class);
                    intent.putExtra("user",u);
                    intent.putExtra("liftLevel",liftlevel.get(position));
                    startActivity(intent);
                }
            });
            ll.addView(btn);
            lm.addView(ll);
        }
    }

}
