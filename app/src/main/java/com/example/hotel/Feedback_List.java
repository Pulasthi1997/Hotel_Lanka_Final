package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class Feedback_List extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback__list);

        mRecyclerView = (RecyclerView) findViewById(R.id.FeedbackRecycler_view);
        new FirebaseDatabaseHelper().readCrew(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<> crews, List<String> keys) {
                findViewById(R.id.progressBar).setVisibility(View.GONE);
                new Recyclerview_config().setConfig(mRecyclerView,Feedback_List.this,f,keys);
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
