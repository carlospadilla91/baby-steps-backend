package com.project.babysteps.repository;

import com.project.babysteps.model.Nap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NapRepository extends JpaRepository<Nap, Long> {
    List<Nap> findByBabyId(Long babyId);
}
