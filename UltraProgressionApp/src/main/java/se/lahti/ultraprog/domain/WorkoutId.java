package se.lahti.ultraprog.domain;

import java.util.Objects;
import java.util.UUID;

public record WorkoutId(String value) {
    public WorkoutId{
        Objects.requireNonNull(value, "Workout ID can't be null");
        if(value.isBlank()) throw new IllegalArgumentException("Workout ID can't be blank");
    }

    public static WorkoutId newId(){
        return new WorkoutId(UUID.randomUUID().toString());
    }

    public static WorkoutId from(String raw){
        return new WorkoutId(raw.trim());
    }

    @Override
    public String toString(){
        return value;
    }

}
