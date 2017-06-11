package com.example.dell.xmezhou1b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.image);

        RotateAnimation animation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
        animation.setDuration(2000);
        image.startAnimation(animation);

        handler.sendEmptyMessageDelayed(0,2000);
    }
}
