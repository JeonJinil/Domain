package com.example.jeonjin_il.da;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AdminUC5_3Activity extends AppCompatActivity {
    Handler handler;
    final int OPEN = 1;
    final int CLOSE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_uc5_3);

        handler = Handler.getInstance();
        ArrayList<Lift> lifts = handler.closeLift(CLOSE,this);

        ListView listView = (ListView) findViewById(R.id.uc5_3list);
        LiftState_Adapter adapter = new LiftState_Adapter(lifts,CLOSE,this);
        listView.setAdapter(adapter);
    }
}
