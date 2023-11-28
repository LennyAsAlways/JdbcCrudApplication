package com.byakovaelena.menu.buttons.breedbuttons;

import com.byakovaelena.menu.MenuItem;
import com.byakovaelena.repository.BreedDao;

public class AllBreedsButton implements MenuItem {
    private final BreedDao breedDao = new BreedDao();
    @Override
    public void run() {
        System.out.println("List of All breeds: ");
        breedDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Show all breeds";
    }
}
