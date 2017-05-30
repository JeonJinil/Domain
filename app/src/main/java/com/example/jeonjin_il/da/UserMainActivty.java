package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class UserMainActivty extends AppCompatActivity {

    User u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermain_activty);

        u = (User) getIntent().getSerializableExtra("u");
        if(u == null)
            u = new User(getIntent().getStringExtra("id"),getIntent().getStringExtra("pw"));

        Toast.makeText(getApplicationContext(),"User id : "+u.getId()+"  User pw : "+u.getPw(),Toast.LENGTH_SHORT).show();
        findViewById(R.id.userbtn1).setOnClickListener(listener1);
        findViewById(R.id.userbtn2).setOnClickListener(listener2);
        findViewById(R.id.userbtn3).setOnClickListener(listener3);
        findViewById(R.id.userbtn4).setOnClickListener(listener4);
        findViewById(R.id.userbtn5).setOnClickListener(listener5);
    }
    Button.OnClickListener listener1 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),UserUC1_1Activity.class);
            intent.putExtra("user",u);
            startActivity(intent);
        }
    };
    Button.OnClickListener listener2 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

        }
    };
    Button.OnClickListener listener3 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),UserUC3_1Activity.class);
            intent.putExtra("user",u);
            startActivity(intent);
        }
    };
    Button.OnClickListener listener4 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            ArrayList<Ticket> temp = u.getBuyTicket();
            for(int i=0;i<temp.size();i++)
                Toast.makeText(getApplication(),temp.get(i).getSerialNumber() + temp.get(i).getDate() + temp.get(i).getTimeType(),Toast.LENGTH_SHORT).show();
        }
    };
    Button.OnClickListener listener5 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            LiftReservation[] l = u.getTicket().getLiftReservation();
            if(l[0] == null)
                Toast.makeText(getApplication(),"예약한 리프트가 없습니다.",Toast.LENGTH_SHORT).show();
            if(l[0] != null)
                Toast.makeText(getApplication(),"첫번째 예약 리프트 이름 : "+l[0].getLiftname()+" 시간 : "+l[0].getLiftTime(),Toast.LENGTH_SHORT).show();
            if(l[1] != null)
                Toast.makeText(getApplication(),"두번째 예약 리프트 이름 : "+l[1].getLiftname()+" 시간 : "+l[1].getLiftTime(),Toast.LENGTH_SHORT).show();
        }
    };
}
