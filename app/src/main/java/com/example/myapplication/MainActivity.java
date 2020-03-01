package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int imgids[] = new int[]{
            R.drawable.num0,R.drawable.num1,R.drawable.num2,R.drawable.num3,
            R.drawable.num4,R.drawable.num5,R.drawable.num6,R.drawable.num7,
            R.drawable.num8,R.drawable.num9
    };
    int imgstart = 0;
    final Handler myhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0x123){
                imageView.setImageResource(imgids[imgstart++ %10]);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img_change);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myhandler.sendEmptyMessage(0x123);
            }
        },0,200);
    }
}
