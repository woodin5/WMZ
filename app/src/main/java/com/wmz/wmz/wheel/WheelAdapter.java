package com.wmz.wmz.wheel;


import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public  class WheelAdapter extends BaseAdapter {
    int mHeight = 40;
    String[] mData = null;
    Context context;
    public WheelAdapter(Context context,String[] data) {
    	this.context=context;
        mHeight = (int) DPUtils.dipToPx(context, mHeight);
        this.mData = data;
    }

    @Override
    public int getCount() {
        return (null != mData) ? mData.length : 0;
    }

    @Override
    public View getItem(int arg0) {
        return getView(arg0, null, null);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }
    
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WheelTextView textView = null;

        if (null == convertView) {
            convertView = new WheelTextView(context);
            convertView.setLayoutParams(new TosGallery.LayoutParams(-1, mHeight));
            textView = (WheelTextView) convertView;
            textView.setTextSize(15);
            textView.setTextColor(0xFFFF5073);
          
            textView.setGravity(Gravity.CENTER);
        }
        
        
        if (null == textView) {
            textView = (WheelTextView) convertView;
        }
        try {
        	 textView.setText(mData[position]);
		} catch (Exception e) {
			// TODO: handle exception
		}
       
        return convertView;
    }
}