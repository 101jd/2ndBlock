package model.animals;

import java.time.LocalDate;

public class Horse extends Animal {
    public Horse(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getClassName() {
        return "Horse";
    }


}
