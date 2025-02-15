package com.grownited.repository;

import com.grownited.entity.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {
    boolean existsByFeatureName(String featureName);
}
