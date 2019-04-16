package com.falk.george.pizzapagazz;

public class Drink {
    private String name;
     private int imageDrink;

    public  Drink(String name, int imageDrink) {
        this.name = name;
        this.imageDrink = imageDrink;
    }

    public String getName() {
        return name;
    }

    public int getImageDrink() {
        return imageDrink;
    }

    public static final Drink[] drinks = {
            new Drink("Fresh tomato juice", R.drawable.tomat),
            new Drink("Fresh fruit juice", R.drawable.fresh),
            new Drink("Cappuccino", R.drawable.capuc),
            new Drink("Tea", R.drawable.tea),
            new Drink("Crafted Beer", R.drawable.beer),
            new Drink("Wine", R.drawable.wine),

    };
}
