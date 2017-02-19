package com.example.ark.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluateQuiz(View V) {
        int quizScore = 0;
//First Question

        TextView correctAns1 = (TextView) findViewById(R.id.correct_answer1);
        correctAns1.setVisibility(View.VISIBLE);
        String correctAnsMsg = getString(R.string.correctMsg) + getString(R.string.q1answer);
        correctAns1.setText(correctAnsMsg);
//Second Question
        RadioGroup rbGroup2 = (RadioGroup) findViewById(R.id.q2_options);
        int selectedId2 = rbGroup2.getCheckedRadioButtonId();
        if (selectedId2 != -1) {
            RadioButton selectedRadioButton2 = (RadioButton) findViewById(selectedId2);
            String radioButtonText2 = selectedRadioButton2.getText().toString();
            if ((radioButtonText2).equals(getString(R.string.q2answer))) {
                quizScore = quizScore + 1;
            }
        }
        TextView correctAns2 = (TextView) findViewById(R.id.correct_answer2);
        correctAns2.setVisibility(View.VISIBLE);
        correctAnsMsg = getString(R.string.correctMsg) + getString(R.string.q2answer);
        correctAns2.setText(correctAnsMsg);
//Third Question
        CheckBox qAnswer1 = (CheckBox) findViewById(R.id.checkbox1);
        boolean isChecked1 = qAnswer1.isChecked();
        CheckBox qAnswer2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean isChecked2 = qAnswer2.isChecked();
        CheckBox qAnswer3 = (CheckBox) findViewById(R.id.checkbox3);
        boolean isChecked3 = qAnswer3.isChecked();
        CheckBox qAnswer4 = (CheckBox) findViewById(R.id.checkbox4);
        boolean isChecked4 = qAnswer4.isChecked();
        if (isChecked2 && isChecked4 && !isChecked1 && !isChecked3) {
            quizScore = quizScore + 1;
        }
        TextView correctAns3 = (TextView) findViewById(R.id.correct_answer3);
        correctAns3.setVisibility(View.VISIBLE);
        correctAnsMsg = getString(R.string.correctMsg) + getString(R.string.q3answer);
        correctAns3.setText(correctAnsMsg);
//Fourth Question
        EditText yogaPose = (EditText) findViewById(R.id.yogapose_name);
        String yogaPoseName = yogaPose.getText().toString();
        String answer4 = getString(R.string.q4answer);
        if (yogaPoseName.equalsIgnoreCase(answer4)) {
            quizScore = quizScore + 1;
        }
        TextView correctAns4 = (TextView) findViewById(R.id.correct_answer4);
        correctAns4.setVisibility(View.VISIBLE);
        correctAnsMsg = getString(R.string.correctMsg) + getString(R.string.q4answer);
        correctAns4.setText(correctAnsMsg);
//Fifth Question
        RadioGroup rbGroup5 = (RadioGroup) findViewById(R.id.q5_options);
        int selectedId5 = rbGroup5.getCheckedRadioButtonId();
        if (selectedId5 != -1) {
            RadioButton selectedRadioButton5 = (RadioButton) findViewById(selectedId5);
            String radioButtonText3 = selectedRadioButton5.getText().toString();
            if ((radioButtonText3).equals(getString(R.string.q5answer))) {
                quizScore = quizScore + 1;
            }
        }
        TextView correctAns5 = (TextView) findViewById(R.id.correct_answer5);
        correctAns5.setVisibility(View.VISIBLE);
        correctAnsMsg = getString(R.string.correctMsg) + getString(R.string.q5answer);
        correctAns5.setText(correctAnsMsg);
        TextView quizResult = (TextView) findViewById(R.id.result_text_view);
        String resultMsg = getString(R.string.resultmsg);
        resultMsg = resultMsg + quizScore;
        quizResult.setText(resultMsg);
        Toast.makeText(MainActivity.this, resultMsg, Toast.LENGTH_SHORT).show();
        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setVisibility(View.INVISIBLE);
    }

    public void resetButton(View V) {
        ViewGroup vg = (ViewGroup) findViewById(R.id.main_layout);
        vg.invalidate();
        setContentView(R.layout.activity_main);
    }

}
