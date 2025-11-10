package se.lahti.ultraprog.service;

import java.util.Objects;

/**
 * Facade for the programs services for easy wiring. It provides getters for each service
 * 
 */
public class Services {
    private final WorkoutService workoutService;
    private final GoalService goalService;
    private final AchivementService achivementService;
    private final RaceService raceService;
    private final TrainingPlanService trainingPlanService;
    
    public Services(WorkoutService workoutService, GoalService goalService,AchivementService achivementService,
                    RaceService raceService, TrainingPlanService trainingPlanService ){
        this.workoutService = Objects.requireNonNull(workoutService);
        this.goalService = Objects.requireNonNull(goalService);
        this.achivementService = Objects.requireNonNull(achivementService);
        this.raceService = Objects.requireNonNull(raceService);
        this.trainingPlanService = Objects.requireNonNull(trainingPlanService);
    }
    
    public WorkoutService workoutService(){return workoutService;}
    public GoalService goalService(){return goalService;}
    public AchivementService achivementService(){return achivementService;}
    public RaceService raceService(){return raceService;}
    public TrainingPlanService trainingPlanService(){return trainingPlanService;}
}
