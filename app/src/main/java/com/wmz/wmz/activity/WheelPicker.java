package com.wmz.wmz.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.aigestudio.wheelpicker.core.AbstractWheelPicker;
import com.aigestudio.wheelpicker.view.WheelCurvedPicker;
import com.aigestudio.wheelpicker.view.WheelStraightPicker;
import com.wmz.wmz.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WheelPicker extends AppCompatActivity {

    @BindView(R.id.wheel_straight)
    public WheelStraightPicker mWheelStraightPicker;
    @BindView(R.id.wheel_circular)
    public WheelCurvedPicker mWheelCurvedPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_wheel_picker);

        ButterKnife.bind(this);

        ArrayList<String> data = new ArrayList<>();
        for(int i=0;i<5;i++){
            data.add(String.valueOf(i));
        }
        mWheelStraightPicker.setData(data);
        mWheelStraightPicker.setItemIndex(3);
        mWheelStraightPicker.setCurrentTextColor(0xFFFF0000);
        mWheelStraightPicker.setOnWheelChangeListener(new AbstractWheelPicker.SimpleWheelChangeListener(){
            @Override
            public void onWheelSelected(int index, String data) {
                Toast.makeText(WheelPicker.this,"data="+data,Toast.LENGTH_LONG).show();
            }
        });
    }

}
