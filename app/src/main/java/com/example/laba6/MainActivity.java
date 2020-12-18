package com.example.laba6;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new Gson();

        Cat cat_1 = new Cat();
        // Insert parameters here
        cat_1.name = "Snowball";
        cat_1.age = 13;
        cat_1.color = Color.rgb(1, 1, 1);

        // Get string here
        Log.i("GSON", gson.toJson(cat_1));

        // Insert string here for get it in view
        String catString = "{\"age\":13,\"color\":-16711423,\"name\":\"Snowball\"}";


        Cat cat_2 = gson.fromJson(catString, Cat.class);

        final TextView catOut = findViewById(R.id.murzikOut);
        final View colorCatView = findViewById(R.id.colorCat);

        catOut.setText(String.format("Кот: %s Возраст: %s Цвет:", cat_2.name, cat_2.age));
        colorCatView.setBackgroundColor(cat_2.color);
    }
}