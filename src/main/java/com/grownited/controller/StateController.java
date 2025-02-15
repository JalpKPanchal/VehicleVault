package com.grownited.controller;

import com.grownited.entity.StateEntity;
import com.grownited.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public String listStates(Model model) {
        List<StateEntity> states = stateService.getAllStates();
        model.addAttribute("states", states);
        return "StateList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("state", new StateEntity());
        return "AddState";
    }

    @PostMapping("/save")
    public String saveState(@ModelAttribute("state") StateEntity state) {
        stateService.addState(state);
        return "redirect:/states";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<StateEntity> state = stateService.getStateById(id);
        if (state.isPresent()) {
            model.addAttribute("state", state.get());
            return "EditState";
        } else {
            return "redirect:/states";
        }
    }

    @PostMapping("/update/{id}")
    public String updateState(@PathVariable Long id, @ModelAttribute("state") StateEntity updatedState) {
        stateService.updateState(id, updatedState);
        return "redirect:/states";
    }

    @GetMapping("/delete/{id}")
    public String deleteState(@PathVariable Long id) {
        stateService.deleteState(id);
        return "redirect:/states";
    }
}
