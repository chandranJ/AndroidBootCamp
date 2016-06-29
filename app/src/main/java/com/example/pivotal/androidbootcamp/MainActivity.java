package com.example.pivotal.androidbootcamp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger.ObjectGraph;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {


    @Bind(R.id.rv)
    RecyclerView mRecyclerView;

    @Inject
    SportsRecycleAdapter.SportsFactory mSportsFactory;

    @Inject
    RetroServiceManager mRetroServiceManager;

    SportsRecycleAdapter mRecyclerSportsAdapter;

    Context mContext;
    RetroInterface mRetroApi;
    protected ObjectGraph mGraph;

    SportsRecycleAdapter.SportsRowClickListener mSportsListener;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        mGraph = ObjectGraph.create(new AppInjectModule());
        mGraph.inject(this);
        mSportsListener = new SportsRecycleAdapter.SportsRowClickListener() {
            @Override
            public void onSportsRowClicked(RetroPojo retro, int position) {
                int pos = position + 1;
                if (pos == retro.getQuarters().size())
                    pos = pos - 1;

                Actions actions = retro.getQuarters().get(pos).getPbp().get(position).getActions().get(position);
                String mDetailUrl = actions.getDetails();

                Log.d("detailurlcheck:", mDetailUrl + "position:" + position);

                Intent detail_intent = new Intent(mContext, SportsDetailActivity.class);
                detail_intent.putExtra("detailurl", mDetailUrl);
                mContext.startActivity(detail_intent);
fsgfsgrgsg

            }
        };

        getApi().getSportDetail(new Callback<RetroPojo>() {

            @Override
            public void success(RetroPojo retro, Response response) {
                Actions mDetailUrl = retro.getQuarters().get(1).getPbp().get(0).getActions().get(0);

                Log.d("detailurlcheck:", "url: " + mDetailUrl.getDetails());
                mRecyclerSportsAdapter = mSportsFactory.CreateAdapter(mContext, retro, mSportsListener);
                mRecyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(mRecyclerSportsAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public RetroInterface getApi() {
        if (mRetroApi == null) {
            mRetroApi = mRetroServiceManager.getService();
        }
        return mRetroApi;
    }

    public void setApi(RetroInterface retroApi) {
        mRetroApi = retroApi;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pivotal.androidbootcamp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pivotal.androidbootcamp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

