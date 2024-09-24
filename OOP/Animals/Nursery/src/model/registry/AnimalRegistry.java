package model.registry;

import model.animals.Animal;
import model.animals.builder.AnimalBuilder;
import model.animals.builder.CatBuilder;
import model.animals.builder.DogBuilder;
import model.animals.enums.AnimalType;
import model.exceptions.WrongClassException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;
    private List<AnimalBuilder> builders;

    public AnimalRegistry(){
        this.animals = new ArrayList<>();
        this.builders = BuildersCreator.getAnimalBuilderList();
    }

//    public boolean addBuilder(AnimalBuilder builder){
//        if (!builders.contains(builder)){
//            builders.add(builder);
//            return true;
//        }
//        return false;
//    }

    private boolean addAnimal(Animal animal){
           return animals.add(animal);

    }

    public boolean addNewAnimal(AnimalType clazz, String name,
                                LocalDate birthDate) throws WrongClassException {
        AnimalBuilder currentBuilder;
        for (AnimalBuilder builder : builders){
            if (clazz == builder.getName()){
                currentBuilder = builder;
                Animal animal = currentBuilder.build(name, birthDate);
                System.out.println(animal.toString());
                return addAnimal(animal);
            }
        }
        return false;
    }

    public Animal getAnimal(int id){
        for (Animal animal : animals){
            if (animal.getId() == id){
                return animal;
            }
        }
        return null;
    }

    public void fillBuilders(AnimalBuilder[] builders){
        BuildersCreator.fillAnimalBuilderList(builders);
    }

    public List<AnimalBuilder> getBuilders() {
        return new ArrayList<>(builders);
    }

    public List<String> getAnimals() {
        List<String> info = new ArrayList<>();
        for (Animal animal : animals){
            info.add(animal.toString());
        }
        return info;
    }

    public int size(){
        return animals.size();
    }

    ////////////////////////////////////////////////

}
