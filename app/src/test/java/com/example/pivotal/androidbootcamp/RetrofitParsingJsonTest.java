package com.example.pivotal.androidbootcamp;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import retrofit.Callback;
import retrofit.RetrofitError;

import static org.mockito.Matchers.any;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class RetrofitParsingJsonTest {
    Context context;
    private MainActivity mainActivity;

    @Mock
    private RetroInterface mockRetrofitApiImpl;
    @Mock
    RetroServiceManager mRetro_service;
    @Captor
    private ArgumentCaptor<Callback<RetroPojo>> callbackArgumentCaptor;

    @Mock
    RetroPojo mRetroPojo;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        mainActivity = controller.get();
        mainActivity.setApi(mockRetrofitApiImpl);

        controller.create();

    }

    @Test
    public void shouldFillAdapter() throws Exception {
        Mockito.verify(mockRetrofitApiImpl).getSportDetail(callbackArgumentCaptor.capture());

//        Callback<RetroPojo> callback = callbackArgumentCaptor.getValue();
//        callback.success(mockPojo, mockResponse);
//
//        callback.failure(mockError);
    }
}
