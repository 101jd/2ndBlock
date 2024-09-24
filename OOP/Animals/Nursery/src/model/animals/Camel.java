package model.animals;

import java.time.LocalDate;

public class Camel extends Animal {
    public Camel(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getClassName() {
        return "Camel";
    }


}
