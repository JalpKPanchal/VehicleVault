package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grownited.entity.CityEntity;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByState_StateId(Long stateId);
}
