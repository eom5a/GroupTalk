package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Enric on 28/03/2016.
 */
public interface AnswerDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_Mensaje = "insert into mensaje (idmensaje, idtema, userid, content) values (UNHEX(?), UNHEX(?), ?, ?)";
    public final static String GET_Mensaje_BY_ID = "select hex(s.idmensaje) as idmensaje, hex(s.idtema) as idtema, hex(s.userid) as userid, s.content, s.last_modified, s.creation_timestamp from mensaje s where s.idmensaje=unhex(?)";
    public final static String UPDATE_Mensaje = "update mensaje set subject=?, content=? where id=unhex(?) ";
    public final static String DELETE_Mensaje = "delete from mensaje where idmensaje=unhex(?)";
}
