package com.workintech.restapi.dao;

import com.workintech.restapi.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

        @Query("SELECT f FROM Vegetable f ORDER BY f.price desc")
        List<Vegetable> getByPriceDesc();


        @Query("SELECT f FROM Vegetable f ORDER BY f.price asc")
        List<Vegetable> getByPriceAsc();

        @Query("SELECT f FROM Vegetable f WHERE f.name like %:name%")
        List<Vegetable> searchByName(String name);
    }


