package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FeedbackDetails extends AppCompatActivity {

    TextView HName;
    TextView FSatis;
    TextView FNote;
    Button Delete_btn;

    private  String key;
    private  String Hotel;
    private String  Satisfied;
    private String Note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_details);

        key=getIntent().getStringExtra("key");
        Hotel =getIntent().getStringExtra("Hotel");
        Satisfied=getIntent().getStringExtra("Satisfied");
        Note=getIntent().getStringExtra("Note");


        HName=(TextView) findViewById(R.id.Hotel);
        HName.setText(Hotel);
        FSatis=(TextView) findViewById(R.id.spinner);
        FSatis.setText(Satisfied);
        FNote=(TextView) findViewById(R.id.Note);
        FNote.setText(Note);


        Delete_btn=(Button)findViewById(R.id.DeleteFeedback_btn);

        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FeedbackHelper().deleteFeedback(key, new FeedbackHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Feedback> feedbacks, List<String> keys) {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(FeedbackDetails.this,"Sucessfully Deleted",Toast.LENGTH_LONG).show();
                        finish();return;

                    }

                });
            }
        });





    }
}
