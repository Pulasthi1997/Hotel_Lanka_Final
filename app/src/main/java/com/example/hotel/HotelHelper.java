package com.example.hotel;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HotelHelper {

    private FirebaseDatabase mdata;
    private DatabaseReference mRef;
    private List<Hotel> hotels=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Hotel> hotels,List<String> keys);
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public HotelHelper() {
        mdata=FirebaseDatabase.getInstance();
        mRef=mdata.getReference("hotels");

    }

    public void readHotels(final DataStatus dataStatus){
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                hotels.clear();
                List<String>keys=new ArrayList<>();
                for (DataSnapshot keyNode:dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Hotel hotel=keyNode.getValue(Hotel.class);
                    hotels.add(hotel);
                }
                dataStatus.DataIsLoaded(hotels,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateHotels(String key,Hotel hotel,final DataStatus dataStatus){
        mRef.child(key).setValue(hotel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deleteHotels(String key,final DataStatus dataStatus){
        mRef.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }

}
