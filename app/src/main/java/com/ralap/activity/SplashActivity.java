package com.ralap.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.ralap.R;
import com.ralap.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private Handler handler;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        delayEnterHome();
    }

    /**
     * 延时进入主页
     */
    private void delayEnterHome() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHome();
            }
        },3000);
    }

    /**
     * 进入主页
     */
    private void enterHome() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                enterHome();
                handler.removeCallbacksAndMessages(null);
                break;
            default:
                break;
        }
        return true;
    }
}