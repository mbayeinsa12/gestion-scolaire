package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/modifier")
public class ModifierNoteServlet extends HttpServlet {

    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        this.noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupère l'ID de la note passé en paramètre
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        int id = Integer.parseInt(idParam);

        // Récupère la note avec l'ID donné
        Note note = noteService.getNoteById(id);

        if (note == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        req.setAttribute("note", note); // Place la note dans l'attribut de requête
        req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp); // Affiche le formulaire de modification
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Vérifie si l'ID est fourni
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        int id = Integer.parseInt(idParam);

        // Récupère la note existante dans la base de données
        Note noteExistant = noteService.getNoteById(id);
        if (noteExistant == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        // Récupère les nouvelles valeurs
        String valeurParam = req.getParameter("valeur");
        double valeur = Double.parseDouble(valeurParam);

        // Modifie les données de la note existante
        noteExistant.setValeur(valeur);

        // Applique les changements dans la base de données
        noteService.modifierNote(noteExistant);

        // Redirige l'utilisateur vers la liste des notes
        resp.sendRedirect(req.getContextPath() + "/notes/lister");
    }
}
