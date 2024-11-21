package com.delifood.delifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delifood.delifood.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
