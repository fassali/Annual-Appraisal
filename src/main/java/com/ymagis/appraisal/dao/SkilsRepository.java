package com.ymagis.appraisal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymagis.appraisal.model.Skils;

@Repository
public interface SkilsRepository extends JpaRepository<Skils, Long> {

}
