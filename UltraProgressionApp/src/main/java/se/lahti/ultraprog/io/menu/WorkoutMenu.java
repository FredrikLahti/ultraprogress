package se.lahti.ultraprog.io.menu;

import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.nav.Back;
import se.lahti.ultraprog.io.nav.Exit;
import se.lahti.ultraprog.io.nav.GoTo;
import se.lahti.ultraprog.io.nav.Nav;
import se.lahti.ultraprog.service.Services;

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

            }
            case 2 -> {}
            case 3 -> {}
            case 4 -> {}
            case 0 -> {return Back.get();}
            default -> io.println("Invalid entry, try again..");
        };
    }
}
