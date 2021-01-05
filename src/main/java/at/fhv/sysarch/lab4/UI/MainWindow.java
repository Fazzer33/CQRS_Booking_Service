package at.fhv.sysarch.lab4.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainWindow.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("CQRS_Booking");
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setY(5);
        double width = 1050;

        primaryStage.setX((primScreenBounds.getWidth() - width) / 2);

        primaryStage.show();
    }
}
