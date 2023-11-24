package com.example.costaricatravel.itemGenerator;

import com.example.costaricatravel.R;
import com.example.costaricatravel.models.Food;
import com.example.costaricatravel.models.FoodRow;

import java.util.ArrayList;

public class foodGenerator {

    public static ArrayList<FoodRow> generate(){
        ArrayList<FoodRow> response = new ArrayList<>();
        Food firstElement = new Food(R.string.food_1,R.drawable.food_1_img,R.string.food_1_description,"Pinto");
        Food secondElement = new Food(R.string.food_2,R.drawable.food_2_img,R.string.food_2_description, "Olla de carne");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_3,R.drawable.food_3_img,R.string.food_3_description,"Chifrijo");
        secondElement = new Food(R.string.food_4,R.drawable.food_4_img,R.string.food_4_description,"Tamales");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_5,R.drawable.food_5_img,R.string.food_5_description,"Arroz con leche");
        secondElement = new Food(R.string.food_6,R.drawable.food_6_img,R.string.food_6_description,"Picadillo de chayote");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_7,R.drawable.food_7_img,R.string.food_7_description,"Chorreadas");
        secondElement = new Food(R.string.food_8,R.drawable.food_8_img,R.string.food_8_description,"Empanadas");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_9,R.drawable.food_9_img,R.string.food_9_description,"Casado");
        //secondElement = new Food(R.string.food_8,R.drawable.food_8_img,R.string.food_8_description,"Empanadas");
        response.add(new FoodRow(firstElement,null));

        return response;
    }
}
