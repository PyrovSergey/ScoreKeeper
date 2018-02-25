package udacity.com.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String SCORE_TEAM_A = "scoreTeamA";
    private final static String SCORE_TEAM_B = "scoreTeamB";
    private final static String NUMBER_OF_CORNER_TEAM_A = "numberOfCornerTeamA";
    private final static String NUMBER_OF_CORNER_TEAM_B = "numberOfCornerTeamB";
    private final static String NUMBER_OF_YELLOW_CARD_TEAM_A = "numberOfYellowCardTeamA";
    private final static String NUMBER_OF_YELLOW_CARD_TEAM_B = "numberOfYellowCardTeamB";
    private final static String NUMBER_OF_RED_CARD_TEAM_A = "numberOfRedCardTeamA";
    private final static String NUMBER_OF_RED_CARD_TEAM_B = "numberOfRedCardTeamB";

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int numberOfCornerTeamA = 0;
    private int numberOfCornerTeamB = 0;
    private int numberOfYellowCardTeamA = 0;
    private int numberOfYellowCardTeamB = 0;
    private int numberOfRedCardTeamA = 0;
    private int numberOfRedCardTeamB = 0;

    private TextView scoreViewATeam;
    private TextView redCardViewATeam;
    private TextView yellowCardViewATeam;
    private TextView cornerViewATeam;

    private TextView scoreViewBTeam;
    private TextView redCardViewBTeam;
    private TextView yellowCardViewBTeam;
    private TextView cornerViewBTeam;

    Button mButtonRedCardA;
    Button mButtonYellowCardA;
    Button mButtonCornerA;
    Button mButtonGoalA;

    Button mButtonRedCardB;
    Button mButtonYellowCardB;
    Button mButtonCornerB;
    Button mButtonGoalB;

    Button mButtonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SCORE_TEAM_A);
            savedInstanceState.getInt(SCORE_TEAM_B);
            savedInstanceState.getInt(NUMBER_OF_CORNER_TEAM_A);
            savedInstanceState.getInt(NUMBER_OF_CORNER_TEAM_B);
            savedInstanceState.getInt(NUMBER_OF_YELLOW_CARD_TEAM_A);
            savedInstanceState.getInt(NUMBER_OF_YELLOW_CARD_TEAM_B);
            savedInstanceState.getInt(NUMBER_OF_RED_CARD_TEAM_A);
            savedInstanceState.getInt(NUMBER_OF_RED_CARD_TEAM_B);
        }
        initialization();
        display();
    }

