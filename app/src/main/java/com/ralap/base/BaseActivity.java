package com.ralap.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ralap.R;

/**
 * Created by ralap on 2017/1/30.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        View view = findViewById(android.R.id.content);
        setButtonOnClickListener(view);
        initView();
        initListener();
        initData();
    }

    /**
     * 显示布局
     *
     * @return
     */
    public abstract int getLayoutResId();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化监听器
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 处理按钮点击事件
     *
     * @param v
     * @param id
     */
    public abstract void onClick(View v, int id);

    /**
     * 泛型查找view
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T> T findView(int id) {
        T view = (T) findViewById(id);
        return view;
    }

    /**
     * 居中展示吐司
     *
     * @param content
     */
    public void tip(String content) {
        Toast toast = Toast.makeText(this, content, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 为view中的所有button设置监听
     *
     * @param view
     */
    public void setButtonOnClickListener(View view) {
        if (view instanceof Button || view instanceof ImageButton) {
            view.setOnClickListener(this);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setButtonOnClickListener(child);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            default:
                onClick(v, v.getId());
                break;
        }
    }
}
