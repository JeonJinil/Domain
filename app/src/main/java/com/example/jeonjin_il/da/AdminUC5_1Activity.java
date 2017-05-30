package com.example.jeonjin_il.da;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.sql.Types.INTEGER;
import static java.sql.Types.TIME;

public class AdminUC5_1Activity extends AppCompatActivity {
    Handler handler;
    EditText ed1,ed2,ed3,ed4;
    Button btn;
    Activity act ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_uc5_1);
        handler = new Handler();
        act = this;

        ed1 = (EditText)findViewById(R.id.uc5_1edit1);
        ed2 = (EditText)findViewById(R.id.uc5_1edit2);
        ed3 = (EditText)findViewById(R.id.uc5_1edit3);
        ed4 = (EditText)findViewById(R.id.uc5_1edit4);
        btn = (Button)findViewById(R.id.uc5_1btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String liftName = ed1.getText().toString();
                int liftLevel = Integer.parseInt(ed2.getText().toString());
                int liftLength = Integer.parseInt(ed3.getText().toString());
                int liftSpeed = Integer.parseInt(ed4.getText().toString());
                handler.RegisterLift(liftName,liftLevel,liftLength,liftSpeed,act);

                Toast.makeText(getApplicationContext(),"리프트 등록을 완료 하였습니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),AdminMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
