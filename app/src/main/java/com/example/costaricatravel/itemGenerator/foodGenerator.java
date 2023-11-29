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
        secondElement = new Food(R.string.food_10,R.drawable.food_10_img,R.string.food_10_description,"Vigoron");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_11,R.drawable.food_11_img,R.string.food_11_description,"Rice and beans");
        secondElement = new Food(R.string.food_12,R.drawable.food_12_img,R.string.food_12_description,"Arroz con pollo");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_13,R.drawable.food_13_img,R.string.food_13_description,"Agua dulce");
        secondElement = new Food(R.string.food_14,R.drawable.food_14_img,R.string.food_14_description,"Ceviche");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_15,R.drawable.food_15_img,R.string.food_15_description,"Chúrchil");
        //secondElement = new Food(R.string.food_14,R.drawable.food_14_img,R.string.food_14_description,"Ceviche");
        response.add(new FoodRow(firstElement,null));

        return response;
    }
}
