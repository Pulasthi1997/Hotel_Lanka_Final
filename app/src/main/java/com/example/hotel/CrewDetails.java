package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class CrewDetails extends AppCompatActivity {

    EditText IName;
    EditText IAddress;
    EditText INIC;
    EditText IPhone;
    EditText IPosition;
    EditText IEmail;
    EditText IPassword;
    Button Update_btn;
    Button Delete_btn;

    private String key;
    private String Name;
    private String Address;
    private String Status;
    private String Phone;
    private String NIC;
    private String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_details);

        key=getIntent().getStringExtra("key");
        Name=getIntent().getStringExtra("Name");
        Address=getIntent().getStringExtra("Address");
        Status=getIntent().getStringExtra("Status");
        Phone=getIntent().getStringExtra("Phone");
        NIC=getIntent().getStringExtra("NIC");
        Email=getIntent().getStringExtra("Email");

        IName=(EditText)findViewById(R.id.IName);
        IName.setText(Name);
        IAddress=(EditText)findViewById(R.id.IAddress);
        IAddress.setText(Address);
        INIC=(EditText)findViewById(R.id.INIC);
        INIC.setText(NIC);
        IPhone=(EditText)findViewById(R.id.IPhone);
        IPhone.setText(Phone);
        IPosition=(EditText)findViewById(R.id.IPosition);
        IPosition.setText(Status);
        IEmail=(EditText)findViewById(R.id.IEmail);
        IEmail.setText(Email);
        IPassword=(EditText)findViewById(R.id.IPassword);

        Update_btn=(Button)findViewById(R.id.Update_btn);
        Delete_btn=(Button)findViewById(R.id.Delete_btn);

        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crew crew=new Crew();
                crew.setmName(IName.getText().toString());
                crew.setmAddress(IAddress.getText().toString());
                crew.setmNIC(INIC.getText().toString());
                crew.setmPhone(IPhone.getText().toString());
                crew.setmStatus(IPosition.getText().toString());
                crew.setmEmail(IEmail.getText().toString());
                crew.setmPassword(IPassword.getText().toString());

                new FirebaseDatabaseHelper().updateCrew(key, crew, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Crew> crews, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(CrewDetails.this,"Member Updation Sucessfully",Toast.LENGTH_LONG).show();
                        finish();return;

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

            }
        });

        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deleteCrew(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Crew> crews, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(CrewDetails.this,"Member Deletion Sucessfully",Toast.LENGTH_LONG).show();
                        finish();return;

                    }
                });
            }
        });





    }
}
