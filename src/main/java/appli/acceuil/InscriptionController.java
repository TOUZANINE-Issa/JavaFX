package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repositoriy.UtilisateurRepository;
import java.io.IOException;

import static appli.StartApplication.changeScene;

public class InscriptionController {


    @FXML
    private TextField email;
    @FXML
    private PasswordField motDePasse;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private PasswordField Confirme;


    public void btnInscription() throws IOException {
        String nom = this.Nom.getText();
        String prenom = this.Prenom.getText();
        String email = this.email.getText();
        String motDePasse = this.motDePasse.getText();
        String confirme = this.Confirme.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || confirme.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
        }

        if (!motDePasse.equals(confirme)) {
            System.out.println("Les mots de passe ne correspondent pas.");
        }else {
            BCryptPasswordEncoder motDePasseHacher = new BCryptPasswordEncoder();
            String mdpHacher = motDePasseHacher.encode(motDePasse);
            System.out.println("Mot de passe hashé : " + mdpHacher);

            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
            String role = "utilisateur";
            Utilisateur utilisateur = new Utilisateur( role , nom, prenom, email, mdpHacher);
            utilisateurRepository.ajouterUtilisateur(utilisateur);


            System.out.println("Inscription réussie !");
        }

    }

    public void btnRetour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("acceuil/Login");
    }
}