package com.workintech.restapi.controller;

import com.workintech.restapi.entity.Fruit;
import com.workintech.restapi.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> getFruits(){
        return fruitService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Fruit> getFruit(@PathVariable  int id){
        return fruitService.findById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }

    @PostMapping("/")
    public Fruit saveFruit(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/name")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteById(@PathVariable  int id){
        Optional<Fruit> fruit = fruitService.findById(id);
        fruitService.delete(fruit.get());
        return fruit.get();
    }
}
