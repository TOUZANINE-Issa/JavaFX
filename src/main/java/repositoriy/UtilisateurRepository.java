package repositoriy;


import dataBase.Database;
import modele.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UtilisateurRepository {

    private Connection cnx;

    public UtilisateurRepository() { this.cnx = Database.getConnexion(); }

    public UtilisateurRepository(Connection cnx) {
        this.cnx = cnx;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public void close() {

    }


    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe, role) VALUES (?, ?, ?, ?, ?)";
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
        return false;
    }
    public Utilisateur getUtilisateurParEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("role")
                );

                return utilisateur;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        String sql = "SELECT * FROM utilisateur";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            return (ArrayList<Utilisateur>) stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void supprimerUtilisateurParEmail(String email) {
        String sql ="DELETE FROM utilisateur WHERE email :email";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Utilisateur supprimé avec succès !");
    }
    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, mot_de_passe = ?, role = ? WHERE email = ?";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getRole());
            stmt.setString(6, utilisateur.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Utilisateur mis à jour avec succès !");
    }
}
