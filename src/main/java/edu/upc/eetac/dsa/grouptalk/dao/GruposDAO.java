package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Enric on 11/04/2016.
 */
public interface GruposDAO {
    public Grupos getGrupo(String idgrupo) throws SQLException;
    public Grupos createGrupo(String fullname) throws SQLException;
    public boolean deleteGrupo(String idgrupo) throws  SQLException;
}
