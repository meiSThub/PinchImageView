package com.plum.pinchimageviewexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.boycy815.pinchimageviewexample.R;
import com.plum.pinchimageviewexample.huge.HugeActivity;
import com.plum.pinchimageviewexample.withviewpager.PagerActivity;
import com.plum.pinchimageviewexample.zoomtransition.ThumbViewActivity;


public class IndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        findViewById(R.id.btn_pager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, PagerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_zoom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, ThumbViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_huge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, HugeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.view_github).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/boycy815/PinchImageView")));
            }
        });
    }
}