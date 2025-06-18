package com.project.babysteps.repository;

import com.project.babysteps.model.Feeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedingRepository extends JpaRepository<Feeding, Long> {
    List<Feeding> findByBabyId(Long babyId);
}
