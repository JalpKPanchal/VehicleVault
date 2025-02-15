package com.grownited.service;

import com.grownited.entity.FeatureEntity;
import com.grownited.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public List<FeatureEntity> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Optional<FeatureEntity> getFeatureById(Long id) {
        return featureRepository.findById(id);
    }

    public void addFeature(FeatureEntity feature) {
        if (!featureRepository.existsByFeatureName(feature.getFeatureName())) {
            featureRepository.save(feature);
        }
    }

    public void updateFeature(Long id, FeatureEntity updatedFeature) {
        Optional<FeatureEntity> existingFeature = featureRepository.findById(id);
        if (existingFeature.isPresent()) {
            FeatureEntity feature = existingFeature.get();
            feature.setFeatureName(updatedFeature.getFeatureName());
            featureRepository.save(feature);
        }
    }

    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}
