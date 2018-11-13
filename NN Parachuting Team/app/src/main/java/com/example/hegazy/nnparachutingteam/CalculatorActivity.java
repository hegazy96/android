package com.example.hegazy.nnparachutingteam;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {


    // TWO TextView ARRAYS
    TextView[] Exs_names = new TextView[5]; //for the names of EXCs textviews
    TextView[] Exs_scores = new TextView[5]; //for the results of each EXCs textviews

    int i,l;


    //Exs_BASEscores is ARRAY for the max score for each exercise
    int[] Exs_BASEscores =  new int[5];

    //Tn_score is ARRAY saved the score of each player enter it with EditView in MainActivity
    int[] Tn_score = new int[5];

    //check_T1,2,3,4 is  used to get the CheckBoxs check_status from the MainActivivty
    // then save them in ARRAY check_Tn in ConnectViews() method
    boolean[] check_Tn = new boolean[5];
    boolean check_T1,check_T2,check_T3,check_T4,check_T5;
    boolean style_Choose1;



    //initialize all my Views HERE to be private and GLOBAL
    private EditText score_value; //used to get the scores from users
    private Button button_result; //used to start calculations as it contain "setOnClickListener()"



    int[] Abs_NO = new int[]{22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79};
    int[] Abs_score = new int[]{2,3,6,8,10,13,15,17,20,22,24,26,28,30,33,34,36,38,40,42,43,45,47,48,50,52,53,55,56,57,59,61,63,64,65,67,68,70,72,73,75,76,78,79,80,82,83,85,87,88,90,91,92,93,95,97,98,110};

    int[] Push_up_NO = new int[]{13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
    int[] Push_up_score = new int[]{2,6,10,14,18,21,24,27,31,34,36,39,42,45,48,53,55,57,59,61,63,65,67,69,71,73,75,77,79,81,83,85,86,87,88,90,91,92,95,97,98,100};

    int[] Pull_up_NO = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    int[] Pull_up_score = new int[]{2,11,19,26,33,40,46,53,58,60,69,74,79,83,87,90,93,96,98,100};

    int[] Tmreen_3_NO= new int[] {15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41};
    int[] Tmreen_3_score= new int[] {2,5,8,12,15,18,22,25,28,32,36,40,43,47,51,55,59,63,67,72,76,80,85,89,93,98,100};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // used to make back button in tittle bar with method onOptionsItemSelected()
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");



        //this method use to connect the the JAVA Views and XML Views
        ConnectViews();
        //calling the method which SCAN each EXC

        if (style_Choose1 == true ) {
            scan(0);
            button_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i < 4) {
                        Tn_score[i] = (Integer.parseInt(score_value.getText().toString()) * 100);
                        Tn_score[i] /= Exs_BASEscores[i];
                        Exs_scores[i].setText(String.valueOf(Tn_score[i] + "%"));
                        score_value.getText().clear();
                        i++;
                        scan(i);
                    } else {
                        Toast.makeText(CalculatorActivity.this, "هنشوف عملت يه !", Toast.LENGTH_SHORT).show();

                        Intent Open_Result_2 = new Intent(CalculatorActivity.this, ResultsActivity.class);
                        Open_Result_2.putExtra("Tn_score_key1", Tn_score[0]);
                        Open_Result_2.putExtra("Tn_score_key2", Tn_score[1]);
                        Open_Result_2.putExtra("Tn_score_key3", Tn_score[2]);
                        Open_Result_2.putExtra("Tn_score_key4", Tn_score[3]);
                        //Open_Result_2.putExtra("Tn_score_key5", Tn_score[4]);
                        Open_Result_2.putExtra("check_key110", check_T1);
                        Open_Result_2.putExtra("check_key120", check_T2);
                        Open_Result_2.putExtra("check_key130", check_T3);
                        Open_Result_2.putExtra("check_key140", check_T4);
                        //Open_Result_2.putExtra("check_key15",check_T5);
                        startActivity(Open_Result_2);

                    }
                }
            });
        }

        else if(style_Choose1 == false){
              scan(0);
            button_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i < 4) {
                        Tn_score[i] = (Integer.parseInt(score_value.getText().toString()));
                        //this if used to calculate  the  1st EXC "BATN" from the table by compare Tn_score and it EXS array
                        if(i==0){
                            if (Tn_score[i] <= 21){
                                Tn_score[i] = 0;
                                Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                            }
                            else {
                                for (l =0;l<=58;l++){
                                    if (Tn_score[i] == Abs_NO[l]){
                                        Tn_score[i] = Abs_score[l];
                                        Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                                        break;
                                    }
                                }
                            }
                        }
                        //this if used to calculate  the  1st EXC "BATN" from the table by compare Tn_score and it EXS array
                        else if (i==1){
                            if (Tn_score[i] <= 12){
                                Tn_score[i] = 0;
                                Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                            }
                            else {
                                for (l =0;l<42;l++){
                                    if (Tn_score[i] == Push_up_NO[l]){
                                        Tn_score[i] = Push_up_score[l];
                                        Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                                        break;
                                    }
                                }
                            }
                        }
                        //this if used to calculate  the  1st EXC "BATN" from the table by compare Tn_score and it EXS array
                        else if (i==2){
                            for (l = 0;l<20;l++){
                                if (Tn_score[i] == Pull_up_NO[l]){
                                    Tn_score[i] = Pull_up_score[l];
                                    Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                                    break;
                                }
                            }
                        }
                        //this if used to calculate  the  1st EXC "BATN" from the table by compare Tn_score and it EXS array
                        else if (i==3){
                            if (Tn_score[i] <=14){
                                Tn_score[i] = 0;
                                Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                            }
                            else {
                                for (l =0;l<27;l++){
                                    if (Tn_score[i] == Tmreen_3_NO[l]){
                                        Tn_score[i] = Tmreen_3_score[l];
                                        Exs_scores[i].setText(String.valueOf(Tn_score[i]));
                                        break;
                                    }
                                }
                            }
                        }

                        score_value.getText().clear();
                        i++;
                        scan(i);
                    } else {
                        Toast.makeText(CalculatorActivity.this, "هنشوف عملت يه !", Toast.LENGTH_SHORT).show();

                        Intent Open_Result_2 = new Intent(CalculatorActivity.this, ResultsActivity.class);
                        Open_Result_2.putExtra("Tn_score_key1", Tn_score[0]);
                        Open_Result_2.putExtra("Tn_score_key2", Tn_score[1]);
                        Open_Result_2.putExtra("Tn_score_key3", Tn_score[2]);
                        Open_Result_2.putExtra("Tn_score_key4", Tn_score[3]);
                        //Open_Result_2.putExtra("Tn_score_key5", Tn_score[4]);
                        Open_Result_2.putExtra("check_key110", check_T1);
                        Open_Result_2.putExtra("check_key120", check_T2);
                        Open_Result_2.putExtra("check_key130", check_T3);
                        Open_Result_2.putExtra("check_key140", check_T4);
                        //Open_Result_2.putExtra("check_key15",check_T5);
                        startActivity(Open_Result_2);

                    }
                }
            });
        }
    }



    /**
     * this method use to SCAN each EXC
     * by using FOR loop
     * if user check it make the calculations and print it in textview
     * else user doesn't check it change its color to red
     *
     * then call it in onCreate()
     */
    public void scan(int x){
        for (i=x;i<4;i++){

            if (check_Tn[i] == true) {
                Exs_names[i].setTextColor(Color.parseColor("#00FDC6"));
                Exs_scores[i].setTextColor(Color.parseColor("#00FDC6"));
                break;
            }
            else {
                Exs_names[i].setTextColor(Color.RED);
                Exs_scores[i].setTextColor(Color.RED);
                Exs_scores[i].setText("0%");
            }

        }
    }



    /**
     * this method use to connect the the JAVA Views and XML Views
     * and initialize its values too
     * by create OBJECTS to them
     * then call it in onCreate()
     */
    private void ConnectViews() {
        //the name of each EXC
        Exs_names [0] = (TextView) findViewById(R.id.EX1_Name);
        Exs_names [1] = (TextView) findViewById(R.id.EX2_Name);
        Exs_names [2] = (TextView) findViewById(R.id.EX3_Name);
        Exs_names [3] = (TextView) findViewById(R.id.EX4_Name);
        //Exs_names [4] = (TextView) findViewById(R.id.EX5_Name);

        //the % score of each EXC after calculating
        Exs_scores[0] = (TextView) findViewById(R.id.Ex1_Score);
        Exs_scores[1] = (TextView) findViewById(R.id.Ex2_Score);
        Exs_scores[2] = (TextView) findViewById(R.id.Ex3_Score);
        Exs_scores[3] = (TextView) findViewById(R.id.Ex4_Score);
        //Exs_scores[4] = (TextView) findViewById(R.id.Ex5_Score);

        //here we get the CheckBoxs check_status from MainActivity and  save them
        check_T1 = getIntent().getBooleanExtra("check_key1", false);
        check_T2 = getIntent().getBooleanExtra("check_key2", false);
        check_T3 = getIntent().getBooleanExtra("check_key3", false);
        check_T4 = getIntent().getBooleanExtra("check_key4", false);
        //check_T5 = getIntent().getBooleanExtra("check_key5", false);

        //CheckBoxs check_status from the MainActivivty
        check_Tn[0]= check_T1;
        check_Tn[1]= check_T2;
        check_Tn[2]= check_T3;
        check_Tn[3]= check_T4;
        //check_Tn[4]= check_T5;

        /**
         * T1 - batn >> 79
         * T2 - d8t >> 54
         * T3 - 32la >> 20
         * T4 - tmreen 3 >> 41
         * T5 - gary >> ???
         * the max score for each exercise
         * */
        Exs_BASEscores[0]=79;
        Exs_BASEscores[1]=54;
        Exs_BASEscores[2]=20;
        Exs_BASEscores[3]=41;
        //Exs_BASEscores[4]=???;



        style_Choose1 = getIntent().getBooleanExtra("style_key10", false);

        score_value = (EditText)findViewById(R.id.editText1);
        button_result = (Button) findViewById(R.id.button1);

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
