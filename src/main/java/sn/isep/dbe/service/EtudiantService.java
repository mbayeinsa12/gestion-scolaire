package sn.isep.dbe.service;

import sn.isep.dbe.dao.EtudiantDAO;
import sn.isep.dbe.modele.Etudiant;

import java.util.List;

public class EtudiantService {
    EtudiantDAO etudiantDAO = new EtudiantDAO();

    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantDAO.findAll();
        return etudiants;
    }
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        Etudiant result = etudiantDAO.save(etudiant);
        return result;
    }

    public Etudiant getEtudiantById(int id) {
        Etudiant etudiant = etudiantDAO.findById(id);
        return etudiant;
    }

    public Etudiant modifierEtudiant(Etudiant etudiant) {
        Etudiant result = etudiantDAO.update(etudiant);
        return result;
    }
    public void supprimerEtudiant(int id) {
        etudiantDAO.delete(id);
    }

}
