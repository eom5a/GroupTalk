package edu.upc.eetac.dsa.grouptalk.dao;

import java.sql.SQLException;

/**
 * Created by Enric on 11/04/2016.
 */
public interface SuscripcionDAO {
    public boolean getSuscripcionByUsuario(String userid, String grupoid) throws SQLException;
    public boolean createSuscripcion(String userid, String grupoid) throws SQLException;
    public boolean deleteSuscripcion(String userid, String grupoid) throws SQLException;
}
