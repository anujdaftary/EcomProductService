package com.springboot.ecomproductservice.InheritanceDemo.JoinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("JT_mr")
public interface MentorRepository extends JpaRepository<Mentor,Long> {
    @Override
    <S extends Mentor> S save(S entity);
}
