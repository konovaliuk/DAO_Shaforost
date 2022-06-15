package org.gallery;


import org.gallery.dao.impl.ExpositionDAOImpl;
import org.gallery.dao.impl.TicketDaoImpl;
import org.gallery.dao.impl.UserDAOImpl;
import org.gallery.entities.Exposition;
import org.gallery.entities.Tickets;
import org.gallery.entities.User;

import java.lang.management.ThreadInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    private final String url = "jdbc:postgresql://localhost:5432/gallery";
    private final String user = "postgres";
    private final String password = "postgres";
    public static Connection conn = null;
    public static Statement statement = null;

    public void  connect() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();

            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) throws SQLException {

        Main app = new Main();
        app.connect();

//------------User DAO Demonstration-------------------//
//       UserDAOImpl UserDao = new UserDAOImpl();
//
//       UserDao.save(new User(1, "Chris", "Doe", "chris@gmail.com", "testtest"));
//       UserDao.save(new User(2, "Amy", "Trump", "amy@gmail.com", "testtest"));

//        System.out.println(UserDao.findById(1).getFirstName() );
//        UserDao.findAll();
//        System.out.println("\n"+UserDao.update(1, "first_name", "cara"));
//        System.out.println("\n"+UserDao.delete(1));
//        System.out.print("\n"+UserDao.delete(2));

        //------------------Exposition DAO Demo------------------

//
//
//        ExpositionDAOImpl ExpositionDao = new ExpositionDAOImpl();
//
//        System.out.print ("Create first exposition: " + ExpositionDao.save(new Exposition(1, "test", "description", "showroom")));
//        System.out.print ("\nCreate second exposition: " + ExpositionDao.save(new Exposition(2, "test2", "description2", "showroom2")));
//        ExpositionDao.findAll();
//        ExpositionDao.findById(1);
//        System.out.print( ExpositionDao.update(1, "description", "new description"));
//        System.out.print(ExpositionDao.delete(1));
//        System.out.print(ExpositionDao.delete(2));
//




//------------Ticket DAO Demonstration-------------------//

        TicketDaoImpl TicketDao = new TicketDaoImpl();
//
//        System.out.print("Create first Ticket: " + TicketDao.create(new Tickets(1, 1, 1, 100)));
//        System.out.print("\nCreate second ticket: " + TicketDao.create(new Tickets(2, 2, 2, 100)));

//        TicketDao.findAll();
//
//        int count = TicketDao.countByExpositionId(1);
//        System.out.print("Numbet of tickets for a given Exposition: " + count + "\n");
//          TicketDao.findById(1);


//          TicketDao.findByUserId(2);
//        TicketDao.delete(1);
//        TicketDao.delete(2);


    }


}