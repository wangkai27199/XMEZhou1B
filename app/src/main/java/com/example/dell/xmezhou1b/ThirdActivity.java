package com.example.dell.xmezhou1b;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        String name = getIntent().getStringExtra("name");
        String imageuri = getIntent().getStringExtra("imageuri");
        String info = getIntent().getStringExtra("info");

        TextView name_title = (TextView) findViewById(R.id.name_title);
        ImageView image_third = (ImageView) findViewById(R.id.image_third);
        TextView name_third = (TextView) findViewById(R.id.name_third);
        TextView info_third = (TextView) findViewById(R.id.info_third);

        name_title.setText(name+"的信息");
        ImageLoader.getInstance().displayImage(imageuri,image_third);
        name_third.setText(name);
        info_third.setText(info);

    }
}
