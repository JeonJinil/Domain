package com.example.jeonjin_il.da;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AdminUC5_2Activity extends AppCompatActivity {
    Handler handler;
    final int OPEN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_uc5_2);

        ArrayList<Lift> lifts = handler.openLift(OPEN,this);

        ListView listView = (ListView) findViewById(R.id.uc5_2list);
        LiftOpen_Adapter adapter = new LiftOpen_Adapter(lifts,this);
        listView.setAdapter(adapter);
    }
}
