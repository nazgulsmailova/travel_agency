package com.epam.smailova.travel.transfer;

import java.sql.*;

public class SingletonEngine {
    private static SingletonEngine instance = null;
    private Connection connectionTo;
    private Connection connectionFrom;

    public synchronized static SingletonEngine getInstance() {
        if (instance == null) {
            instance = new SingletonEngine();
            instance.getConnectionTo();
            instance.getConnectionFrom();
        }
        return instance;
    }

    private Connection getConnectionFrom() {
        try {
            connectionFrom = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travel", "root", "root");
            connectionFrom.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage()
                    + "SQLState: " + e.getSQLState());
        }
        return connectionFrom;
    }

    private Connection getConnectionTo() {
        final String connectToAdress = "jdbc:mysql://localhost:3306/travel";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectionTo = DriverManager.getConnection(
                    connectToAdress, "root", "root");
            connectionTo.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage()
                    + "SQLState: " + e.getSQLState());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }
        return connectionTo;
    }

    public void transfer(String summa) throws SQLException {
        Statement stFrom = null;
        Statement stTo = null;
        try {
            int sum = Integer.parseInt(summa);
            if (sum <= 0) {
                throw new NumberFormatException("less or equals zero");
            }
            stFrom = connectionFrom.createStatement();
            stTo = connectionTo.createStatement();
// transaction of 4 queries
            ResultSet rsFrom =
                    stFrom.executeQuery("SELECT amount from account");
            ResultSet rsTo =
                    stTo.executeQuery("SELECT amount from tour_order");
            int accountFrom = 0;
            while (rsFrom.next()) {
                accountFrom = rsFrom.getInt(1);
            }
            int resultFrom = 0;
            if (accountFrom >= sum) {
                resultFrom = accountFrom - sum;
            } else {
                throw new SQLException("Invalid balance");
            }
            int accountTo = 0;
            while (rsTo.next()) {
                accountTo = rsTo.getInt(1);
            }
            int resultTo = accountTo + sum;
            stFrom.executeUpdate(
                    "UPDATE account SET balance=" + resultFrom);
            stTo.executeUpdate("UPDATE tour_order SET balance=" + resultTo);
// transaction's finish
            connectionFrom.commit();
            connectionTo.commit();
            System.out.println("remaining on :" + resultFrom + " rub");
        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState()
                    + "Error Message: " + e.getMessage());
            // rollback transaction
            connectionFrom.rollback();
            connectionTo.rollback();
        } catch (NumberFormatException e) {
            System.err.println("Invalid summa: " + summa);
        } finally {
            if (stFrom != null) {
                try {
                    stFrom.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (stTo != null) {
                try {
                    stTo.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}


