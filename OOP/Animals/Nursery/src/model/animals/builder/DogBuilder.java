package model.animals.builder;

import model.animals.Animal;
import model.animals.Dog;
import model.animals.enums.AnimalType;
import model.animals.enums.Pets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class DogBuilder extends AnimalBuilder{
    public DogBuilder() {
        super(Pets.DOG);
    }

    @Override
    public Dog build(String name, LocalDate birthDate) {
        ++counter;
        System.out.println(counter + " dog creating");
        return new Dog(counter, name, birthDate);
    }

    @Override
    public void close() throws IOException {

    }
}
