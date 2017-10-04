/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import Items.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajpap
 */
public class DoterraDB extends Database{
    public DoterraDB(String dir)
    {
        super(dir);
    }
    
    private void createItemTable()
    {
        String SQL = "CREATE TABLE IF NOT EXISTS items (\n"
                + "ID text PRIMARY KEY, "
                + "NAME text NOT NULL, "
                + "DESCRIPTION text, "
                + "SIZE textn, "
                + "PRICE real,"
                + "PV real,"
                + "TYPE string);";
        
        runQuery(SQL);
    }
    
    private void createOrderTable()
    {
        String SQL = "CREATE TABLE IF NOT EXISTS orders ("
                + "ID text PRIMARY KEY,"
                + "DATE text NOT NULL);";
        runQuery(SQL);       
    }
    
    private void createContentsTable()
    {
        String SQL = "CREATE TABLE IF NOT EXISTS contents ("
                + "ID text,"
                + "ITEM text"
                + "QUANTITY integer,"
                + "FOREIGN KEY(ID) REFERENCES orders(ID));";
        runQuery(SQL);        
    }
    
    private void createTypeTable()
    {
        String SQL = "CREATE TABLE IF NOT EXISTS types ("
                + "ID text PRIMARY KEY)";
        runQuery(SQL);                
    }
    
    private void createSizeTable()
    {
        String SQL = "CREATE TABLE IF NOT EXISTS sizes ("
                + "ID text,"
                + "SIZE text,"
                + "FOREIGN KEY(ID) REFERENCES types(ID));";
        runQuery(SQL);
    }
        
    public void initialize()
    {
        createTypeTable();
        createItemTable();
        createOrderTable();
        createContentsTable(); 
        createSizeTable();
    }
   
    public void addType(String type)
    {
        String SQL = "INSERT INTO types (ID) VALUES (?)";
                if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, type);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteType(String type)
    {
        String SQL = "DELETE FROM types where ID = ?";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, type);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ResultSet getTypes()
    {
        ResultSet rs = null;
        String SQL = "SELECT * FROM types ORDER BY ID ASC";
        if(conn != null)
        {
            try
            {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }
    
    public void addSize(String type, String size)
    {
        String SQL = "INSERT INTO sizes (ID, SIZE) VALUES (?, ?)";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, type);
                pstmt.setString(2, size);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    public void deleteSize(String type, String size)
    {
        String SQL = "DELETE FROM sizes WHERE ID = ? AND SIZE = ?";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, type);
                pstmt.setString(2, size);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
      public ResultSet getSizes(String type)
    {
        ResultSet rs = null;
        String SQL = "SELECT SIZE FROM sizes WHERE ID = ?";
        if(conn != null)
        {
            try
            {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, type);
            rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }
      
    public void addItem(Item item)
    {
        String SQL = "INSERT INTO items"
                + "(ID, NAME, DESCRIPTION, SIZE, PRICE, PV, TYPE)"
                + "VALUES"
                + "(?, ?, ?, ?, ? , ?, ?);";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, item.getProductID());
                pstmt.setString(2, item.getName());
                pstmt.setString(3, item.getDescription());
                pstmt.setString(4, item.getSize());
                pstmt.setFloat(5, item.getPrice());
                pstmt.setFloat(6, item.getPV());
                pstmt.setString(7, item.getType());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        public void updateItem(Item item)
    {
        String SQL = "UPDATE items SET ID = ?, NAME = ?, DESCRIPTION = ?,"
                + "SIZE = ?, PRICE = ?, PV = ?, TYPE = ? WHERE ID = ?";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, item.getProductID());
                pstmt.setString(2, item.getName());
                pstmt.setString(3, item.getDescription());
                pstmt.setString(4, item.getSize());
                pstmt.setFloat(5, item.getPrice());
                pstmt.setFloat(6, item.getPV());
                pstmt.setString(7, item.getType());
                pstmt.setString(8, item.getProductID());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteItem(Item item)    
    {
        String SQL = "DELETE FROM items WHERE ID = ?";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, item.getProductID());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }     
    
    public void deleteItem(String ID)    
    {
        String SQL = "DELETE FROM items WHERE ID = ?";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, ID);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
    
    public ResultSet getItems(String filter)
    {
        String SQL = "";
        if(filter == "All")
            SQL = "SELECT * FROM ITEMS";
        else
            SQL = "SELECT * FROM ITEMS WHERE TYPE = '" + filter + "'";
        
        ResultSet rs  = null; 
        if(conn != null)
        {
            try
            {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }
    
    public ResultSet findItems(String filter, String searchStr)
    {
        String SQL = "";
        if(filter == "All")
            SQL = "SELECT * FROM ITEMS WHERE ((ID LIKE ?) OR (NAME LIKE ?))";
        else
            SQL = "SELECT * FROM ITEMS WHERE TYPE = ? AND ((ID LIKE ?) OR (NAME LIKE ?))";
        
        ResultSet rs  = null; 
        if(conn != null)
        {
            try
            {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            if(filter == "All")
            {
                pstmt.setString(1, searchStr + "%");
                pstmt.setString(2, searchStr + "%"); 
            }
            else
            {
                pstmt.setString(1, filter);
                pstmt.setString(2, searchStr + "%");
                pstmt.setString(3, searchStr + "%");   
            }
            rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }
    
    public Item getItem(String ID)
    {
        String SQL = "SELECT * FROM ITEMS WHERE ID = ?";
        ResultSet rs  = null; 
        Item item = new Item();
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, ID);
                rs = pstmt.executeQuery();
                if(rs.next())
                {
                    item.setProductID(rs.getString(1));
                    item.setName(rs.getString(2));
                    item.setDescription(rs.getString(3));
                    item.setSize(rs.getString(4));
                    item.setPrice(rs.getFloat(5));
                    item.setPV(rs.getFloat(6));
                    item.setType(rs.getString(7));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return item;
    }
}
