package com.jsalazar.costaricatravel.ui.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.FragmentHomeBinding;
import com.jsalazar.costaricatravel.interfaces.JsonArrayCallback;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jsalazar.costaricatravel.utils.BackgroundTask;
import com.jsalazar.costaricatravel.utils.DrawableTextViewTouched;
import com.jsalazar.costaricatravel.utils.HttpRequestJSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Objects;
import java.util.TimeZone;

public class HomeFragment extends Fragment{
    private FragmentHomeBinding binding;

    private JSONArray cb_result;

    JsonArrayCallback cb = result -> cb_result = result;


    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        if (this.getContext() instanceof fragmentInit) {
            fragmentInit mListener = (fragmentInit) this.getContext();
            mListener.onFragmentInteraction(fragmentId.HOME);
            mListener.setBannerAdView(binding.adView);
        }
        final int MAX_SLIDER_ELEMENTS = 7;
        View root = binding.getRoot();

        ArrayList<SlideModel> tmpImgList = new ArrayList<>();

        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701354737/fqyqh5bjqjc0gdevtyi1.jpg", getString(R.string.home_slider_1), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701353550/rwvf6mqko5xlcw2cfdqd.jpg", getString(R.string.home_slider_2), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701354542/orwke15erlwgpoimhlon.jpg", getString(R.string.home_slider_3), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701353550/vhhc1pgghfp73xjoxmak.jpg", getString(R.string.home_slider_4), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701355663/mmmg11gwnipsovlpy6rk.jpg", getString(R.string.home_slider_5), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701355943/tfkbwj5roe6jeaywolht.jpg", getString(R.string.home_slider_6), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701356330/i7auuzyujr8yemgiqqoh.jpg", getString(R.string.home_slider_7), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1702393051/rz0rzog0zwoqs0rxbntw.jpg", getString(R.string.home_slider_8), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1702393288/wjvsh6t3afnbthdplaeq.jpg", getString(R.string.home_slider_9), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1702393666/kgmlmwgeaac7ixchsjkr.jpg", getString(R.string.home_slider_10), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1710688886/zrhrifm6y5pyf0har4ve.jpg", getString(R.string.home_slider_11), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1722951477/1-Punta-Uva-Puerto-Viejo-Costa-Rica.-March-2018.-A-view-of-canoes-on-the-beach-at-Punta-Uva-in-Costa-Rica_1_qnkbof.jpg", getString(R.string.home_slider_12), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1736692170/tamarindo-sunset_j9h5af.jpg", getString(R.string.home_slider_13), ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1736692592/Montezuma-Ylang-ylang-Costa-Rica-1_lacwsy.jpg", getString(R.string.home_slider_14), ScaleTypes.FIT));


        Collections.shuffle(tmpImgList);


        ArrayList<SlideModel> finalList = new ArrayList<>( tmpImgList.subList(0,MAX_SLIDER_ELEMENTS));
        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(finalList,ScaleTypes.FIT);


        new BackgroundTask(this.getActivity()) {
            @Override
            public void doInBackground() {
                HttpRequestJSON.getRequest(this.getContext(),"https://api.recope.go.cr/ventas/precio/consumidor",cb);
            }

            @Override
            public void onPostExecute() {

            }
        }.execute();

        binding.textTimeZone.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toggleTimeZoneModal();
            }
            return true;
        });

        binding.textCurrency.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.home_currency_disclaimer);
            }
            return true;
        });

        binding.textLanguage.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.home_language_disclaimer);
            }
            return true;
        });

        binding.textTip.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.home_tip_disclaimer);
            }
            return true;
        });

        binding.textGasStation.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleGasModal();
            }
            return true;
        });

        binding.textDriving.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.home_driving_disclaimer);
            }
            return true;
        });

        binding.textSim.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.home_sim_disclaimer);
            }
            return true;
        });

        binding.textClimate.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.climate_disclaimer);
            }
            return true;
        });
        binding.textHoliday.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleOtherModal(R.string.holidays_disclaimer);
            }
            return true;
        });

        binding.textTaxi.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleTaxiModal();
            }
            return true;
        });

        binding.textEmergencies.setOnTouchListener((v, event) -> {
            if (DrawableTextViewTouched.touchedRight((TextView) v,event)) {
                toogleEmergenciesModal();
            }
            return true;
        });
        return root;
    }

    public void toggleTimeZoneModal(){
        View view = getLayoutInflater().inflate(R.layout.fragment_home_timezone_modal,binding.getRoot(),false);
        BottomSheetDialog dialog = new BottomSheetDialog(this.requireContext());
        TextView txt = view.findViewById(R.id.timeZoneSubHeader);
        TimeZone tz = TimeZone.getTimeZone("GMT-06:00");
        Calendar c = Calendar.getInstance(tz);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        String meridiam = " AM";
        if(hour > 12){
            meridiam = " PM";
            hour -= 12;
        }
        String time = hour+":" + (minute<10?"0"+minute:minute) + meridiam;
        txt.setText(time);

        dialog.setContentView(view);
        dialog.show();
    }

    public void toogleOtherModal(int text){
        View view = getLayoutInflater().inflate(R.layout.fragment_home_default_modal,binding.getRoot(),false);
        String textToDisplay = getResources().getString(text);


        BottomSheetDialog dialog = new BottomSheetDialog(this.requireContext());
        TextView txt = view.findViewById(R.id.homePageDefaultModalText);
        if(textToDisplay.contains("href")){
            txt.setMovementMethod(LinkMovementMethod.getInstance());
        }
        txt.setText(textToDisplay.replace("\\n", Objects.requireNonNull(System.getProperty("line.separator"))));
        dialog.setContentView(view);
        dialog.show();
    }

    public void toogleGasModal(){
        View view = getLayoutInflater().inflate(R.layout.fragment_home_gas_station_modal,binding.getRoot(),false);
        BottomSheetDialog dialog = new BottomSheetDialog(this.requireContext());

        TextView txtGas1 = view.findViewById(R.id.gas1);
        TextView txtGas2 = view.findViewById(R.id.gas2);
        TextView txtGas3 = view.findViewById(R.id.gas3);
        Context context = getContext();

        if(cb_result!=null && context !=null){
            for(int index=0;index<cb_result.length();index++){
                try {
                    JSONObject singleElement = cb_result.getJSONObject(index);
                    String productName = singleElement.getString("nomprod").toLowerCase();
                    if(productName.contains("super")){
                        int intValue = (int) Math.round(singleElement.getDouble("preciototal"));
                        txtGas1.setText(context.getString(R.string.gas_price,intValue));
                    }else if(productName.contains("regular")){
                        int intValue = (int) Math.round(singleElement.getDouble("preciototal"));
                        txtGas2.setText(context.getString(R.string.gas_price,intValue));
                    }else if(productName.contains("diesel")){
                        int intValue = (int) Math.round(singleElement.getDouble("preciototal"));
                        txtGas3.setText(context.getString(R.string.gas_price,intValue));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        dialog.setContentView(view);
        dialog.show();
    }

    public void toogleTaxiModal(){
        View view = getLayoutInflater().inflate(R.layout.fragment_home_taxi_modal,binding.getRoot(),false);
        BottomSheetDialog dialog = new BottomSheetDialog(this.requireContext());

        TextView t2 = view.findViewById(R.id.downloadUber);
        t2.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://referrals.uber.com/refer?id=fzcujc7fkd48"));
            startActivity(browserIntent);
        });
        t2 = view.findViewById(R.id.downloadDidi);
        t2.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.didiglobal.passenger"));
            startActivity(browserIntent);
        });

        dialog.setContentView(view);
        dialog.show();
    }

    public void toogleEmergenciesModal(){
        View view = getLayoutInflater().inflate(R.layout.fragment_home_emergencies_modal,binding.getRoot(),false);
        BottomSheetDialog dialog = new BottomSheetDialog(this.requireContext());

        TextView t2 = view.findViewById(R.id.embassyInfo);
        t2.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rree.go.cr/?sec=misiones&cat=enCR"));
            startActivity(browserIntent);
        });

        dialog.setContentView(view);
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}