package model.animals;

import java.time.LocalDate;

public class Donkey extends Animal {
    public Donkey(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getClassName() {
        return "Donkey";
    }


}
