package com.github.yangkangli.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMarquee = findViewById(R.id.tv_marquee);
    }

    public void setLongText1(View view) {
        tvMarquee.setText("这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1这是很长的文本1");
    }

    public void setLongText2(View view) {
        tvMarquee.setText("这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2这是很长的文本2");
    }

    public void setShortText1(View view) {
        tvMarquee.setText("这是很端的文本1");
    }

    public void setShortText2(View view) {
        tvMarquee.setText("这是很端的文本2");
    }
}
