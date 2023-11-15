package com.example.costaricatravel.itemGenerator;

import com.example.costaricatravel.R;
import com.example.costaricatravel.models.Food;
import com.example.costaricatravel.models.FoodRow;

import java.util.ArrayList;

public class foodGenerator {

    public static ArrayList<FoodRow> generate(){
        ArrayList<FoodRow> response = new ArrayList<>();
        Food firstElement = new Food(R.string.food_1,R.drawable.food_1_img,R.string.food_1_description);
        Food secondElement = new Food(R.string.food_2,R.drawable.food_2_img,R.string.food_2_description);
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_3,R.drawable.food_3_img,R.string.food_3_description);
        secondElement = new Food(R.string.food_4,R.drawable.food_4_img,R.string.food_4_description);
        response.add(new FoodRow(firstElement,secondElement));

        return response;
    }
}
