import model.Service;
import model.animals.builder.AnimalBuilder;
import model.animals.builder.CatBuilder;
import model.animals.builder.DogBuilder;
import model.animals.enums.Pets;
import model.registry.AnimalRegistry;
import presenter.Presenter;
import view.cui.ConsoleUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConsoleUI ui = new ConsoleUI(new Service());
        ui.init();
        ui.menu();

        //test
    }
}