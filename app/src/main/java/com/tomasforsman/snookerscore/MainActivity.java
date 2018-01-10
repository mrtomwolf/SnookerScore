package com.tomasforsman.snookerscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int score_player1 = 0;
    int score_player2 = 0;
    int reds_left = 15;
    int table_left = 147;
    int final_stretch = 0;
    int break_score = 0;
    boolean player1 = true;
    boolean last_red = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBlack = (Button) findViewById(R.id.buttonBlack);
        buttonBlack.setEnabled(false);
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(7);
            }


        });

        Button buttonRed = (Button) findViewById(R.id.buttonRed);
        buttonRed.setEnabled(true);
        buttonRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(1);
                reds_left = reds_left - 1;
                TextView redsLeft = (TextView) findViewById(R.id.textRedOnTable);
                redsLeft.setText(String.valueOf(reds_left));
                last_red = true;
            }
        });

        Button buttonPink = (Button) findViewById(R.id.buttonPink);
        buttonPink.setEnabled(false);
        buttonPink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(6);
            }
        });

        Button buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonBlue.setEnabled(false);
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(5);
            }
        });

        Button buttonYellow = (Button) findViewById(R.id.buttonYellow);
        buttonYellow.setEnabled(false);
        buttonYellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(2);
            }
        });

        Button buttonBrown = (Button) findViewById(R.id.buttonBrown);
        buttonBrown.setEnabled(false);
        buttonBrown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(4);
            }
        });

        Button buttonGreen = (Button) findViewById(R.id.buttonGreen);
        buttonGreen.setEnabled(false);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startScore(3);
                            }
        });

        Button buttonMiss = (Button) findViewById(R.id.buttonMiss);
        buttonMiss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(last_red) {
                    if (reds_left > 0) {
                        aimRed();
                    } else if (final_stretch == 0) {
                        aimRed();
                    } else {
                        final_stretch -= 1;
                        startScore(0);
                    }
                    break_score = 0;
                    player1 ^= true;
                    aheadBehind();

                    last_red = false;
                    leftOnTable(7);
                }else{
                    player1 ^= true;
                    aheadBehind();
                    break_score = 0;
                }
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setScore(1);
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setScore(4);
            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setScore(5);
            }
        });

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setScore(6);
            }
        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setScore(7);
            }
        });
    }

    void leftOnTable(int s){

            if (final_stretch == 0 & s == 1) {
                table_left -= 1;
            } else if (final_stretch == 0 & s != 1) {
                table_left -= 7;
            } else {
                table_left -= s;
            }

            TextView tableLeft = (TextView) findViewById(R.id.textLeftOnTable);
            tableLeft.setText(String.valueOf(table_left));

    }

    void aimColor(){
        Button buttonRed = (Button) findViewById(R.id.buttonRed);
        buttonRed.setEnabled(false);
        Button buttonBlack = (Button) findViewById(R.id.buttonBlack);
        buttonBlack.setEnabled(true);
        Button buttonPink = (Button) findViewById(R.id.buttonPink);
        buttonPink.setEnabled(true);
        Button buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonBlue.setEnabled(true);
        Button buttonYellow = (Button) findViewById(R.id.buttonYellow);
        buttonYellow.setEnabled(true);
        Button buttonGreen = (Button) findViewById(R.id.buttonGreen);
        buttonGreen.setEnabled(true);
        Button buttonBrown = (Button) findViewById(R.id.buttonBrown);
        buttonBrown.setEnabled(true);
    }

    void aimRed(){
        Button buttonBlack = (Button) findViewById(R.id.buttonBlack);
        Button buttonPink = (Button) findViewById(R.id.buttonPink);
        Button buttonBlue = (Button) findViewById(R.id.buttonBlue);
        Button buttonYellow = (Button) findViewById(R.id.buttonYellow);
        Button buttonGreen = (Button) findViewById(R.id.buttonGreen);
        Button buttonBrown = (Button) findViewById(R.id.buttonBrown);
        Button buttonRed = (Button) findViewById(R.id.buttonRed);



        if(reds_left < 1) {
            buttonBlack.setEnabled(false);
            buttonPink.setEnabled(false);
            buttonBlue.setEnabled(false);
            buttonGreen.setEnabled(false);
            buttonBrown.setEnabled(false);
            buttonRed.setEnabled(false);
            buttonYellow.setEnabled(true);
            final_stretch += 1;
        }else{
            buttonRed.setEnabled(true);
            buttonBlack.setEnabled(false);
            buttonPink.setEnabled(false);
            buttonBlue.setEnabled(false);
            buttonYellow.setEnabled(false);
            buttonGreen.setEnabled(false);
            buttonBrown.setEnabled(false);
        }
    }

    void startScore(int s){
        Button buttonBlack = (Button) findViewById(R.id.buttonBlack);
        Button buttonPink = (Button) findViewById(R.id.buttonPink);
        Button buttonBlue = (Button) findViewById(R.id.buttonBlue);
        Button buttonYellow = (Button) findViewById(R.id.buttonYellow);
        Button buttonGreen = (Button) findViewById(R.id.buttonGreen);
        Button buttonBrown = (Button) findViewById(R.id.buttonBrown);
        if(s!=1){
            last_red = false;
        }
        switch(final_stretch) {

            case(0):
                setScore(s);

                leftOnTable(s);
                if(s==1) {
                    aimColor();
                }else{
                    aimRed();
                }
                break;
            case(1):
                final_stretch++;
                buttonYellow.setEnabled(false);
                buttonGreen.setEnabled(true);
                setScore(s);
                leftOnTable(s);
                break;
            case(2):
                final_stretch = 3;
                buttonGreen.setEnabled(false);
                buttonBrown.setEnabled(true);
                setScore(s);
                leftOnTable(s);
                break;
            case(3):
                final_stretch++;
                buttonBrown.setEnabled(false);
                buttonBlue.setEnabled(true);
                setScore(s);
                leftOnTable(s);
                break;
            case(4):
                final_stretch = final_stretch+1;
                buttonBlue.setEnabled(false);
                buttonPink.setEnabled(true);
                setScore(s);
                leftOnTable(s);
                break;
            case(5):
                final_stretch = final_stretch+1;
                buttonPink.setEnabled(false);
                buttonBlack.setEnabled(true);
                setScore(s);
                leftOnTable(s);
                break;
            case(6):
                buttonBlack.setEnabled(false);
                setScore(s);
                leftOnTable(s);
                break;
        }
    }
    void setScore(int s){
        if (player1) {
            score_player1 += s;
            break_score += s;
            TextView scorePlayer = (TextView) findViewById(R.id.textP1Score);
            scorePlayer.setText(String.valueOf(score_player1));
        } else {
            score_player2 += s;
            break_score += s;
            TextView scorePlayer = (TextView) findViewById(R.id.textP2Score);
            scorePlayer.setText(String.valueOf(score_player2));
        }
        TextView breakScore = (TextView) findViewById(R.id.textBreak);
        breakScore.setText(String.valueOf(break_score));
        aheadBehind();
    }

    void aheadBehind(){
        TextView aheadText = (TextView) findViewById(R.id.textBehindAheadTitle);
        TextView aheadScore = (TextView) findViewById(R.id.textBehindAhead);
        String ahead = getString(R.string.ahead);
        String behind = getString(R.string.behind);
        int zero = 0;

        if(player1 & score_player1>score_player2){
            aheadText.setText(ahead);
            aheadScore.setText(String.valueOf(score_player1-score_player2));

        }else if(player1 & score_player1<score_player2){
            aheadText.setText(behind);
            aheadScore.setText(String.valueOf(score_player2-score_player1));
        }else if(!player1 & score_player2>score_player1){
            aheadText.setText(ahead);
            aheadScore.setText(String.valueOf(score_player2-score_player1));
        }else if(!player1 & score_player2<score_player1){
            aheadText.setText(behind);
            aheadScore.setText(String.valueOf(score_player1-score_player2));
        }else{
            aheadText.setText(behind);
            aheadScore.setText(String.valueOf(zero));


        }
    }


}
