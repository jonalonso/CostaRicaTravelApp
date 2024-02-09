package com.jsalazar.costaricatravel.adapters;

import static com.jsalazar.costaricatravel.constants.adsValues.PREMIUM_APP;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.models.Bus;

import java.util.ArrayList;

public class busAdapter extends ArrayAdapter<Bus> {

    private final Activity context;
    private final ArrayList<Bus> elements;

    public busAdapter(Activity context, ArrayList<Bus> pElements) {
        super(context, R.layout.bus_item, pElements);

        this.context=context;
        this.elements=pElements;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.bus_item, null,true);
        Bus element = this.elements.get(position);
        TextView textView = rowView.findViewById(R.id.originPlace);
        textView.setText(element.getOrigin());

        textView = rowView.findViewById(R.id.destinationPlace);
        textView.setText(element.getDestination());

        textView = rowView.findViewById(R.id.distance);
        if(PREMIUM_APP){
            textView.setText(element.getDistance());
        }


        ImageView imageView = rowView.findViewById(R.id.googleMapsIcon1);
        imageView.setOnClickListener(v -> this.openURL(element.getOriginURL()));

        imageView = rowView.findViewById(R.id.googleMapsIcon2);
        imageView.setOnClickListener(v -> this.openURL(element.getDestinationURL()));
        return rowView;
    }

    public void openURL(String url){
        Intent navigation = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.context.startActivity(navigation);
    }
}