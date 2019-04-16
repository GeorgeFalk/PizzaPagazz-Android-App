package com.falk.george.pizzapagazz;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {

    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //set toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //set image details
        int pizzaId = (int) getIntent().getExtras().get(EXTRA_PIZZA_ID);
        String pizzaName = Pizza.pizzas[pizzaId].getName();
        int pizzImage = Pizza.pizzas[pizzaId].getPizzaImage();
        TextView textView = findViewById(R.id.pizza_text);
        textView.setText(pizzaName);
        ImageView imageView = findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzImage));
        imageView.setContentDescription(pizzaName);

        TextView description = findViewById(R.id.pizza_description);
        if (Pizza.pizzas[pizzaId].getDescription() != null) {
            description.setText(Pizza.pizzas[pizzaId].getDescription());
        }




    }
}
