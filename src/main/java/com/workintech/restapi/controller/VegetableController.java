package com.workintech.restapi.controller;

import com.workintech.restapi.entity.Fruit;
import com.workintech.restapi.entity.Vegetable;
import com.workintech.restapi.services.FruitService;
import com.workintech.restapi.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> getFruits(){
        return vegetableService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vegetable> getFruit(@PathVariable  int id){
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }

    @PostMapping("/")
    public Vegetable saveFruit(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @PostMapping("/name")
    public List<Vegetable> searchByName(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable deleteById(@PathVariable int id){
        Optional<Vegetable> vegetable = vegetableService.findById(id);
        vegetableService.delete(vegetable.get());
        return vegetable.get();
    }
}
