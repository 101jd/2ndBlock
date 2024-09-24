package model.animals.builder;

import model.animals.Donkey;
import model.animals.Horse;
import model.animals.enums.PackAnimals;
import model.animals.enums.Pets;

import java.io.IOException;
import java.time.LocalDate;

public class HorseBuilder extends AnimalBuilder{
    public HorseBuilder() {
        super(PackAnimals.HORSE);
    }

    @Override
    public Horse build(String name, LocalDate birthDate) {
        ++counter;
        return new Horse(counter, name, birthDate);
    }

    @Override
    public void close() throws IOException {

    }
}
