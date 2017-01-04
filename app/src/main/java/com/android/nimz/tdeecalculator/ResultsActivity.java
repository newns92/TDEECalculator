package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.android.nimz.tdeecalculator.MainActivity.bmr;
import static com.android.nimz.tdeecalculator.MainActivity.tdee;

public class ResultsActivity extends AppCompatActivity {
/*********************************************************
*               GLOBAL VARIABLES                         *
*********************************************************/
//private TextView userAgeTextView;
    private TextView userBMRTextView;
    private TextView userTDEETextView;
    private TextView goalCaloriesTextView;
    private RadioGroup goalRadioGroup;
    private RadioGroup goalSpeedRadioGroup;
    private int goalSign;
    private int additionalGoalCalories;
    private int goalCalories;
//    public int bmr;
//    public int tdee;
/********************************************************
 ********************************************************/

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.results_layout);

        Button resultsCalculateBtn = (Button) findViewById(R.id.results_calculate_button);
        goalRadioGroup = (RadioGroup) findViewById(R.id.goal_group);
        goalSpeedRadioGroup = (RadioGroup) findViewById(R.id.goal_speed_group);
        goalCaloriesTextView = (TextView) findViewById(R.id.goal_calories_display);

        //Find the Views w/in the Main Activity */
        //final RadioGroup activityRadioGroup = (RadioGroup) findViewById(R.id.activity_group);
       userBMRTextView = (TextView) findViewById(R.id.bmr_calories_display);
       userTDEETextView = (TextView) findViewById(R.id.tdee_calories_display);
       //MainActivity.calculateBMR(weight, height, age);
       //calculateTDEE(bmr, activityLevel);
        //MainActivity.bmr(MainActivity.weight, MainActivity.height, MainActivity.age);
        userBMRTextView.setText(String.valueOf(bmr));
        userTDEETextView.setText(String.valueOf(tdee));

               /* When Calculate button is clicked, open up results fragment/activity/layout and display
            BMR and TDEE to user (TO-DO) */
        resultsCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check which Gender radio button was clicked and set constant for BMR calculation
                switch (goalRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.lose_weight_radio_button:
                        goalSign = -1;
                        break;
                    case R.id.maintain_weight_radio_button:
                        goalSign = 0;
                        break;
                    case R.id.gain_weight_radio_button:
                        goalSign = 1;
                        break;
                }
                switch (goalSpeedRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.aggressive_radio_button:
                        additionalGoalCalories = 500;
                        break;
                    case R.id.suggested_radio_button:
                        additionalGoalCalories = 250;
                        break;
                    case R.id.slowly_radio_button:
                        additionalGoalCalories = 100;
                        break;
                }

                calculateGoalCalories(tdee, goalSign, additionalGoalCalories);
                //Toast.makeText(MainActivity.this,
                //        String.valueOf(goalSign), Toast.LENGTH_SHORT).show();
                goalCaloriesTextView.setText(String.valueOf(goalCalories));

            }
        });

//        resetBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //clearAll();
//            }
//        });

        }
    public void clearAllResults(View view) {
        userBMRTextView.setText("0");
        userTDEETextView.setText("0");
        goalCaloriesTextView.setText("0");
        goalRadioGroup.clearCheck();
        goalSpeedRadioGroup.clearCheck();
    }
    /**
   * Method to calculate BMR using Harris–Benedict equations revised by Mifflin + St Jeor in 1990
    *
    * @param tdee    User's weight in kg
     * @param goalSign    User's height in cm
     * @param additionalGoalCalories       User's age in years
     */
    public int calculateGoalCalories(int tdee, int goalSign, int additionalGoalCalories) {
        /* BMR Calculation -  Harris–Benedict equation (1990) */
        return goalCalories = tdee + (goalSign*additionalGoalCalories);
    }
//    /**
//     * Method to calculate BMR using Harris–Benedict equations revised by Mifflin + St Jeor in 1990
//     *
//     * @param bmr               User's BMR calculated with calculateBMR button
//     * @param activityLevel     User's activity level constant
//     */
//    public double calculateTDEE(double bmr, double activityLevel) {
//        /* TDEE Calculation -  Harris–Benedict equation (1990) */
//        return tdee = (int) (bmr*activityLevel);
//    }
}
