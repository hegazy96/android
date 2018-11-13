package com.example.hegazy.nnparachutingteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;


public class Cal_StyleActivity extends AppCompatActivity {
    boolean style1;
    private Button style_but1,style_but2,info_but1,info_but2;
    private PopupWindow info_popS1,info_popS2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_style);

        //supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getSupportActionBar().setTitle("");





        style_but1 = (Button) findViewById(R.id.avg_calculation); //initialize the View and connect jave with XML
        style_but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                style1 = true;
                Intent Open_Main= new Intent(Cal_StyleActivity.this, MainActivity.class);
                Open_Main.putExtra("style_key1",style1);
                startActivity(Open_Main);




            }
        });

        style_but2 = (Button) findViewById(R.id.table_calculation); //initialize the View and connect jave with XML
        style_but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                style1 = false;
                Intent Open_Main= new Intent(Cal_StyleActivity.this, MainActivity.class);
                Open_Main.putExtra("style_key1",style1);
                startActivity(Open_Main);

            }
        });


    }
}
