package org.gallery.dao;

import org.gallery.entities.Tickets;

import java.sql.SQLException;
import java.util.List;

public interface TicketDao {


    List<Tickets> findAll();
    Tickets findById(int id);
    List<Tickets> findByUserId(int userId);
    int  countByExpositionId (int expositionId);

    String delete(int id);

    Tickets create(Tickets ticket) throws SQLException;
}
