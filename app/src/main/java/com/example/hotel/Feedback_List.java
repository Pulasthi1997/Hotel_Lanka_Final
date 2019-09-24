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
        new FeedbackHelper().readFeedback(new FeedbackHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Feedback> feedbacks, List<String> keys) {
                findViewById(R.id.progressBar2).setVisibility(View.GONE);
                new ReclerView_config2().setConfig(mRecyclerView,Feedback_List.this,feedbacks,keys);

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
