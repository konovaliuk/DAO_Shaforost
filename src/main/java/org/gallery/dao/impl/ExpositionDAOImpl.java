package org.gallery.dao.impl;

import org.gallery.Main;
import org.gallery.dao.ExpositionsDAO;
import org.gallery.entities.Exposition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpositionDAOImpl extends BasicImpl implements ExpositionsDAO {

    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_DESCRIPTION = "description";
    private final String COLUMN_SHOWROOM = "showroom";

    private Exposition getExposition(ResultSet resultSet) throws SQLException {

        long id = resultSet.getLong(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        String description = resultSet.getString(COLUMN_DESCRIPTION);
        String showroom = resultSet.getString(COLUMN_SHOWROOM);

        Exposition exposition = new Exposition();
        exposition.setId(id);
        exposition.setName(name);
        exposition.setDescription(description);
        exposition.setShowroom(showroom);

        return exposition;
    }

    @Override
    public Exposition findById(int id){
        String request = "select * from expositions where id = " +id;
        Exposition exposition = null;

        try{
            ResultSet resultSet = Main.statement.executeQuery(request);
            while(resultSet.next()){
                exposition = getExposition(resultSet);
                System.out.print(exposition);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exposition;
    }

    @Override
    public List<Exposition> findAll(){
        String request = "select * from expositions";
        List<Exposition> expos= new ArrayList<>();

        try{
            ResultSet resultSet = Main.statement.executeQuery(request);
            while(resultSet.next()){
                Exposition exposition = getExposition(resultSet);
                expos.add(exposition);
                System.out.println(exposition);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expos;
    }
    @Override
    public String update(int id, String field, String value){
        String query  = "update expositions set " + field + "=" + "'"+value +"'"+ " where id = " + id;
        String result = "UPDATE Failed!\n";
        try {
            Main.statement.execute(query);
            result =  "UPDATE successful! \n";
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }
    @Override
    public String delete (int id){
        String query  = "delete from expositions where id = " + id;

        String result = "DELETE Failed!\n";
        try {
            Main.statement.execute(query);
            result =  "DELETE successful! \n";
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;


    }

    @Override
    public Exposition save(Exposition exposition) {
        String query = "insert into expositions values (?,?,?,?)";
        try {
            PreparedStatement st = Main.conn.prepareStatement(query);
            st.setLong(1, exposition.getId());
            st.setString(2, exposition.getName());
            st.setString(3, exposition.getDescription());
            st.setString(4, exposition.getShowroom());
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return exposition;
    }
}



