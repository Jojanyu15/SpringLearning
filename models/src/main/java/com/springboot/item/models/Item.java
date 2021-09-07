package com.springboot.item.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    public Item(Bill item) {
		// TODO Auto-generated constructor stub
	}

	private Bill bill;
}
