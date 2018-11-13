package com.example.hegazy.nnparachutingteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    // TWO TextView ARRAYS
    // TextView[] Exs_names = new TextView[4]; //for the names of EXCs textviews
    //TextView[] Scores = new TextView[4];//for the results of each EXCs textviews


    int[] Exs_scores = new int[5];//for the results of each EXCs


    //check_T1,2,3,4 is  used to get the CheckBoxs check_status from the MainActivivty
    // then save them in ARRAY check_Tn in ConnectViews() method
    boolean[] check_Tn = new boolean[5];
    boolean check_T1,check_T2,check_T3,check_T4,check_T5;

    /**
     * T1_Score,T2_Score,T3_Score,T4_Score
     * used to save each EXS % Score from CalculatorActivity
     * ------------------------------------------------------
     * sum_score >> used to sum this scores and has been initialize = 0
     * ------------------------------------------------------
     * counter >> used to count the number of true EXs  which user check them and has been initialize = 0
     *
     */
    int T1_Score,T2_Score,T3_Score,T4_Score,T5_Score,sum_score=0,counter=0;

    //initialize all my Views HERE to be private and GLOBAL
    private TextView Results ; //to show the AVR of all EXs scores

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // used to make back button in tittle bar with method onOptionsItemSelected()
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        ConnectViews();


        for (int i=0;i<4;i++){

            if (check_Tn[i] == true) {
                sum_score+=Exs_scores[i];
                counter++;
            }
        }

        Results = (TextView) findViewById(R.id.Final_Result) ;
        Results.setText(String.valueOf(sum_score/counter+"%"));


    }


    /**
     * this method use to connect the the JAVA Views and XML Views
     * and initialize its values too
     * by create OBJECTS to them
     * then call it in onCreate()
     */
    private void ConnectViews() {



        //int T1_Score,T2_Score,T3_Score,T4_Score,sum_score=0,counter=0;


        //boolean check_T1,check_T2,check_T3,check_T4;
        //here we get the CheckBoxs check_status from CalculatorActivity and  save them
        check_T1 = getIntent().getBooleanExtra("check_key110", false);
        check_T2 = getIntent().getBooleanExtra("check_key120", false);
        check_T3 = getIntent().getBooleanExtra("check_key130", false);
        check_T4 = getIntent().getBooleanExtra("check_key140", false);
        //check_T5 = getIntent().getBooleanExtra("check_key15", false);

        //boolean[] check_Tn = new boolean[4];
        //CheckBoxs check_status from the MainActivivty
        check_Tn[0]= check_T1;
        check_Tn[1]= check_T2;
        check_Tn[2]= check_T3;
        check_Tn[3]= check_T4;
        //check_Tn[4]= check_T5;

        //int T1_Score,T2_Score,T3_Score,T4_Score,sum_score=0,counter=0;
        //here we get the each EXS % Score  from CalculatorActivity and  save them
        T1_Score = getIntent().getIntExtra("Tn_score_key1",0);
        T2_Score = getIntent().getIntExtra("Tn_score_key2",0);
        T3_Score = getIntent().getIntExtra("Tn_score_key3",0);
        T4_Score = getIntent().getIntExtra("Tn_score_key4",0);
        //T5_Score = getIntent().getIntExtra("Tn_score_key5",0);

        // int[] Exs_scores = new int[4];
        // this array used to each EXS % Score from >> T1_Score,T2_Score,T3_Score,T4_Score
        Exs_scores[0]=T1_Score;
        Exs_scores[1]=T2_Score;
        Exs_scores[2]=T3_Score;
        Exs_scores[3]=T4_Score;
        //Exs_scores[4]=T5_Score;

/**
 //the name of each EXC
 Exs_names [0] = (TextView) findViewById(R.id.EX1_Name);
 Exs_names [1] = (TextView) findViewById(R.id.EX2_Name);
 Exs_names [2] = (TextView) findViewById(R.id.EX3_Name);
 Exs_names [3] = (TextView) findViewById(R.id.EX4_Name);


 //the % score of each EXC after calculating
 Scores[0] = (TextView) findViewById(R.id.Ex1_Score);
 Scores[1] = (TextView) findViewById(R.id.Ex2_Score);
 Scores[2] = (TextView) findViewById(R.id.Ex3_Score);
 Scores[3] = (TextView) findViewById(R.id.Ex4_Score);

 Scores[0].setText(String.valueOf(check_T1));
 Scores[1].setText(String.valueOf(check_T2));
 Scores[2].setText(String.valueOf(check_T3));
 Scores[3].setText(String.valueOf(check_T4));
 */

    }

    // used to make back button in tittle bar
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Cal_StyleActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(getApplicationContext(), Cal_StyleActivity.class);
        startActivityForResult(myIntent, 0);
    }

}


