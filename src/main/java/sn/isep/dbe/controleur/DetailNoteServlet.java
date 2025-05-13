package sn.isep.dbe.controleur;

import sn.isep.dbe.service.NoteService;
import sn.isep.dbe.modele.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/notes/details")
public class DetailNoteServlet extends HttpServlet {
    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Note note = noteService.getNoteById(id);
        if (note == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        req.setAttribute("note", note);
        req.getRequestDispatcher("/WEB-INF/views/detail-note.jsp").forward(req, resp);
    }
}
