package com.workintech.restapi.services;

import com.workintech.restapi.entity.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit save(Fruit fruit);
    List<Fruit> findAll();
    Optional<Fruit> findById(int id);
    Fruit update(Fruit fruit);
    void delete(Fruit fruit);
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);
}
