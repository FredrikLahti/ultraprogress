package se.lahti.ultraprog.io.menu;

import se.lahti.ultraprog.app.CreateWorkoutRequest;
import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.nav.Back;
import se.lahti.ultraprog.io.nav.Nav;
import se.lahti.ultraprog.service.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkoutMenu implements Menu{

    @Override
    public String title(){
        return "Workout Menu";
    }

    @Override
    public Nav handle(ConsoleIO io, Services services){

        io.println("""
                1) Log workout
                2) Find workout
                3) View workouts
                4) Remove workout
                0) Back
                """);
        int choice = io.readInt("Your choice: ",0,4);

        switch (choice){
            case 1 -> {
                services.workoutService().logWorkout(createWorkoutFlow(io));
            }
            case 2 -> {}
            case 3 -> {}
            case 4 -> {}
            case 0 -> {return Back.get();}
            default -> io.println("Invalid entry, try again..");
        };
    }

    /**
     * Helper method to create necessary arguments for each workout
     *
     * @param io Console helper for I/O
     * @return the record for necessary workout arguments.
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
