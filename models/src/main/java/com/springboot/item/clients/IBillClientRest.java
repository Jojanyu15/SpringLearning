package com.springboot.item.clients;

import com.springboot.item.models.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "factura-microservice",url = "localhost:8001")
public interface IBillClientRest {

    @GetMapping("/bill")
    public List<Bill> list();

    @GetMapping("/bill/{id}")
    public Object getBill(@PathVariable long id);
}
