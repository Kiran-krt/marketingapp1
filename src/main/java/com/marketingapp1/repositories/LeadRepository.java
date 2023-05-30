package com.marketingapp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp1.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead,Long> {

}
