package com.byakovaelena.repository;

import com.byakovaelena.DatabaseConnector;
import com.byakovaelena.entity.Breed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BreedDao implements CrudDao<Breed>{
    private final Connection connection = DatabaseConnector.getConnection();
    @Override
    public List<Breed> findAll() {
        List<Breed> breeds = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from breeds");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Breed breed = new Breed();
                breed.setId(rs.getInt(1));
                breed.setName(rs.getString(2));
                breeds.add(breed);
            }
        } catch (SQLException d){
            d.printStackTrace();
        }
        return breeds;
    }

    @Override
    public Breed findById(int id) {
        Breed breed = new Breed();
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from breeds where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                breed.setId(rs.getInt(1));
                breed.setName(rs.getString(2));
            }
        } catch (SQLException d){
            d.printStackTrace();
        }
        return breed;
    }

    @Override
    public Breed save(Breed entity) {
        return null;
    }

    @Override
    public void update(Breed entity) {

    }

    @Override
    public void delete(Breed entity) {

    }
}
