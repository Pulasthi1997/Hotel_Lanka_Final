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

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceCrew;
    private List<Crew> crews=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Crew> crews,List<String> keys);
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase=FirebaseDatabase.getInstance();
        mReferenceCrew=mDatabase.getReference("crew");
    }

    public void readCrew(final DataStatus dataStatus){
        mReferenceCrew.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                crews.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Crew crew=keyNode.getValue(Crew.class);
                    crews.add(crew);
                }
                dataStatus.DataIsLoaded(crews,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateCrew(String key,Crew crew,final DataStatus dataStatus){
        mReferenceCrew.child(key).setValue(crew).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deleteCrew(String key,final DataStatus dataStatus){
        mReferenceCrew.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
