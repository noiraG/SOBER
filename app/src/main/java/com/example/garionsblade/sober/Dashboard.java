package com.example.garionsblade.sober;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Dashboard extends AppCompatActivity {

    RingProgressBar ringProgressBar1, ringProgressBar2;

    int progress = 0;

    Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if (msg.what==0){
                if (progress<100){
                    progress++;
                    ringProgressBar1.setProgress(progress);
                    ringProgressBar2.setProgress(progress);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //ringProgressBar1 = (RingProgressBar)findViewById(R.id.progress_bar_1);
        ringProgressBar2 = (RingProgressBar)findViewById(R.id.progress_bar_2);

//        ringProgressBar1.setOnProgressListener(new RingProgressBar.OnProgressListener(){
//            @Override
//            public void progressToComplete(){
//                Toast.makeText(Dashboard.this, "Complete!!!", Toast.LENGTH_SHORT).show();
//            }
//        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    try {
                        Thread.sleep(100);
                        myHandler.sendEmptyMessage(0);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
