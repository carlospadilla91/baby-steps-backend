package com.project.babysteps.repository;

import com.project.babysteps.model.DiaperChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaperChangeRepository extends JpaRepository<DiaperChange, Long> {
    List<DiaperChange> findByBabyId(Long babyId);
}
