package sn.isep.dbe.controleur;

import sn.isep.dbe.service.FiliereService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filieres/supprimer")
public class SupprimerFiliereServlet extends HttpServlet {
    private FiliereService filiereService;

    @Override
    public void init() {
        filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        filiereService.supprimerFiliere(id);
        resp.sendRedirect(req.getContextPath() + "/filieres/lister");
    }
}
