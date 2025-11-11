package se.lahti.ultraprog.domain;

import java.time.LocalDate;

/**
 * Record storing date and what workout of the date, seq
 *
 * @param date the specific date
 * @param seq which workout for the day
 */
//Seq is what workout that day if more.
public record WorkoutHandle(LocalDate date, int seq) {
    public WorkoutHandle{
        if (date == null) throw new IllegalArgumentException("Date is null.");
        if(seq < 1) throw new IllegalArgumentException("Amount of workouts > 0");
    }

    /**
     * Overrides built in to String method. Returns the date and what workout it is
     *
     * @return
     */
    @Override
    public String toString(){
        return date + "#" + seq;
    }
    //Parse YYYY-MM-DD#N
    public static WorkoutHandle parse(String s){
        var parts = s.split("#", 2);
        return new WorkoutHandle(LocalDate.parse(parts[0]), Integer.parseInt(parts[1]));
    }
}
