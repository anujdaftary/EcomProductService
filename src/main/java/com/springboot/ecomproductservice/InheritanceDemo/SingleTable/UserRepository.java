package com.springboot.ecomproductservice.InheritanceDemo.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ST_ur")
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    <S extends User> S save(S entity);
}
