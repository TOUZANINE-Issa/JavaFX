package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static appli.StartApplication.changeScene;

public class InscriptionController {


    @FXML
    private TextField email;
    private PasswordField motdepasse;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    private PasswordField Confirme;


    public void btnInscription() throws IOException {
        System.out.println(email.getText());
        System.out.println(motdepasse.getText());
        System.out.println(Nom.getText());
        System.out.println(Prenom.getText());
        System.out.println(Confirme.getText());


    }

    public void btnRetour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("main/appli.acceuil/Login");
    }
}