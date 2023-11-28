package com.byakovaelena.menu.buttons.dogbuttons;

import com.byakovaelena.entity.Breed;
import com.byakovaelena.entity.Dog;
import com.byakovaelena.menu.MenuItem;
import com.byakovaelena.repository.DogDao;

import java.util.Scanner;

public class UpdateDogButton implements MenuItem {
    private final DogDao dogDao = new DogDao();
    @Override
    public void run() {
        Dog d = updateDog();
        dogDao.update (d);
    }

    @Override
    public String getTitle() {
        return "Update dog";
    }
    private Dog updateDog(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input dog id which you want to update ");
        int id = scanner.nextInt();

        Dog d = dogDao.findById(id);
        System.out.println(d);

        System.out.println("Edit dog: ");

        System.out.println("Input dog name (input \"old\" for the old value) ");
        String s = scanner.nextLine();
        if(!s.equals("old")){
            d.setDogName(s);
        }

        System.out.println("Input dog's owner name (input \"old\" for the old value) ");
        String ownerName = scanner.nextLine();
        if(!ownerName.equals("old")){
            d.setOwnerName(ownerName);
        }

        System.out.println("Input dog age (input \"-1\" for the old value) ");
        int age = scanner.nextInt();
        if(age != -1){
            d.setAge(age);
        }

        System.out.println("Input dog breed (input \"-1\" for the old value) ");
        Breed b = new Breed();
        int bId = scanner.nextInt();

        if(bId != -1) {
            b.setId(bId);
            d.setBreed(b);
        }

        return d;
    }
}
