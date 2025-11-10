package se.lahti.ultraprog.io.menu;

import se.lahti.ultraprog.io.ConsoleIO;
import se.lahti.ultraprog.io.nav.Exit;
import se.lahti.ultraprog.io.nav.*;
import se.lahti.ultraprog.service.Services;

public class MainMenu implements Menu{

    @Override
    public String title(){
        return "ULTRA PROGRESSION MAIN MENU";
    }

    @Override
    public Nav handle(ConsoleIO io, Services services){
        io.println("""
                1) Workouts
                2) Training Plan
                3) Goals
                4) Races
                0) Exit
                """);
        while (true){
            int choice = io.readInt("Your choice: ",0,4);

            switch (choice){
                case 1 -> new GoTo(new WorkoutMenu());
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 0 -> {return Exit.get();}
                 default -> io.println("Invalid entry, try again..");
            };
        }


    }
}
