package com.example.android.project2scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
    static final String TEAM_A_RUN = "teamARun";
    static final String TEAM_A_BALL = "teamABall";
    static final String TEAM_A_OVER = "teamAOver";
    static final String TEAM_A_WKT = "teamAWkt";
    static final String TEAM_B_RUN = "teamBRun";
    static final String TEAM_B_BALL = "teamBBall";
    static final String TEAM_B_OVER = "teamBOver";
    static final String TEAM_B_WKT = "teamBWkt";
    static  final String RESULT_CHOICE="1 for teamA win, 2 for tamB win, 3 for draw";

    String commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
    String commentryB="TeamB Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+"."+ballTeamB+" Overs.";
    String teamAWin= "TeamA Won The Game By " +runDiff+ " runs!" ;
    String teamBWin= "TeamB Won The Game for "+wktDiff+ " Wickets!";
    String draw= "The Game is Drawn!";
    int resultChoice=0;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




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

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

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
        resultChoice=savedInstanceState.getInt(RESULT_CHOICE);
        displayRunTeamA(runTeamA);
        displayOverTeamA(overTeamA);
        displayWktTeamA(wktTeamA);
        displayBallTeamA(ballTeamA);
        displayBallTeamB(ballTeamB);
        displayRunTeamB(runTeamB);
        displayOverTeamB(overTeamB);
        displayWktTeamB(wktTeamB);
        commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
        commentryB="TeamB Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+"."+ballTeamB+" Overs.";
        runDiff=runTeamA-runTeamB;
        teamAWin= "TeamA Won The Game By " +runDiff+ " runs!" ;
        wktDiff=10-wktTeamB;
        teamBWin= "TeamB Won The Game for "+wktDiff+ " Wickets!";
