package org.gallery;


import org.gallery.dao.impl.TicketDaoImpl;
import org.gallery.dao.impl.UserDAOImpl;
import org.gallery.entities.Tickets;

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
//        System.out.println(UserDao.findById(1).getFirstName() );
//         UserDao.findAll();
//         System.out.println("\n"+UserDao.update(1, "first_name", "cara"));
//        System.out.println("\n"+UserDao.delete(1));

//----------------------------------------------------//


        TicketDaoImpl TicketDao = new TicketDaoImpl();
        TicketDao.countByExpositionId(1);
        System.out.print(TicketDao.create(new Tickets(1,1,1,100)));
    }
}