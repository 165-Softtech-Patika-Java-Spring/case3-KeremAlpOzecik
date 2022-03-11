package com.example.demo.prd.dao;

import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.entity.PrdProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrdProductDao extends JpaRepository<PrdProduct,Long> {
Optional<PrdProduct> findById(Long id);
    Optional<PrdProduct> findByName(String name);


}
