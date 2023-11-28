package com.byakovaelena.menu.buttons.dogbuttons;

import com.byakovaelena.repository.DogDao;
import com.byakovaelena.menu.MenuItem;

import java.util.Scanner;

public class DogByIdButton implements MenuItem {
    DogDao dogDao = new DogDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dog id");
        int id = scanner.nextInt();
        System.out.println(dogDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Find dog by Id";
    }
}
