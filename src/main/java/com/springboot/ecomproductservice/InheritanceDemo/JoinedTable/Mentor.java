package com.springboot.ecomproductservice.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private double averageRating;

}
