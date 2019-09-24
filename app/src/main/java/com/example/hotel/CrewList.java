package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class CrewList extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_Crew);
        new FirebaseDatabaseHelper().readCrew(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Crew> crews, List<String> keys) {
                findViewById(R.id.progressBar).setVisibility(View.GONE);
                new Recyclerview_config().setConfig(mRecyclerView,CrewList.this,crews,keys);
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
