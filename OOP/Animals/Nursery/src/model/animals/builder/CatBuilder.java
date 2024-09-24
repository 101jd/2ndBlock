package model.animals.builder;

import model.animals.Animal;
import model.animals.Cat;
import model.animals.enums.AnimalType;
import model.animals.enums.Pets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CatBuilder extends AnimalBuilder {

    public CatBuilder() {
        super(Pets.CAT);
    }

    @Override
    public Animal build(String name, LocalDate birthDate) {
        ++counter;
        return new Cat(counter, name, birthDate);
    }

    @Override
    public void close() throws IOException {

    }
}
