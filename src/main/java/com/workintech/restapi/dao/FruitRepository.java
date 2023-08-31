package com.workintech.restapi.dao;

import com.workintech.restapi.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price desc")
    List<Fruit> getByPriceDesc();


    @Query("SELECT f FROM Fruit f ORDER BY f.price asc")
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name like %:name%")
    List<Fruit> searchByName(String name);
}
