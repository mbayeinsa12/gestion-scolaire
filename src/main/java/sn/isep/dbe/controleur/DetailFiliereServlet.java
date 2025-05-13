package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Filiere;
import sn.isep.dbe.service.FiliereService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filieres/details")
public class DetailFiliereServlet extends HttpServlet {
    private FiliereService filiereService;

    @Override
    public void init() {
        filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Filiere filiere = filiereService.getFiliereById(id);
        req.setAttribute("filiere", filiere);
        req.getRequestDispatcher("/WEB-INF/views/detail-filiere.jsp").forward(req, resp);
    }
}
