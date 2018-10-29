package com.ymagis.appraisal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymagis.appraisal.model.MeaningSkils;

@Repository
public interface MeaningRepository extends JpaRepository<MeaningSkils, Long>{

}
