package model.animals.builder;

import model.animals.Donkey;
import model.animals.Humster;
import model.animals.enums.PackAnimals;
import model.animals.enums.Pets;

import java.io.IOException;
import java.time.LocalDate;

public class DonkeyBuilder extends AnimalBuilder{
    public DonkeyBuilder() {
        super(PackAnimals.DONKEY);
    }

    @Override
    public Donkey build(String name, LocalDate birthDate) {
        ++counter;
        return new Donkey(counter, name, birthDate);
    }

    @Override
    public void close() throws IOException {

    }
}
