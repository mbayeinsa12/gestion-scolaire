package sn.isep.dbe.modele;

public class Etudiant {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCarteEtudiant() {
        return carteEtudiant;
    }

    public void setCarteEtudiant(String carteEtudiant) {
        this.carteEtudiant = carteEtudiant;
    }

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String carteEtudiant;
    private int idFiliere;

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }


}
