package com.example.lab7_8.model.dao;

import com.example.lab7_8.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO {
    public static int getUsers_count() {
        return users_count;
    }

    public static void setUsers_count(int users_count) {
        UserDAO.users_count = users_count;
    }

    private static int users_count;
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaMVC";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "persik15";
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Class Postgresql Driver not found");
        }
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Wrong URl, NAME or PASSWORD");
        }
    }
    private static List < User > users = new ArrayList < > ();
    public UserDAO() {

    }

    public List < User > index() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM usermvc";
            ResultSet set = statement.executeQuery(query);

            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setName(set.getString("name"));
                user.setPassword(set.getString("password"));
                boolean found = false;
                Iterator var6 = this.users.iterator();

                while (true) {
                    if (var6.hasNext()) {
                        User slot = (User) var6.next();
                        if (slot.getId() != set.getInt("id")) {
                            continue;
                        }

                        found = true;
                    }

                    if (!found) {
                        this.users.add(user);
                    }
                    break;
                }
            }
        } catch (SQLException var8) {
            System.err.println("SQL query SELECT not run");
        }

        return this.users;
    }
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void save(User user) {
        try {
            Statement statement = connection.createStatement();
            String var10000 = user.getName();
            String SQL = "INSERT INTO usermvc(id, name, email, password) VALUES (" +
                    user.getId() + ", '" +
                    user.getName() + "', '" +
                    user.getEmail() + "', " +
                    user.getPassword() + ")";
            System.out.println(SQL);
            statement.executeUpdate(SQL);
        } catch (SQLException var4) {
            System.err.println("SQL query INSRT not run");
        }

    }

    public void update(int id, User user) {
    /*
    User tmp = this.show(id);
    tmp.setName(user.getName());
    tmp.setPassword(user.getPassword());
    tmp.setEmail(user.getEmail());
    System.out.println(id)
     */
    }

    public void delete(int id) {
        this.users.removeIf((user) -> {
            return user.getId() == id;
        });

        try {
            Statement statement = connection.createStatement();
            String SQL = "DELETE FROM usermvc WHERE id=" + id;
            statement.executeUpdate(SQL);
        } catch (SQLException var4) {
            System.err.println("SQL query DELETE not run");
        }

    }

}