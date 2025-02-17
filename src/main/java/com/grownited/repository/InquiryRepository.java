package com.grownited.repository;

import com.grownited.entity.InquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<InquiryEntity, Long> {
}
