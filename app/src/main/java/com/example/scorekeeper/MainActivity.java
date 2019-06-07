package com.example.scorekeeper;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Up;
    TextView Down;
    int ScoreUp=0;
    int ScoreDown=0;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_SCORE_1, ScoreUp);
        outState.putInt(STATE_SCORE_2, ScoreDown);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Up=findViewById(R.id.textViewUp);
        Down=findViewById(R.id.textViewUp2);

        if (savedInstanceState != null) {
            ScoreUp = savedInstanceState.getInt(STATE_SCORE_1);
            ScoreDown = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            Up.setText(String.valueOf(ScoreUp));
            Down.setText(String.valueOf(ScoreDown));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu, menu);

        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode= AppCompatDelegate.getDefaultNightMode();
            if(nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void Clickhandler(View view) {
        switch (view.getId()){
            case R.id.imageButtonLeft:
                ScoreUp--;
                Up.setText(Integer.toString(ScoreUp));
                break;
            case R.id.imageButtonRight:
                ScoreUp++;
                Up.setText(Integer.toString(ScoreUp));
                break;
            case R.id.imageButtonLeft2:
                ScoreDown--;
                Down.setText(Integer.toString(ScoreDown));
                break;
            case R.id.imageButtonRight2:
                ScoreDown++;
                Down.setText(Integer.toString(ScoreDown));
                break;

        }
    }


}
