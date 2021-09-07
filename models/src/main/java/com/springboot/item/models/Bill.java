package com.springboot.item.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bill  implements Serializable {

    private long bill_id;
    private long customer_id;
    private Date createdAt;

}