package com.byakovaelena.menu.buttons.dogbuttons;

import com.byakovaelena.entity.Breed;
import com.byakovaelena.entity.Dog;
import com.byakovaelena.menu.MenuItem;
import com.byakovaelena.repository.DogDao;

import java.util.Scanner;

public class SaveNewDogButton implements MenuItem {
    private final DogDao dogDao = new DogDao();

    @Override
    public void run() {
        Dog d = inputNewDog();
        d = dogDao.save(d);
        System.out.println(d);
    }

    @Override
    public String getTitle() {
        return "Create new dog";
    }
    private Dog inputNewDog(){
        Scanner scanner = new Scanner(System.in);
        Dog d = new Dog();
        System.out.println("Input dog name ");
        d.setDogName(scanner.nextLine());
        System.out.println("Input dog's owner name ");
        d.setOwnerName(scanner.nextLine());
        System.out.println("Input dog age ");
        d.setAge(scanner.nextInt());
        System.out.println("Input dog breed ");
        Breed b = new Breed();
        b.setId(scanner.nextInt());
        d.setBreed(b);

        return d;
    }
}
