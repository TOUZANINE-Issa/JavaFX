package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField motDePasse;

    @FXML
    void btnConnexion() throws IOException {
        System.out.println("Votre Email : "+email.getText());
        System.out.println("Votre Mot de passe : "+motDePasse.getText());
        if (email.getText().equals("admin") && motDePasse.getText().equals("Azerty"))
        //Utilisateur user =new utilisateur(utilisateur utilisateur)
            {
            System.out.println("Connexion réussier");
        } else {
            System.out.println("Connexion échouer");
        }
    }
    @FXML
    void btnMotDePasseOublie() {


    }

    @FXML
    public void btnInscription() throws IOException {
        StartApplication.changeScene("acceuil/Inscription");

    }
    public void btnRetour() throws IOException {
        StartApplication.changeScene("acceuil/Connexion");
    }
}

