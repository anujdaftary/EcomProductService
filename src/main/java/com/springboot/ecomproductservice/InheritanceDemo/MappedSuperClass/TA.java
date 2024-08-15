package com.springboot.ecomproductservice.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MS_ta")
public class TA extends User{
    private double averageRating;

}
