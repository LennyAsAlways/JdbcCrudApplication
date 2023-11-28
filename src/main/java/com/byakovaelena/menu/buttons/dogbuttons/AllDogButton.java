package com.byakovaelena.menu.buttons.dogbuttons;

import com.byakovaelena.repository.DogDao;
import com.byakovaelena.menu.MenuItem;

public class AllDogButton implements MenuItem {
    private final DogDao dogDao = new DogDao();

    @Override
    public void run() {
        System.out.println("List of All dogs: ");
        dogDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Show all dogs";
    }
}
