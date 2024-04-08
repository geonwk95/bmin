package com.team1.model.repository;

import com.team1.model.entity.PackagingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagingRepository extends JpaRepository<PackagingEntity , Integer > {
}
