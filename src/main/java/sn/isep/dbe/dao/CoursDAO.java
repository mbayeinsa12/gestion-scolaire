package sn.isep.dbe.dao;

import sn.isep.dbe.modele.Cours;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDAO {

    public List<Cours> findAll() {
        List<Cours> coursList = new ArrayList<>();

        try (Connection connection = ConnexionBD.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cours");

            while (rs.next()) {
                Cours cours = new Cours();
                cours.setId(rs.getInt("id"));
                cours.setCode(rs.getString("code"));
                cours.setNom(rs.getString("nom"));
                cours.setDescription(rs.getString("description"));
                cours.setVolumeHoraire(rs.getInt("volume_horaire"));
                coursList.add(cours);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coursList;
    }

    public Cours findById(int id) {
        Cours cours = null;
        String sql = "SELECT * FROM cours WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                cours = new Cours();
                cours.setId(rs.getInt("id"));
                cours.setCode(rs.getString("code"));
                cours.setNom(rs.getString("nom"));
                cours.setDescription(rs.getString("description"));
                cours.setVolumeHoraire(rs.getInt("volume_horaire"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cours;
    }

    public Cours save(Cours cours) {
        String sql = "INSERT INTO cours (code, nom, description, volume_horaire) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnexionBD.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cours.getCode());
            statement.setString(2, cours.getNom());
            statement.setString(3, cours.getDescription());
            statement.setInt(4, cours.getVolumeHoraire());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cours;
    }

    public Cours update(Cours cours) {
        String sql = "UPDATE cours SET code = ?, nom = ?, description = ?, volume_horaire = ? WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cours.getCode());
            statement.setString(2, cours.getNom());
            statement.setString(3, cours.getDescription());
            statement.setInt(4, cours.getVolumeHoraire());
            statement.setInt(5, cours.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cours;
    }

    public void delete(Cours cours) {
        String sql = "DELETE FROM cours WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cours.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM cours WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
