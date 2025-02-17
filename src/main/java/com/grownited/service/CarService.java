package com.grownited.service;

import com.grownited.entity.CarEntity;
import com.grownited.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<CarEntity> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public void addCar(CarEntity car) {
        carRepository.save(car);
    }

    public void updateCar(Long id, CarEntity updatedCar) {
        Optional<CarEntity> existingCar = carRepository.findById(id);
        if (existingCar.isPresent()) {
            CarEntity car = existingCar.get();
            car.setMake(updatedCar.getMake());
            car.setModel(updatedCar.getModel());
            car.setYear(updatedCar.getYear());
            car.setVariant(updatedCar.getVariant());
            car.setMileage(updatedCar.getMileage());
            car.setFuelType(updatedCar.getFuelType());
            car.setTransmissionType(updatedCar.getTransmissionType());
            car.setPrice(updatedCar.getPrice());
            car.setColor(updatedCar.getColor());
            car.setDescription(updatedCar.getDescription());
            car.setStatus(updatedCar.getStatus());
            car.setListingDate(updatedCar.getListingDate());
            car.setRegistrationNum(updatedCar.getRegistrationNum());
            car.setRegistrationYear(updatedCar.getRegistrationYear());
            car.setInsurance(updatedCar.getInsurance());
            car.setSeats(updatedCar.getSeats());
            car.setKmsDriven(updatedCar.getKmsDriven());
            car.setRTO(updatedCar.getRTO());
            car.setOwnership(updatedCar.getOwnership());
            car.setEngineDisplacement(updatedCar.getEngineDisplacement());
            car.setNoOfAirBags(updatedCar.getNoOfAirBags());
            carRepository.save(car);
        }
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
