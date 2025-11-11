package se.lahti.ultraprog.repo;

import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.domain.WorkoutId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkoutRepoInterface {

    WorkoutId save(Workout w);
    Optional<Workout> findById(WorkoutId id);
    List<Workout> findBetween(LocalDate from, LocalDate to);
    void delete(WorkoutId id);
}
