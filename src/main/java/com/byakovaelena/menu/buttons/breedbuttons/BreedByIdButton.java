package com.byakovaelena.menu.buttons.breedbuttons;

import com.byakovaelena.menu.MenuItem;
import com.byakovaelena.repository.BreedDao;

import java.util.Scanner;

public class BreedByIdButton implements MenuItem {
    private final BreedDao breedDao = new BreedDao();
    @Override
    public void run() {
        System.out.println("Input breed Id ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println(breedDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Find breed by Id";
    }
}
