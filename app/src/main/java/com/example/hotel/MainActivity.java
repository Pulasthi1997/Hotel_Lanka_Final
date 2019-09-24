package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5,linearLayout7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1 = findViewById(R.id.mlayout1);
        linearLayout2 = findViewById(R.id.mlayout2);
        linearLayout3 = findViewById(R.id.mlayout3);
        linearLayout4 = findViewById(R.id.mlayout4);
        linearLayout5 = findViewById(R.id.mlayout5);
        linearLayout7 = findViewById(R.id.mlayout7);
    }

    public void ChangePage(View view) {
        if (view == linearLayout1) {
            Intent intent = new Intent(MainActivity.this, Hotel_Register.class);
            startActivity(intent);
        } else if (view == linearLayout2) {
            Intent intent = new Intent(MainActivity.this, HotelList.class);
            startActivity(intent);
        } else if (view == linearLayout3) {
            Intent intent = new Intent(MainActivity.this, Crew_Register.class);
            startActivity(intent);
        } else if (view == linearLayout4) {
            Intent intent = new Intent(MainActivity.this, CrewList.class);
            startActivity(intent);
        } else if (view == linearLayout5) {
            Intent intent = new Intent(MainActivity.this, ReclerView_config2.class);
            startActivity(intent);
        }  else if (view == linearLayout7) {
            Intent intent = new Intent(MainActivity.this, CrewDashboard.class);
            startActivity(intent);
        }
    }
}
