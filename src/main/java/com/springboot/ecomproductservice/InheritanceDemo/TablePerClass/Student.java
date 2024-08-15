package com.springboot.ecomproductservice.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_student")
public class Student extends User {
    private double psp;
    private double attendance;
}
