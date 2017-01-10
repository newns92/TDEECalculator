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
    private TextView userBMRTextView;
    private TextView userTDEETextView;
    private TextView goalCaloriesTextView;
    private RadioGroup goalRadioGroup;
    private RadioGroup goalSpeedRadioGroup;
    private int goalSign;
    private int additionalGoalCalories;
    private int goalCalories;
    private Button resultsCalculateBtn;
    private Button resultsResetBtn;
/********************************************************
 ********************************************************/

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.results_layout);

        /* Find the Views w/in the Main Activity */
        resultsCalculateBtn = (Button) findViewById(R.id.results_calculate_button);
        resultsResetBtn = (Button) findViewById(R.id.results_reset_button);
        goalRadioGroup = (RadioGroup) findViewById(R.id.goal_group);
        goalSpeedRadioGroup = (RadioGroup) findViewById(R.id.goal_speed_group);
        goalCaloriesTextView = (TextView) findViewById(R.id.goal_calories_display);
        userBMRTextView = (TextView) findViewById(R.id.bmr_calories_display);
        userTDEETextView = (TextView) findViewById(R.id.tdee_calories_display);
        final MainActivity  MainAct2 = new MainActivity();


        // Set value of TextViews with BMR and TDEE calculated from Main Activity interface
        userBMRTextView.setText(String.valueOf(bmr));
        userTDEETextView.setText(String.valueOf(tdee));

        // When Calculate button is clicked,calculate amount of calories for user to meet their goal
        resultsCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check which Goal radio button was clicked and set sign for goal calorie calculation
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
                /* Check which Goal Speed radio button was clicked and set amount of calories to
                 add or gain */
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
                // Calculate calories to meet user's goal based on their stats and display the amount
                calculateGoalCalories(tdee, goalSign, additionalGoalCalories);
                goalCaloriesTextView.setText(String.valueOf(goalCalories));
            }
        });

        resultsResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllResults(findViewById(R.id.results_layout));
            }
        });
    }
    /**
    * Method to clear all TextViews, SeekBars, and RadioGroups for ResultsActivity.java
    */
    public void clearAllResults(View view) {
        userBMRTextView.setText("0");
        userTDEETextView.setText("0");
        goalCaloriesTextView.setText("0");
        goalRadioGroup.clearCheck();
        goalSpeedRadioGroup.clearCheck();
    }
    /**
    * Method to calculate the amount of calories to meet user's goal of weight loss, gain, or maintenance
    *
    * @param tdee                       User's Calculated TDEE
    * @param goalSign                   Sign of the user's weight loss, gain, or maintenance
    * @param additionalGoalCalories     Additional calories to gain or lose based on user's goal
    */
    public int calculateGoalCalories(int tdee, int goalSign, int additionalGoalCalories) {
        return goalCalories = tdee + (goalSign*additionalGoalCalories);
    }
}
