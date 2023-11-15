package com.example.costaricatravel.adapters;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.costaricatravel.R;
import com.example.costaricatravel.models.Food;
import com.example.costaricatravel.models.FoodRow;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;

public class foodAdapter extends ArrayAdapter<FoodRow> {

    private final Activity context;
    private final ArrayList<FoodRow> elements;

    public foodAdapter(Activity context, ArrayList<FoodRow> pElements) {
        super(context, R.layout.food_item, pElements);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.elements=pElements;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.food_item, null,true);
        FoodRow element = this.elements.get(position);
        TextView Text = rowView.findViewById(R.id.textElement1);
        ImageView imageView = rowView.findViewById(R.id.imgElement1);
        TextView Text2 = rowView.findViewById(R.id.textElement2);
        ImageView imageView2 = rowView.findViewById(R.id.imgElement2);


        Text.setText(element.firstElement.getFoodNameId());
        imageView.setImageResource(element.firstElement.getImgId());
        imageView.setOnClickListener(v -> {
            toogleModal(element.firstElement);
        });

        Text2.setText(element.secondElement.getFoodNameId());
        imageView2.setImageResource(element.secondElement.getImgId());
        imageView2.setOnClickListener(v -> {
            toogleModal(element.secondElement);
        });

        return rowView;
    };
    public void toogleModal(Food element){
        View view = this.context.getLayoutInflater().inflate(R.layout.fragment_food_modal,null);
        BottomSheetDialog dialog = new BottomSheetDialog(this.context);
        TextView txt = view.findViewById(R.id.test);
        txt.setText(element.getFoodNameId());
        ImageView img = view.findViewById(R.id.imgCloseFoodModal);
        img.setOnClickListener(v -> {
            dialog.dismiss();
        });
        img = view.findViewById(R.id.imgFoodModal);
        img.setImageResource(element.getImgId());

        img = view.findViewById(R.id.imgSpeakFoodModal);
        TextToSpeech t1=new TextToSpeech(this.context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {

                }
            }
        });
        t1.setLanguage(new Locale("spa"));
        Log.d("", String.valueOf(t1.isLanguageAvailable(new Locale("spa"))));

        img.setOnClickListener(v -> {
            t1.speak(this.context.getString(element.getFoodNameId()),TextToSpeech.QUEUE_FLUSH,null);
        });


        dialog.setContentView(view);
        dialog.setCancelable(false);
        dialog.show();
    }
}