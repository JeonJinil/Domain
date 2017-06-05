package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AdminMainActivity extends AppCompatActivity {
    Handler handler;
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        handler = Handler.getInstance();
        ArrayList<String> functionList = handler.ManageLift();

        btn1 = (Button)findViewById(R.id.adbtn1);
        btn2 = (Button)findViewById(R.id.adbtn2);
        btn3 = (Button)findViewById(R.id.adbtn3);

        btn1.setText(functionList.get(0));
        btn2.setText(functionList.get(1));
        btn3.setText(functionList.get(2));


        //1버튼이 눌리는 것이 RegisterLift 자체인데?
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdminUC5_1Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdminUC5_2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdminUC5_3Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
