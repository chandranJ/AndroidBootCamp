package com.example.pivotal.androidbootcamp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger.ObjectGraph;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SportsDetailActivity extends AppCompatActivity {

    @Bind(R.id.type_txt)
    TextView type;
    @Bind(R.id.summary_txt)
    TextView summary;
    @Bind(R.id.direction_txt)
    TextView direction;
    @Bind(R.id.formation_txt)
    TextView formation;
    protected ObjectGraph mGraph;

    @Inject
    RetroServiceManager mRetroServiceManager;

    String summary_txt, type_txt, direct_txt, form_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_detail);
        ButterKnife.bind(this);

        mGraph = ObjectGraph.create(new AppInjectModule());
        mGraph.inject(this);

        String detailurl = getIntent().getStringExtra("detailurl");

        mRetroServiceManager.getService().getSportsSummaryDetail(detailurl, new Callback<DetailsModel>() {
            @Override
            public void success(DetailsModel detailmodel, Response response) {


                SetDetailView(detailmodel);


            }

            @Override
            public void failure(RetrofitError error) {

                String err = error.getMessage();
                Log.d("boot", "error " + err);
            }
        });


    }

    public void SetDetailView(DetailsModel detailmodel) {
        if (detailmodel != null) {
            if (detailmodel.getSummary() != null) {
                summary_txt = detailmodel.getSummary();
                summary.setText(summary_txt);
            }
            if (detailmodel.getType() != null) {
                type_txt = detailmodel.getType();
                type.setText(type_txt);
            }
            if (detailmodel.getSummary() != null) {
                direct_txt = detailmodel.getDirection();
                direction.setText(direct_txt);
            }
            if (detailmodel.getSummary() != null) {
                form_txt = detailmodel.getFormation();
                formation.setText(form_txt);
            }

        }


    }

}
