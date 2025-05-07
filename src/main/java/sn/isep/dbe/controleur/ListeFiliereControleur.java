package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Filiere;
import sn.isep.dbe.service.FiliereService;
import sn.isep.dbe.util.ConnexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/filieres/lister")
public class ListeFiliereControleur extends HttpServlet {

    FiliereService filiereService;

    @Override
    public void init() throws ServletException {
        super.init();
        filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Filiere> filieres = filiereService.getAllFilieres();

        req.setAttribute("filieres", filieres);
        req.getRequestDispatcher("/WEB-INF/views/liste-filiere.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
