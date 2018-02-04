/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.myquizapp
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.myquizapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.android.myquizapp.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This is answers for question 1
     *@return 1 if correct
     */

    public int question_1() {
        CheckBox goodAnswer1 = findViewById(R.id.Question_1_Option_2_checkbox);
        boolean isGoodAnswer1Checked = goodAnswer1.isChecked();

        CheckBox goodAnswer2 = findViewById(R.id.Question_1_Option_4_checkbox);
        boolean isGoodAnswer2Checked = goodAnswer2.isChecked();

        CheckBox badAnswer1 = findViewById(R.id.Question_1_Option_1_checkbox);
        boolean isBadAnswer1Checked = badAnswer1.isChecked();

        CheckBox badAnswer2 = findViewById(R.id.Question_1_Option_3_checkbox);
        boolean isBadAnswer2Checked = badAnswer2.isChecked();

        if ((!isBadAnswer1Checked && !isBadAnswer2Checked) && (isGoodAnswer1Checked && isGoodAnswer2Checked)) {
            return 1;
        }
        return 0;
    }

    /**
     * This is answers for question 4
     * @return 1 if correct
     */

    public int question_4() {
        CheckBox goodAnswer1 = findViewById(R.id.Question_4_Option_3_checkbox);
        boolean isGoodAnswer1Checked = goodAnswer1.isChecked();

        CheckBox goodAnswer2 = findViewById(R.id.Question_4_Option_4_checkbox);
        boolean isGoodAnswer2Checked = goodAnswer2.isChecked();

        CheckBox badAnswer1 = findViewById(R.id.Question_4_Option_1_checkbox);
        boolean isBadAnswer1Checked = badAnswer1.isChecked();

        CheckBox badAnswer2 = findViewById(R.id.Question_4_Option_2_checkbox);
        boolean isBadAnswer2Checked = badAnswer2.isChecked();

        if ((!isBadAnswer1Checked && !isBadAnswer2Checked) && (isGoodAnswer1Checked && isGoodAnswer2Checked)) {
            return 1;
        }
        return 0;
    }


    /**
     * This is answers for question 7
     *@return 1 if correct
     */

    public int question_7() {
        CheckBox goodAnswer1 = findViewById(R.id.Question_7_Option_1_checkbox);
        boolean isGoodAnswer1Checked = goodAnswer1.isChecked();

        CheckBox goodAnswer2 = findViewById(R.id.Question_7_Option_3_checkbox);
        boolean isGoodAnswer2Checked = goodAnswer2.isChecked();

        CheckBox goodAnswer3 = findViewById(R.id.Question_7_Option_4_checkbox);
        boolean isGoodAnswer3Checked = goodAnswer3.isChecked();

        CheckBox badAnswer1 = findViewById(R.id.Question_7_Option_2_checkbox);
        boolean isBadAnswer1Checked = badAnswer1.isChecked();


        if ((!isBadAnswer1Checked) && (isGoodAnswer1Checked && isGoodAnswer2Checked && isGoodAnswer3Checked)) {
            return 1;
        }
        return 0;
    }



    /**
     * Checks question_3
     * @return 1 if correct
     */

    public int question_3() {
        EditText question3EditText = (EditText) findViewById(R.id.Question_3_Question_EditText);
        String correctAnswer3 = question3EditText.getText().toString();
        if (correctAnswer3.equals("Shape Of You") || correctAnswer3.equals("shape of you")
                || correctAnswer3.equals("Shape of you") || correctAnswer3.equals("Shape of You")) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks question_6
     * @return 1 if correct
     */

    public int question_6() {
        EditText question3EditText = (EditText) findViewById(R.id.Question_6_Question_EditText);
        String correctAnswer6 = question3EditText.getText().toString();
        if (correctAnswer6.equals("Maroom 5") || correctAnswer6.equals("maroom 5")
                || correctAnswer6.equals("Maroom5") || correctAnswer6.equals("maroom5")) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks question_9
     * @return 1 if correct
     */

    public int question_9() {
        EditText question3EditText = (EditText) findViewById(R.id.Question_9_Question_EditText);
        String correctAnswer9 = question3EditText.getText().toString();
        if (correctAnswer9.equals("Uptown Funk") || correctAnswer9.equals("Uptown funk")
                || correctAnswer9.equals("uptown funk")) {
            return 1;
        }
        return 0;
    }


    /**
     * Checks if a RadioButton question is correct provided by the ID of the question and the ID
     * of the correct answer
     *
     * @param questionID ID of the RadioButton question to be checked
     * @param answerID   ID of the correct answer of the RadioButton question
     * @return 1 if correct else 0
     */

    public int questions_25810(int questionID, int answerID) {
        RadioGroup question = (RadioGroup) findViewById(questionID);
        int selectedId = question.getCheckedRadioButtonId();
        RadioButton submitAnswersRadioButton = (RadioButton) findViewById(selectedId);
        if (question.getCheckedRadioButtonId() == -1) {
            return 0;
        } else if (submitAnswersRadioButton.getId() == answerID) {
            return 1;
        }
        return 0;
    }


    public void getScore(View view) {
        int totalScore;
        totalScore = question_1() + questions_25810(R.id.Question_2_Question_Radio, R.id.Question_2_Option_1_radio_button) + question_3()
        + question_4() + questions_25810(R.id.Question_5_Question_Radio, R.id.Question_5_Option_3_radio_button) + question_6()
        + question_7() + questions_25810(R.id.Question_8_Question_Radio, R.id.Question_8_Option_4_radio_button) + question_9()
        + questions_25810(R.id.Question_10_Question_Radio, R.id.Question_10_Option_1_radio_button);
        String scoreMessage = getResources().getString(R.string.scoreMessage, totalScore);
        switch (totalScore) {
            case 0:
                Toast.makeText(MainActivity.this, scoreMessage + "\n no correct answers", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(MainActivity.this, scoreMessage + " \n only 1 correct answer", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, scoreMessage + "\n nice try!", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, scoreMessage + "\n Good!", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this, scoreMessage + "\n isn't it fun?", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(MainActivity.this, scoreMessage + " \n You got half right!", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(MainActivity.this, scoreMessage + "\n Good game!", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(MainActivity.this, scoreMessage + "\n You are a real player!", Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(MainActivity.this, scoreMessage + "\n almost everything is correct!", Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(MainActivity.this, scoreMessage + "\n You really like music don't you?", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(MainActivity.this, scoreMessage + "\n well done! everything is correct!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}