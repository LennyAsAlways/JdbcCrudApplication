package org.example.dao;

import org.example.DatabaseConnector;
import org.example.entity.Dog;

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
            PreparedStatement ps = connection.prepareStatement("select * from dogs");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               Dog d = new Dog();
               d.setId(rs.getInt(1));
               d.setDogName(rs.getString(2));
               d.setOwnerName(rs.getString(3));
               d.setAge(rs.getInt(4));
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
        try {
            PreparedStatement ps = connection.prepareStatement("select * from dogs where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                dog.setId(rs.getInt(1));
                dog.setDogName(rs.getString(2));
                dog.setOwnerName(rs.getString(3));
                dog.setAge(rs.getInt(4));
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
                    ("insert into dogs (dog_name, owner_name, age) values (?, ?, ?)");
            ps.setString(1, entity.getDogName());
            ps.setString(2, entity.getOwnerName());
            ps.setInt(3, entity.getAge());

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
                    ("update dogs set dog_name = ?, owner_name = ?, age = ? where id = ?");
            ps.setString(1, entity.getDogName());
            ps.setString(2, entity.getOwnerName());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getId());

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
