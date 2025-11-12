package se.lahti.ultraprog.service;

import se.lahti.ultraprog.app.CreateWorkoutRequest;
import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.domain.WorkoutHandle;
import se.lahti.ultraprog.domain.WorkoutId;
import se.lahti.ultraprog.repo.WorkoutRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class WorkoutService {
    WorkoutRepo workoutRepo;

    public WorkoutService(WorkoutRepo workoutRepo){
        this.workoutRepo = workoutRepo;
    }

    public void logWorkout(CreateWorkoutRequest workoutReq){

        //---Parameters that are input dependant----
        String groundType = workoutReq.groundType();
        double distanceKm = workoutReq.distanceKm();
        double timeMin = workoutReq.timeMin();
        double pace = workoutReq.pace();
        int calories = workoutReq.calories();
        int cadence = workoutReq.cadence();
        int avgHr = workoutReq.avgHr();
        LocalDate workoutDate = workoutReq.workoutDate();


        //----Fields no user should be able to change.
        WorkoutHandle handle = new WorkoutHandle(workoutDate,workoutRepo.nextSeqDate(workoutDate));
        WorkoutId id = WorkoutId.newId();


        //Calls to create a workout and return that workout.
        Workout workout = Workout.create(groundType, distanceKm, timeMin, pace, calories, cadence, avgHr,
                workoutDate, handle, id);
        //Store workout inside the repo.
        workoutRepo.save(workout);

    }


    public Workout findWorkout(LocalDate workoutDate){
        return workoutRepo.findWorkoutByDate(workoutDate);
    }

    public List<Workout> viewWorkouts(LocalDate from, LocalDate to){
        Collection<Workout> foundWorkouts = workoutRepo.findBetween();
        List<Workout> inRangeWorkouts = new ArrayList<>();
        for (Workout w : foundWorkouts){
            LocalDate workoutDate = w.getDate();
            boolean inRange = (!workoutDate.isBefore(from) && !workoutDate.isAfter(to));
            if (inRange) inRangeWorkouts.add(w);
        }
        return inRangeWorkouts;
    }


    public void removeWorkout(LocalDate workoutDate){
        workoutRepo.delete(workoutDate);
    }

}
