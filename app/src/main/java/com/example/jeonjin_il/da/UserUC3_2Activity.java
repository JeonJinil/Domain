package com.example.jeonjin_il.da;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserUC3_2Activity extends AppCompatActivity {
    User u;
    int liftLevel;
    Handler handler;
    ArrayList<Lift> Lifts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_uc3_2);

        handler = new Handler();
        u = (User)getIntent().getSerializableExtra("user");
        liftLevel = getIntent().getIntExtra("liftLevel",1);
        Lifts = handler.enterLevel(u.getTicket(),liftLevel,this);

        ListView listView = (ListView) findViewById(R.id.listview);
        ListView_Adapter adapter = new ListView_Adapter(Lifts,u);
        listView.setAdapter(adapter);
    }
}
