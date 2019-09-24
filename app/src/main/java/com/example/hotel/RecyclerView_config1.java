package com.example.hotel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_config1 {

    private Context mContext;
    private HotelAdapter mHotelAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Hotel> hotels,List<String> keys){
        mContext=context;
        mHotelAdapter=new HotelAdapter(hotels,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mHotelAdapter);
    }

    class HotelItemView extends RecyclerView.ViewHolder{
        private TextView mHID;
        private TextView mHName;
        private TextView mHAddress;
        private TextView mHPhone;
        private TextView mHPrice;
        private TextView mHClass;
        private TextView mHFacilities;
        private TextView mHOwner;
        private TextView mHWeb;

        private String key;

        public HotelItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.hotel_list_item,parent,false));

            mHID=(TextView)itemView.findViewById(R.id.ID_txtView);
            mHName=(TextView)itemView.findViewById(R.id.Name_txtView);
            mHAddress=(TextView)itemView.findViewById(R.id.Address_txtView);
            mHPhone=(TextView)itemView.findViewById(R.id.Phone_txtView);
            mHPrice=(TextView)itemView.findViewById(R.id.Price_txtView);
            mHClass=(TextView)itemView.findViewById(R.id.Class_txtView);
            mHFacilities=(TextView)itemView.findViewById(R.id.Facilites_txtView);
            mHOwner=(TextView)itemView.findViewById(R.id.Owner_txtView);
            mHWeb=(TextView)itemView.findViewById(R.id.Web_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,HotelDetails.class);
                    intent.putExtra("key",key);
                    intent.putExtra("HID",mHID.getText().toString());
                    intent.putExtra("HName",mHName.getText().toString());
                    intent.putExtra("HAddress",mHAddress.getText().toString());
                    intent.putExtra("HPhone",mHPhone.getText().toString());
                    intent.putExtra("HPrice",mHPrice.getText().toString());
                    intent.putExtra("HClass",mHClass.getText().toString());
                    intent.putExtra("HFacilities",mHFacilities.getText().toString());
                    intent.putExtra("HOwner",mHOwner.getText().toString());
                    intent.putExtra("HWeb",mHWeb.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }
        public void bind(Hotel hotel,String key){
            mHID.setText(hotel.getmHid());
            mHName.setText(hotel.getmHName());
            mHAddress.setText(hotel.getmHAddress());
            mHPhone.setText(hotel.getmHPhone());
            mHPrice.setText(hotel.getmHPrice());
            mHClass.setText(hotel.getmHClass());
            mHFacilities.setText(hotel.getmHFacilites());
            mHOwner.setText(hotel.getmHOwner());
            mHWeb.setText(hotel.getmHWeb());
            this.key=key;

        }
    }
    class HotelAdapter extends RecyclerView.Adapter<HotelItemView>{
        private List<Hotel> mHotelList;
        private List<String> mKeys;

        public HotelAdapter(List<Hotel> mHotelList, List<String> mKeys) {
            this.mHotelList = mHotelList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public HotelItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new HotelItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull HotelItemView holder, int position) {
            holder.bind(mHotelList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mHotelList.size();
        }
    }
}
