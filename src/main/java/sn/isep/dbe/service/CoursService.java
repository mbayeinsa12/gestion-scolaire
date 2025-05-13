package sn.isep.dbe.service;

import sn.isep.dbe.dao.CoursDAO;
import sn.isep.dbe.modele.Cours;

import java.util.List;

public class CoursService {
    private final CoursDAO coursDAO;

    public CoursService() {
        this.coursDAO = new CoursDAO();
    }

    public List<Cours> listerCours() {
        return coursDAO.findAll();
    }



    public Cours ajoutCours(Cours cours) {
        // Appel à la méthode de DAO pour insérer un cours dans la base de données
        return coursDAO.save(cours);
    }

    public Cours getCoursById(int id) {
        return coursDAO.findById(id);
    }

    public void ajouterCours(Cours cours) {
        coursDAO.save(cours);
    }

    public void modifierCours(Cours cours) {
        coursDAO.update(cours);
    }

    public void supprimerCours(Cours cours) {
        coursDAO.delete(cours);
    }
    public void supprimerCours(int id) {
        coursDAO.delete(id);
    }




}
