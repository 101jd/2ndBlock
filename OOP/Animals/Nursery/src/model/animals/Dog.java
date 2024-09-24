package model.animals;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Animal {
    public Dog(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getClassName() {
        return "Dog";
    }


}
