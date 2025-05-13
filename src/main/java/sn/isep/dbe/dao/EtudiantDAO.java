package sn.isep.dbe.dao;

import sn.isep.dbe.modele.Etudiant;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setEmail(rs.getString("email"));
                etudiant.setTelephone(rs.getString("telephone"));
                etudiant.setCarteEtudiant(rs.getString("carte_etudiant"));
                etudiants.add(etudiant);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiants;
    }

    public Etudiant findById(int id) {
        Etudiant etudiant = null;
        String sql = "SELECT * FROM etudiant WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                etudiant = new Etudiant();
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setEmail(rs.getString("email"));
                etudiant.setTelephone(rs.getString("telephone"));
                etudiant.setCarteEtudiant(rs.getString("carte_etudiant"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiant;
    }

    public Etudiant save(Etudiant etudiant) {
        String sql = "INSERT INTO etudiant (nom, prenom, email, telephone, carte_etudiant) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getEmail());
            statement.setString(4, etudiant.getTelephone());
            statement.setString(5, etudiant.getCarteEtudiant());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiant;
    }

    public Etudiant update(Etudiant etudiant) {
        String sql = "UPDATE etudiant SET nom = ?, prenom = ?, email = ?, telephone = ?, carte_etudiant = ? WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getEmail());
            statement.setString(4, etudiant.getTelephone());
            statement.setString(5, etudiant.getCarteEtudiant());
            statement.setInt(6, etudiant.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiant;
    }

    public void delete(Etudiant etudiant) {
        String sql = "DELETE FROM etudiant WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, etudiant.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM etudiant WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
