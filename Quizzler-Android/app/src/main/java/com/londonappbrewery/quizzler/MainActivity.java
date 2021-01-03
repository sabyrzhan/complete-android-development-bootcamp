package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    // TODO: Declare member variables here:
    Button trueButton, falseButton;
    TextView questionTextView;
    int questionIndex, questionId, score;
    TextView scoreTextView;
    ProgressBar progressBar;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    // TODO: Declare constants here
    final int PROGRESS_BAR_STEP = (int) Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionId = mQuestionBank[questionIndex].getQuestionId();
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text_view);
        progressBar = findViewById(R.id.progress_bar);
        scoreTextView = findViewById(R.id.score);

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("ScoreKey");
            questionIndex = savedInstanceState.getInt("IndexKey");
            updateScoreTextView();
        } else {
            score = 0;
            questionIndex = 0;
        }

        questionTextView.setText(questionId);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();
                Log.i("Quizzler", "True button pressed");
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();
                Log.i("Quizzler", "False button pressed");
            }
        });
    }

    private void updateQuestion() {
        questionIndex = ++questionIndex % mQuestionBank.length;
        if (questionIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game over");
            alert.setCancelable(false);
            alert.setMessage(String.format("You scored %d points!", score));
            alert.setPositiveButton("Close application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        Log.i("Quizzler", "Index is: " + questionIndex);
        questionId = mQuestionBank[questionIndex].getQuestionId();
        questionTextView.setText(questionId);
        if (progressBar.getProgress() >= progressBar.getMax()) {
            progressBar.setProgress(0);
        }
        progressBar.incrementProgressBy(PROGRESS_BAR_STEP);
    }

    private void checkAnswer(boolean userSelection) {
        boolean questionAnswer = mQuestionBank[questionIndex].isAnswer();

        score = questionIndex % mQuestionBank.length == 0 ? 0 : score;

        if (questionAnswer == userSelection) {
            score++;
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }

        updateScoreTextView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey", score);
        outState.putInt("IndexKey", questionIndex);
    }

    private void updateScoreTextView() {
        scoreTextView.setText(String.format("Score %d/%d", score , mQuestionBank.length));
    }
}