//    private void getSavedStates(Bundle savedInstanceState) {
//        if (savedInstanceState != null) {
//            savedInstanceState.getInt(SCORE_TEAM_A, 0);
//            savedInstanceState.getInt(SCORE_TEAM_B, 0);
//            savedInstanceState.getInt(NUMBER_OF_CORNER_TEAM_A, 0);
//            savedInstanceState.getInt(NUMBER_OF_CORNER_TEAM_B, 0);
//            savedInstanceState.getInt(NUMBER_OF_YELLOW_CARD_TEAM_A, 0);
//            savedInstanceState.getInt(NUMBER_OF_YELLOW_CARD_TEAM_B, 0);
//            savedInstanceState.getInt(NUMBER_OF_RED_CARD_TEAM_A, 0);
//            savedInstanceState.getInt(NUMBER_OF_RED_CARD_TEAM_B, 0);
//            display();
//        }
//    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        savedInstanceState.getInt(SCORE_TEAM_A);
//        savedInstanceState.getInt(SCORE_TEAM_B);
//        savedInstanceState.getInt(NUMBER_OF_CORNER_TEAM_A);
//        savedInstanceState.getInt(NUMBER_OF_CORNER_TEAM_B);
//        savedInstanceState.getInt(NUMBER_OF_YELLOW_CARD_TEAM_A);
//        savedInstanceState.getInt(NUMBER_OF_YELLOW_CARD_TEAM_B);
//        savedInstanceState.getInt(NUMBER_OF_RED_CARD_TEAM_A);
//        savedInstanceState.getInt(NUMBER_OF_RED_CARD_TEAM_B);
//        display();
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_TEAM_A, scoreTeamA);
        outState.putInt(SCORE_TEAM_B, scoreTeamB);
        outState.putInt(NUMBER_OF_CORNER_TEAM_A, numberOfCornerTeamA);
        outState.putInt(NUMBER_OF_CORNER_TEAM_B, numberOfCornerTeamB);
        outState.putInt(NUMBER_OF_YELLOW_CARD_TEAM_A, numberOfYellowCardTeamA);
        outState.putInt(NUMBER_OF_YELLOW_CARD_TEAM_B, numberOfYellowCardTeamB);
        outState.putInt(NUMBER_OF_RED_CARD_TEAM_A, numberOfRedCardTeamA);
        outState.putInt(NUMBER_OF_RED_CARD_TEAM_B, numberOfRedCardTeamB);
    }

    private void initialization() {
        scoreViewATeam = (TextView) findViewById(R.id.team_a_score);
        redCardViewATeam = (TextView) findViewById(R.id.team_a_red_card);
        yellowCardViewATeam = (TextView) findViewById(R.id.team_a_yellow_card);
        cornerViewATeam = (TextView) findViewById(R.id.team_a_corner);

        scoreViewBTeam = (TextView) findViewById(R.id.team_b_score);
        redCardViewBTeam = (TextView) findViewById(R.id.team_b_red_card);
        yellowCardViewBTeam = (TextView) findViewById(R.id.team_b_yellow_card);
        cornerViewBTeam = (TextView) findViewById(R.id.team_b_corner);

        mButtonRedCardA = (Button) findViewById(R.id.button_red_card_a);
        mButtonYellowCardA = (Button) findViewById(R.id.button_yellow_card_a);
        mButtonCornerA = (Button) findViewById(R.id.button_corner_a);
        mButtonGoalA = (Button) findViewById(R.id.button_goal_a);

        mButtonRedCardB = (Button) findViewById(R.id.button_red_card_b);
        mButtonYellowCardB = (Button) findViewById(R.id.button_yellow_card_b);
        mButtonCornerB = (Button) findViewById(R.id.button_corner_b);
        mButtonGoalB = (Button) findViewById(R.id.button_goal_b);

        mButtonReset = (Button) findViewById(R.id.button_reset);

        mButtonRedCardA.setOnClickListener(this);
        mButtonYellowCardA.setOnClickListener(this);
        mButtonCornerA.setOnClickListener(this);
        mButtonGoalA.setOnClickListener(this);

        mButtonRedCardB.setOnClickListener(this);
        mButtonYellowCardB.setOnClickListener(this);
        mButtonCornerB.setOnClickListener(this);
        mButtonGoalB.setOnClickListener(this);

        mButtonReset.setOnClickListener(this);
    }

    private void resetScore() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        numberOfCornerTeamA = 0;
        numberOfCornerTeamB = 0;
        numberOfYellowCardTeamA = 0;
        numberOfYellowCardTeamB = 0;
        numberOfRedCardTeamA = 0;
        numberOfRedCardTeamB = 0;
        display();
    }

    private void display() {
        scoreViewATeam.setText(String.valueOf(scoreTeamA));
        redCardViewATeam.setText(String.valueOf(numberOfRedCardTeamA));
        yellowCardViewATeam.setText(String.valueOf(numberOfYellowCardTeamA));
        cornerViewATeam.setText(String.valueOf(numberOfCornerTeamA));

        scoreViewBTeam.setText(String.valueOf(scoreTeamB));
        redCardViewBTeam.setText(String.valueOf(numberOfRedCardTeamB));
        yellowCardViewBTeam.setText(String.valueOf(numberOfYellowCardTeamB));
        cornerViewBTeam.setText(String.valueOf(numberOfCornerTeamB));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_corner_a:
                numberOfCornerTeamA++;
                display();
                break;
            case R.id.button_corner_b:
                numberOfCornerTeamB++;
                display();
                break;
            case R.id.button_red_card_a:
                numberOfRedCardTeamA++;
                display();
                break;
            case R.id.button_red_card_b:
                numberOfRedCardTeamB++;
                display();
                break;
            case R.id.button_yellow_card_a:
                numberOfYellowCardTeamA++;
                display();
                break;
            case R.id.button_yellow_card_b:
                numberOfYellowCardTeamB++;
                display();
                break;
            case R.id.button_goal_a:
                scoreTeamA++;
                display();
                break;
            case R.id.button_goal_b:
                scoreTeamB++;
                display();
                break;
            case R.id.button_reset:
                resetScore();
                display();
                break;
        }
    }
}
