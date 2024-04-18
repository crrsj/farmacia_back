package com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farmacia.entity.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
	
	
}
