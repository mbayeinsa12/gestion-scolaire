package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Cours;
import sn.isep.dbe.service.CoursService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/details")
public class DetailCoursServlet extends HttpServlet {
    private CoursService coursService;

    @Override
    public void init() {
        coursService = new CoursService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cours cours = coursService.getCoursById(id);
        req.setAttribute("cours", cours);
        req.getRequestDispatcher("/WEB-INF/views/detail-cours.jsp").forward(req, resp);
    }
}

