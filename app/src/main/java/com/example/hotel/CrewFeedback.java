package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrewFeedback extends AppCompatActivity {

    EditText editText2;
    EditText editText;
    Spinner hClass1;
    Button button3;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_feedback);
        db = FirebaseDatabase.getInstance().getReference("feedback");

        editText2=(EditText)findViewById(R.id.Hotel);
        editText=(EditText)findViewById(R.id.Note);
        hClass1=(Spinner)findViewById(R.id.spinner);

        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFeedback();
            }
        });

    }
        private void addFeedback () {
            String mHotel=editText2.getText().toString().trim();
            String mNote=editText.getText().toString().trim();
            String mSatis=hClass1.getSelectedItem().toString().trim();


            if (!TextUtils.isEmpty(mHotel)) {
                if (!TextUtils.isEmpty(mNote)) {
                        String mId=db.push().getKey();
                        Feedback mfeedback = new Feedback(mHotel,mSatis,mNote);

                        db.child(mId).setValue(mfeedback);
                        Toast.makeText(this, "Feedback Send Sucessfully ", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    } else {
                        Toast.makeText(this, "Please Enter Hotel Name", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(this, "Please Enter Description", Toast.LENGTH_LONG).show();
                }



        }
    }
