package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Hotel_Register extends AppCompatActivity {

    EditText hID;
    EditText hName;
    EditText hAddress;
    EditText hPhone;
    EditText hPrice;
    Spinner hClass;
    EditText hExtra;
    EditText hOName;
    EditText hOWeb;

    Button btnNext;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel__register);
        db= FirebaseDatabase.getInstance().getReference("hotels");

        hID=(EditText)findViewById(R.id.hID);
        hName=(EditText)findViewById(R.id.hName);
        hAddress=(EditText)findViewById(R.id.hAddress);
        hPhone=(EditText)findViewById(R.id.hPhone);
        hPrice=(EditText)findViewById(R.id.hPrice);
        hClass=(Spinner)findViewById(R.id.hClass);
        hExtra=(EditText)findViewById(R.id.hExtra);
        hOName=(EditText)findViewById(R.id.hOName);
        hOWeb=(EditText)findViewById(R.id.hOWeb);
        btnNext=(Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHotel();
            }
        });
    }


    private void addHotel(){
        String mID=hID.getText().toString().trim();
        String mName=hName.getText().toString().trim();
        String mAddress=hAddress.getText().toString().trim();
        String mPhone=hPhone.getText().toString().trim();
        String mPrice=hPrice.getText().toString().trim();
        String mClass=hClass.getSelectedItem().toString().trim();
        String mExtra=hExtra.getText().toString().trim();
        String mOName=hOName.getText().toString().trim();
        String mWeb =hOWeb.getText().toString().trim();


        if (!TextUtils.isEmpty(mID)){
            if (!TextUtils.isEmpty(mName)){
                if (!TextUtils.isEmpty(mAddress)){
                    if (!TextUtils.isEmpty(mPhone)){
                        if (!TextUtils.isEmpty(mPrice)){
                            if (!TextUtils.isEmpty(mClass)){
                                if(!TextUtils.isEmpty(mOName)) {


                                    Hotel mhotel = new Hotel(mID, mName, mAddress, mPhone, mPrice, mClass, mExtra,mOName,mWeb);

                                    db.child(mID).setValue(mhotel);
                                    Toast.makeText(this, "Hotel Added Sucessfully", Toast.LENGTH_LONG).show();
                                    finish();
                                    return;
                                }else{
                                    Toast.makeText(this,"Please Enter Owner Name",Toast.LENGTH_LONG).show();
                                }

                            }else {
                                Toast.makeText(this,"Please Enter Hotel Class",Toast.LENGTH_LONG).show();
                            }

                        }else{
                            Toast.makeText(this,"Please Enter Price Per Night",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(this,"Please Enter Contact Number",Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(this,"Please Enter Address",Toast.LENGTH_LONG).show();
                }

            }else{
                Toast.makeText(this,"Please Enter Hotel Name",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Please Enter Hotel Register ID",Toast.LENGTH_LONG).show();
        }
    }
}
