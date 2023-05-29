package com.example.mother_pls_help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"+
                dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser,dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = " INSERT INTO " + Const.USER_TABLE + " ( " +
                Const.USERS_FIRSTNAME + " , " + Const.USERS_LASTNAME + " , " +
                Const.USERS_MIDDLENAME + " , " + Const.USERS_NICKNAME +
                " , " + Const.USERS_EMAIL + " , " + Const.USERS_PASSWORD + " , " +
                Const.USERS_CODEWORD + " , " + Const.USERS_BIRTH + " ) " +
                " VALUES(?,?,?,?,?,?,?,?) ";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirst_name());
            prSt.setString(2, user.getLast_name());
            prSt.setString(3, user.getMiddle_name());
            prSt.setString(4, user.getNickname());
            prSt.setString(5, user.getEmail());
            prSt.setString(6, user.getPassword());
            prSt.setString(7, user.getCodeword());
            prSt.setString(8, user.getDate_birth());

            prSt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public ResultSet getUser(User user) {
            ResultSet resSet = null;

            String select = " SELECT * FROM " + Const.USER_TABLE + " WHERE "+
                    Const.USERS_NICKNAME + " =? AND "+ Const.USERS_PASSWORD + " =? OR "
                    + Const.USERS_CODEWORD + " =? ";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1,user.getNickname());
                prSt.setString(2,user.getPassword());
                prSt.setString(3,user.getCodeword());

                resSet = prSt.executeQuery();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return resSet;
        }

    }


