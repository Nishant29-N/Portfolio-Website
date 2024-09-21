/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author nisha
 */
public class UserDao {

    public static void save(User user) {
        String query = "insert into users(UName, EmailId, MobileNo, address, password, securityQues, ans, status) values('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getMobileNumber() + "', '" + user.getAddress() + "', '" + user.getPassword() + "', '" + user.getSecurityQuestion() + "', '" + user.getAnswer() + "', 'false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully!! Wait for Admin Approval!!");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select * from users where EmailId = '" + email + "' and password = '" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static User getsecurityQues(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select * from users where EmailId = '" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQues"));
                user.setAnswer(rs.getString("ans"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "update users set password = '" +newPassword+"' where EmailId ='" + email + "'";
        DbOperations.setDataOrDelete(query, "Password Changed Successfully!!");
    }
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from users where EmailId like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("UName"));
                user.setEmail(rs.getString("EmailId"));
                user.setMobileNumber(rs.getString("MobileNo"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQues"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void changeStatus(String email, String status){
        String query = "update users set status = '"+status+"' where EmailId = '"+email+"'";
        DbOperations.setDataOrDelete(query, "Status Changed Successfully");
    }
}
