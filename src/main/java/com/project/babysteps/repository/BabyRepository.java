package com.project.babysteps.repository;

import com.project.babysteps.model.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Long> {
    List<Baby> findByUserId(Long userId);
}
