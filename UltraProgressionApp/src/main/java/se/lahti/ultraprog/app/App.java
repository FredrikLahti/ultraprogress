package se.lahti.ultraprog.app;

import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.menu.MainMenu;
import se.lahti.ultraprog.repo.*;
import se.lahti.ultraprog.service.*;

import java.util.Locale;

import java.io.InputStream;

public class App {

    public static void app(String[] args){
        Locale locale = new Locale("English", "England");
        ConsoleIO io = new ConsoleIO(System.in, System.out, locale);

        //Repos
        WorkoutRepo workoutRepo = new WorkoutRepo();
        AchivementRepo achivementRepo = new AchivementRepo();
        GoalRepo goalRepo = new GoalRepo();
        RaceRepo raceRepo = new RaceRepo();
        TrainingPlanRepo trainingPlanRepo = new TrainingPlanRepo();


        //Services
        WorkoutService workoutService = new WorkoutService(workoutRepo);
        AchivementService achivementService = new AchivementService(achivementRepo);
        GoalService goalService = new GoalService(goalRepo);
        RaceService raceService = new RaceService(raceRepo);
        TrainingPlanService trainingPlanService = new TrainingPlanService (trainingPlanRepo);

        //Wrap in facade
        Services services = new Services(workoutService, goalService, achivementService, raceService,
                trainingPlanService);


        //Start controller
        AppController controller = new AppController (io,services,new MainMenu());
        controller.run();
    }
}
