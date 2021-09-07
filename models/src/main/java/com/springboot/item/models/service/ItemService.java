package com.springboot.item.models.service;

import com.springboot.item.models.Bill;
import com.springboot.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemService implements IItemService {

    @Autowired
    private RestTemplate restClient;

    @Override
    public List<Item> findAll() {
        List<Bill> bills = Arrays.asList(restClient.getForObject("http://localhost:8001/bill", Bill[].class));
        return bills.stream().map(item -> new Item(item)).collect(Collectors.toList());
    }

    @Override
    public Item findByID(Long id) {
        Map<String,String> pathVariables =  new HashMap<String,String>();
        pathVariables.put("id",id.toString());
        Bill bills = restClient.getForObject("http://localhost:8001/bill/{id}", Bill.class,pathVariables);
        return new Item(bills);
    }

    @Override
    public Object findByIDO(Long id) {
        return "Hola";
    }
}
