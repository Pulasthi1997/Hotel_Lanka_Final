package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class HotelDetails extends AppCompatActivity {

    EditText hID;
    EditText hName;
    EditText hAddress;
    EditText hPhone;
    EditText hPrice;
    Spinner hClass;
    EditText hExtra;
    EditText hOName;
    EditText hOWeb;

    Button Update_btn;
    Button Delete_btn;

    private String key;
    private String HID;
    private String HName;
    private String HAddress;
    private String HPhone;
    private String HPrice;
    private String HClass;
    private String HFacilities;
    private String HOwner;
    private String HWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        key=getIntent().getStringExtra("key");
        HID=getIntent().getStringExtra("HID");
        HName=getIntent().getStringExtra("HName");
        HAddress=getIntent().getStringExtra("HAddress");
        HPhone=getIntent().getStringExtra("HPhone");
        HPrice=getIntent().getStringExtra("HPrice");
        HClass=getIntent().getStringExtra("HClass");
        HFacilities=getIntent().getStringExtra("HFacilities");
        HOwner=getIntent().getStringExtra("HOwner");
        HWeb=getIntent().getStringExtra("HWeb");


        hID=(EditText)findViewById(R.id.hID);
        hID.setText(HID);
        hName=(EditText)findViewById(R.id.hName);
        hName.setText(HName);
        hAddress=(EditText)findViewById(R.id.hAddress);
        hAddress.setText(HAddress);
        hPhone=(EditText)findViewById(R.id.hPhone);
        hPhone.setText(HAddress);
        hPrice=(EditText)findViewById(R.id.hPrice);
        hPrice.setText(HPrice);
        hClass=(Spinner)findViewById(R.id.hClass);
        hClass.setSelection(getSpinnerItem(hClass,HClass));
        hExtra=(EditText)findViewById(R.id.hExtra);
        hExtra.setText(HFacilities);
        hOName=(EditText)findViewById(R.id.hOName);
        hOName.setText(HOwner);
        hOWeb=(EditText)findViewById(R.id.hOWeb);
        hOWeb.setText(HWeb);

        Update_btn=(Button)findViewById(R.id.Update_btn);
        Delete_btn=(Button)findViewById(R.id.Delete_btn);

        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel hotel=new Hotel();
                hotel.setmHid(hID.getText().toString());
                hotel.setmHName(hName.getText().toString());
                hotel.setmHAddress(hAddress.getText().toString());
                hotel.setmHPhone(hPhone.getText().toString());
                hotel.setmHPrice(hPrice.getText().toString());
                hotel.setmHClass(hClass.getSelectedItem().toString());
                hotel.setmHFacilites(hExtra.getText().toString());
                hotel.setmHOwner(hOName.getText().toString());
                hotel.setmHWeb(hOWeb.getText().toString());

                new HotelHelper().updateHotels(key, hotel, new HotelHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(HotelDetails.this,"Sucessfully Updated",Toast.LENGTH_LONG).show();
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
                new HotelHelper().deleteHotels(key, new HotelHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(HotelDetails.this,"Sucessfully Deleted",Toast.LENGTH_LONG).show();
                        finish();return;


                    }
                });
            }
        });


    }

    private int getSpinnerItem(Spinner spinner,String item){
        int index=0;
        for (int i=0;i<spinner.getCount();i++){
            if(spinner.getItemAtPosition(i).equals(item)){
                index=i;
                break;
            }
        }
        return index;
    }

}
