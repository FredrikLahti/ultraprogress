package se.lahti.ultraprog.domain;
import se.lahti.ultraprog.app.CreateWorkoutRequest;
import se.lahti.ultraprog.util.Validate;

import java.time.LocalDate;

public class Workout {
    private String groundType;
    private double distanceKm;
    private double timeMin;
    private double pace;
    private int calories;
    private int cadence;
    private int avgHr;
    private LocalDate workoutDate;
    private WorkoutHandle handle;
    private WorkoutId id;


    public Workout(String groundType, double distance, double time, double pace, int calories
    , int cadence, int avgHr, LocalDate workoutDate, WorkoutHandle handle, WorkoutId id){
        this.groundType = groundType;
        this.distanceKm = Validate.requirePositive(distance,"distance in km ");
        this.timeMin = Validate.requirePositive(time,"Time in Minutes ");
        this.pace = Validate.requirePositive(pace, "Pace in min/km: ");
        this.calories = Validate.requirePositive(calories, "Calories ");
        this.cadence = Validate.requirePositive(cadence, "Cadence ");
        this.avgHr = Validate.requireRange(avgHr,30,230, "Average Heart Rate ");
        this.workoutDate = workoutDate;
        this.handle = handle;
        this.id = id;

        if(groundType == null || groundType.isBlank()) throw new IllegalArgumentException("Surface type must exist.");


    }

    public String getGroundType(){return groundType;}
    public double getDistance(){return distanceKm;}
    public double getTime(){return timeMin;}
    public double getPace(){return pace;}
    public int getCalories(){return calories;}
    public int getCadence(){return cadence;}
    public int getHr(){return avgHr;}
    public WorkoutId getId(){return id;}
    public LocalDate getDate(){return workoutDate; }
    public WorkoutHandle getHandle(){return handle;}




    public static Workout create(String groundType, double distanceKm, double timeMin, double pace,
                                 int calories, int cadence, int avgHr, LocalDate workoutDate, WorkoutHandle handle,
                                 WorkoutId id){
        return new Workout(groundType, distanceKm, timeMin, pace, calories, cadence, avgHr, workoutDate, handle, id);
    }
}
