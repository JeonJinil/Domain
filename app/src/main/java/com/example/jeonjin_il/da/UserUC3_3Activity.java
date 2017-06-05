package com.example.jeonjin_il.da;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class UserUC3_3Activity extends AppCompatActivity {
    User u;
    Lift l;
    Handler handler;
    LinearLayout lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_uc3_3);

        u = (User) getIntent().getSerializableExtra("u");
        l = (Lift) getIntent().getSerializableExtra("l");
        handler = Handler.getInstance();
        TextView t = (TextView)findViewById(R.id.uc3_3text2);
        t.setText(l.getLiftName());

        handler.enterName(u.getTicket(),l.getLiftName());
        Toast.makeText(getApplicationContext(),u.getId()+l.getLiftName(),Toast.LENGTH_SHORT).show();


        lm = (LinearLayout) findViewById(R.id.ll2);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        // 동적 버튼 생성 (level 버튼생성)
        for (int j = 0; j < 48; j++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            final Button btn = new Button(this);
            btn.setId(j + 1);
            btn.setTextSize(20);
            btn.setGravity(Gravity.CENTER);
            btn.setText("시간 : " + l.getTimeblock().get(j).getTime() +" 가능 인원 : " +l.getTimeblock().get(j).getCapacity()+" / "+"2");
            btn.setLayoutParams(params);

            final int position = j;
            final Activity act = this;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(l.getTimeblock().get(position).isfull()) {
                        Toast.makeText(getApplicationContext(), "선택한 시간에 예약이 이미 가득 찼습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        handler.enterTime(u.getTicket(), l.getTimeblock().get(position).getTime());
                        l.increaseCapacity(l.getTimeblock().get(position).getTime(), act);
                        Toast.makeText(getApplicationContext(), "완료 되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), UserMainActivty.class);
                        intent.putExtra("u", u);
                        startActivity(intent);
                        finish();
                    }
                }
            });
            ll.addView(btn);
            lm.addView(ll);
        }

    }
}
