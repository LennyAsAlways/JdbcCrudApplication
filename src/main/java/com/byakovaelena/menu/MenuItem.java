package com.byakovaelena.menu;

public interface MenuItem {
   void run();
   default String getTitle(){
       return "Exit Button";
   }
}
