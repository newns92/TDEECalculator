package com.android.nimz.tdeecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {

    /*********************************************************
     * GLOBAL VARIABLES                         *
     *********************************************************/
    public double age;
    public double weight;
    public double height;
    public int daysExercise;
    public int minutesExercise;
    public int exerciseIntensity;
    public double activityLevel;
    public static int bmr;
    public static int tdee;
    public double genderConstant;
    private SeekBar userAge;
    private SeekBar userWeight;
    private SeekBar userHeight;
    private SeekBar userDaysExercise;
    private SeekBar userMinutesExercise;
    private TextView userAgeTextView;
    private TextView userWeightTextView;
    private TextView userHeightFootTextView;
    private TextView userHeightInchesTextView;
    private TextView exerciseDaysTextView;
    private TextView exerciseMinutesTextView;
    private Button calculateTDEEBtn;
    private Button resetBtn;
    private RadioGroup genderRadioGroup;
    private RadioGroup intensityRadioGroup;
    private RadioGroup activityRadioGroup;

    /********************************************************
     ********************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Find the Views w/in the Main Activity */
        userAge = (SeekBar) findViewById(R.id.age_slider);
        userWeight = (SeekBar) findViewById(R.id.weight_slider);
        userHeight = (SeekBar) findViewById(R.id.height_slider);
        userDaysExercise = (SeekBar) findViewById(R.id.exercise_days_slider);
        userMinutesExercise = (SeekBar) findViewById(R.id.exercise_minutes_slider);
        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_group);
        intensityRadioGroup = (RadioGroup) findViewById(R.id.intensity_group);
        activityRadioGroup = (RadioGroup) findViewById(R.id.activity_group);
        userAgeTextView = (TextView) findViewById(R.id.age_display);
        userWeightTextView = (TextView) findViewById(R.id.weight_display);
        userHeightFootTextView = (TextView) findViewById(R.id.height_display_foot);
        userHeightInchesTextView = (TextView) findViewById(R.id.height_display_inches);
        exerciseDaysTextView = (TextView) findViewById(R.id.exercise_days_display);
        exerciseMinutesTextView = (TextView) findViewById(R.id.exercise_minutes_display);
        calculateTDEEBtn = (Button) findViewById(R.id.calculate_button);
        resetBtn = (Button) findViewById(R.id.reset_button);

        /* Set OnSeekBarChangeListener to get the value of user's age and display as SeekBar moves*/
        userAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = progress + 13;
                displayAge(progress+13);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to get the value of user's weight and display as SeekBar moves*/
        userWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //convert weight in pounds to kg
                weight = (progress + 75)/2.2;
                displayWeight(progress + 75);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to get the value of user's height and display as SeekBar moves*/
        userHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Convert height in inches to centimeters
                height = (progress + 48)*2.54;
                displayHeight(progress + 48);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to get the value of user's days per week of exercise
            and display as SeekBar moves*/
        userDaysExercise.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                daysExercise = progress;
                displayDaysExercise(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* Set OnSeekBarChangeListener to get the value of user's minutes per day of exercise and
            display as SeekBar moves*/
        userMinutesExercise.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                minutesExercise = progress;
                displayMinutesExercise(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* When Calculate button is clicked, open up results fragment/activity/layout and display
            BMR and TDEE to user (TO-DO) */
        calculateTDEEBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check which Gender radio button was clicked and set constant for BMR calculation
                switch (genderRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.male_radio_button:
                        genderConstant = 5;
                        break;
                    case R.id.female_radio_button:
                        genderConstant = -161;
                        break;
                }
                switch (activityRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.sedentary_radio_button:
                        activityLevel = 1.2;
                        break;
                    case R.id.lightly_active_radio_button:
                        activityLevel = 1.375;
                        break;
                    case R.id.moderately_active_radio_button:
                        activityLevel = 1.55;
                        break;
                    case R.id.active_radio_button:
                        activityLevel = 1.725;
                        break;
                    case R.id.very_active_radio_button:
                        activityLevel = 1.9;
                        break;
                }
                /* Check which Exercise Intensity radio button was clicked and set constant for TDEE
                    calculation */
                switch (intensityRadioGroup.getCheckedRadioButtonId()) {
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

                calculateBMR(weight, height, age);
                calculateTDEE(bmr, activityLevel);
                //Toast.makeText(MainActivity.this,
                //        String.valueOf(bmr), Toast.LENGTH_SHORT).show();

                /* Create new intent to open up new activity and screen with calculation results */
                Intent resultsIntent = new Intent(MainActivity.this, ResultsActivity.class);
                // Start the new activity
                startActivity(resultsIntent);
            }
        });
    }

public void clearAll(View view) {
    userAge.setProgress(0);
    userWeight.setProgress(0);
    userHeight.setProgress(0);
    userDaysExercise.setProgress(0);
    userMinutesExercise.setProgress(0);
    userAgeTextView.setText("13");
    userWeightTextView.setText("75");
    userHeightFootTextView.setText("4'");
    userHeightInchesTextView.setText("0''");
    exerciseDaysTextView.setText("0");
    exerciseMinutesTextView.setText("0");
    genderRadioGroup.clearCheck();
    activityRadioGroup.clearCheck();
    intensityRadioGroup.clearCheck();
}
    /* Set the user's age as the age slider is moved */
    public void displayAge(int progress) {
        int userAge = valueOf(progress);
        /* If the user attempts to make party size < 1, give error message */
        userAgeTextView.setText(String.valueOf(userAge));
    }
    /* Set the user's weight as the weight slider is moved */
    public void displayWeight(int progress) {
        int userWeight = valueOf(progress);
        /* If the user attempts to make party size < 1, give error message */
        userWeightTextView.setText(String.valueOf(userWeight));
    }
    /* Set the user's height as the height slider is moved */
    public void displayHeight(int progress) {
        int userHeight = valueOf(progress);
        /* If the user attempts to make party size < 1, give error message */
        userHeightFootTextView.setText(String.valueOf(userHeight/12) + "'");
        userHeightInchesTextView.setText(String.valueOf(userHeight%12) + "''");
    }
    /* Set the user's days of exercise as the exercise days slider is moved */
    public void displayDaysExercise(int progress) {
        int userDaysExercise = valueOf(progress);
        /* If the user attempts to make party size < 1, give error message */
        exerciseDaysTextView.setText(String.valueOf(userDaysExercise));
    }
    /* Set the user's minutes of exercise as the exercise minutes slider is moved */
    public void displayMinutesExercise(int progress) {
        int userMinutesExercise = valueOf(progress);
        /* If the user attempts to make party size < 1, give error message */
        exerciseMinutesTextView.setText(String.valueOf(userMinutesExercise));
    }
    /**
     * Method to calculate BMR using Harris–Benedict equations revised by Mifflin + St Jeor in 1990
     *
     * @param weight    User's weight in kg
     * @param height    User's height in cm
     * @param age       User's age in years
     */
    public double calculateBMR(double weight, double height, double age) {
        /* BMR Calculation -  Harris–Benedict equation (1990) */
        return bmr = (int) ((10*weight) + (6.25*height) - (5*age) + genderConstant);
    }
    /**
     * Method to calculate BMR using Harris–Benedict equations revised by Mifflin + St Jeor in 1990
     *
     * @param bmr               User's BMR calculated with calculateBMR button
     * @param activityLevel     User's activity level constant
     */
    public double calculateTDEE(double bmr, double activityLevel) {
        /* TDEE Calculation -  Harris–Benedict equation (1990) */
        return tdee = (int) (bmr*activityLevel);
    }
}
