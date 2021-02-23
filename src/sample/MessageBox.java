/**
 * Message Box Class
 *
 * Displays Notifications in a separate window.
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * All required Javafx imports + sample package
 */
package sample;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * MessageBox Class
 */
public class MessageBox {

    /**
     * MessageBox Constructor
     */
    public MessageBox() {}

    /**
     * Displays the notification
     */
    private Label output = new Label();

    /**
     * Window Setter
     *
     * Displays the notification box
     */
    public void setWindow() {
        Stage window = new Stage();
        window.setTitle("Results");
        output.setFont(new Font("Cambria",16));
        VBox vBox = new VBox();
        vBox.getChildren().addAll(output);
        Scene scene = new Scene(vBox);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * Output Setter
     *
     * Sets the message to be displayed
     *
     * @param result    message of output
     */
    public void setOutput(String result) {
        output.setText(result);
    }
}
