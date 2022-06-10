package org.gallery.dao.impl;


import org.gallery.Main;
import org.gallery.dao.TicketDao;
import org.gallery.entities.Tickets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends BasicImpl implements TicketDao {

    private final String COLUMN_ID = "id";
    private final String COLUMN_USERID = "userId";
    private final String COLUMN_EXPOSITIONID = "expositionId";
    private final String COLUMN_PRICE = "price";





    @Override
    public List<Tickets> findAll() {
        String request = "select * from tickets";
        List<Tickets> tickets= new ArrayList<>();

        try{
            ResultSet resultSet = Main.statement.executeQuery(request);
            while(resultSet.next()){
                Tickets ticket = getTicket(resultSet);
                tickets.add(ticket);
                System.out.println(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    private Tickets getTicket(ResultSet resultSet) throws SQLException {
            long id = resultSet.getLong(COLUMN_ID);
            long expoId = resultSet.getLong(COLUMN_EXPOSITIONID);
            long userId = resultSet.getLong(COLUMN_USERID);
            long price = resultSet.getLong(COLUMN_PRICE);

            Tickets ticket = new Tickets();

            ticket.setId(id);
            ticket.setUserId(userId);
            ticket.setExpositionId(expoId);
            ticket.setPrice(price);

            return ticket;


    }

    private int getCount (ResultSet resultSet) throws SQLException{
        int count = resultSet.getInt("COUNT");
        return count;
    }
    @Override
    public Tickets findById(int id) {
        String query = "select * from tickets where id =  " + id;

        Tickets ticket = null;

        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while (resultSet.next()){
                ticket = getTicket(resultSet);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return ticket;
    }

    @Override
    public List<Tickets> findByUserId(int userId) {
        String query = "select * from tickets where userId = " + userId;

        List<Tickets> tickets  = new ArrayList<>();

        try {
            ResultSet resultSet = Main.statement.executeQuery(query);

            while (resultSet.next()){
                Tickets ticket = getTicket(resultSet);
                tickets.add(ticket);
                System.out.print(ticket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public int countByExpositionId(int expositionId) {
        String query = "select count(*) as COUNT from tickets where expositionId = " + expositionId;

        try {
            ResultSet resultSet = Main.statement.executeQuery(query);
            while(resultSet.next()) {
                int count = getCount(resultSet);
                System.out.print(count);
                return count;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
            return 0;
    }

    @Override
    public String delete(int id) {
        String query = "delete from tickets where id = " +id;
        return BasicImpl.delete(query);
    }

    @Override
    public Tickets create(Tickets ticket) throws SQLException {
        String query = "insert into tickets values (?,?,?,?)";


        try {
            PreparedStatement st = Main.conn.prepareStatement(query);

            st.setLong(1, ticket.getId());
            st.setLong(2, ticket.getUserId());
            st.setLong(3, ticket.getExpositionId());
            st.setLong(4, ticket.getPrice());
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ticket;
    }
}
