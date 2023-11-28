package com.byakovaelena.repository;

import com.byakovaelena.entity.Breed;
import com.byakovaelena.entity.Dog;
import com.byakovaelena.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogDao implements CrudDao<Dog> {
private final Connection connection = DatabaseConnector.getConnection();
    @Override
    public List<Dog> findAll() {
        List<Dog> dogs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from dogs join breeds on breeds.id = dogs.breed_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               Dog d = new Dog();
               d.setId(rs.getInt(1));
               d.setDogName(rs.getString(2));
               d.setOwnerName(rs.getString(3));
               d.setAge(rs.getInt(4));

               Breed breed = new Breed();
               breed.setId(rs.getInt(5));
               breed.setName(rs.getString(7));
               d.setBreed(breed);

               dogs.add(d);

            }
        } catch (SQLException d){
            d.printStackTrace();
        }
        return dogs;
    }

    @Override
    public Dog findById(int id) {
        Dog dog = new Dog();
        String sql = "select * from dogs join breeds on breeds.id = dogs.breed_id where dogs.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                dog.setId(rs.getInt(1));
                dog.setDogName(rs.getString(2));
                dog.setOwnerName(rs.getString(3));
                dog.setAge(rs.getInt(4));

                Breed breed = new Breed();
                breed.setId(rs.getInt(5));
                breed.setName(rs.getString(7));
                dog.setBreed(breed);
            }
        }catch (SQLException d){
            d.printStackTrace();
        }
        return dog;
    }

    @Override
    public Dog save(Dog entity) {
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("insert into dogs (dog_name, owner_name, age, breed_id) values (?, ?, ?, ?)");
            ps.setString(1, entity.getDogName());
            ps.setString(2, entity.getOwnerName());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getBreed().getId());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement
                    ("select id from dogs where dog_name = ? AND owner_name = ? AND age = ?");
            pst.setString(1, entity.getDogName());
            pst.setString(2, entity.getOwnerName());
            pst.setInt(3, entity.getAge());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
               entity.setId(rs.getInt(1));
            }
        }catch (SQLException d){
            d.printStackTrace();
        }
        return entity;
    }

    @Override
    public void update(Dog entity) {
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("update dogs set dog_name = ?, owner_name = ?, age = ?, breed_id = ? where id = ?");
            ps.setString(1, entity.getDogName());
            ps.setString(2, entity.getOwnerName());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getBreed().getId());
            ps.setInt(5, entity.getId());

            ps.executeUpdate();
        }catch (SQLException d){
            d.printStackTrace();
        }


    }

    @Override
    public void delete(Dog entity) {
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("delete from dogs where id = ?");
            ps.setInt(1, entity.getId());
            ps.execute();

        }catch (SQLException d){
            d.printStackTrace();
        }

    }
}
