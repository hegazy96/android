package com.example.hegazy.nnparachutingteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;



public class MainActivity extends AppCompatActivity {


    //initialize private and GLOBAL 4 CheckBoxs Views onetime
    private CheckBox T1_checkedTV,T2_checkedTV,T3_checkedTV,T4_checkedTV,T5_checkedTV;

    //initialize 4 GLOBAL Booleans to collect the CheckBoxs check_status
    boolean check_T1,check_T2,check_T3,check_T4,Check_T5;


    boolean style1,style2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // used to make back button in tittle bar with method onOptionsItemSelected()
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        // Sample AdMob app ID: ca-app-pub-6338644967157973/8418874634



        //calling initializeViews() to onCreate()
        this.ConnectViews();

        /**
         * create setOnClickListener() to the  BUTTON #Next_Btn
         * when user press it .. it will send the CheckBoxs check_status to the next activity #CalculatorActivity
         * by using OnClickListener() method
         */
        Button Next_Btn = (Button) findViewById(R.id.NEXT_btn); //initialize the View and connect jave with XML
        Next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }

    /**
     * this method use to connect the the JAVA Views and XML Views
     * by create OBJECTS to them
     * then call it in onCreate()
     */
    private void ConnectViews() {
        T1_checkedTV = (CheckBox) findViewById(R.id.T1_checkedTV);
        T2_checkedTV = (CheckBox) findViewById(R.id.T2_checkedTV);
        T3_checkedTV = (CheckBox) findViewById(R.id.T3_checkedTV);
        T4_checkedTV = (CheckBox) findViewById(R.id.T4_checkedTV);
        //T5_checkedTV = (CheckBox) findViewById(R.id.T5_checkedTV);

        style1 = getIntent().getBooleanExtra("style_key1", false);




    }

    /**
     * this method use to send data to the next activity #CalculatorActivity
     * by using INTENT called #open_cal
     * then use .putExtra("name",<what u want to send it>)
     * and then call it in the setOnClickListener of the BUTTON #Next_Btn >> onClick()
     */
    private void sendData() {
        check_T1 = T1_checkedTV.isChecked();
        check_T2 = T2_checkedTV.isChecked();
        check_T3 = T3_checkedTV.isChecked();
        check_T4 = T4_checkedTV.isChecked();
        // check_T5 = T5_checkedTV.isChecked();

       Intent Open_Cal= new Intent(MainActivity.this, CalculatorActivity.class);
        Open_Cal.putExtra("check_key1",check_T1);
        Open_Cal.putExtra("check_key2",check_T2);
        Open_Cal.putExtra("check_key3",check_T3);
        Open_Cal.putExtra("check_key4",check_T4);
        Open_Cal.putExtra("style_key10",style1);
        //Open_Cal.putExtra("check_key5",check_T5);
        this.startActivity(Open_Cal);


        //Intent Open_Result= new Intent(MainActivity.this, ResultsActivity.class);
        //Open_Result.putExtra("check_key11",check_T1);
        //Open_Result.putExtra("check_key12",check_T2);
        //Open_Result.putExtra("check_key13",check_T3);
        //Open_Result.putExtra("check_key14",check_T4);
        //Open_Result.putExtra("check_key15",check_T5);


    }

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




//Open_Cal.putExtra("key",check_T1);
