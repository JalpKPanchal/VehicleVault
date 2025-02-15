package com.grownited.controller;

import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.service.CityService;
import com.grownited.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;

    @GetMapping
    public String listCities(Model model) {
        List<CityEntity> cities = cityService.getAllCities();
        model.addAttribute("cities", cities);
        return "CityList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("city", new CityEntity());
        model.addAttribute("states", stateService.getAllStates());
        return "AddCity";
    }

    @PostMapping("/save")
    public String saveCity(@RequestParam("stateId") Long stateId, @ModelAttribute("city") CityEntity city) {
        cityService.addCity(stateId, city);
        return "redirect:/cities";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<CityEntity> city = cityService.getCityById(id);
        if (city.isPresent()) {
            model.addAttribute("city", city.get());
            model.addAttribute("states", stateService.getAllStates());
            return "EditCity";
        } else {
            return "redirect:/cities";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCity(@PathVariable Long id, @RequestParam("stateId") Long stateId, @ModelAttribute("city") CityEntity updatedCity) {
        cityService.updateCity(id, stateId, updatedCity);
        return "redirect:/cities";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "redirect:/cities";
    }
}
