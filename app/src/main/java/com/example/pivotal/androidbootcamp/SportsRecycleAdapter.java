package com.example.pivotal.androidbootcamp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SportsRecycleAdapter extends RecyclerView.Adapter<SportsRecycleAdapter.MyViewHolder> {

    private RetroPojo mSportsList;
    private Actions mDetailUrl;
    private Context mContext;
    private SportsRowClickListener mListener;
    int mPosition;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.genre)
        TextView tUpdate;
        @Bind(R.id.title)
        TextView tSummary;

        @OnClick(R.id.cardview)
        public void OnSportClicked() {
            mListener.onSportsRowClicked(mSportsList, getAdapterPosition());
        }



        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }


    public SportsRecycleAdapter(Context context, RetroPojo retrodetail, SportsRowClickListener sportsclicklistener) {
        this.mSportsList = retrodetail;
        mContext = context;
        mListener = sportsclicklistener;
    }

    public SportsRecycleAdapter(Context context, RetroPojo retrodetail) {
        this.mSportsList = retrodetail;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sports_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        int pos = position + 1;
        if (pos == mSportsList.getQuarters().size())
            pos = pos - 1;
        Actions mDetailUrl = mSportsList.getQuarters().get(pos).getPbp().get(position).getActions().get(position);

        holder.tSummary.setText(mDetailUrl.getSummary());
        holder.tUpdate.setText(mDetailUrl.getUpdated());


        mPosition = position;


    }


    @Override
    public int getItemCount() {
        return mSportsList.getQuarters().size();
    }


    @Singleton
    public static class SportsFactory {
        @Inject
        public SportsFactory() {
        }

        public SportsRecycleAdapter CreateAdapter(Context context, RetroPojo pojo,SportsRowClickListener listener) {
            return new SportsRecycleAdapter(context, pojo,listener);
        }


    }

    public interface SportsRowClickListener {
        void onSportsRowClicked(RetroPojo mpojo, int position);
    }
}