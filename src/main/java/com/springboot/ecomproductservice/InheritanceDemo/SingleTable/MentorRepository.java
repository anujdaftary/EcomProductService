package com.springboot.ecomproductservice.InheritanceDemo.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ST_mr")
public interface MentorRepository extends JpaRepository<Mentor,Long> {
    <S extends Mentor> S save(S entity);
}
