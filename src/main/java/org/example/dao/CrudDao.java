package org.example.dao;

import java.util.List;

public interface CrudDao <D>{
    List<D> findAll();
    D findById(int id);
    D save(D entity);
    void update(D entity);
    void delete(D entity);
}
