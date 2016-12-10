package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
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
    private int activityLevel;
    private int selectedGender;
    private int selectedIntensity;
    private int selectedActivity;
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
        final RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.gender_group);
        final RadioGroup intensityRadioGroup = (RadioGroup) findViewById(R.id.intensity_group);
        final RadioGroup activityRadioGroup = (RadioGroup) findViewById(R.id.activity_group);
        Button bt = (Button) findViewById(R.id.calculate_button);

        /* TESTING GETTING RADIOBUTTON ID AND SETTING INT VALUE FOR GENDER AND INTENSITY */
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        selectedGender = genderRadioGroup.getCheckedRadioButtonId();

        // Check which Gender radio button was clicked
        switch (selectedGender) {
            case R.id.male_radio_button:
                gender = 0;
                break;
            case R.id.female_radio_button:
                gender = 1;
                break;
        }
//        Toast.makeText(MainActivity.this,
//                String.valueOf(gender), Toast.LENGTH_SHORT).show();
//            }
//        });

        selectedIntensity = intensityRadioGroup.getCheckedRadioButtonId();

        switch (selectedIntensity) {
            case R.id.light_exercise_radio_button:
                exerciseIntensity = 1;
                break;
            case R.id.moderate_exercise_radio_button:
                exerciseIntensity = 2;
                break;
            case R.id.heavy_exercise_radio_button:
                exerciseIntensity = 3;
                break;
            case R.id.intense_exercise_radio_button:
                exerciseIntensity = 4;
                break;
            //IF DAYS EXERCISE AND/OR MINUTES = 0, NEED TO SET THIS TO 0!
//            default:
//                exerciseIntensity = 0;
//                break;
        }

        selectedActivity = activityRadioGroup.getCheckedRadioButtonId();

        switch (selectedActivity) {
            case R.id.sedentary_radio_button:
                activityLevel = 0;
                break;
            case R.id.lightly_active_radio_button:
                activityLevel = 1;
                break;
            case R.id.active_radio_button:
                activityLevel = 2;
                break;
            case R.id.very_active_radio_button:
                activityLevel = 3;
                break;
        }

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
}