package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    /*********************************************************
     * GLOBAL VARIABLES                         *
     *********************************************************/
    private int gender;
    private int age;
    private int weight;
    private int daysExercise;
    private int minutesExercise;
    private int exerciseIntensity;
    //private RadioGroup genderRadioGroup;
    //private RadioGroup intensityRadioGroup;

    /********************************************************
     ********************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Find the Views w/in the Main Activity */
        SeekBar userWeight = (SeekBar) findViewById(R.id.weight_slider);
        SeekBar userAge = (SeekBar) findViewById(R.id.age_slider);
        SeekBar userDaysExercise = (SeekBar) findViewById(R.id.exercise_days_slider);
        SeekBar userMinutesExercise = (SeekBar) findViewById(R.id.exercise_minutes_slider);
        RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.gender_group);
        RadioGroup intensityRadioGroup = (RadioGroup) findViewById(R.id.intensity_group);

        //Button calcButton = (Button) findViewById(R.id.calculate_button);
        //calcButton.setOnClickListener(new OnClickListener() {
//
        ///}

        /* Set OnSeekBarChangeListener to change the value of the tip % as the slider is used */
        userWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to change the value of the tip % as the slider is used */
        userAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to change the value of the tip % as the slider is used */
        userDaysExercise.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                daysExercise = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to change the value of the tip % as the slider is used */
        userMinutesExercise.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                minutesExercise = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    // Check which Gender radio button was clicked
//                switch (view.getId()) {
//                    case R.id.male_radio_button:
//                        if (checked)
//                            gender = 0;
//                        break;
//                    case R.id.female_radio_button:
//                        if (checked)
//                            gender = 1;
//                        break;
//                }

//        // Check which Gender radio button was clicked
//            switch (view.getId()) {
//                case R.id.light_exercise_radio_button:
//                    if (checked)
//                        exerciseIntensity = 0;
//                    break;
//                case R.id.moderate_exercise_radio_button:
//                    if (checked)
//                        exerciseIntensity = 1;
//                    break;
//                case R.id.heavy_exercise_radio_button:
//                    if (checked)
//                        exerciseIntensity = 2;
//                    break;
//                case R.id.intense_exercise_radio_button:
//                    if (checked)
//                        exerciseIntensity = 3;
//                    break;
//            }
}