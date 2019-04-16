package com.falk.george.pizzapagazz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrinkFragment extends Fragment {


    public DrinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView drinkRecycler =
                (RecyclerView) inflater.inflate(R.layout.fragment_drink, container,false);

        String[] drinkName = new String[Drink.drinks.length];
        int[] drinkImages = new int[Drink.drinks.length];

        for (int i =0; i < drinkName.length; i++) {
            drinkName[i] = Drink.drinks[i].getName();
            drinkImages[i] = Drink.drinks[i].getImageDrink();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(drinkName, drinkImages);
        drinkRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        drinkRecycler.setLayoutManager(layoutManager);

        return drinkRecycler;
    }

}
