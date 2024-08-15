package com.springboot.ecomproductservice.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ST_ta")
@DiscriminatorValue(value = "2")
public class TA extends User {
    private double averageRating;

}
