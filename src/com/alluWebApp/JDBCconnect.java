package com.alluWebApp;

import java.sql.*;

public class JDBCconnect {

    public static void main(String[] argv) throws SQLException {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered");

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/alluWebApp", "alluwebapp",
                    "xxxxxx");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (con != null) {
            System.out.println("Connection succeeded");
        } else {
            System.out.println("Failed to make connection!");
        }

        Statement stmt = con.createStatement();
        String sql = "SELECT id,name,address FROM alluWebApp.address WHERE name = 'Allan'";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Name: " + name);
            System.out.print(", Address: " + address);
        }
        rs.close();
    }
}