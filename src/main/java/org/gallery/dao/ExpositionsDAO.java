package org.gallery.dao;

import org.gallery.entities.Exposition;

import java.sql.SQLException;
import java.util.List;

public interface ExpositionsDAO {

    Exposition findById(int id)throws SQLException;
    List<Exposition> findAll()throws SQLException;
    String update (int id, String field, String value);
    String delete (int id);


    Exposition save(Exposition exposition) throws SQLException;
}
