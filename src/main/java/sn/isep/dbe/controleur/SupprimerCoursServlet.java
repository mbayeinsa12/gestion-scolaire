package sn.isep.dbe.controleur;


import sn.isep.dbe.service.CoursService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/supprimer")
public class SupprimerCoursServlet extends HttpServlet {
    private CoursService coursService;

    @Override
    public void init() {
        coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        coursService.supprimerCours(id);

        resp.sendRedirect(req.getContextPath() + "/cours/lister");
    }
}
