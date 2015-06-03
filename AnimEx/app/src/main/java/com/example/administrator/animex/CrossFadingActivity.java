package com.example.administrator.animex;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CrossFadingActivity extends Activity {

    private Button mBtn;
    private TextView mTvTextView1;
    private TextView mTvTextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cross_fade);

        findView();
        setListener();
    }

    private void setListener() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossFade();
            }
        });
    }

    private void findView() {
        mTvTextView1 = (TextView) findViewById(R.id.tv_textview_1);
        mTvTextView2 = (TextView) findViewById(R.id.tv_textview_2);
        mBtn = (Button) findViewById(R.id.btn_start);
    }

    private void crossFade() {
        mTvTextView2.setAlpha(0f);
        mTvTextView2.setVisibility(View.VISIBLE);

        mTvTextView2.animate()
                .alpha(1f)
                .setDuration(getResources().getInteger(android.R.integer.config_longAnimTime))
                .setListener(null);

        mTvTextView1.animate()
                .alpha(0f)
                .setDuration(getResources().getInteger(android.R.integer.config_longAnimTime))
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mTvTextView1.setVisibility(View.GONE);
                        TextView tmp = mTvTextView1;
                        mTvTextView1 = mTvTextView2;
                        mTvTextView2 = tmp;
                    }
                });

    }
}
