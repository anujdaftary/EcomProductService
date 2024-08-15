package com.springboot.ecomproductservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


import java.util.UUID;
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID uuid;
}
