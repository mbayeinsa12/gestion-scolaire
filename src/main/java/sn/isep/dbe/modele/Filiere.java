package sn.isep.dbe.modele;

public class Filiere {
    private Integer id;
    private String code;
    private String nom;
    private String Departement;
    private String nomResponsable;
    private String prenomResponsable;
    private Integer capacite;

    // Constructeur par défaut
    public Filiere() {}

    // Constructeur avec ID
    public Filiere(Integer id) {
        this.id = id;
    }

    // Constructeur complet
    public Filiere(Integer id, String code, String nom, String departement, String nomResponsable, String prenomResponsable, Integer capacite) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.Departement = departement;
        this.nomResponsable = nomResponsable;
        this.prenomResponsable = prenomResponsable;
        this.capacite = capacite;
    }

    // Getters et Setters
    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String departement) {
        Departement = departement;
    }

    public String getPrenomResponsable() {
        return prenomResponsable;
    }

    public void setPrenomResponsable(String prenomResponsable) {
        this.prenomResponsable = prenomResponsable;
    }
}
