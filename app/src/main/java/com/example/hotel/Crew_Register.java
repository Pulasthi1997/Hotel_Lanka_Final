package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Crew_Register extends AppCompatActivity {

    EditText IName;
    EditText IAddress;
    EditText INIC;
    EditText IPhone;
    EditText IPosition;
    EditText IEmail;
    EditText IPassword;
    Button Registerbtn;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew__register);
        db= FirebaseDatabase.getInstance().getReference("crew");

        IName=(EditText)findViewById(R.id.IName);
        IAddress=(EditText)findViewById(R.id.IAddress);
        INIC=(EditText)findViewById(R.id.INIC);
        IPhone=(EditText)findViewById(R.id.IPhone);
        IPosition=(EditText)findViewById(R.id.IPosition);
        IEmail=(EditText)findViewById(R.id.IEmail);
        IPassword=(EditText)findViewById(R.id.IPassword);
        Registerbtn=(Button)findViewById(R.id.Registerbtn);

        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCrew();
            }
        });
    }

    private void addCrew(){
        String mName=IName.getText().toString().trim();
        String mAddress=IAddress.getText().toString().trim();
        String mNIC=INIC.getText().toString().trim();
        String mPhone=IPhone.getText().toString().trim();
        String mStatus=IPosition.getText().toString().trim();
        String mEmail=IEmail.getText().toString().trim();
        String mPassword=IPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(mName)){
            if (!TextUtils.isEmpty(mAddress)){
                if (!TextUtils.isEmpty(mNIC)){
                    if (!TextUtils.isEmpty(mPhone)){
                        if (!TextUtils.isEmpty(mStatus)){
                            if (!TextUtils.isEmpty(mEmail)){
                                if (!TextUtils.isEmpty(mPassword)){

                                    String mId=db.push().getKey();

                                    Crew mcrew=new Crew(mId,mName,mAddress,mNIC,mPhone,mStatus,mEmail,mPassword);

                                    db.child(mId).setValue(mcrew);
                                    Toast.makeText(this,"Crew Member Added...",Toast.LENGTH_LONG).show();
                                    finish();return;



                                }else {
                                    Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
                                }

                            }else {
                                Toast.makeText(this,"Please Enter Email",Toast.LENGTH_LONG).show();
                            }

                        }else{
                            Toast.makeText(this,"Please Enter Position",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(this,"Please Enter Phone Number",Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(this,"Please Enter NIC!",Toast.LENGTH_LONG).show();
                }

            }else{
                Toast.makeText(this,"Please Enter Address!",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Please Enter Name!",Toast.LENGTH_LONG).show();
        }
    }

}
