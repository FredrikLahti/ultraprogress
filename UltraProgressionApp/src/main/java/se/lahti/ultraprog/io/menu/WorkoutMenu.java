package se.lahti.ultraprog.io.menu;

import se.lahti.ultraprog.app.CreateWorkoutRequest;
import se.lahti.ultraprog.domain.Workout;
import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.nav.*;
import se.lahti.ultraprog.service.Services;

import java.time.LocalDate;


public class WorkoutMenu implements Menu{

    @Override
    public String title(){
        return "Workout Menu";
    }

    @Override
    public Nav handle(ConsoleIO io, Services services){

        io.println("""
                1) Log Workout
                2) Find Workout
                3) View Workouts
                4) Remove Workout
                0) Back
                """);
        int choice = io.readInt("Your choice: ",0,4);

        switch (choice){
            case 1 -> {
                //WorkoutID can be used to find specific workouts, UUID.
                services.workoutService().logWorkout(createWorkoutFlow(io));

            }
            case 2 -> {
                Workout w = services.workoutService().findWorkout(io.readIsoDate("Enter what date to look at: "));
                io.printf("Workout Information%nSurface: %s%nDistance: %.2f%nTime: %.2f%nPace: %.2f%nCalories burned: " +
                        "%d%nAverage Cadence: %d%nAverage Heart Rate: %d%nWorkout Date: %tF%n",
                        w.getGroundType(),w.getDistance(),
                        w.getTime(), w.getPace(), w.getCalories(), w.getCadence(),w.getHr(), w.getDate());
            }
            case 3 -> {
                LocalDate from = io.readIsoDate("Enter from what Date to view Workouts: ");
                LocalDate until = io.readIsoDate("Enter until what Date to view Workouts: ");
                services.workoutService().viewWorkouts(from, until);
            }
            case 4 -> {}
            case 0 -> {return Back.get();}
            default -> io.println("Invalid entry, try again..");
        };
        return Stay.get();
    }

    /**
     * Helper method to create necessary arguments for each workout
     *
     * @param io Console helper for I/O
     * @return the record for arguments that are input dependant
     */
    public CreateWorkoutRequest createWorkoutFlow(ConsoleIO io){
        String groundType = io.readLine("Enter Workout Surface: ");
        double distanceKm = io.readDouble("Enter Workout Distance in Km: ");
        double timeMin = io.readDouble("Enter Workout Time in Minutes: ");
        double pace = timeMin/distanceKm;
        int calories = io.readInt("Enter Calories Burnt from Workout: ");
        int cadence = io.readInt("Enter Average Workout Cadence: ");
        int avgHr = io.readInt("Enter Average Workout Heart Rate: ");
        LocalDate workoutDate = io.readIsoDate("Enter Workout Date: ");


        return new CreateWorkoutRequest(groundType, distanceKm, timeMin, pace,
                calories, cadence, avgHr, workoutDate);
    }

}
