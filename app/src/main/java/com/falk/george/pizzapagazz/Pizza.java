package com.falk.george.pizzapagazz;

public class Pizza {

    private String name;
    private String description;
    private int pizzaImage;


    public static final Pizza[] pizzas = {
            new Pizza("Diavolo", R.drawable.diavola, "Pizza diavola means the devils pizza " +
                    "and is quite a spicy little devil and one of my favourite pizzas. " +
                    " If you like spicy hot and chilli flavours you will enjoy this pizza  recipe."),
            new Pizza("Funghi", R.drawable.funghi,
                    "This popular vegetarian pizza is topped with the finest aromatic mushrooms," +
                            " juicy mozzarella and Edam cheeses, and finished with a herb garnish."),
            new Pizza("Margarita", R.drawable.margarita,
            "Fresh tomato sauce, chewy mozzarella cheese, a sprinkling of basil on a crispy crust."),
            new Pizza("Meat", R.drawable.meat,
                    "A Meat pizza is a food " +
                            "item created when adding Cooked meat or Cooked chicken to a Plain pizza"),
            new Pizza("Seafood", R.drawable.seafood,
                    "Seafood pizza is pizza prepared with seafood as a primary ingredient. " +
                            "Many types of seafood ingredients in fresh, frozen or canned forms may be used."),
            new Pizza("Spicy", R.drawable.spicy,
                    "Traditional Italian Herbs are combined with onion flakes, garlic powder, thyme," +
                            " rosemary and red pepper flakes in this spice mix to take your pizza to the next level"),
//            new Pizza("Strawberries", R.drawable.sweet,
//                    " This is the very best strawberry dessert pizza you will find. "),
//            new Pizza("Sweet", R.drawable.sweet2,
//                    "Pizza and dessert in one – what could you wish more for? " +
//                            "There has been this huge chocolate pizza hype so we decided to make one our way.")
    };

    private Pizza(String name, int imgRes) {
        this.name = name;
        pizzaImage = imgRes;
    }

    private Pizza(String name, int pizzaImage, String description) {
        this.name = name;
        this.pizzaImage = pizzaImage;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPizzaImage() {
        return pizzaImage;
    }

    public String getDescription() {
        return description;
    }
}
