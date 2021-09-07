package com.springboot.item.models.service;

import com.springboot.item.clients.IBillClientRest;
import com.springboot.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ItemServiceFeign implements IItemService{

    @Autowired
    private IBillClientRest feignClient;

    @Override
    public List<Item> findAll() {
        return feignClient.list().stream().map(item -> new Item(item)).collect(Collectors.toList());
    }

    @Override
    public Item findByID(Long id) {
        return null;
    }

    @Override
    public Object findByIDO(Long id) {
        return feignClient.getBill(id);
    }
}
