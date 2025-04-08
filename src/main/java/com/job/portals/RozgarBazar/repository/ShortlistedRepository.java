package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.ShortlistedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortlistedRepository extends JpaRepository<ShortlistedEntity, Long> {
}