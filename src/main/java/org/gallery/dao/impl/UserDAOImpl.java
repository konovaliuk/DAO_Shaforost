package org.gallery.dao.impl;

import org.gallery.Main;
import org.gallery.dao.UserDAO;
import org.gallery.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl  implements UserDAO {

    private final String COLUMN_ID = "id";
    private final String COLUMN_first_name = "first_name";
    private final String COLUMN_last_name = "last_name";
    private final String COLUMN_email = "email";
    private final String COLUMN_password = "password";





    private User getUser(ResultSet resultSet) throws SQLException{
        Long id = resultSet.getLong(COLUMN_ID);
        String firstName = resultSet.getString(COLUMN_first_name);
        String lastName = resultSet.getString(COLUMN_last_name);
        String email = resultSet.getString(COLUMN_email);
        String password = resultSet.getString(COLUMN_password);

        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setId(id);
        user.setPassword(password);
        user.setLastName(lastName);

        return user;
    }

    @Override
    public User findById(int id) {
        String request = "select * from users where id = " + id;

        User user = null;
        try {
            ResultSet resultSet = Main.statement.executeQuery(request);
            while (resultSet.next()) {
                user = getUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }
    @Override
    public List<User> findAll(){
        List<User> users = new ArrayList<>();

        try {
            ResultSet resultSet = Main.statement.executeQuery("select * from users");
            while (resultSet.next()) {
                User user = getUser(resultSet);
                users.add(user);
                System.out.print (user);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }
    @Override

    public String update(int id, String field, String value){
        String query  = "update users set " + field + "=" + "'"+value +"'"+ " where id = " + id;

        String update = BasicImpl.update(query);
        return update;

    }

    @Override

    public String delete (int id){
        String query  = "delete from users where id = " + id;

        return BasicImpl.delete(query);

    }

    @Override

    public void save(User user) throws SQLException{
       String query = "insert into users values (?,?,?,?,?)";

       try {
           PreparedStatement st = Main.conn.prepareStatement(query);
           st.setLong(1, user.getId());
           st.setString(2, user.getFirstName());
           st.setString(3,user.getLastName());
           st.setString(4, user.getEmail());
           st.setString(5, user.getPassword());
            st.executeUpdate();
       } catch (SQLException e){
           e.printStackTrace();
       }
    }

}


