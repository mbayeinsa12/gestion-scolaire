package sn.isep.dbe.controleur;

import sn.isep.dbe.service.EtudiantService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/etudiants/supprimer")
public class SupprimerEtudiantServlet extends HttpServlet {
    private EtudiantService etudiantService;

    @Override
    public void init() {
        etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        etudiantService.supprimerEtudiant(id);
        resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
    }
}

