package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Enric on 11/04/2016.
 */
public class TopicDAOImpl implements TopicDAO {
    @Override
    public Topic createTema(String idgrupo, String subject) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String idtema = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TopicDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                idtema = rs.getString(1);
            else
                throw new SQLException();

            stmt = connection.prepareStatement(TopicDAOQuery.CREATE_TEMA);
            stmt.setString(1, idtema);
            stmt.setString(2, idgrupo);
            stmt.setString(3, subject);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return getTemaById(idtema);
    }

    @Override
    public Topic getTemaById(String idtema) throws SQLException {
        Topic tema= null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TopicDAOQuery.GET_TEMA_BY_ID);
            stmt.setString(1, idtema);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tema = new Topic();
                tema.setIdtema(rs.getString("idtema"));
                tema.setIdgrupo(rs.getString("idgrupo"));
                tema.setSubject(rs.getString("subject"));
                tema.setLastModified(rs.getTimestamp("last_modified").getTime());
                tema.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return tema;
    }


    @Override
    public boolean deleteTema(String idtema) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TopicDAOQuery.DELETE_TEMA);
            stmt.setString(1, idtema);

            int rows = stmt.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
}
