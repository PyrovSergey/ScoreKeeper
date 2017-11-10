package udacity.com.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    // Tracks the corner for Team A
    int numberOfCornerTeamA = 0;

    // Tracks the corner for Team B
    int numberOfCornerTeamB = 0;

    // Tracks the yellow card for Team A
    int numberOfYellowCardTeamA = 0;

    // Tracks the yellow card for Team B
    int numberOfYellowCardTeamB = 0;

    // Tracks the red card for Team A
    int numberOfRedCardTeamA = 0;

    // Tracks the red card for Team B
    int numberOfRedCardTeamB = 0;

    TextView scoreViewATeam;
    TextView redCardViewATeam;
    TextView yellowCardViewATeam;
    TextView cornerViewATeam;

    TextView scoreViewBTeam;
    TextView redCardViewBTeam;
    TextView yellowCardViewBTeam;
    TextView cornerViewBTeam;

    Button button_red_card_a;
    Button button_yellow_card_a;
    Button button_corner_a;
    Button button_goal_a;

    Button button_red_card_b;
    Button button_yellow_card_b;
    Button button_corner_b;
    Button button_goal_b;

    Button button_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewATeam = (TextView) findViewById(R.id.team_a_score);
        redCardViewATeam = (TextView) findViewById(R.id.team_a_red_card);
        yellowCardViewATeam = (TextView) findViewById(R.id.team_a_yellow_card);
        cornerViewATeam = (TextView) findViewById(R.id.team_a_corner);

        scoreViewBTeam = (TextView) findViewById(R.id.team_b_score);
        redCardViewBTeam = (TextView) findViewById(R.id.team_b_red_card);
        yellowCardViewBTeam = (TextView) findViewById(R.id.team_b_yellow_card);
        cornerViewBTeam = (TextView) findViewById(R.id.team_b_corner);

        button_red_card_a = (Button) findViewById(R.id.button_red_card_a);
        button_yellow_card_a = (Button) findViewById(R.id.button_yellow_card_a);
        button_corner_a = (Button) findViewById(R.id.button_corner_a);
        button_goal_a = (Button) findViewById(R.id.button_goal_a);

        button_red_card_b = (Button) findViewById(R.id.button_red_card_b);
        button_yellow_card_b = (Button) findViewById(R.id.button_yellow_card_b);
        button_corner_b = (Button) findViewById(R.id.button_corner_b);
        button_goal_b = (Button) findViewById(R.id.button_goal_b);

        button_reset = (Button) findViewById(R.id.button_reset);

        button_red_card_a.setOnClickListener(this);
        button_yellow_card_a.setOnClickListener(this);
        button_corner_a.setOnClickListener(this);
        button_goal_a.setOnClickListener(this);

        button_red_card_b.setOnClickListener(this);
        button_yellow_card_b.setOnClickListener(this);
        button_corner_b.setOnClickListener(this);
        button_goal_b.setOnClickListener(this);

        button_reset.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Resets the score for both teams back to 0.
    public void resetScore() {
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

    public void display() {
         scoreViewATeam.setText(scoreTeamA);
         redCardViewATeam.setText(numberOfRedCardTeamA);
         yellowCardViewATeam.setText(numberOfYellowCardTeamA);
         cornerViewATeam.setText(numberOfCornerTeamA);

         scoreViewBTeam.setText(scoreTeamB);
         redCardViewBTeam.setText(numberOfRedCardTeamB);
         yellowCardViewBTeam.setText(numberOfYellowCardTeamB);
         cornerViewBTeam.setText(numberOfCornerTeamB);
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
