package com.byakovaelena.menu.buttons.dogbuttons;

import com.byakovaelena.entity.Dog;
import com.byakovaelena.menu.MenuItem;
import com.byakovaelena.repository.DogDao;

import java.util.Scanner;

public class DeleteDogButton implements MenuItem {
    private final DogDao dogDao = new DogDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Dog d = new Dog();
        d.setId(id);
        dogDao.delete(d);
    }

    @Override
    public String getTitle() {
        return "Delete dog by Id";
    }
}
