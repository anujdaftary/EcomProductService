package com.springboot.ecomproductservice.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MS_student")
public class Student extends User {
    private double psp;
    private double attendance;
}
