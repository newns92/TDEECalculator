package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {

/*********************************************************
*               GLOBAL VARIABLES                         *
*********************************************************/
    private int gender;
    private int age = 15;
    private int weight = 2;
    private int daysExercise;
    private int minutesExercise;
    private int exerciseIntensity;
/********************************************************
********************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        /* Find the Views w/in the Main Activity */
//        startingBillAmount = (EditText)findViewById(R.id.starting_bill_input);
//        startingBillAmount.setSelection(startingBillAmount.getText().length());
//        tipPercentSlider = (SeekBar)findViewById(R.id.tip_percent_slider);
//        tipPercentDisplay = (TextView)findViewById(R.id.tip_percent_text_view);
//        tipDollarAmountDisplay = (TextView)findViewById(R.id.tip_dollar_amount_text_view);
//        partySizeSlider = (SeekBar)findViewById(R.id.party_size_slider);
//        partySizeDisplay = (TextView)findViewById(R.id.party_size_text_view);
//        overall_total_bill_text_view = (TextView)findViewById(R.id.overall_total_bill_text_view);
//        total_per_person_text_view = (TextView)findViewById(R.id.total_per_person_text_view);

        //}
    }

            public void onRadioButtonClicked (View view){
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which Gender radio button was clicked
                switch (view.getId()) {
                    case R.id.male_radio_button:
                        if (checked)
                            gender = 0;
                        break;
                    case R.id.female_radio_button:
                        if (checked)
                            gender = 1;
                        break;
                }
            }
    public void onRadioButtonClicked (View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which Gender radio button was clicked
            switch (view.getId()) {
                case R.id.light_exercise_radio_button:
                    if (checked)
                        exerciseIntensity = 0;
                    break;
                case R.id.moderate_exercise_radio_button:
                    if (checked)
                        exerciseIntensity = 1;
                    break;
                case R.id.heavy_exercise_radio_button:
                    if (checked)
                        exerciseIntensity = 2;
                    break;
                case R.id.intense_exercise_radio_button:
                    if (checked)
                        exerciseIntensity = 3;
                    break;
            }
        }
    }
}
