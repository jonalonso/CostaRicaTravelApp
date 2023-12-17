package com.jsalazar.costaricatravel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.costaricatravel.R;
import com.example.costaricatravel.databinding.FragmentHomeBinding;
import com.jsalazar.costaricatravel.utils.AdsController;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.TimeZone;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private final int MAX_SLIDER_ELEMENTS = 5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
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


        //

        Collections.shuffle(tmpImgList);


        ArrayList<SlideModel> finalList = new ArrayList<>() ;
        for(int i=0;i<MAX_SLIDER_ELEMENTS;i++){
            finalList.add(tmpImgList.get(i));
        }

        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(finalList);


        TextView textView = binding.textTimeZone;

        textView.setOnTouchListener((v, event) -> {
            v.performClick();
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int[] textLocation = new int[2];
                textView.getLocationOnScreen(textLocation);
                if (event.getRawX() >= textLocation[0] + textView.getWidth() - textView.getTotalPaddingRight()){
                    toogleTimeZoneModal();
                }
            }
            return true;
        });

        TextView textView2 = binding.textCurrency;

        textView2.setOnTouchListener((v, event) -> {
            v.performClick();
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int[] textLocation = new int[2];
                textView2.getLocationOnScreen(textLocation);
                if (event.getRawX() >= textLocation[0] + textView2.getWidth() - textView2.getTotalPaddingRight()){
                    toogleOtherModal(R.layout.fragment_home_currency_modal);
                }
            }
            return true;
        });

        TextView textView3 = binding.textLanguage;

        textView3.setOnTouchListener((v, event) -> {
            v.performClick();
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int[] textLocation = new int[2];
                textView3.getLocationOnScreen(textLocation);
                if (event.getRawX() >= textLocation[0] + textView3.getWidth() - textView3.getTotalPaddingRight()){
                    toogleOtherModal(R.layout.fragment_home_language_modal);
                }
            }
            return true;
        });


        AdsController.displayBanner(binding.adView);
        return root;
    }

    public void toogleTimeZoneModal(){
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

    public void toogleOtherModal(int layout){
        View view = getLayoutInflater().inflate(layout,binding.getRoot(),false);
        BottomSheetDialog dialog = new BottomSheetDialog(this.requireContext());
        dialog.setContentView(view);
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}