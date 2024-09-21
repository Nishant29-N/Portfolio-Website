/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.lang.*;
import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author nisha
 */
public class CategoryDao {
    
    public static void save(Category category){
        String query =  "insert into category (Name) values('"+category.getName()+"')";
        DbOperations.setDataOrDelete(query, "Category Added Successfully");
    }
    
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from category");
            while(rs.next())
            {
                Category  category = new Category();
                category.setID(rs.getInt("ID"));
                category.setName(rs.getString("Name"));
                arrayList.add(category);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    } 
    public static void delete(String ID){
        String query = "delete from category where ID = '"+ID+"'";
        DbOperations.setDataOrDelete(query, "Category Deleted ");
    }
}