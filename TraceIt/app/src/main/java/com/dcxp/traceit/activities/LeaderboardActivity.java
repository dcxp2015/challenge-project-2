package com.dcxp.traceit.activities;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dcxp.traceit.R;
import com.dcxp.traceit.backend.Leaderboard;

import java.util.List;


public class LeaderboardActivity extends Activity implements Leaderboard.ILeaderboardListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_leaderboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTopHighScoreLookupCompleted(List<Float> topScores) {

    }

    @Override
    public String getUsername() {
        return "daniel";
    }

    @Override
    public void onMyHighScoreLookUpCompleted(float highscore) {

    }
}
