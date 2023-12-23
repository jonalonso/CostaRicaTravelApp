package com.jsalazar.costaricatravel.utils;

import android.view.MotionEvent;
import android.widget.TextView;

public class DrawableTextViewTouched {

    public static boolean touchedRight(TextView textViewElement, MotionEvent event){
        int[] textLocation = new int[2];
        textViewElement.getLocationOnScreen(textLocation);
        return event.getAction() == MotionEvent.ACTION_UP &&
                event.getRawX() >= textLocation[0] + textViewElement.getWidth() - textViewElement.getTotalPaddingRight();
    }
}
