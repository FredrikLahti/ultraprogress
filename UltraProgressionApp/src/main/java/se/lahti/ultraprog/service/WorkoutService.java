package se.lahti.ultraprog.service;

import se.lahti.ultraprog.app.CreateWorkoutRequest;
import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.domain.WorkoutId;
import se.lahti.ultraprog.repo.WorkoutRepo;

import java.time.LocalDate;


public class WorkoutService {
    WorkoutRepo workoutRepo;

    public WorkoutService(WorkoutRepo workoutRepo){
        this.workoutRepo = workoutRepo;
    }

    public WorkoutId logWorkout(CreateWorkoutRequest workoutReq){

        String groundType = workoutReq.groundType();
        double distanceKm = workoutReq.distanceKm();
        double timeMin = workoutReq.timeMin();
        double pace = workoutReq.pace();
        int calories = workoutReq.calories();
        int cadence = workoutReq.cadence();
        int avgHr = workoutReq.avgHr();
        LocalDate workoutDate = workoutReq.workoutDate();

        Workout workout = Workout.create(groundType, distanceKm, timeMin, pace, calories, cadence, avgHr, workoutDate);
        return workoutRepo.save(workout);

    }
}
