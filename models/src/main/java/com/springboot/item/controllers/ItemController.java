package com.springboot.item.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.item.models.Item;
import com.springboot.item.models.service.IItemService;

import java.util.List;

@RestController
public class ItemController {

	
    @Autowired
    private IItemService itemService;

    @GetMapping("/bill")
    public List<Item> list(){
        return itemService.findAll();
    }

    @GetMapping("/bill/{id}")
    public Object getBill(@PathVariable long id){
        return itemService.findByIDO(id);
    }

    @GetMapping("/hello")
    public Object getBill(){
        return "hello";
    }
}
