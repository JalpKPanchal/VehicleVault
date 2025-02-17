package com.grownited.controller;

import com.grownited.entity.AreaEntity;
import com.grownited.entity.CityEntity;
import com.grownited.service.AreaService;
import com.grownited.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private CityService cityService;

    @GetMapping
    public String listAreas(Model model) {
        List<AreaEntity> areas = areaService.getAllAreas();
        model.addAttribute("areas", areas);
        return "AreaList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("area", new AreaEntity());
        model.addAttribute("cities", cityService.getAllCities());
        return "AddArea";
    }

    @PostMapping("/save")
    public String saveArea(@ModelAttribute("area") AreaEntity area, @RequestParam Long cityId) {
        areaService.addArea(area, cityId);
        return "redirect:/area";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<AreaEntity> area = areaService.getAreaById(id);
        if (area.isPresent()) {
            model.addAttribute("area", area.get());
            model.addAttribute("cities", cityService.getAllCities());
            return "EditArea";
        } else {
            return "redirect:/area";
        }
    }

    @PostMapping("/update/{id}")
    public String updateArea(@PathVariable Long id, @ModelAttribute("area") AreaEntity updatedArea, @RequestParam Long cityId) {
        areaService.updateArea(id, updatedArea, cityId);
        return "redirect:/area";
    }

    @GetMapping("/delete/{id}")
    public String deleteArea(@PathVariable Long id) {
        areaService.deleteArea(id);
        return "redirect:/area";
    }
}
