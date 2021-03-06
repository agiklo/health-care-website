package com.agiklo.HeathProject.controler.restControllers;

import com.agiklo.HeathProject.model.dto.SetDTO;
import com.agiklo.HeathProject.model.workout.Set;
import com.agiklo.HeathProject.model.workout.Workout;
import com.agiklo.HeathProject.repository.SetRepository;
import com.agiklo.HeathProject.service.workout.SetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/v2/workouts/exercises/sets")
@AllArgsConstructor
public class SetRestController {

    private final SetService setService;

    @GetMapping
    public ResponseEntity<List<SetDTO>> getAllSets(){
        return status(HttpStatus.OK).body(setService.getAllSets());
    }

    @GetMapping("{id}")
    public ResponseEntity<List<SetDTO>> getAllByExercises(@PathVariable("id") Long id) {
        return status(HttpStatus.OK).body(setService.getAllByExercises(id));
    }

    @PostMapping("{id}")
    public ResponseEntity<Set> addNewSet(@PathVariable("id") Long id, @RequestBody Set set) {
        return status(HttpStatus.CREATED).body(setService.addNewSet(id, set));
    }


}
