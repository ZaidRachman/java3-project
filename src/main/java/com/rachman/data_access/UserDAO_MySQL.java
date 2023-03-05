package com.rachman.data_access;

import com.rachman.ch5.User;
import com.rachman.twilio.SMSOut;
import com.rachman.twilio.Twilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDAO_MySQL implements DAO_MySQL<User> {
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection()) {
            if(connection.isValid(2)) {
                //System.out.println("Connection successful");
                //Step 1: Make a statement (Statement or PreparedStatement)
                Statement statement = connection.createStatement();
                //Step 2: Execute a query (plain SQL or stored procedure) and return the results
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                //Step 3: Get data from the results
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_Name");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    char[] password = resultSet.getString("password").toCharArray();
                    String status = resultSet.getString("status");
                    User user = new User(id, firstName, lastName, email, phone, password, status);
                    users.add(user);


                }
                resultSet.close();
                statement.close();
            }
        } catch(SQLException e) {
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
        }
        return users;

    }
    public int add(User user){
        int numRowsAffected = 0;
        /*
                use Statement when there are no arguments
                    Example: SELECT * FROM USERS;
                use PreparedStatement if there are arguments
                    Example: INSERT INTO users (firstName)
                            VALUES (Zaid)
                 */
        try {
            Connection connection = getConnection();
            if (connection.isValid(2)){
                String sql = "INSERT INTO users (first_name, last_name, email, phone, password, status)"+
                        "VALUES (?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, user.getFirst_name());
                statement.setString(2, user.getLast_name());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPhone());
                statement.setString(5, new String(user.getPassword()));
                statement.setString(6, user.getStatus());
                statement.execute();
                numRowsAffected = statement.getUpdateCount();
                statement.close();
            }
        }catch (SQLException e){
            System.out.println("Add user failed");
            System.out.println(e.getMessage());

        }
        return numRowsAffected;
    }
    public int generate2A(User user){
        Random rg = new Random();
        int code = rg.nextInt(900000) +100000;
        System.out.println(code);
        try{
            Connection connection = getConnection();
            if(connection.isValid(2)){
                String sql = "INSERT INTO 2fa_codes (user_id, code, method) values (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, user.getId());
                statement.setInt(2,code);
                statement.setString(3, "method");
                statement.execute();
                statement.close();


            }
        }
        catch (SQLException e){
            System.out.println("generate2A Failed");
            System.out.println(e.getMessage());
        }
        Twilio twilio = new Twilio();
        twilio.sendTextMessage(user.getPhone(), "Here is your account activation code: " + code);




        return code;

    }
}
