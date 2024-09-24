package model.registry;

import model.animals.builder.AnimalBuilder;

import java.util.ArrayList;
import java.util.List;

 // Доступность класса в рамках пакета
 class BuildersCreator {
    private static List<AnimalBuilder> animalBuilderList = new ArrayList<>();

    private BuildersCreator(){

    }

    public static void fillAnimalBuilderList(AnimalBuilder[] builders){
        for (int i = 0; i < builders.length; i++) {
            animalBuilderList.add(builders[i]);
        }
    }

    static List<AnimalBuilder> getAnimalBuilderList(){
        return animalBuilderList;
    }
}
