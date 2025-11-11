package se.lahti.ultraprog.repo;

import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.domain.WorkoutId;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WorkoutRepo implements WorkoutRepoInterface{
    private final Map<WorkoutId, Workout> storedWorkouts = new LinkedHashMap<>();

    public WorkoutRepo(){};

    public WorkoutId save(Workout w){
        WorkoutId id = WorkoutId.newId();
        storedWorkouts.put(id, w);
        return id;

    }

    public void delete(WorkoutId id){

    }

    public List<Workout> findBetween(LocalDate from, LocalDate to){

    }

    public Optional<Workout> findById(WorkoutId id){

    }

}
