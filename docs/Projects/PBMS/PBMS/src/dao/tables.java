/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author nisha
 */
public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table users(id int AUTO_INCREMENT primary key, UName varchar(200), EmailId varchar(200), MobileNo varchar(200), address varchar(200), passwrod varchar(200), securityQues varchar(200), ans varchar(200), status varchar(20), UNIQUE(EmailId))";
            String adminDetails = "insert into users(UName, Emailid, MobileNo, address, password, securityQues, ans, status) values('Admin', 'admin@gmail.com', '9988776655', 'India', '12345', 'What primary school did you attend?', 'ABC', 'true')";
            String categoryTable = "create table category(ID int AUTO_INCREMENT primary key, Name varchar(200))"; 
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200), price varchar(200))";
            String billTable = "create table bill(id int primary key, name varchar(200), mobileNumber varchar(200), email varchar(200), date varchar(50), total varchar(200), createdBy varchar(200))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
            DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully!!");
            DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully!!");
            DbOperations.setDataOrDelete(billTable, "Bill Table Created Successfully!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
