package com.jsalazar.costaricatravel.itemGenerator;

import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.models.Place;

import java.util.ArrayList;

public class PlaceGenerator {

    public static ArrayList<Place> generate(){
        ArrayList<Place> response = new ArrayList<>();

        Place newPlace = new Place(R.string.place_1,R.string.place_1_description,R.string.place_1_download,"geo:9.9705439,-83.6903558?z=17",R.string.place_1_buy,R.string.place_1_price,R.string.place_1_schedule,new int[]{R.drawable.place_1_img_1,R.drawable.place_1_img_2,R.drawable.place_1_img_3,R.drawable.place_1_img_4,R.drawable.place_1_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_2,R.string.place_2_description,R.string.place_2_download,"geo:9.5134327,-83.5542221?z=17",R.string.place_2_buy,R.string.place_2_price,R.string.place_2_schedule,new int[]{R.drawable.place_2_img_1,R.drawable.place_2_img_2,R.drawable.place_2_img_3,R.drawable.place_2_img_4,R.drawable.place_2_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_3,R.string.place_3_description,R.string.place_3_download,"geo:9.3922047,-84.1413162?z=17",R.string.place_3_buy,R.string.place_3_price,R.string.place_3_schedule,new int[]{R.drawable.place_3_img_1,R.drawable.place_3_img_2,R.drawable.place_3_img_3,R.drawable.place_3_img_4,R.drawable.place_3_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_4,R.string.place_4_description,R.string.place_4_download,"geo:9.1548186,-83.7531078?z=17",R.string.place_4_buy,R.string.place_4_price,R.string.place_4_schedule,new int[]{R.drawable.place_4_img_1,R.drawable.place_4_img_2,R.drawable.place_4_img_3,R.drawable.place_4_img_4,R.drawable.place_4_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_5,R.string.place_5_description,R.string.place_5_download,"geo:10.7739476,-85.3525616?z=17",R.string.place_5_buy,R.string.place_5_price,R.string.place_5_schedule,new int[]{R.drawable.place_5_img_1,R.drawable.place_5_img_2,R.drawable.place_5_img_3,R.drawable.place_5_img_4,R.drawable.place_5_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_6,R.string.place_6_description,R.string.place_6_download,"geo:10.8669734,-85.6931912?z=17",R.string.place_6_buy,R.string.place_6_price,R.string.place_6_schedule,new int[]{R.drawable.place_6_img_1,R.drawable.place_6_img_2,R.drawable.place_6_img_3,R.drawable.place_6_img_4,R.drawable.place_6_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_7,R.string.place_7_description,R.string.place_7_download,"geo:10.4612189,-84.730729?z=17",R.string.place_7_buy,R.string.place_7_price,R.string.place_7_schedule,new int[]{R.drawable.place_7_img_1,R.drawable.place_7_img_2,R.drawable.place_7_img_3,R.drawable.place_7_img_4,R.drawable.place_7_img_5});
        response.add(newPlace);

        newPlace = new Place(R.string.place_8,R.string.place_8_description,R.string.place_8_download,"geo:10.1977986,-84.2408768?z=17",R.string.place_8_buy,R.string.place_8_price,R.string.place_8_schedule,new int[]{R.drawable.place_8_img_1,R.drawable.place_8_img_2,R.drawable.place_8_img_3,R.drawable.place_8_img_4,R.drawable.place_8_img_5});
        response.add(newPlace);

        return response;

    }
}
