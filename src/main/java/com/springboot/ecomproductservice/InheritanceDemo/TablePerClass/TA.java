package com.springboot.ecomproductservice.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_ta")
public class TA extends User {
    private double averageRating;

}
