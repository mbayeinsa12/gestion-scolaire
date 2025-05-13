package sn.isep.dbe.service;

import sn.isep.dbe.dao.FiliereDAO;
import sn.isep.dbe.modele.Filiere;

import java.util.List;

public class FiliereService {
    FiliereDAO filiereDAO = new FiliereDAO();

    public List<Filiere> getAllFilieres() {
        List<Filiere> filieres = filiereDAO.findAll();
        return filieres;
    }

    public Filiere ajoutFiliere(Filiere filiere) {
        Filiere result = filiereDAO.save(filiere);
        return result;
    }

    // ajouter une nouvelle filiere,
    // recuperer toutes les filieres,
    // recuperer une filiere via son id

    // recuperer une filiere via son code
    public Filiere getFiliereById(int id) {
        Filiere filiere = filiereDAO.findById(id);
        return filiere;
    }
    // modifier une filiere
    public Filiere modifierFiliere(Filiere filiere) {
        Filiere result = filiereDAO.update(filiere);
        return result;
    }
    public void supprimerFiliere(int id) {
        filiereDAO.delete(id);
    }


    // supprimer une filiere
    // etc
}
