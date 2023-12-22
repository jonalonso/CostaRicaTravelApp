package com.jsalazar.costaricatravel.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.models.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;

public class currencyAdapter extends ArrayAdapter<Currency> {

    private final Activity context;
    private final ArrayList<Currency> elements;

    public currencyAdapter(Activity context, ArrayList<Currency> pElements) {
        super(context, R.layout.currency_item, pElements);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.elements=pElements;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.currency_item, null,true);
        Currency element = this.elements.get(position);
        TextView titleText = rowView.findViewById(R.id.title);
        ImageView imageView = rowView.findViewById(R.id.icon);
        TextView subtitleText = rowView.findViewById(R.id.subtitle);

        if(element.getCustomValue()==0){
            element.setCustomValue(element.getOriginalValue());
        }
        String titleTextContent = this.context.getString(element.getNameId(), BigDecimal.valueOf(element.getCustomValue() / element.getOriginalValue()).doubleValue());
        if(titleTextContent.startsWith("1.00")){
            titleTextContent=titleTextContent.replace("1.00","1");
        }
        titleText.setText(titleTextContent);
        imageView.setImageResource(element.getImgId());
        subtitleText.setText(this.context.getString( R.string.crc_value,element.getCustomValue()));
        return rowView;
    }
}