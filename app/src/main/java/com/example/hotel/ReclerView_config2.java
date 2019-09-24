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

public class ReclerView_config2 {

    private Context mContext;
    private ReclerView_config2.FeedbackAdapter mFeedbackAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Feedback> feedbacks, List<String> keys) {
        mContext = context;
        mFeedbackAdapter = new ReclerView_config2.FeedbackAdapter(feedbacks, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mFeedbackAdapter);

    }

    class FeedbackItem extends RecyclerView.ViewHolder {
        private TextView mHotel;
        private TextView mSatissfied;
        private TextView mNote;


        private String key;

        public FeedbackItem(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.feedback_list, parent, false));

            mHotel = (TextView) itemView.findViewById(R.id.Hotel_txtView1);
            mSatissfied = (TextView) itemView.findViewById(R.id.satissfied_txtView1);
            mNote = (TextView) itemView.findViewById(R.id.note_txtView1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, FeedbackDetails.class);
                    intent.putExtra("key", key);
                    intent.putExtra("Hotel", mHotel.getText().toString());
                    intent.putExtra("Satisfied", mSatissfied.getText().toString());
                    intent.putExtra("Note", mNote.getText().toString());


                    mContext.startActivity(intent);
                }
            });
        }

        public void bind(Feedback feedback, String key) {
            mHotel.setText(feedback.getHotel());
            mSatissfied.setText(feedback.getSatist());
            mNote.setText(feedback.getNote());

            this.key = key;
        }

    }

    class FeedbackAdapter extends RecyclerView.Adapter<ReclerView_config2.FeedbackItem> {
        private List<Feedback> mfeedbackList;
        private List<String> mKeys;

        public FeedbackAdapter(List<Feedback> mfeedbackList, List<String> mKeys) {
            this.mfeedbackList = mfeedbackList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public FeedbackItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FeedbackItem(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull FeedbackItem holder, int position) {
            holder.bind(mfeedbackList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mfeedbackList.size();
        }
    }
}
