package com.grownited.service;

import com.grownited.entity.AreaEntity;
import com.grownited.entity.CityEntity;
import com.grownited.repository.AreaRepository;
import com.grownited.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<AreaEntity> getAllAreas() {
        return areaRepository.findAll();
    }

    public void addArea(AreaEntity area, Long cityId) {
        CityEntity city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));
        area.setCity(city);
        areaRepository.save(area);
    }

    public Optional<AreaEntity> getAreaById(Long id) {
        return areaRepository.findById(id);
    }

    public void updateArea(Long id, AreaEntity updatedArea, Long cityId) {
        Optional<AreaEntity> existingAreaOpt = areaRepository.findById(id);
        if (existingAreaOpt.isPresent()) {
            AreaEntity existingArea = existingAreaOpt.get();
            CityEntity city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));
            existingArea.setAreaName(updatedArea.getAreaName());
            existingArea.setCity(city);
            areaRepository.save(existingArea);
        }
    }

    public void deleteArea(Long id) {
        areaRepository.deleteById(id);
    }
}
