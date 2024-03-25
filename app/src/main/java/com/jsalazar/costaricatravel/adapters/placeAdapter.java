package com.jsalazar.costaricatravel.adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.models.Place;
import com.jsalazar.costaricatravel.utils.BackgroundTask;
import com.jsalazar.costaricatravel.utils.FileDownloader;


import java.util.ArrayList;
import java.util.Objects;

public class placeAdapter extends ArrayAdapter<Place> {

    private final Activity context;
    private final ArrayList<Place> elements;

    private boolean downloadingFile = false;

    public placeAdapter(Activity context, ArrayList<Place> pElements) {
        super(context, R.layout.places_item, pElements);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.elements=pElements;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.places_item, null, true);

        Place element = this.elements.get(position);
        rowView.setOnClickListener(v-> toogleModal(element));
        TextView Text = rowView.findViewById(R.id.PlacesName);
        Text.setText(element.getTitleId());

        ImageView img = rowView.findViewById(R.id.downloadInfo);
        if(element.getDownloadLinkId() == 0){
            img.setVisibility(View.GONE);
        }else{
            img.setVisibility(View.VISIBLE);
            img.setOnClickListener(v ->{
                if(!this.downloadingFile){
                    this.downloadingFile = true;
                    Toast.makeText(context, R.string.downloading, Toast.LENGTH_SHORT).show();
                    new BackgroundTask(context){
                        @Override
                        public void doInBackground() {
                            String fileName = String.format("%s.pdf", context.getString(element.getTitleId()).toLowerCase().replace(" ","_"));
                            FileDownloader.downloadFile(context,context.getString(element.getDownloadLinkId()),fileName);
                        }

                        @Override
                        public void onPostExecute() {
                            placeAdapter.this.downloadingFile = false;
                        }
                    }.execute();
                }
            });
        }

        img = rowView.findViewById(R.id.openLocation);
        img.setOnClickListener(v ->{
            Uri gmmIntentUri = Uri.parse(element.getLocationURL());

            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            context.startActivity(mapIntent);
        });

        img = rowView.findViewById(R.id.onlineReservation);
        img.setOnClickListener(v -> {
            String value = context.getString(element.getOnlineBookingURL());
            if(value.startsWith("https")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(value));
                context.startActivity(browserIntent);
            }else{
                Toast.makeText(context,value,Toast.LENGTH_LONG).show();
            }
        });

        Text = rowView.findViewById(R.id.PlacePriceText);
        Text.setText(element.getPriceDisclaimerId());

        Text = rowView.findViewById(R.id.PlaceSchedule);
        Text.setText(element.getScheduleDisclaimerId());





        return rowView;
    }
    public void toogleModal(Place element){
        View view = this.context.getLayoutInflater().inflate(R.layout.fragment_place_default_modal,null);
        BottomSheetDialog dialog = new BottomSheetDialog(this.context);
        TextView txt = view.findViewById(R.id.placePageDefaultModalText);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) txt.getLayoutParams();
        layoutParams.removeRule(RelativeLayout.CENTER_HORIZONTAL);
        txt.setLayoutParams(layoutParams);
        String textToDisplay = context.getResources().getString(element.getDescriptionId());
        txt.setText(textToDisplay.replace("\\n", Objects.requireNonNull(System.getProperty("line.separator"))));

        ArrayList<SlideModel> finalList = new ArrayList<>();

        for (int imgElement : element.getImgs()) {
            finalList.add(new SlideModel(imgElement, null, ScaleTypes.FIT));
        }


        ImageSlider imageSlider = view.findViewById(R.id.image_slider_place);
        imageSlider.setImageList(finalList,ScaleTypes.FIT);

        dialog.setContentView(view);
        dialog.show();
    }


}