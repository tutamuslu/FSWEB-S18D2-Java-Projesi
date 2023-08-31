package com.workintech.restapi.services;

import com.workintech.restapi.entity.Fruit;
import com.workintech.restapi.entity.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {
    Vegetable save(Vegetable vegetable);
    List<Vegetable> findAll();
    Optional<Vegetable> findById(int id);
    Vegetable update(Vegetable vegetable);
    void delete(Vegetable vegetable);
    List<Vegetable> getByPriceDesc();
    List<Vegetable> getByPriceAsc();
    List<Vegetable> searchByName(String name);
}
