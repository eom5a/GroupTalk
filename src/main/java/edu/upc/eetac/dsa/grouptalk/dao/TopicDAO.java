package edu.upc.eetac.dsa.grouptalk.dao;

import java.sql.SQLException;

/**
 * Created by Enric on 11/04/2016.
 */
public interface TopicDAO {
    public Topic createTema(String idgrupo, String subject) throws SQLException;
    public Topic getTemaById(String idtema) throws SQLException;
    public boolean deleteTema(String idtema) throws SQLException;
}
