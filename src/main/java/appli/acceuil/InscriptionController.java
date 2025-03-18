package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Utilisateur;
import repositoriy.UtilisateurRepository;

import java.awt.*;
import java.io.IOException;

import static appli.StartApplication.changeScene;

public class InscriptionController {


    @FXML
    private TextField email;
    @FXML
    private PasswordField motdepasse;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private PasswordField Confirme;


    public void btnInscription() throws IOException {
        System.out.println(email.getText());
        System.out.println(motdepasse.getText());
        System.out.println(Nom.getText());
        System.out.println(Prenom.getText());
        System.out.println(Confirme.getText());
        if (Confirme.getText().isEmpty() ||
                motdepasse.getText().isEmpty() ||
                email.getText().isEmpty() ||
                Nom.getText().isEmpty() ||
                Prenom.getText().isEmpty()) {
            System.out.println("Veuillez remplir tous les champs");
        } else if (!motdepasse.getText().equals(Confirme.getText())) {
            System.out.println("Les mots de passe ne correspondent pas");
            }else{
                Utilisateur utilisateur = new Utilisateur("utilisateur",Nom.getText(),Prenom.getText(),email.getText(),motdepasse.getText());

                UtilisateurRepository.ajouterUtilisateur(utilisateur);
                System.out.println("vous Inscrit 'o' ");
            }
        }
        //else
        //       Utilisateur utilisateur = new Utilisateur(Nom.getText(), Prenom.getText(), email.getText(), motdepasse.getText(),Role:"utilisateur");
        //boolean estInscrit = utilisateurRepository
        //    utilisateurDAO.ajouterUtilisateur(utilisateur);
        //    System.out.println("");

    public void btnRetour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("acceuil/Login");
    }
}