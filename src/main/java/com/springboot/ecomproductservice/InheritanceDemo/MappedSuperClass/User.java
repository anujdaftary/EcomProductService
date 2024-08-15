package com.springboot.ecomproductservice.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
@ToString
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
