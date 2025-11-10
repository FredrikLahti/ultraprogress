package se.lahti.ultraprog.domain;
import se.lahti.ultraprog.util.Validate;

public class Workout {
    private GroundType groundType;
    private double distanceKm;
    private double timeMin;
    private double pace;
    private int calories;
    private int cadence;
    private int avgHr;
    private final double DEFAULT = 0.0;

    public Workout(GroundType groundType, double distance, double time, double pace, int calories
    , int cadence, int avgHr){
        this.groundType = groundType;
        this.distanceKm = Validate.requirePositive(distance,"distance in km ");
        this.timeMin = Validate.requirePositive(time,"Time in Minutes ");
        this.pace = Validate.requirePositive(pace, "Pace in min/km: ");
        this.calories = Validate.requirePositive(calories, "Calories ");
        this.cadence = Validate.requirePositive(cadence, "Cadence ");
        this.avgHr = Validate.requireRange(avgHr,30,230, "Average Heart Rate ");

        if(groundType == null ) throw new IllegalArgumentException("Ground type must exist.");



    }
}
