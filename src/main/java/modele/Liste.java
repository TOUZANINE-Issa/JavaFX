package modele;

public class Liste {

    private int idListe;

    private String nom;

    public Liste(String nom, int idListe) {
        this.nom = nom;
        this.idListe = idListe;
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Liste{" +
                "idListe=" + idListe +
                ", nom='" + nom + '\'' +
                '}';
    }

}
