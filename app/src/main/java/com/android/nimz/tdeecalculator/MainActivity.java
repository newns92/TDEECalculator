package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {

    /*********************************************************
     * GLOBAL VARIABLES                         *
     *********************************************************/
    //private int gender;
    private double age;
    private double weight;
    private double height;
    private int daysExercise;
    private int minutesExercise;
    private int exerciseIntensity;
    private int activityLevel;
    private int selectedGender;
    private int selectedIntensity;
    private int selectedActivity;
    private int bmr;
    private double genderConstant;
    private SeekBar userAge;
    private SeekBar userWeight;
    private SeekBar userHeight;
    private SeekBar userDaysExercise;
    private SeekBar userMinutesExercise;
    private TextView userAgeTextView;
    //private RadioGroup genderRadioGroup;
    //private RadioGroup intensityRadioGroup;

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
        final RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.gender_group);
        final RadioGroup intensityRadioGroup = (RadioGroup) findViewById(R.id.intensity_group);
        final RadioGroup activityRadioGroup = (RadioGroup) findViewById(R.id.activity_group);
        userAgeTextView = (TextView) findViewById(R.id.age_display);
        //partySizeDisplay = (TextView)findViewById(R.id.party_size_text_view);

        /* TESTING GETTING RADIOBUTTON ID AND SETTING INT VALUE FOR GENDER AND INTENSITY */
        Button calculateBtn = (Button) findViewById(R.id.calculate_button);

//        calculateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

                //Toast.makeText(MainActivity.this,
                //        String.valueOf(gender), Toast.LENGTH_SHORT).show();

                /* Set OnSeekBarChangeListener to get the value og user's age */
                userAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        age = progress;
                        //userAgeTextView.setText(String.valueOf(progress));
                        displayAge(progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
                //Toast.makeText(MainActivity.this,
                //       String.valueOf(age), Toast.LENGTH_SHORT).show();

                /* Set OnSeekBarChangeListener to get the value of user's weight in pounds */
                userWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //convert weight in pounds to kg
                        weight = progress/2.2;
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
                //Toast.makeText(MainActivity.this,
                //        String.valueOf(weight), Toast.LENGTH_SHORT).show();

                /* Set OnSeekBarChangeListener to get the value of user's height in inches */
                userHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //Convert height in inches to centimeters
                        height = progress*2.54;
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
//                Toast.makeText(MainActivity.this,
//                        String.valueOf(height), Toast.LENGTH_SHORT).show();

                /* Set OnSeekBarChangeListener to get the value of user's days per week of exercise */
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
//                Toast.makeText(MainActivity.this,
//                        String.valueOf(daysExercise), Toast.LENGTH_SHORT).show();

                /* Set OnSeekBarChangeListener to get the value user's minutes per day of exercise */
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
//                Toast.makeText(MainActivity.this,
//                        String.valueOf(minutesExercise), Toast.LENGTH_SHORT).show();

//                Toast.makeText(MainActivity.this,
//                        String.valueOf(exerciseIntensity), Toast.LENGTH_SHORT).show();
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedGender = genderRadioGroup.getCheckedRadioButtonId();

                // Check which Gender radio button was clicked
                switch (selectedGender) {
                    case R.id.male_radio_button:
                        genderConstant = 5;
                        break;
                    case R.id.female_radio_button:
                        genderConstant = -161;
                        break;
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
//                Toast.makeText(MainActivity.this,
//                        String.valueOf(activityLevel), Toast.LENGTH_SHORT).show();

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

                calculateBMR(weight, height, age);
                Toast.makeText(MainActivity.this,
                        String.valueOf(bmr), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openResults(View view) {
//        Button calculateBtn = (Button) findViewById(R.id.calculate_button);
//
//        calculateBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                //Intent myIntent = new Intent(view.getContext(), ResultsActivity.class);
//                //startActivity(myIntent);
//                calculateBMR(gender, weight, height, age);
//                Toast.makeText(MainActivity.this,
//                        String.valueOf(gender), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    /* Set the party size, final overall and per person bill amounts as the party slider is moved */
    public void displayAge(int progress) {
        int userAgeDisplay = valueOf(progress);
        /* If the user attempts to make party size < 1, give error message */
        userAgeTextView.setText(String.valueOf(userAgeDisplay));
    }

    /**
     * Method to calculate BMR using Harris–Benedict equations revised by Mifflin + St Jeor in 1990
     *
     * @param weight    User's weight in kg
     * @param height    User's height in cm
     * @param age       User's age in years
     */
    public double calculateBMR(double weight, double height, double age) {
//        double genderConstant;
//        double weightConstant = 10;
//        double heightConstant = 6.25;
//        double ageConstant = 5;

//        if (gender == 0) {
//            genderConstant = -161.0;
////            weightConstant = 10;
////            heightConstant = 4.7;
////            ageConstant = 4.7;
//        } else {
//            genderConstant = 5.0;
////            weightConstant = 6.23;
////            heightConstant = 12.7;
////            ageConstant = 6.8;
//        }

        /* BMR Calculation -  Harris–Benedict equation (1990) */
        return bmr = (int) ((10*weight) + (6.25*height) - (5*age) + genderConstant);
        //return bmr = (int) (genderConstant + (weightConstant*weight) + (heightConstant*height) - (ageConstant*age));
    }
}
