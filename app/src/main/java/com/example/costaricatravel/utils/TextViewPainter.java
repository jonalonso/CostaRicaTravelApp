package com.example.costaricatravel.utils;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.widget.TextView;

public class TextViewPainter {
    public static void addColor(TextView textView,String text){
        textView.setShadowLayer(5, 0, 0, Color.BLACK);
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(text);

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#0000FF"),
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#FF0000"),
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#0000FF"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }
}
