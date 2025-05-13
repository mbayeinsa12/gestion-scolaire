package sn.isep.dbe.modele;

public class Cours {
    private Integer id;
    private String code;
    private String nom;
    private String description;
    private Integer volumeHoraire;

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    private Filiere filiere;

    // Autres attributs et méthodes

    public void setFiliereId(int filiereId) {
        this.filiere = new Filiere(filiereId);  // Créer un objet Filiere basé sur l'ID
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(Integer volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }
}
