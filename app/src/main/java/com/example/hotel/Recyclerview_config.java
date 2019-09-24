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

public class Recyclerview_config {

    private Context mContext;
    private  CrewAdapter mCrewAdapter;

    public void setConfig(RecyclerView recyclerView,Context context,List<Crew> crews,List<String> keys){
        mContext=context;
        mCrewAdapter=new CrewAdapter(crews,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mCrewAdapter);

    }

    class CrewItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mAddress;
        private TextView mStatus;
        private TextView mPhone;
        private TextView mNic;
        private TextView mEmail;

        private String key;

        public CrewItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.crew_list_item,parent,false));

            mName=(TextView)itemView.findViewById(R.id.name_txtview);
            mAddress=(TextView)itemView.findViewById(R.id.address_txtview);
            mStatus=(TextView)itemView.findViewById(R.id.status_txtview);
            mPhone=(TextView)itemView.findViewById(R.id.phone_txtview);
            mNic=(TextView)itemView.findViewById(R.id.nic_txtview);
            mEmail=(TextView)itemView.findViewById(R.id.email_txtview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,CrewDetails.class);
                    intent.putExtra("key",key);
                    intent.putExtra("Name",mName.getText().toString());
                    intent.putExtra("Address",mAddress.getText().toString());
                    intent.putExtra("Status",mStatus.getText().toString());
                    intent.putExtra("Phone",mPhone.getText().toString());
                    intent.putExtra("NIC",mNic.getText().toString());
                    intent.putExtra("Email",mEmail.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }
        public void bind(Crew crew,String key){
            mName.setText(crew.getmName());
            mAddress.setText(crew.getmAddress());
            mStatus.setText(crew.getmStatus());
            mPhone.setText(crew.getmPhone());
            mNic.setText(crew.getmNIC());
            mEmail.setText(crew.getmEmail());
            this.key=key;
        }

    }

    class CrewAdapter extends RecyclerView.Adapter<CrewItemView>{
        private List<Crew> mCrewList;
        private List<String> mKeys;

        public CrewAdapter(List<Crew> mCrewList, List<String> mKeys) {
            this.mCrewList = mCrewList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public CrewItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CrewItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrewItemView holder, int position) {
            holder.bind(mCrewList.get(position),mKeys.get(position));


        }

        @Override
        public int getItemCount() {
            return mCrewList.size();
        }
    }
}
