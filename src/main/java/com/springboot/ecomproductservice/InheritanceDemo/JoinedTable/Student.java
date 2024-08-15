package com.springboot.ecomproductservice.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private double psp;
    private double attendance;
}
