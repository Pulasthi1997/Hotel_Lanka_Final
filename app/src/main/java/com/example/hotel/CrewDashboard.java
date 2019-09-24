package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CrewDashboard extends AppCompatActivity {

    LinearLayout linearLayout1,linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_dashboard); linearLayout1=findViewById(R.id.layout1);
        linearLayout2=findViewById(R.id.layout2);

    }

    public void ChangePage(View view){
        if(view==linearLayout1){
            Intent intent=new Intent(CrewDashboard.this,HotelList.class);
            startActivity(intent);
        }else if(view==linearLayout2){
            Intent intent=new Intent(CrewDashboard.this,CrewFeedback.class);
            startActivity(intent);
        }
    }
}
