package model;


import model.animals.Animal;
import model.animals.builder.AnimalBuilder;
import model.animals.enums.AnimalType;
import model.exceptions.WrongClassException;
import model.registry.AnimalRegistry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private AnimalRegistry registry;

    public Service() {
        this.registry = new AnimalRegistry();
    }

    public void fillBuilders(AnimalBuilder[] builders){
        registry.fillBuilders(builders);
    }

//    public AnimalRegistry getRegistry() {
//        return registry;
//    }

    private Animal getAnimal(int id){
        return registry.getAnimal(id);
    }

    public String printAnimal(int id){
        return getAnimal(id).toString();
    }

    public boolean addNewComand(int id, String comand){
        return getAnimal(id).addNewComand(comand);
    }

    public List<String> getComands(int id){
        return getAnimal(id).getComandsNames();
    }

    public List<String> getAnimalsInfo(){
        return registry.getAnimals();
    }

    public boolean addNewAnimal(AnimalType clazz, String name,
                                LocalDate birthDate) throws WrongClassException{
        return registry.addNewAnimal(clazz, name, birthDate);
    }

    public int size(){
        return registry.size();
    }


    ///////////////////////////////////////////////

    public List<AnimalBuilder> getBuilders(){
        return registry.getBuilders();
    }
}
