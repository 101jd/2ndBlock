package view.cui;

import model.Service;
import presenter.Presenter;
import view.iView;

import java.util.Scanner;

public class ConsoleUI implements iView {
    Presenter presenter;
    public ConsoleUI(Service service) {
        presenter = new Presenter(this, service);
    }

    public void menu(){
        System.out.println(helloMessage());

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            String input = scanner.nextLine().toLowerCase();
            //1
            if (input.equals("new")){
                String clazz;
                String name;
                String date;

                //REQUEST DATA
                System.out.println("Enter type of animal");
                clazz = scanner.nextLine();
                System.out.println("Enter name");
                name = scanner.nextLine();
                System.out.println("Enter birth date in YYYY-MM-DD format");
                date = scanner.nextLine();

                presenter.addNewAnimal(clazz, name, date);
            }

            //2
            if (input.startsWith("add ")){
                String comand;
                //REQUEST DATA
                System.out.println("Enter command:");
                comand = scanner.nextLine();
                presenter.addCommand(getArg(input), comand);
            }

            //3
            if (input.startsWith("print ")){
                presenter.printAnimal(getArg(input));
            }

            //4
            if (input.startsWith("commands ")){
                presenter.printCommands(getArg(input));
            }

            //5
            if (input.equals("printall")){
                presenter.printAll();
            }

            //6
            if (input.equals("help")){
                System.out.println(helloMessage());
            }

            //7
            if (input.equals("q")){
                scanner.close();
                System.out.println("Bye!");
                flag = false;
            }
        }
    }

    private String helloMessage(){
        StringBuilder sb = new StringBuilder();

        sb.append("WELCOME TO ANIMAL NURSERY!").append(System.lineSeparator())
                .append("'new' to add new animal")
                .append(System.lineSeparator())
                .append("'add <id> <command name>' to add new command to animal")
                .append(System.lineSeparator())
                .append("'print <id>' to print animal info")
                .append(System.lineSeparator())
                .append("'commands <id>' to print all animal commands")
                .append(System.lineSeparator())
                .append("'printall' to print all animals in the nursery")
                .append(System.lineSeparator())
                .append("'help' to see menu")
                .append(System.lineSeparator())
                .append("'q' to quit");

        return sb.toString();
    }

    private String getArg(String input) {
        String[] args = input.split(" ");
        try {


            return args[1];
        } catch (ArrayIndexOutOfBoundsException e){
            return e.getMessage();
        }
    }

    @Override
    public void init() {
        presenter.fillBuilders();
    }

    @Override
    public void answer(String answer){
        System.out.println(answer);
    }


}
