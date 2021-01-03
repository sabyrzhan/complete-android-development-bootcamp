package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final List<Integer> RESET_STORY_LIST = Arrays.asList(4,5,6);

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button topButton, bottomButton;
    private TextView textView;
    private int story, textViewResId, topButtonResId, bottomButtonResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        story = 1;
        textViewResId = R.string.T1_Story;
        topButtonResId = R.string.T1_Ans1;
        bottomButtonResId = R.string.T1_Ans2;

        if (savedInstanceState != null) {
            int savedStory = savedInstanceState.getInt("Story");
            if (!RESET_STORY_LIST.contains(savedStory)) {
                story = savedStory;
                textViewResId = savedInstanceState.getInt("textViewResId");
                topButtonResId = savedInstanceState.getInt("topButtonResId");
                bottomButtonResId = savedInstanceState.getInt("bottomButtonResId");
            }
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        textView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        textView.setText(textViewResId);
        topButton.setText(topButtonResId);
        bottomButton.setText(bottomButtonResId);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (story) {
                    case 1:
                    case 2:
                        story = 3;
                        textViewResId = R.string.T3_Story;
                        topButtonResId = R.string.T3_Ans1;
                        bottomButtonResId = R.string.T3_Ans2;
                        updateViews();
                        break;
                    case 3:
                        story = 6;
                        textViewResId = R.string.T6_End;
                        updateViews();
                        break;
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (story) {
                    case 1:
                        story = 2;
                        textViewResId = R.string.T2_Story;
                        topButtonResId = R.string.T2_Ans1;
                        bottomButtonResId = R.string.T2_Ans2;
                        updateViews();
                        break;
                    case 2:
                        story = 4;
                        textViewResId = R.string.T4_End;
                        updateViews();
                        break;
                    case 3:
                        story = 5;
                        textViewResId = R.string.T5_End;
                        updateViews();
                        break;
                }
            }
        });

    }

    private void updateViews() {
        textView.setText(textViewResId);
        topButton.setText(topButtonResId);
        bottomButton.setText(bottomButtonResId);

        if (RESET_STORY_LIST.contains(story)) {
            topButton.setVisibility(View.GONE);
            bottomButton.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Story", story);
        outState.putInt("textViewResId", textViewResId);
        outState.putInt("topButtonResId", topButtonResId);
        outState.putInt("bottomButtonResId", bottomButtonResId);
    }
}
