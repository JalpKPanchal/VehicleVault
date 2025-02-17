package com.grownited.controller;

import com.grownited.entity.CarEntity;
import com.grownited.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String listCars(Model model) {
        List<CarEntity> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "CarList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new CarEntity());
        return "AddCar";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") CarEntity car) {
        carService.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<CarEntity> car = carService.getCarById(id);
        if (car.isPresent()) {
            model.addAttribute("car", car.get());
            return "EditCar";
        } else {
            return "redirect:/cars";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") CarEntity updatedCar) {
        carService.updateCar(id, updatedCar);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
