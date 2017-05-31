package com.example.jeonjin_il.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText idtext;
    EditText pwtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idtext = (EditText)findViewById(R.id.loginId);
        pwtext = (EditText)findViewById(R.id.loginPw);
        findViewById(R.id.loginbtn).setOnClickListener(clickListener);
        DBInit();
    }
    Button.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String id = idtext.getText().toString();
            String pw = pwtext.getText().toString();
            if(id.equals("test")  && pw.equals("123")) {
                Intent intent = new Intent(MainActivity.this, UserMainActivty.class);
                intent.putExtra("id",id);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }else if(id.equals("admin") && pw.equals("123")){
                Intent intent = new Intent(MainActivity.this, AdminMainActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }else
                Toast.makeText(getApplicationContext(),"아이디 비밀번호 확인해주세요.",Toast.LENGTH_LONG).show();
        }
    };

    public void DBInit(){
        DBHandler db = new DBHandler(getApplicationContext(),"SNL.db",null,1);
        if(db.needInti()){
            db.Lift_Insert("Mercury",1,1000,10,1);
//            db.Lift_Insert("Venus",3,500,50,1);
//            db.Lift_Insert("Mars",3,600,60,1);
//            db.Lift_Insert("Jupiter",1,1200,10,1);
//            db.Lift_Insert("Saturn",2,2000,40,1);
//            db.Lift_Insert("Uranus",2,600,30,1);
//            db.Lift_Insert("Neptune",3,560,60,1);
//            db.Lift_Insert("Pluto",2,1120,40,1);
//            db.Lift_Insert("Earth",1,1500,10,1);
//            db.Lift_Insert("Sun",3,900,60,1);


            db.ticketPrice_Insert("06-11",40000,50000,30000);
            db.ticketPrice_Insert("06-12",40000,50000,30000);
            db.ticketPrice_Insert("06-13",35000,45000,25000);
            db.ticketPrice_Insert("06-14",40000,50000,30000);
            db.ticketPrice_Insert("06-15",40000,50000,30000);
            db.ticketPrice_Insert("06-16",45000,55000,35000);
            db.ticketPrice_Insert("06-17",45000,55000,35000);


            Toast.makeText(getApplicationContext(),"테스트 데이타 들갓음",Toast.LENGTH_LONG).show();
        }
    }
}
