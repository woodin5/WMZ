package com.wmz.wmz.wheel;


import android.content.Context;
import android.util.TypedValue;

public class DPUtils {
    

    public static float pixelToDp(Context context, float val) {
        float density = context.getResources().getDisplayMetrics().density;
       
        return val * density;
    }
    
    public static int dipToPx(Context context, int dipValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, context
                .getResources().getDisplayMetrics());
    }
    
    
}
