package model.animals;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Animal {
    public Cat(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getClassName() {
        return "Cat";
    }


}
