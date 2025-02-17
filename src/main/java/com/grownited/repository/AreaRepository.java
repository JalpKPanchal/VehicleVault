package com.grownited.repository;

import com.grownited.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
}
