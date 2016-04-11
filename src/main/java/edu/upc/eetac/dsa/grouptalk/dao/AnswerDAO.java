package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Answer;

import java.sql.SQLException;

/**
 * Created by Enric on 28/03/2016.
 */
public interface AnswerDAO {
    public Answer createAnswer(String creator, String content) throws SQLException;
    public Answer getAnswerById(String id) throws SQLException;
    public Answer updateAnswer(String id, String creator, String content) throws SQLException;
    public boolean deleteAnswer() throws SQLException;
}
