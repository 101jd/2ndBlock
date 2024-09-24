package model.animals.builder;

import model.animals.Dog;
import model.animals.Humster;
import model.animals.enums.Pets;

import java.io.IOException;
import java.time.LocalDate;

public class HumsterBuilder extends AnimalBuilder{
    public HumsterBuilder() {
        super(Pets.HUMSTER);
    }

    @Override
    public Humster build(String name, LocalDate birthDate) {
        ++counter;
        return new Humster(counter, name, birthDate);
    }

    @Override
    public void close() throws IOException {

    }
}
