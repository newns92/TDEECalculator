package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

public class ResultsActivity extends AppCompatActivity {
    /*********************************************************
     //         * GLOBAL VARIABLES                         *
     //         *********************************************************/

        /********************************************************
         ********************************************************/

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.results_layout);

        /* Find the Views w/in the Main Activity */
            final RadioGroup activityRadioGroup = (RadioGroup) findViewById(R.id.activity_group);

        }
}
