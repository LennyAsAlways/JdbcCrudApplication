package com.byakovaelena.menu;

import com.byakovaelena.menu.buttons.breedbuttons.AllBreedsButton;
import com.byakovaelena.menu.buttons.breedbuttons.BreedByIdButton;
import com.byakovaelena.menu.buttons.dogbuttons.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private static boolean exitButton = false;
    private static Map<Integer, MenuItem> menu = new TreeMap<>();
    static {
        menu.put(-1, () -> exitButton = true);
        menu.put(11, new AllDogButton());
        menu.put(12, new DogByIdButton());
        menu.put(13, new SaveNewDogButton());
        menu.put(14, new UpdateDogButton());
        menu.put(15, new DeleteDogButton());
        menu.put(21, new AllBreedsButton());
        menu.put(22, new BreedByIdButton());
    }

    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        do {
            printMenuChoices();
            Integer choice = scanner.nextInt();
            if (menu.containsKey(choice)){
            menu.get(choice).run();
            }else {
                System.out.println("Choose one command, that represents in menu ");
            }
        } while (!exitButton);
    }
    private void printMenuChoices(){
        System.out.println("------------------------- ");
        System.out.println("Select command: ");
        menu.forEach((k, v)-> System.out.println(k + " - " + v.getTitle()));
    }
}
