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
        tvMarquee.setText("得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了得游上线了");
    }

    public void setLongText2(View view) {
        tvMarquee.setText("我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了我的App上线了");
    }

    public void setShortText1(View view) {
        tvMarquee.setText("得游上线了11111");
    }

    public void setShortText2(View view) {
        tvMarquee.setText("得游上线了2222");
    }
}
