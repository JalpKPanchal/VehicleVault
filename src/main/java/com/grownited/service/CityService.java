package com.grownited.service;

import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    public List<CityEntity> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<CityEntity> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    public List<CityEntity> getCitiesByState(Long stateId) {
        return cityRepository.findByState_StateId(stateId);
    }

    public CityEntity addCity(Long stateId, CityEntity city) {
        Optional<StateEntity> state = stateRepository.findById(stateId);
        state.ifPresent(city::setState);
        return cityRepository.save(city);
    }

    public CityEntity updateCity(Long id, Long stateId, CityEntity newCity) {
        return cityRepository.findById(id).map(city -> {
            city.setCityName(newCity.getCityName());
            stateRepository.findById(stateId).ifPresent(city::setState);
            return cityRepository.save(city);
        }).orElse(null);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
