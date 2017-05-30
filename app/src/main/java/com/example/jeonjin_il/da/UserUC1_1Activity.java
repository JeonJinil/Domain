package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserUC1_1Activity extends AppCompatActivity {
    User u;
    Handler handler;
    ArrayList<TicketPrice> desc;
    Button btn;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_uc1_1);

        u = (User)getIntent().getSerializableExtra("user");
        textview = (TextView)findViewById(R.id.uc1_1Text1);
        handler = new Handler();
        desc = handler.buyTicket(this);
        u.makeBasket();

        btn = (Button)findViewById(R.id.uc1_1btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textview.getText().toString().equals("0WON")) {
                    Intent intent = new Intent(getApplicationContext(),UserUC1_2Activity.class);
                    intent.putExtra("user",u);
                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),"상품을 골라주세요",Toast.LENGTH_SHORT).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.tklist);
        TicketPrice_Adapter adapter = new TicketPrice_Adapter(desc,u,textview);
        listView.setAdapter(adapter);

    }




}
