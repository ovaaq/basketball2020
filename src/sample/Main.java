package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller controller = new Controller();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "panel.fxml"
                )
        );
        loader.setController(controller);

        Parent root = loader.load();


        primaryStage.setTitle("Basketball2020");
       // Font.loadFont(Main.class.getResource("./College.TFF").toExternalForm(), 12);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setMaximized(true);
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();


        FXMLLoader loader2 = new FXMLLoader(
                getClass().getResource(
                        "panel2.fxml"
                )
        );
        loader2.setController(controller);


        Parent anotherRoot = loader2.load();

        Stage anotherStage = new Stage();
        Scene anotherScene = new Scene(anotherRoot);
        anotherScene.getRoot().requestFocus();
        anotherStage.setScene(anotherScene);
        anotherStage.setFullScreen(true);
        anotherStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
