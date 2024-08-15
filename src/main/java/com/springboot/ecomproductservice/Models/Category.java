package com.springboot.ecomproductservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    @OneToMany//(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
