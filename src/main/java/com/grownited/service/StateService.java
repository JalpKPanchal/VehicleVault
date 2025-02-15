package com.grownited.service;

import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<StateEntity> getAllStates() {
        return stateRepository.findAll();
    }

    public Optional<StateEntity> getStateById(Long id) {
        return stateRepository.findById(id);
    }

    public StateEntity addState(StateEntity state) {
        return stateRepository.save(state);
    }

    public StateEntity updateState(Long id, StateEntity newState) {
        return stateRepository.findById(id).map(state -> {
            state.setStateName(newState.getStateName());
            return stateRepository.save(state);
        }).orElse(null);
    }

    public void deleteState(Long id) {
        stateRepository.deleteById(id);
    }
}