//THIS IS THE PLACE WHERE I AM MAKING THE DISPLAYS WITH IF CONDITION
        if(ballTeamA>0){
            displayResult(commentryA);

        }
        if(ballTeamB>0){
            displayResult(commentryB);

        }
        //displayResultB(commentryB);
        if (resultChoice==1){
            displayFinalResult(teamAWin);

        }
        if (resultChoice==2){
            displayFinalResult(teamBWin);

        }

        if (resultChoice==3){
            displayFinalResult(draw);


        }



    }




    //method for displaying teamA run

    public void displayRunTeamA(int run){
        TextView runView= (TextView) findViewById(R.id.team_a_run);
        runView.setText(String.valueOf(run));
    }

    //method for displaying teamA wicket

    public void displayWktTeamA(int wkt){
        TextView wktView= (TextView) findViewById(R.id.team_a_wkt);
        wktView.setText(String.valueOf(wkt));
    }

    //method for displaying teamA over

    public void displayOverTeamA(int over){
        TextView overView= (TextView) findViewById(R.id.team_a_over);
        overView.setText(String.valueOf(over));
    }

    public void displayBallTeamA(int ball){
        TextView ballView= (TextView) findViewById(R.id.team_a_ball);
        ballView.setText(String.valueOf(ball));
    }

    public void oneRunTeamA(View view){



        runTeamA=runTeamA+1;
        displayRunTeamA(runTeamA);
        commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";

        displayResult(commentryA);
    }

    public void bndryTeamA(View view){

        runTeamA=runTeamA+4;
        displayRunTeamA(runTeamA);
        commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
        displayResult(commentryA);
    }
    public void sixTeamA(View view){

        runTeamA=runTeamA+6;
        displayRunTeamA(runTeamA);
        commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
        displayResult(commentryA);
    }


    public void addBallTeamA(View view){

        if(overTeamA>19){
            //String finalResult="Team A Batting Finished";
            overTeamA=20;
            ballTeamA=0;
            commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";


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
        commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
        displayResult(commentryA);
    }

    public void addWktTeamA(View view) {

        if (wktTeamA < 10) {

            wktTeamA = wktTeamA + 1;
            displayWktTeamA(wktTeamA);
            commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";
            displayResult(commentryA);
        }

        if (wktTeamA >9) {

            wktTeamA = 10;
            displayWktTeamA(wktTeamA);
            commentryA="TeamA Scored "+runTeamA+ " for "+wktTeamA+ " in "+overTeamA+"."+ballTeamA+" Overs.";


            displayResult(commentryA);

        }
    }



    //method for displaying teamB run

    public void displayRunTeamB(int run){
        TextView runView= (TextView) findViewById(R.id.team_b_run);
        runView.setText(String.valueOf(run));
    }



    //method for displaying teamB wicket

    public void displayWktTeamB(int wkt){
        TextView wktView= (TextView) findViewById(R.id.team_b_wkt);
        wktView.setText(String.valueOf(wkt));
    }

    //method for displaying teamB over

    public void displayOverTeamB(int over){
        TextView overView= (TextView) findViewById(R.id.team_b_over);
        overView.setText(String.valueOf(over));
    }

    public void displayBallTeamB(int ball){
        TextView ballView= (TextView) findViewById(R.id.team_b_ball);
        ballView.setText(String.valueOf(ball));
    }

    public void oneRunTeamB(View view){

        runTeamB=runTeamB+1;
        commentryB="TeamB Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+" Overs.";
        displayRunTeamB(runTeamB);
        displayResultB(commentryB);


        if(runTeamB>runTeamA){
            resultChoice=2;
            wktDiff=10-wktTeamB;
            String teamBWin= "TeamB Won The Game for "+wktDiff+ " Wickets!";
            //String result="Team B Won The Game.";
            displayFinalResult(teamBWin);



        }
        if ((runTeamA==runTeamB) && (overTeamB>20)){
            resultChoice=3;

            //String result=" The Game is Drawn!";
            displayFinalResult(draw);


        }


    }

    public void bndryTeamB(View view){



        runTeamB=runTeamB+4;
        displayRunTeamB(runTeamB);
        //String commentry="TeamB Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+" Overs.";
        displayResultB(commentryB);
        if(runTeamB>runTeamA){
            resultChoice=2;
            String teamBWin= "TeamB Won The Game By "+wktDiff+ " Wickets!";
            //String result="Team B Won The Game.";
            displayFinalResult(teamBWin);



        }
        if ((runTeamA==runTeamB) && (overTeamB>19)){
            resultChoice=3;

            //String result=" The Game is Drawn!";
            displayFinalResult(draw);


        }
    }
    public void sixTeamB(View view){



        runTeamB=runTeamB+6;
        displayRunTeamB(runTeamB);
        commentryB="TeamB Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+" Overs.";
        displayResultB(commentryB);

        if(runTeamB>runTeamA){
            resultChoice=2;
            wktDiff=10-wktTeamB;
            String teamBWin= "TeamB Won The Game By "+wktDiff+ " Wickets!";

            //String result="Team B Won The Game.";
            displayFinalResult(teamBWin);



        }
        if ((runTeamA==runTeamB) && (overTeamB>19)){
            resultChoice=3;

            //String result=" The Game is Drawn!";
            displayFinalResult(draw);


        }
    }


    public void addBallTeamB(View view) {


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
            commentryB = "TeamB Scored " + runTeamB + " for " + wktTeamB + " in " + overTeamB + "." + ballTeamB + " Overs.";
            displayResultB(commentryB);

            if (overTeamB == 20) {
                overTeamB = 20;
                ballTeamB = 0;
                commentryB = "TeamB Scored " + runTeamB + " for " + wktTeamB + " in " + overTeamB + "." + ballTeamB + " Overs.";
                displayResultB(commentryB);
                if (runTeamA > runTeamB) {
                    resultChoice=1;
                    runDiff=runTeamA-runTeamB;
                    teamAWin= "TeamA Won The Game By " +runDiff+ " runs!" ;

                    //String result = "Team A Won The Game!";
                    displayFinalResult(teamAWin);


                }
                if (runTeamB > runTeamA) {
                    resultChoice=2;
                    wktDiff=10-wktTeamB;
                    String teamBWin= "TeamB Won The Game By "+wktDiff+ " Wickets!";
                    //String result = "Team B Won The Game!";
                    displayFinalResult(teamBWin);


                }
                if (runTeamA == runTeamB) {
                    resultChoice=3;
                    //String result = "The Game is Drawn!";
                    displayFinalResult(draw);


                }


            }
        }
    }

    public void addWktTeamB(View view){
        if (wktTeamB < 10) {

            wktTeamB = wktTeamB + 1;
            displayWktTeamB(wktTeamB);
            commentryB="TeamB Scored "+runTeamB+ " for "+wktTeamB+ " in "+overTeamB+"."+ballTeamB+" Overs.";
            displayResultB(commentryB);
        }

        if (wktTeamB > 9) {
            //String finalResult="Team B All Out!";
            wktTeamB = 10;
            runDiff=runTeamA-runTeamB;
            displayWktTeamB(wktTeamB);
            displayResultB(commentryB);
            if(runTeamA>runTeamB){
                resultChoice=1;
                String teamAWin= "TeamA Won The Game By " +runDiff+ " runs!" ;

                //String result="Team A Won The Game for "+runDiff+ " runs!";
                displayFinalResult(teamAWin);


            }
            if(runTeamB>runTeamA){
                resultChoice=2;
                wktDiff=10-wktTeamB;
                String teamBWin= "TeamB Won The Game By "+wktDiff+ " Wickets!";
                //String result="Team B Won The Game";
                displayFinalResult(teamBWin);



            }
            if (runTeamA==runTeamB){
                resultChoice=3;
                //String result="The Game is Drawn!";
                displayFinalResult(draw);

            }
        }



    }

    public void displayResult(String result) {

        TextView resultView = (TextView) findViewById(R.id.resultA);
        resultView.setText(result);

    }


    public void displayResultB(String result){

        TextView resultView = (TextView) findViewById(R.id.resultB);
        resultView.setText(result);

    }

    public void displayFinalResult(String result){

        TextView resultView = (TextView) findViewById(R.id.finalResult);
        resultView.setText(result);

    }




    //Reset View

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



    }










}