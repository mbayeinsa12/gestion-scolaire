package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Cours;
import sn.isep.dbe.service.CoursService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/cours/lister")
public class ListeCoursControleur extends HttpServlet {

    private CoursService coursService;

    @Override
    public void init() throws ServletException {
        super.init();
        coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cours> coursList = coursService.listerCours();
        req.setAttribute("cours", coursList);
        req.getRequestDispatcher("/WEB-INF/views/liste-cours.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
