package com.example.test101;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Heidi on 5/6/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnitTestSample {

    private static final String FAKE_STRING = "Settings";

    @Mock
    private Context context;

    @Test
    public void testTextView() {
        Mockito.when(context.getString(R.string.action_settings)).thenReturn(FAKE_STRING);


    }
}
