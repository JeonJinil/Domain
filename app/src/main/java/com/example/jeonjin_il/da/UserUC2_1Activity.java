package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserUC2_1Activity extends AppCompatActivity {
    Handler handler;
    EditText text1,text2,text3,text4;
    User u;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_uc2_1);
        u = (User)getIntent().getSerializableExtra("user");
        handler = Handler.getInstance();

        text1 = (EditText)findViewById(R.id.UC2text1);
        text2 = (EditText)findViewById(R.id.UC2text2);
        text3 = (EditText)findViewById(R.id.UC2text3);
        text4 = (EditText)findViewById(R.id.UC2text4);



        btn = (Button)findViewById(R.id.UC2btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serialNumber = text1.getText().toString()+text2.getText().toString()+text3.getText().toString()+text4.getText().toString();
                boolean state = handler.registerTicket(serialNumber,u);
                if(state)
                    Toast.makeText(getApplication(),"티켓 등록을 완료하였습니다.",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplication(),"티켓 등록을 하지 못하였습니다.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),UserMainActivty.class);
                intent.putExtra("u",u);
                startActivity(intent);
            }
        });

    }
}
