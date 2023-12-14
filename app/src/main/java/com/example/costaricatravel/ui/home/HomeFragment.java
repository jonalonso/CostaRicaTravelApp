package com.example.costaricatravel.ui.home;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.costaricatravel.R;
import com.example.costaricatravel.databinding.FragmentHomeBinding;
import com.example.costaricatravel.models.Food;
import com.example.costaricatravel.utils.AdsController;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.TimeZone;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private int MAX_SLIDER_ELEMENTS = 5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList tmpImgList = new ArrayList<SlideModel>();

        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701354737/fqyqh5bjqjc0gdevtyi1.jpg", "Bahía ballena", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701353550/rwvf6mqko5xlcw2cfdqd.jpg", "Volcan Arenal", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701354542/orwke15erlwgpoimhlon.jpg", "Rio Celeste", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701353550/vhhc1pgghfp73xjoxmak.jpg", "La Fortuna", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701355663/mmmg11gwnipsovlpy6rk.jpg", "Isla del coco", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701355943/tfkbwj5roe6jeaywolht.jpg", "Ruinas de Cartago", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1701356330/i7auuzyujr8yemgiqqoh.jpg", "Parque La Sabana", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1702393051/rz0rzog0zwoqs0rxbntw.jpg", "Museo de los niños", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1702393288/wjvsh6t3afnbthdplaeq.jpg", "Parque Zarcero", ScaleTypes.FIT));
        tmpImgList.add(new SlideModel("https://res.cloudinary.com/dsfgjdvgt/image/upload/v1702393666/kgmlmwgeaac7ixchsjkr.jpg", "Sanatorio Duran", ScaleTypes.FIT));


        //

        Collections.shuffle(tmpImgList);


        ArrayList finalList = new ArrayList<SlideModel>() ;
        for(int i=0;i<MAX_SLIDER_ELEMENTS;i++){
            finalList.add(tmpImgList.get(i));
        }

        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(finalList);


        TextView textView = binding.textTimeZone;

        textView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int[] textLocation = new int[2];
                textView.getLocationOnScreen(textLocation);
                if (event.getRawX() >= textLocation[0] + textView.getWidth() - textView.getTotalPaddingRight()){
                    toogleTimeZoneModal();
                    return true;
                }
            }
            return true;
        });


        AdsController.displayBanner(binding.adView);
        return root;
    }

    public void toogleTimeZoneModal(){
        View view = getLayoutInflater().inflate(R.layout.fragment_home_timezone_modal,null);
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
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
        //dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}