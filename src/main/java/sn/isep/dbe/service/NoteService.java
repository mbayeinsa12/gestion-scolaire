package sn.isep.dbe.service;

import sn.isep.dbe.dao.NoteDAO;
import sn.isep.dbe.modele.Note;

import java.util.List;

public class NoteService {
    private NoteDAO noteDAO;

    public NoteService() {
        noteDAO = new NoteDAO();
    }

    public List<Note> getAllNotes() {
        return noteDAO.findAll();
    }

    public Note getNoteById(int id) {
        return noteDAO.findById(id);
    }

    public Note ajouterNote(Note note) {
        return noteDAO.save(note);
    }

    public Note modifierNote(Note note) {
        return noteDAO.update(note);
    }

    public void supprimerNote(Note note) {
        noteDAO.delete(note);
    }
}
