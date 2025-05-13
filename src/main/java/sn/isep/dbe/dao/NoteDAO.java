package sn.isep.dbe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.util.ConnexionBD;

public class NoteDAO {

    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();

        try (Connection connection = ConnexionBD.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM note");

            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt("id"));
                note.setValeur(rs.getDouble("note")); // Change "note" to the actual column name for the note value in your table
                note.setIdEtudiant(rs.getInt("etudiant_id")); // Update to actual column name
                note.setIdCours(rs.getInt("cours_id")); // Update to actual column name

                notes.add(note);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notes;
    }

    public Note findById(int id) {
        Note note = null;
        String sql = "SELECT * FROM note WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                note = new Note();
                note.setId(rs.getInt("id"));
                note.setValeur(rs.getDouble("valeur"));
                note.setIdEtudiant(rs.getInt("etudiant_id")); // Update to actual column name
                note.setIdCours(rs.getInt("cours_id")); // Update to actual column name
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return note;
    }

    public Note save(Note note) {
        String sql = "INSERT INTO note (note, etudiant_id, cours_id) VALUES (?, ?, ?)"; // Update to actual column names

        try (Connection connection = ConnexionBD.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, note.getValeur());
            statement.setInt(2, note.getIdEtudiant());
            statement.setInt(3, note.getIdCours());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return note;
    }

    public Note update(Note note) {
        String sql = "UPDATE note SET note = ?, etudiant_id = ?, cours_id = ? WHERE id = ?"; // Update to actual column names

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, note.getValeur());
            statement.setInt(2, note.getIdEtudiant());
            statement.setInt(3, note.getIdCours());
            statement.setInt(4, note.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return note;
    }

    public void delete(Note note) {
        String sql = "DELETE FROM note WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, note.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
