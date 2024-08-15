package com.springboot.ecomproductservice.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_mentor")
public class Mentor extends User {
    private double averageRating;

}
