package se.lahti.ultraprog.repo;

import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.domain.WorkoutHandle;
import se.lahti.ultraprog.domain.WorkoutId;

import java.time.LocalDate;
import java.util.*;

public class WorkoutRepo implements WorkoutRepoInterface{
    private final Map<WorkoutId, Workout> storedWorkouts = new LinkedHashMap<>();
    private final Map<WorkoutHandle, WorkoutId> handleToId = new HashMap<>();
    private final Map<LocalDate, Integer> SeqByDate = new HashMap<>();
    private final Map<LocalDate,WorkoutId> dateToId = new HashMap<>();

    public WorkoutRepo(){};

    /**
     * Stores the newly created workout in the diffrent maps. Not sure which I want to use yet so abit messy.
     * @param w workout that was created.
     */
    public void save(Workout w){
        storedWorkouts.put(w.getId(), w);
        dateToId.put(w.getDate(), w.getId());
        handleToId.put(w.getHandle(), w.getId());
    }

    /**
     * Checks the date of workout and makes seq to default 1 or whatever was the seq for that date.
     * It then adds +1 so if another workout is added the same date seq will be +1.
     * @param workoutDate the date of the workout
     * @return integer to keep track of which workout it was.
     */
    public synchronized int nextSeqDate(LocalDate workoutDate){
        int next = SeqByDate.getOrDefault(workoutDate,1);
        SeqByDate.put(workoutDate, next + 1);
        return next;

    }

    public void delete(WorkoutId id){

    }

    public List<Workout> findBetween(LocalDate from, LocalDate to){


    }

    public Workout findWorkoutByDate(LocalDate workoutDate){
        return storedWorkouts.get(dateToId.get(workoutDate));
    }

}
