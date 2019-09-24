package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class HotelList extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView_Hotel);

        new HotelHelper().readHotels(new HotelHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {
                findViewById(R.id.Loading).setVisibility(View.GONE);
                new RecyclerView_config1().setConfig(mRecyclerView,HotelList.this,hotels,keys);
            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
