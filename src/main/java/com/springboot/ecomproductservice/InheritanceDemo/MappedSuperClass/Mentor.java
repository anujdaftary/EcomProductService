package com.springboot.ecomproductservice.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.realm.UserDatabaseRealm;

@Getter
@Setter
@Entity(name = "MS_mentor")
public class Mentor extends User {
    private double averageRating;

}
