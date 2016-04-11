package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Enric on 28/03/2016.
 */
public class AnswerDAOImpl implements AnswerDAO {
    @Override
    public Answer createAnswer(String creator, String content) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String idmensaje = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(AnswerDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                idmensaje = rs.getString(1);
            else
                throw new SQLException();

            stmt = connection.prepareStatement(AnswerDAOQuery.CREATE_Mensaje);
            stmt.setString(1, idmensaje);
            stmt.setString(2, idtema);
            stmt.setString(3, userid);
            stmt.setString(4, content);
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
        return getAnswerById(idmensaje);
    }

    @Override
    public Answer getAnswerById(String id) throws SQLException {
        Answer Mensaje = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(AnswerDAOQuery.GET_Mensaje_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Mensaje = new Mensaje();
                Mensaje.setIdmensaje(rs.getString("idmensaje"));
                Mensaje.setIdtema(rs.getString("idtema"));
                Mensaje.setUserid(rs.getString("userid"));
                Mensaje.setContent(rs.getString("content"));
                Mensaje.setLastModified(rs.getTimestamp("last_modified").getTime());
                Mensaje.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return Mensaje;
    }

    @Override
    public Answer updateAnswer(String id, String creator, String content) throws SQLException {
        Answer Mensaje = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(AnswerDAOQuery.UPDATE_Mensaje);
            stmt.setString(1, subject);
            stmt.setString(2, content);
            stmt.setString(3, id);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                Mensaje = getAnswerById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return Mensaje;
    }

    @Override
    public boolean deleteAnswer() throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();f

            stmt = connection.prepareStatement(AnswerDAOQuery.DELETE_Mensaje);
            stmt.setString(1, id);

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
