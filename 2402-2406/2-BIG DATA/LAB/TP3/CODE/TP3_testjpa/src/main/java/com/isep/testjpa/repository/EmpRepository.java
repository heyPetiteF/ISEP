package com.isep.testjpa.repository;
import com.isep.testjpa.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
}