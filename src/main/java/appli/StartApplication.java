package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("acceuil/LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 220, 360);
        mainStage.setTitle("Connexion/Inscription");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String nomDuFichierFxml ) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(StartApplication.class.getResource(nomDuFichierFxml + "View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setScene(scene);
    }
}