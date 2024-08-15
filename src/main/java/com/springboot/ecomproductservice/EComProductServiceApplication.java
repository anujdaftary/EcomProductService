package com.springboot.ecomproductservice;

import com.springboot.ecomproductservice.Models.Category;
import com.springboot.ecomproductservice.Models.Product;
import com.springboot.ecomproductservice.Repositories.CategoryRepository;
import com.springboot.ecomproductservice.Repositories.ProductRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springboot.ecomproductservice.InheritanceDemo.SingleTable.Mentor;
import com.springboot.ecomproductservice.InheritanceDemo.SingleTable.MentorRepository;
import com.springboot.ecomproductservice.InheritanceDemo.SingleTable.User;
import com.springboot.ecomproductservice.InheritanceDemo.SingleTable.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class EComProductServiceApplication implements CommandLineRunner {
   private MentorRepository mentorRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public EComProductServiceApplication(MentorRepository mentorRepository, UserRepository userRepository
                                  ,ProductRepository productRepository,CategoryRepository categoryRepository
                                  ) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
   public static void main(String[] args) {
        SpringApplication.run(EComProductServiceApplication.class, args);
   }

    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Anuj");
        mentor.setEmail("Anuj@gmail.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("harshita");
        user.setEmail("harshita@gmail.com");
        userRepository.save(user);

        Category category = new Category();
        category.setName("Apple Devices");
        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("The best iPhone Ever");
        product.setCategory(savedCategory);

        productRepository.save(product);
    }
}

