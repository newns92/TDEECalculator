package com.android.nimz.tdeecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
//    public int bmr;
//    public int tdee;
/********************************************************
 ********************************************************/

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.results_layout);

        //Find the Views w/in the Main Activity */
        //final RadioGroup activityRadioGroup = (RadioGroup) findViewById(R.id.activity_group);
       userBMRTextView = (TextView) findViewById(R.id.bmr_calories_display);
       userTDEETextView = (TextView) findViewById(R.id.tdee_calories_display);
       //MainActivity.calculateBMR(weight, height, age);
       //calculateTDEE(bmr, activityLevel);
        //MainActivity.bmr(MainActivity.weight, MainActivity.height, MainActivity.age);
        userBMRTextView.setText(String.valueOf(bmr));
        userTDEETextView.setText(String.valueOf(tdee));
        }

//    /**
//     * Method to calculate BMR using Harris–Benedict equations revised by Mifflin + St Jeor in 1990
//     *
//     * @param weight    User's weight in kg
//     * @param height    User's height in cm
//     * @param age       User's age in years
//     */
//    public double calculateBMR(double weight, double height, double age) {
//        /* BMR Calculation -  Harris–Benedict equation (1990) */
//        return bmr = (int) ((10*weight) + (6.25*height) - (5*age) + genderConstant);
//    }
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
