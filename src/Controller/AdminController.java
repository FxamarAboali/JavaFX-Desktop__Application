/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.User;
import Utils.DataBase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AdminController {
    
      Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public AdminController() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    
       boolean isUserValid(User user) {
        return !(user.getPseudoName().length() < 2 || user.getUserCin().length() != 8 || user.getUserName().isEmpty() || user.getUserPassword().length() < 8);
    }

    public boolean addUser(User user) {

        String sqlinsert =  "INSERT INTO `user` ( username,username_canonical,email,email_canonical,enabled,password,roles,name,lastname,user_mail,user_password,user_phone,user_address,user_photo,user_cin,"
                            + "user_day_birth,user_site,nationality,speciality,bio) VALUES (?, ?, ?, ?, ?,?,?, ?, ?, ?, ?,?,?, ?, ?, ?, ?,?,?,?,?)";
        if (!isUserValid(user)) {
            return false;
        } else {
            try {
                preparedStatement = connection.prepareStatement(sqlinsert);
                
                
                  preparedStatement.setString(1, user.getUsername());
                    preparedStatement.setString(2, user.getUsername());
                    
                    preparedStatement.setString(3, user.getEmail());
                    preparedStatement.setString(4, user.getEmailCanonical());
                    preparedStatement.setString(5, "1");
                    preparedStatement.setString(6, user.getPassword());
                    preparedStatement.setString(7, user.getRoles());
                    preparedStatement.setString(8, user.getUsername());
                    preparedStatement.setString(9, "");
                    preparedStatement.setString(10, user.getEmail());
                    preparedStatement.setString(11, user.getPassword());
                    preparedStatement.setString(12, user.getUserPhone());
                    preparedStatement.setString(13, user.getUserAddress());
                    preparedStatement.setString(14,user.getUserCin() );
                  
                    preparedStatement.setString(15, user.getUserPhoto());
                    preparedStatement.setString(16, user.getUserCin());
                    preparedStatement.setDate(17, user.getUserDayOfBirth());
                    preparedStatement.setString(18, user.getUserSite());
                    preparedStatement.setString(19, user.getNationality());
                    preparedStatement.setString(20, user.getSpeciality());
                    preparedStatement.setString(21, user.getBio());

                preparedStatement.executeUpdate();

                preparedStatement.close();
            } catch (SQLException ex) {

                return false;

            }
        }
        return true;

    }

    public boolean updateUser(User user) throws SQLException {

        String query = "UPDATE"
                + "    `user`"
                + "SET"
                + "    `username` = ?,"
                + "    `pseudoName` = ?,"
                + "    `userMail` = ?,"
                + "    `userPassword` = ?,"
                + "    `userPhone` = ?,"
                + "    `userAddress` = ?,"
                + "    `userPhoto` = ?,"
                + "    `userCin` = ?,"
                + "    `userDay-of-birth` =?,"
                + "    `userSite` = ?,"
                + "    `nationality` = ?,"
                + "    `speciality` = ?,"
                + "    `bio` = ?, "
                + "    `roles`= ? "
                + "WHERE"
                + "    id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPseudoName());
        preparedStatement.setString(3, user.getUserMail());
        preparedStatement.setString(4, user.getUserPassword());
        preparedStatement.setString(5, user.getUserPhone());
        preparedStatement.setString(6, user.getUserAddress());
        preparedStatement.setString(7, user.getUserPhoto());
        preparedStatement.setString(8, user.getUserCin());

        preparedStatement.setDate(9, user.getUserDayOfBirth());
        preparedStatement.setString(10, user.getUserSite());
        preparedStatement.setString(11, user.getNationality());
        preparedStatement.setString(12, user.getSpeciality());
        preparedStatement.setString(13, user.getBio());
        preparedStatement.setString(14, user.getUserPhoto());
        preparedStatement.setInt(15, user.getId());

        boolean result = preparedStatement.execute();
        preparedStatement.close();

        return true;
    }

    public boolean updateUserEmail(int userId, String email) throws SQLException {

        String query = "update user set email = ?, where id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setInt(2, userId);

        int result = preparedStatement.executeUpdate();
        preparedStatement.close();

        if (result < 1) {
            return false;
        }
        return true;
    }

    public boolean updateUserPassword(int userId, String userPassword) throws SQLException {

        String query = "update user set password = ? where id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userPassword);
        preparedStatement.setInt(2, userId);

        int result = preparedStatement.executeUpdate();
        preparedStatement.close();

        if (result < 1) {
            return false;
        }
        return true;
    }

    public boolean updateUserName(int userId, String userName) throws SQLException {

        String query = "update user set username = ?, where id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, userId);

        int result = preparedStatement.executeUpdate();
        preparedStatement.close();

        if (result < 1) {
            return false;
        }
        return true;
    }

    public boolean deleteUser(String userMail) {
System.out.println(userMail);
        try {
  Statement st = connection.createStatement();
  String sql = "DELETE FROM user WHERE email = ? ";
              PreparedStatement statement = connection.prepareStatement(sql);

          
            statement.setString(1, userMail.toString());

            int rows = statement.executeUpdate();

   st.executeUpdate(sql);
  st.close();
        } catch (SQLException ex) {

            return false;

        }
        return true;

    }

    public ArrayList getAllUser() throws SQLException {
        ArrayList<User> userlist = new ArrayList<User>();

        String query = "SELECT * FROM user";
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
             User user = new User();
            user.setId(res.getInt("id"));
            System.out.println(user.getId());
            user.setUserName(res.getString("username"));
            user.setUserMail(res.getString("email"));
            user.setUserPhone(res.getString("user_phone"));
            user.setUserAddress(res.getString("user_address"));

            user.setUserPhoto(res.getString("user_photo"));
            user.setUserCin(res.getString("user_cin"));
            user.setUserDayOfBirth(res.getDate("user_day_birth"));
            user.setUserSite(res.getString("user_site"));
            user.setNationality(res.getString("nationality"));
            user.setSpeciality(res.getString("speciality"));
            user.setBio(res.getString("bio"));
            user.setRoles(res.getString("roles"));

            userlist.add(user);

            userlist.add(user);
        }
        return userlist;
    }

    public ArrayList getUsersbyRole(String role) throws SQLException {
        ArrayList<User> userlist = new ArrayList<User>();

        String query = "SELECT * FROM user where roles = ? ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, role);

        ResultSet res = preparedStatement.executeQuery();
        while (res.next()) {
            User user = new User();
            user.setId(res.getInt("id"));
            System.out.println(user.getId());
            user.setUserName(res.getString("username"));
            user.setUserMail(res.getString("email"));
            user.setUserPhone(res.getString("user_phone"));
            user.setUserAddress(res.getString("user_address"));

            user.setUserPhoto(res.getString("user_photo"));
            user.setUserCin(res.getString("user_cin"));
            user.setUserDayOfBirth(res.getDate("user_day_birth"));
            user.setUserSite(res.getString("user_site"));
            user.setNationality(res.getString("nationality"));
            user.setSpeciality(res.getString("speciality"));
            user.setBio(res.getString("bio"));
            user.setRoles(res.getString("roles"));

            userlist.add(user);
        }
        return userlist;
    }

    public Integer getNumberOfUser(String role) throws SQLException {
        int count = 0;
        String query = "SELECT count(*) as total FROM user where roles =  ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, role);
        ResultSet res = preparedStatement.executeQuery();
        while (res.next()) {
            count = res.getInt("total");
        }

        return count;
    }

    public User getUserByEmail(String email) throws SQLException {

        String query = "SELECT * FROM user where email =  ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet res = preparedStatement.executeQuery();
        while (res.next()) {
            User user = new User();

            user.setId(res.getInt("id"));
            user.setUserName(res.getString("username"));
            user.setUsernameCanonical(res.getString("username_canonical"));
            user.setEmail(res.getString("email"));
            user.setEmailCanonical(res.getString("email_canonical"));
            user.setEnabled(res.getInt("enabled"));
            user.setPassword(res.getString("password"));
            user.setRoles(res.getString("roles"));
            user.setUserMail(res.getString("user_mail"));
            user.setUserAddress(res.getString("user_phone"));
            user.setUserAddress(res.getString("user_address"));
            user.setUserPhone(res.getString("user_phone"));
            user.setUserPassword(res.getString("user_password"));
            user.setUserPhoto(res.getString("user_photo"));
            user.setUserCin(res.getString("user_cin"));
            user.setUserDayOfBirth(res.getDate("user_day_birth"));
            user.setUserSite(res.getString("user_site"));
            user.setNationality(res.getString("nationality"));
            user.setSpeciality(res.getString("speciality"));
            user.setBio(res.getString("bio"));
            user.setRoles(res.getString("roles"));

            return user;
        }
        return null;
    }
   
    
}
