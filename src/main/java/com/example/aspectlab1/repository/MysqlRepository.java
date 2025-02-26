package com.example.aspectlab1.repository;

import com.example.aspectlab1.model.address;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlRepository extends JpaRepository<address, Integer> {
}
