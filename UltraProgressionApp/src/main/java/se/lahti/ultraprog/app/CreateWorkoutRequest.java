package se.lahti.ultraprog.app;

import java.time.LocalDate;

public record CreateWorkoutRequest(String groundType, double distanceKm, double timeMin,
                                   double pace, int calories, int cadence, int avgHr, LocalDate workoutDate) {}
