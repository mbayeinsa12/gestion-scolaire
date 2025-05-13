package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/ajouter")
public class AjoutNoteServlet extends HttpServlet {
    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        super.init();
        noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ajout-note.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idEtudiant = req.getParameter("idEtudiant");
        String idCours = req.getParameter("idCours");
        String valeur = req.getParameter("valeur");

        Note note = new Note();
        note.setIdEtudiant(Integer.parseInt(idEtudiant));
        note.setIdCours(Integer.parseInt(idCours));
        note.setValeur(Double.parseDouble(valeur));

        noteService.ajouterNote(note);


        resp.sendRedirect(req.getContextPath() + "/notes/lister");
    }
}
