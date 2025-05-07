package sn.isep.dbe.service;

import sn.isep.dbe.dao.FiliereDAO;
import sn.isep.dbe.modele.Filiere;

import java.util.List;

public class FiliereService {
    FiliereDAO filiereDAO = new FiliereDAO();

    public List<Filiere> getAllFilieres() {
        return filiereDAO.findAll();
    }

    public Filiere ajoutFiliere(Filiere filiere) {
        Filiere result = filiereDAO.save(filiere);
        return result;
    }
}
