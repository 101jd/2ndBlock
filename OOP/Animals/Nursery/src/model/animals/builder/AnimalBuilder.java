package model.animals.builder;

import model.animals.Animal;
import model.animals.enums.AnimalType;
import model.animals.enums.Pets;
import model.exceptions.WrongClassException;

import java.io.Closeable;
import java.time.LocalDate;
import java.util.List;

public abstract class AnimalBuilder implements Closeable {
    protected static int counter;
    private final AnimalType name;

    protected AnimalBuilder(AnimalType type) {
        this.name = type;
    }

    public abstract Animal build(String name,
                                 LocalDate birthDate)
            throws WrongClassException;

    public AnimalType getName() {
        return name;
    }

    public boolean equals(AnimalBuilder builder) {
        if (builder.name.equals(this.name))
            return true;
        return false;
    }
}
