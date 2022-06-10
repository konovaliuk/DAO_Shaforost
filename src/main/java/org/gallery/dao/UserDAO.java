package org.gallery.dao;

import org.gallery.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    User findById(int id);

    List<User> findAll();

    String update(int id, String field, String value);

    String delete(int id);



    void save(User user) throws SQLException;
}
