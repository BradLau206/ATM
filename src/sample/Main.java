/**
 * Main Class
 *
 * Runs all classes.
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * All required Javafx imports + sample package
 */
package sample;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main Class.
 */
public class Main extends Application {

    /**
     * Model, Controller, and View
     */
    private Model model;
    private Controller controller;
    private View view;

     /**
     * Start
     *
     * Links Model, View, and Controller with respected classes
      *
      * @param primaryStage     The main stage used in the program
     */
    public void start(Stage primaryStage) throws Exception{
        controller = new Controller();
        model = new Model(controller);
        view = new View(primaryStage,controller,model);
        model.setView(view);
        controller.setView(view);
        controller.setModel(model);
        primaryStage.show();
    }

    /**
     * Launch the program.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
