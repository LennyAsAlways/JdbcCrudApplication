package com.byakovaelena.entity;

public class Dog {
    private int id;
    private String dogName;
    private String ownerName;
    private int age;
    private Breed breed;

    public Dog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", dogName='" + dogName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", age=" + age +
                ", breed=" + breed +
                '}';
    }
}
