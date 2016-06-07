package com.wmz.wmz.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Button;

import com.wmz.wmz.R;
import com.wmz.wmz.wheel.WheelViewDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WheelActivity extends Activity {

    @BindView(R.id.btn_wheel_show)
    public Button mBtnShow;

    @OnClick(R.id.btn_wheel_show)
    public void show(){
        Log.d("wmz","wmz:show");
        String[] arrs = {"1","2","3","4","5"};
        new WheelViewDialog(WheelActivity.this, "test", arrs, 3, new WheelViewDialog.OnWheelSelectedDialogListener() {
            @Override
            public void onDone(String[] list, int position) {
                Snackbar.make(mBtnShow,list[position],Snackbar.LENGTH_SHORT).show();
            }
        }).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_wheel);
        ButterKnife.bind(WheelActivity.this);


        mBtnShow.setText("show me");

    }

}
