package se.lahti.ultraprog.repo;

import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.domain.WorkoutId;

import java.time.LocalDate;
import java.util.Collection;


public interface WorkoutRepoInterface {

    void save(Workout w);
    Workout findWorkoutByDate(LocalDate workoutDate);
    Collection<Workout> findBetween();
    void delete(LocalDate workoutDate);
}
