package se.lahti.ultraprog.util;

import java.time.LocalDate;

public class Validate {

    public static int requirePositive(int x, String name){
        if (x <= 0) throw new IllegalArgumentException (name + " has to be positive.");
        return x;
    }

    //validate range
    public static int requireRange(int x, int min, int max, String name){
        if (x < min || x > max) throw new IllegalArgumentException(name + "Is out of range.");
        return x;
    }

    public static double requirePositive(double x, String name){
        if (x <= 0.0) throw new IllegalArgumentException (name + " has to be positive.");
        return x;
    }

    public static double requireRange(double x, double min, double max, String name){
        if (x < min || x > max) throw new IllegalArgumentException(name + "Is out of range.");
        return x;
    }





    //validate double non neg

    //double range


}
