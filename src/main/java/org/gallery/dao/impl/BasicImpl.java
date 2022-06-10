package org.gallery.dao.impl;

import org.gallery.Main;

import java.sql.SQLException;

public class BasicImpl  {

    static String update(String query){
        String result = "UPDATE Failed!\n";
        try {
            Main.statement.execute(query);
            result =  "UPDATE successful! \n";
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    static String delete(String query){
        String result = "DELETE Failed!\n";
        try {
            Main.statement.execute(query);
            result =  "DELETE successful! \n";
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;

    }
}
