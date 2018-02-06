package com.example.android.project2scorekeeper;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.project2scorekeeper.R;

public class MainActivity extends AppCompatActivity {
    //global variables
    int runTeamA=0;
    int  overTeamA=0;
    int ballTeamA=0;
    int wktTeamA=0;
    int runTeamB=0;
    int overTeamB=0;
    int ballTeamB=0;
    int wktTeamB=0;
    int runDiff= runTeamA-runTeamB;
    int wktDiff=10-wktTeamB;
    boolean batFirst=false;
    boolean ballFirst=false;
    static final String Bat_First_Team="hello";
    static final String Ball_First_Team="hi";
    static final String TEAM_A_RUN = "teamARun";
    static final String TEAM_A_BALL = "teamABall";
    static final String TEAM_A_OVER = "teamAOver";
    static final String TEAM_A_WKT = "teamAWkt";
    static final String TEAM_B_RUN = "teamBRun";
    static final String TEAM_B_BALL = "teamBBall";
    static final String TEAM_B_OVER = "teamBOver";
    static final String TEAM_B_WKT = "teamBWkt";
    static final String BAT_FIRST="batfirst";
    static final String BALL_FIRST="ballfirst";
    static  final String RESULT_CHOICE="1 for teamA win, 2 for tamB win, 3 for draw";
    EditText batFirstEditText;
    EditText ballFirstEditText;
    String batFirstTeam="abc";
    String ballFirstTeam="def";
    int resultChoice=0;
    int myColor;
   //ON CREATE METHOD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batFirstEditText=(EditText)findViewById(R.id.battingFirstName);
        ballFirstEditText=(EditText)findViewById(R.id.ballFirstName);
        myColor = getResources().getColor(R.color.colorAccent);
    }
    //SAVED INSTANCE STATE
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(TEAM_A_RUN, runTeamA);
        savedInstanceState.putInt(TEAM_A_OVER, overTeamA);
        savedInstanceState.putInt(TEAM_A_BALL,ballTeamA);
        savedInstanceState.putInt(TEAM_A_WKT,wktTeamA);
        savedInstanceState.putInt(TEAM_B_RUN,runTeamB);
        savedInstanceState.putInt(TEAM_B_BALL,ballTeamB);
        savedInstanceState.putInt(TEAM_B_OVER,overTeamB);
        savedInstanceState.putInt(TEAM_B_WKT,wktTeamB);
        savedInstanceState.putInt(RESULT_CHOICE,resultChoice);
        savedInstanceState.putBoolean(BAT_FIRST,batFirst);
        savedInstanceState.putBoolean(BALL_FIRST,ballFirst);
        ballFirstTeam=ballFirstEditText.getText().toString();
        batFirstTeam=batFirstEditText.getText().toString();
        savedInstanceState.putString(Bat_First_Team,batFirstTeam);
        savedInstanceState.putString(Ball_First_Team,ballFirstTeam);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    //RESTORE INSTANCE STATE METHOD
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance

        runTeamA = savedInstanceState.getInt(TEAM_A_RUN);
        overTeamA = savedInstanceState.getInt(TEAM_A_OVER);
        wktTeamA=savedInstanceState.getInt(TEAM_A_WKT);
        ballTeamA=savedInstanceState.getInt(TEAM_A_BALL);
        runTeamB=savedInstanceState.getInt(TEAM_B_RUN);
        ballTeamB=savedInstanceState.getInt(TEAM_B_BALL);
        overTeamB=savedInstanceState.getInt(TEAM_B_OVER);
        wktTeamB=savedInstanceState.getInt(TEAM_B_WKT);
        batFirst=savedInstanceState.getBoolean(BAT_FIRST);
        ballFirst=savedInstanceState.getBoolean(BALL_FIRST);
        String batFirstTeam=savedInstanceState.getString(Bat_First_Team);
        String ballFirstTeam=savedInstanceState.getString(Ball_First_Team);
        resultChoice=savedInstanceState.getInt(RESULT_CHOICE);
        displayRunTeamA(runTeamA);
        displayOverTeamA(overTeamA);
        displayWktTeamA(wktTeamA);
        displayBallTeamA(ballTeamA);
        displayBallTeamB(ballTeamB);
        displayRunTeamB(runTeamB);
        displayOverTeamB(overTeamB);
        displayWktTeamB(wktTeamB);
        String commentryA=  batFirstTeam +" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
        String commentryB=  ballFirstTeam +" Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+"."+ballTeamB+" Overs.";
        runDiff=runTeamA-runTeamB;
        String teamAWin= batFirstTeam +"Won The Game By " +runDiff+ " runs!" ;
        wktDiff=10-wktTeamB;
        String teamBWin= ballFirstTeam +"Won The Game for "+wktDiff+ " Wickets!";
        if(ballTeamA>0|| runTeamA>0){
            displayResult(commentryA);

        }
        if(ballTeamB>0 || runTeamB>0){
            displayResultB(commentryB);

        }
        if (resultChoice==1){
            displayFinalResult(teamAWin);

        }
        if (resultChoice==2){
            displayFinalResult(teamBWin);

        }

        if (resultChoice==3){
            String result = "The Game is Drawn!";
            displayFinalResult(result);


        }
        if(batFirst ==true && ballFirst==true){
            ballFirstEditText.setCursorVisible(false);
            batFirstEditText.setCursorVisible(false);
        }

    }
    //SETTING BATTING FIRST METHOD
    public void setBatFirst(View view){
        if (TextUtils.isEmpty(batFirstEditText.getText().toString())) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Batting Team Name.", Toast.LENGTH_SHORT);
            toast.show(); // display the Toast

        }
        else {
            batFirst=true;

            batFirstTeam=batFirstEditText.getText().toString();
            batFirstEditText.setBackgroundColor(myColor);
            batFirstEditText.setText(batFirstTeam);
            batFirstEditText.setCursorVisible(false);

        }
    }
    //SETTING BAWLING FIRST METHOD
    public void setBallFirst(View view ) {


        if (TextUtils.isEmpty(ballFirstEditText.getText().toString())) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Balling Team Name.", Toast.LENGTH_SHORT);
            toast.show(); // display the Toast

        }
        else {

            ballFirst=true;
            ballFirstTeam = ballFirstEditText.getText().toString();
            ballFirstEditText.setBackgroundColor(myColor);
            ballFirstEditText.setText(ballFirstTeam);
            ballFirstEditText.setCursorVisible(false);
        }
    }
    //DISPLAY BATTING TEAM  RUN METHOD
    public void displayRunTeamA(int run ){
        TextView runView= (TextView) findViewById(R.id.team_a_run);
        runView.setText(String.valueOf(run));
    }

    //BATTING TEAM WICKET DISPLAY
    public void displayWktTeamA(int wkt){
        TextView wktView= (TextView) findViewById(R.id.team_a_wkt);
        wktView.setText(String.valueOf(wkt));
    }

    //BATTING TEAM OVER DISPLAY
    public void displayOverTeamA(int over){
        TextView overView= (TextView) findViewById(R.id.team_a_over);
        overView.setText(String.valueOf(over));
    }
     //BATTING TEAM BALL DISPLAY
    public void displayBallTeamA(int ball){
        TextView ballView= (TextView) findViewById(R.id.team_a_ball);
        ballView.setText(String.valueOf(ball));
    }
     //BATTING TEAM 1 RUN ADDING
    public void oneRunTeamA(View view ){

        batFirstTeam=batFirstEditText.getText().toString();
        if(batFirst==true&& ballFirst==true&& overTeamA<20 && wktTeamA<10){
            runTeamA=runTeamA+1;
            displayRunTeamA(runTeamA);

            String commentryA= batFirstTeam +" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";


            displayResult(commentryA);

        }
        if(overTeamA==20 || wktTeamA==10){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }

    }
     //BATTING TEAM 4 RUN ADDING
    public void bndryTeamA(View view){

        batFirstTeam=batFirstEditText.getText().toString();
        if(batFirst==true&& ballFirst==true&& overTeamA<20 && wktTeamA<10){
            runTeamA=runTeamA+4;
            displayRunTeamA(runTeamA);
             String commentryA=batFirstTeam +"Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
            displayResult(commentryA);

        }
        if(overTeamA==20 || wktTeamA==10){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }



    }
    //BATTING TEAM 6 RUN ADDING
    public void sixTeamA(View view){

        batFirstTeam=batFirstEditText.getText().toString();
        if(batFirst==true&& ballFirst==true&& overTeamA<20 && wktTeamA<10){
            runTeamA=runTeamA+6;
            displayRunTeamA(runTeamA);
             String commentryA=batFirstTeam+" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
            displayResult(commentryA);

        }
        if(overTeamA==20 || wktTeamA==10){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }

        if(batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
    }

    //BATTING TEAM 1 BALL ADDING
    public void addBallTeamA(View view){
        batFirstTeam=batFirstEditText.getText().toString();
        if(batFirst==true&& ballFirst==true){

            if(overTeamA>19){

                overTeamA=20;
                ballTeamA=0;
                String commentryA=batFirstTeam+" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";


                displayResult(commentryA);
            }

            if(overTeamA<=19){



                if (ballTeamA<6){
                    ballTeamA=ballTeamA+1;

                }
                if(ballTeamA>5){
                    ballTeamA=0;
                    overTeamA=overTeamA+1;
                }
            }
            displayOverTeamA(overTeamA);
            displayBallTeamA(ballTeamA);
            String commentryA=batFirstTeam +" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
            displayResult(commentryA);
        }
        if(overTeamA==20 || wktTeamA==10){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if (batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }

    }
    //BATTING TEAM WICKET ADDDING
    public void addWktTeamA(View view) {
        batFirstTeam=batFirstEditText.getText().toString();
        if(batFirst==true&& ballFirst==true){

            if (wktTeamA < 10) {

                wktTeamA = wktTeamA + 1;
                displayWktTeamA(wktTeamA);
                String commentryA=batFirstTeam +" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
                displayResult(commentryA);
            }

            if (wktTeamA >9) {

                wktTeamA = 10;
                displayWktTeamA(wktTeamA);
                String commentryA=batFirstTeam +" Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";


                displayResult(commentryA);

            }
        }
        if(overTeamA==20 || wktTeamA==10){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(ballFirst==false || batFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();
        }
    }
    //BALLING TEAM RUN DISPLAY
    public void displayRunTeamB(int run){
        TextView runView= (TextView) findViewById(R.id.team_b_run);
        runView.setText(String.valueOf(run));
    }

    //BALLING TEAM WICKET DISPLAY
    public void displayWktTeamB(int wkt){
        TextView wktView= (TextView) findViewById(R.id.team_b_wkt);
        wktView.setText(String.valueOf(wkt));
    }
    //BALLING TEAM OVER DISPLAY
    public void displayOverTeamB(int over){
        TextView overView= (TextView) findViewById(R.id.team_b_over);
        overView.setText(String.valueOf(over));
    }
    //BALLING TEAM BALL DISPLAY
    public void displayBallTeamB(int ball){
        TextView ballView= (TextView) findViewById(R.id.team_b_ball);
        ballView.setText(String.valueOf(ball));
    }
    //BALLING TEAM 1 RUN ADDING
    public void oneRunTeamB(View view){
        ballFirstTeam=ballFirstEditText.getText().toString();
        batFirstTeam=batFirstEditText.getText().toString();

        if(wktTeamA==10 || overTeamA==20 && overTeamB<20 && wktTeamB<10&& resultChoice==0){


            runTeamB=runTeamB+1;
            String commentryB=ballFirstTeam +" Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+" Overs.";
            displayRunTeamB(runTeamB);
            displayResultB(commentryB);


            if(runTeamB>runTeamA){
                resultChoice=2;
                wktDiff=10-wktTeamB;
                String teamBWin= ballFirstTeam +" Won The Game for "+wktDiff+ " Wickets!";
                displayFinalResult(teamBWin);



            }
            if ((runTeamA==runTeamB) && (overTeamB==20)){
                resultChoice=3;

                String result=" The Game is Drawn!";
                displayFinalResult(result);


            }


        }
        if(overTeamB==20 || wktTeamB==10){
            Toast toast = Toast.makeText(getApplicationContext(), ballFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(overTeamA<20&& wktTeamA<10 ){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+" Batting.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(resultChoice!=0){
            Toast toast = Toast.makeText(getApplicationContext(), "Game Already Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
    }
    //BALLING TEAM 4 RUN ADDING
    public void bndryTeamB(View view){

        ballFirstTeam=ballFirstEditText.getText().toString();
        batFirstTeam=batFirstEditText.getText().toString();

        if(wktTeamA==10 || overTeamA==20 && overTeamB<20 && wktTeamB<10 && resultChoice==0) {

            runTeamB=runTeamB+4;
            displayRunTeamB(runTeamB);
            String commentry=ballFirstTeam+" Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+" Overs.";
            displayResultB(commentry);
            if(runTeamB>runTeamA){
                resultChoice=2;
                String teamBWin= ballFirstTeam+" Won The Game By "+wktDiff+ " Wickets!";
                displayFinalResult(teamBWin);



            }
            if ((runTeamA==runTeamB) && (overTeamB==20)){
                resultChoice=3;

                String result=" The Game is Drawn!";
                displayFinalResult(result);


            }

        }
        if(overTeamB==20 || wktTeamB==10){
            Toast toast = Toast.makeText(getApplicationContext(), ballFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(overTeamA<20&& wktTeamA<10 ){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+" Batting.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(resultChoice!=0){
            Toast toast = Toast.makeText(getApplicationContext(), "Game Already Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }

    }
    //BALLING TEAM 6 RUN ADDING
    public void sixTeamB(View view){
        ballFirstTeam=ballFirstEditText.getText().toString();
        batFirstTeam=batFirstEditText.getText().toString();

        if(wktTeamA==10 || overTeamA==20 && overTeamB<20 && wktTeamB<10 && resultChoice==0) {
            runTeamB=runTeamB+6;
            displayRunTeamB(runTeamB);
            String commentryB=ballFirstTeam +"Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+" Overs.";
            displayResultB(commentryB);

            if(runTeamB>runTeamA){
                resultChoice=2;
                wktDiff=10-wktTeamB;
                String teamBWin= ballFirstTeam+" Won The Game By "+wktDiff+ " Wickets!";
                displayFinalResult(teamBWin);



            }
            if ((runTeamA==runTeamB) && (overTeamB==20)){
                resultChoice=3;

                String result=" The Game is Drawn!";
                displayFinalResult(result);


            }

        }
        if(overTeamB==20 || wktTeamB==10){
            Toast toast = Toast.makeText(getApplicationContext(), ballFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(batFirst==false || ballFirst==false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter The Team Names and Batting Order.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(overTeamA<20 && wktTeamA<10 ){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+" Batting.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(resultChoice!=0){
            Toast toast = Toast.makeText(getApplicationContext(), "Game Already Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }

    }
    //BALLING TEAM 1 BALL ADDING
    public void addBallTeamB(View view) {
        ballFirstTeam=ballFirstEditText.getText().toString();
        batFirstTeam=batFirstEditText.getText().toString();
        if(wktTeamA==10 || overTeamA==20 && overTeamB<20 && wktTeamB<10 && resultChoice==0) {
            if (overTeamB < 20) {


                if (ballTeamB < 6) {
                    ballTeamB = ballTeamB + 1;

                }
                if (ballTeamB > 5 && overTeamB < 20) {
                    ballTeamB = 0;
                    overTeamB = overTeamB + 1;
                }


                displayOverTeamB(overTeamB);
                displayBallTeamB(ballTeamB);
                String commentryB = ballFirstTeam +" Scored " + runTeamB + " for " + wktTeamB + " in " + overTeamB + "." + ballTeamB + " Overs.";
                displayResultB(commentryB);

                if (overTeamB == 20) {
                    overTeamB = 20;
                    ballTeamB = 0;
                    commentryB = ballFirstTeam +" Scored " + runTeamB + " for " + wktTeamB + " in " + overTeamB + "." + ballTeamB + " Overs.";
                    displayResultB(commentryB);
                    if (runTeamA > runTeamB) {
                        resultChoice=1;
                        runDiff=runTeamA-runTeamB;
                        String teamAWin= batFirstTeam +"Won The Game By " +runDiff+ " runs!" ;
                        displayFinalResult(teamAWin);


                    }
                    if (runTeamB > runTeamA) {
                        resultChoice=2;
                        wktDiff=10-wktTeamB;
                        String teamBWin= ballFirstTeam+" Won The Game By "+wktDiff+ " Wickets!";
                        displayFinalResult(teamBWin);


                    }
                    if (runTeamA == runTeamB) {
                        resultChoice=3;
                        String result = "The Game is Drawn!";
                        displayFinalResult(result);


                    }


                }

        }

        }
        if(overTeamB==20 || wktTeamB==10){
            Toast toast = Toast.makeText(getApplicationContext(), ballFirstTeam+"'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(batFirst==false || ballFirst==false){
            Toast toast = Toast.makeText(getApplicationContext(), "Please Set The Team Names, Batting Order and Finish Scoring Bat First Team. ", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(overTeamA<20&& wktTeamA<10 ){
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam+" Batting.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if(resultChoice!=0){
            Toast toast = Toast.makeText(getApplicationContext(), "Game Already Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
    }
    //BALLING TEAM WICKET ADDING
    public void addWktTeamB(View view) {
        ballFirstTeam = ballFirstEditText.getText().toString();
        batFirstTeam = batFirstEditText.getText().toString();
        if (wktTeamA == 10 || overTeamA == 20 && overTeamB < 20 && wktTeamB < 10 && resultChoice == 0) {

            if (wktTeamB < 10) {

                wktTeamB = wktTeamB + 1;
                displayWktTeamB(wktTeamB);
                String commentryB = ballFirstTeam + " Scored " + runTeamB + " for " + wktTeamB + " in " + overTeamB + "." + ballTeamB + " Overs.";
                displayResultB(commentryB);
            }

            if (wktTeamB > 9) {

                wktTeamB = 10;
                runDiff = runTeamA - runTeamB;
                displayWktTeamB(wktTeamB);
                String commentryB = ballFirstTeam + " Scored " + runTeamB + " for " + wktTeamB + " in " + overTeamB + "." + ballTeamB + " Overs.";
                displayResultB(commentryB);
                if (runTeamA > runTeamB) {
                    resultChoice = 1;
                    String teamAWin = batFirstTeam + "Won The Game By " + runDiff + " runs!";

                    displayFinalResult(teamAWin);


                }
                if (runTeamB > runTeamA) {
                    resultChoice = 2;
                    wktDiff = 10 - wktTeamB;
                    String teamBWin = ballFirstTeam + " Won The Game By " + wktDiff + " Wickets!";
                    displayFinalResult(teamBWin);


                }
                if (runTeamA == runTeamB) {
                    resultChoice = 3;
                    String result = "The Game is Drawn!";
                    displayFinalResult(result);

                }
            }


        }

        if (overTeamB == 20 || wktTeamB == 10) {
            Toast toast = Toast.makeText(getApplicationContext(), ballFirstTeam + "'s Batting Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if (ballFirst == false && batFirst == false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Set The Team Names, Batting Order and Finish Scoring Bat First Team. ", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();
        }
        if (overTeamA < 20 && wktTeamA < 10) {
            Toast toast = Toast.makeText(getApplicationContext(), batFirstTeam + " Batting.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
        if (resultChoice != 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Game Already Finished.", Toast.LENGTH_SHORT); // initiate the Toast with context, message and duration for the Toast
            toast.show();

        }
    }
    //BATTING TEAM COMMENTARY
    public void displayResult(String result ) {

        TextView resultView = (TextView) findViewById(R.id.resultA);
        resultView.setText(result);

    }

    //BALLING TEAM COMMENTARY
    public void displayResultB(String result){

        TextView resultView = (TextView) findViewById(R.id.resultB);
        resultView.setText(result);

    }
    //FINAL RESULT COMMENTARY
    public void displayFinalResult(String result){

        TextView resultView = (TextView) findViewById(R.id.finalResult);
        resultView.setText(result);

    }
    //RESET BUTTON
    public void reset(View view){
        runTeamA=0;
        wktTeamA=0;
        overTeamA=0;
        ballTeamA=0;
        runTeamB=0;
        wktTeamB=0;
        overTeamB=0;
        ballTeamB=0;
        resultChoice=0;
        displayRunTeamA(runTeamA);
        displayWktTeamA(wktTeamA);
        displayOverTeamA(overTeamA);
        displayBallTeamA(ballTeamA);
        displayRunTeamB(runTeamB);
        displayWktTeamB(wktTeamB);
        displayOverTeamB(overTeamB);
        displayBallTeamB(ballTeamB);
        displayResult("");
        displayResultB("");
        displayFinalResult("");
        ballFirstEditText.setText(null);
        ballFirstEditText.setCursorVisible(true);
        batFirstEditText.setCursorVisible(true);
        batFirstEditText.setText(null);
        batFirstTeam="";
        ballFirstTeam="";
        batFirst=false;
        ballFirst=false;
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(ballFirstEditText, InputMethodManager.SHOW_IMPLICIT);
        imm.showSoftInput(batFirstEditText, InputMethodManager.SHOW_IMPLICIT);

    }
}