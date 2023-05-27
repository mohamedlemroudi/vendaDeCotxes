import controller.Controller;
import model.Model;
import view.ViewMenu;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new ViewMenu());
        controller.iniciar();
    }
}
