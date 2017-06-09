package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                        updateStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2, 2);
                        break;
                    case 2:
                        endStory(R.string.T6_End);
                        break;
                    case 3:
                        updateStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2, 4);
                        break;
                    case 4:
                        endStory(R.string.T6_End);
                        break;
                    default:
                        Log.e("Destini", "Invalid mStoryIndex: " + mStoryIndex);
                }
            }
        });


        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                        updateStory(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2, 3);
                        break;
                    case 2:
                        endStory(R.string.T5_End);
                        break;
                    case 3:
                        endStory(R.string.T4_End);
                        break;
                    case 4:
                        endStory(R.string.T5_End);
                        break;
                    default:
                        Log.e("Destini", "Invalid mStoryIndex: " + mStoryIndex);
                }
            }
        });

    }

    private void updateStory(int storyStringId, int btnTopStringId, int btnBottomStringId, int storyIndex) {
        mStoryTextView.setText(storyStringId);
        mButtonTop.setText(btnTopStringId);
        mButtonBottom.setText(btnBottomStringId);
        mStoryIndex = storyIndex;
    }

    private void endStory(int endId) {
        mStoryTextView.setText(endId);
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }
}
