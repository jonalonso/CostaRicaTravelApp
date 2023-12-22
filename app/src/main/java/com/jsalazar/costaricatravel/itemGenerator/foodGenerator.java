package com.jsalazar.costaricatravel.itemGenerator;

import com.jsalazar.costaricatravel.R;
import com.jsalazar.costaricatravel.models.Food;
import com.jsalazar.costaricatravel.models.FoodRow;

import java.util.ArrayList;

public class foodGenerator {

    public static ArrayList<FoodRow> generate(){
        ArrayList<FoodRow> response = new ArrayList<>();
        Food firstElement = new Food(R.string.food_1,R.drawable.food_1_img,R.string.food_1_description,"Pinto","₡1500 ∼ ₡4500");
        Food secondElement = new Food(R.string.food_2,R.drawable.food_2_img,R.string.food_2_description, "Olla de carne","₡3500 ∼ ₡5000");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_3,R.drawable.food_3_img,R.string.food_3_description,"Chifrijo","₡3500 ∼ ₡5500");
        secondElement = new Food(R.string.food_4,R.drawable.food_4_img,R.string.food_4_description,"Tamales","₡1000 ∼ ₡2000");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_5,R.drawable.food_5_img,R.string.food_5_description,"Arroz con leche","₡1000 ∼ ₡3000");
        secondElement = new Food(R.string.food_6,R.drawable.food_6_img,R.string.food_6_description,"Picadillo de chayote","");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_7,R.drawable.food_7_img,R.string.food_7_description,"Chorreadas","₡1000 ∼ ₡2000");
        secondElement = new Food(R.string.food_8,R.drawable.food_8_img,R.string.food_8_description,"Empanadas","₡1000 ∼ ₡2000");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_9,R.drawable.food_9_img,R.string.food_9_description,"Casado","₡2500 ∼ ₡4500");
        secondElement = new Food(R.string.food_10,R.drawable.food_10_img,R.string.food_10_description,"Vigorón","₡3500 ∼ ₡5000");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_11,R.drawable.food_11_img,R.string.food_11_description,"Rice and beans","₡4000 ∼ ₡6000");
        secondElement = new Food(R.string.food_12,R.drawable.food_12_img,R.string.food_12_description,"Arroz con pollo","₡2500 ∼ ₡4500");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_13,R.drawable.food_13_img,R.string.food_13_description,"Agua dulce","₡1000 ∼ ₡1500");
        secondElement = new Food(R.string.food_14,R.drawable.food_14_img,R.string.food_14_description,"Ceviche","₡1500 ∼ ₡2500");
        response.add(new FoodRow(firstElement,secondElement));

        firstElement = new Food(R.string.food_15,R.drawable.food_15_img,R.string.food_15_description,"Chúrchil","₡1000 ∼ ₡2500");
        secondElement = new Food(R.string.food_16,R.drawable.food_16_img,R.string.food_16_description,"Budín","₡500 ∼ ₡1000");
        response.add(new FoodRow(firstElement,secondElement));

        return response;
    }
}
