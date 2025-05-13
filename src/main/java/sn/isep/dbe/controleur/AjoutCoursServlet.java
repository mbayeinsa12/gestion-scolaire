package sn.isep.dbe.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isep.dbe.modele.Cours;
import sn.isep.dbe.modele.Filiere;
import sn.isep.dbe.service.CoursService;                        
import sn.isep.dbe.service.FiliereService;

@WebServlet("/cours/ajouter")
public class AjoutCoursServlet extends HttpServlet {

    private FiliereService filiereService;
    private CoursService coursService;

    @Override
    public void init() throws ServletException {
        super.init();
        filiereService = new FiliereService();
        coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Filiere> filieres = filiereService.getAllFilieres(); 
        req.setAttribute("filieres", filieres);
        req.getRequestDispatcher("/WEB-INF/views/ajout-cours.jsp").forward(req, resp); 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        int volumeHoraire = Integer.parseInt(req.getParameter("volumeHoraire"));
        int filiereId = Integer.parseInt(req.getParameter("filiereId"));

        Cours cours = new Cours();
        cours.setCode(code);
        cours.setNom(nom);
        cours.setDescription(description);
        cours.setVolumeHoraire(volumeHoraire);
        cours.setFiliereId(filiereId); 

        coursService.ajoutCours(cours); 

        resp.sendRedirect(req.getContextPath() + "/cours/lister"); 
    }
}
