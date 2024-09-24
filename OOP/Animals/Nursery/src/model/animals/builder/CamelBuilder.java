package model.animals.builder;

import model.animals.Camel;
import model.animals.Donkey;
import model.animals.enums.PackAnimals;
import model.animals.enums.Pets;

import java.io.IOException;
import java.time.LocalDate;

public class CamelBuilder extends AnimalBuilder{
    public CamelBuilder() {
        super(PackAnimals.CAMEL);
    }

    @Override
    public Camel build(String name, LocalDate birthDate) {
        ++counter;
        return new Camel(counter, name, birthDate);
    }

    @Override
    public void close() throws IOException {

    }
}
