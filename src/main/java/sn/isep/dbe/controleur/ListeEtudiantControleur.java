package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Etudiant;
import sn.isep.dbe.service.EtudiantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/etudiants/lister")
public class ListeEtudiantControleur extends HttpServlet {

    EtudiantService etudiantService;

@Override
    public void init() throws ServletException {
    super.init();
    etudiantService = new EtudiantService();
}

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Etudiant> etudiants = etudiantService.getAllEtudiants();

        request.setAttribute("etudiants", etudiants);
        request.getRequestDispatcher("/WEB-INF/views/liste-etudiant.jsp").forward(request, response);
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doPost(request, response);
    }
}
