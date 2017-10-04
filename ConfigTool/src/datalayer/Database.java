/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datalayer;

import Items.Item;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Database {
    protected String dbName = "";
    protected String connStr = "";
    protected Connection conn = null;
    
    public Database(String dir)
    {
        dbName = dir;
        connStr = "jdbc:sqlite:" + dbName;
    }
    
    public Database()
    {
        dbName = "\\data\\database.db";
        connStr = "jdbc:sqlite:" + dbName;
    }
    
    public void open()
    {
        if((conn == null) && (connStr != ""))
        {
            try
            {
                conn = DriverManager.getConnection(connStr);
            } 
            catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void close()
    {
        if(conn != null)
        {
            try
            {
                conn.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    protected void runQuery(String SQL)
    {
        if(conn != null)
        {
            try
            {
            Statement stmt = conn.createStatement();
            stmt.execute(SQL);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    

    
}
