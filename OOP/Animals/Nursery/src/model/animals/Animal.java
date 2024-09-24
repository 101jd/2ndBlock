package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Animal {
    private int id;
    private String name;
    private List<String> comands;
    private LocalDate birthDate;

    public Animal(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.comands = new ArrayList<>();
        this.birthDate = birthDate;
    }

    public List<String> getComandsNames(){
        return new ArrayList<>(this.comands);
    }

    public boolean addNewComand(String comand){
        if (this.comands.add(comand))
            return true;
        return false;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append(" ")
                .append(this.getClassName()).append(" ")
                .append(this.name).append(" ")
                .append(this.birthDate.toString()).append(System.lineSeparator());
        return sb.toString();
    }

    public abstract String getClassName();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
