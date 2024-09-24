package model.animals;

import java.time.LocalDate;

public class Humster extends Animal {
    public Humster(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getClassName() {
        return "Humster";
    }


}
