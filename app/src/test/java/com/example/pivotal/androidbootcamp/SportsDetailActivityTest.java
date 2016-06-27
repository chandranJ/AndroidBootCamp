package com.example.pivotal.androidbootcamp;

import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import butterknife.Bind;
import butterknife.ButterKnife;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)

public class SportsDetailActivityTest {

    private SportsDetailActivity mainActivity;

    @Bind(R.id.summary_txt)
    TextView summary;
    @Bind(R.id.formation_txt)
    TextView formation;
    @Bind(R.id.type_txt)
    TextView type;
    @Bind(R.id.direction_txt)
    TextView direction;

    @Before
    public void setup() {

        mainActivity = Robolectric.setupActivity(SportsDetailActivity.class);
        ButterKnife.bind(this, mainActivity);

    }


    @Test
    public void textViewNullCheck() {
        Assert.assertNotNull("Text view could not found", summary);
        Assert.assertNotNull("Text view could not found", type);
        Assert.assertNotNull("Text view could not found", direction);
        Assert.assertNotNull("Text view could not found", formation);
    }

    @Test
    public void validationTextView() {


        Assert.assertEquals("Summary", summary.getText().toString());
        Assert.assertEquals("Formation", formation.getText().toString());
        Assert.assertEquals("Direction", direction.getText().toString());
        Assert.assertEquals("Type", type.getText().toString());

        Assert.assertTrue(true);


    }
}
