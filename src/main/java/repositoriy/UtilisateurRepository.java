package repositoriy;


import modele.Utilisateur;
import dataBase.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UtilisateurRepository {

    private Connection cnx;
    public static void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }
    public void supprimerUtilisateurParEmail(String email) {
        String sql ="DELETE FROM utilisateur WHERE email :email";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
}
