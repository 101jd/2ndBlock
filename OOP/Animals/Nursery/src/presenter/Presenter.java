package presenter;

import model.Service;
import model.animals.builder.*;
import model.animals.enums.AnimalType;
import model.animals.enums.PackAnimals;
import model.animals.enums.Pets;
import model.exceptions.WrongClassException;
import view.iView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private iView view;
    private Service model;
    private final String wrongId = "Wrong ID";
    private final String mustBeNumber = "ID must be a number";


    public Presenter(iView view, Service service) {
        this.view = view;
        this.model = service;
    }

    public void addNewAnimal(String clazz, String name, String date) {
        String answer;
        if (checkDate(date)) {
            if (checkClazz(clazz) != null) {
                try {
                    model.addNewAnimal(checkClazz(clazz), name, parseDate(date));
                    answer = "Animal added";

                } catch (WrongClassException e) {
                    answer = e.getMessage();
                }
            } else answer = "There is no type in registry";
        } else answer = "Wrong date!";

        view.answer(answer);
    }


    @Modificateable
    private AnimalType checkClazz(String clazz) {
        for (AnimalType type : Pets.values()){
            if (type.toString().toLowerCase().equals(clazz.toLowerCase())){
                return type;
            }
        }
        for (AnimalType type : PackAnimals.values()){
            if (type.toString().toLowerCase().equals(clazz.toLowerCase())){
                return type;
            }
        }
        return null;
    }

    @Modificateable
    public void fillBuilders(){
        model.fillBuilders(new AnimalBuilder[]{
                new CatBuilder(),
                new DogBuilder(),
                new HumsterBuilder(),
                new HorseBuilder(),
                new DonkeyBuilder(),
                new HorseBuilder()
        });
    }

    public void addCommand(String arg, String command) {
        String answer = "";
        if (tryParseInt(arg)){
            int intArg = getArg(arg);
            if (validateId(intArg)) {
                if (model.addNewComand(intArg, command)) {
                    answer = String.format("Command %s added successfully!", command);
                } else answer = "Something went wrong";
            } else answer = wrongId;
        } else answer = mustBeNumber;
        view.answer(answer);
    }

    public void printAnimal(String arg) {
        String answer;
        if (tryParseInt(arg)) {
            int intArg = getArg(arg);
            if (validateId(intArg)) {
                answer = model.printAnimal(intArg);
            } else answer = wrongId;
        } else answer = mustBeNumber;
        view.answer(answer);
    }

    public void printCommands(String arg) {
        String answer = "";
        if (tryParseInt(arg)) {
            int intArg = getArg(arg);
            if (validateId(intArg)) {
                if (model.getComands(intArg).size() == 0){
                    answer = "There is no commands";
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String comand : model.getComands(intArg)) {
                        sb.append(comand);
                        sb.append(System.lineSeparator());
                    }

                    answer = sb.toString();
                }
            } else answer = wrongId;
        } else answer = mustBeNumber;

        view.answer(answer);
    }

    public void printAll() {
        String answer = "";
        if (model.getAnimalsInfo().size() == 0){
            answer = "There is no animals in nursery";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String info : model.getAnimalsInfo()) {
                sb.append(info);
                sb.append(System.lineSeparator());
            }
            answer = sb.toString();
        }
        view.answer(answer);
    }

    private int getArg(String string){
        return Integer.parseInt(string);
    }

    private boolean tryParseInt(String string){
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private LocalDate parseDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    private boolean checkDate(String date){
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /////////////////////////////////////
    public List<String> builders(){
        List<String> list = new ArrayList<>();
        for (AnimalBuilder builder : model.getBuilders()){
            list.add(builder.toString());
        }
        return list;
    }

    private boolean validateId(int id){
        if (id < 1 || id > model.size())
            return false;
        return true;
    }
}
