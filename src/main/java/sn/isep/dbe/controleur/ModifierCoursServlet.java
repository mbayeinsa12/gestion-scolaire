package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Cours;
import sn.isep.dbe.service.CoursService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cours/modifier")
public class ModifierCoursServlet extends HttpServlet {

    private CoursService coursService;

    @Override
    public void init() throws ServletException {
        this.coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Cours cours = coursService.getCoursById(id);
        req.setAttribute("item", cours);
        req.getRequestDispatcher("/WEB-INF/views/modifier-cours.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Cours coursExistant = coursService.getCoursById(id);
        if (coursExistant == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        String volumeHoraire = req.getParameter("volumeHoraire");

        coursExistant.setCode(code);
        coursExistant.setNom(nom);
        coursExistant.setDescription(description);
        coursExistant.setVolumeHoraire(Integer.parseInt(volumeHoraire));

        coursService.modifierCours(coursExistant);
        resp.sendRedirect(req.getContextPath() + "/cours/lister");
    }
}
