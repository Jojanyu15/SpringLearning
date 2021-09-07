package com.springboot.item.models.service;

import com.springboot.item.models.Item;

import java.util.List;

public interface IItemService {
    public List<Item> findAll();
    public Item findByID(Long id);
    public Object findByIDO(Long id);

}
