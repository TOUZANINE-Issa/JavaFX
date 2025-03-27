package appli.acceuil;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import repositoriy.UtilisateurRepository;
import modele.Utilisateur;

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
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(email.getText());

        if (email.getText().isEmpty() || motDePasse.getText().isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
        }
        if ( utilisateur != null ){
            System.out.println("c bon ");

        }else {
            System.out.println("c pas bon ");

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

