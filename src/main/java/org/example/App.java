package org.example;

import org.example.dao.DogDao;
import org.example.entity.Dog;

import java.sql.Connection;
import java.util.List;

/**
 * Jdbc Crud Application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection connection = DatabaseConnector.getConnection ();
        System.out.println("Connection is succeeded");
        System.out.println("List of all dogs");
        DogDao dogDao = new DogDao();
        List<Dog> dogList = dogDao.findAll();

        dogList.forEach(System.out::println);
        System.out.println("-------------------------------");

//        Dog d = new Dog();
//        d.setDogName("Darcy");
//        d.setOwnerName("Maria");
//        d.setAge(1);
//        d = dogDao.save(d);
//        System.out.println("-------------------------------");
//        dogList = dogDao.findAll();
//        dogList.forEach(System.out::println);
//
//        d.setAge(2);
//        dogDao.update(d);
        Dog d = new Dog();
        d.setId(7);
        dogDao.delete(d);

        System.out.println("-------------------------------");
        dogList = dogDao.findAll();
        dogList.forEach(System.out::println);


    }
}
