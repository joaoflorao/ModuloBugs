/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulobugs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joaoflorao
 */
public class ConnectDB {
    private String url;
    private String username;
    private String password;
    private Connection conn;
    
    public ConnectDB() throws SQLException, SQLException, SQLException{
        this.url = "jdbc:mysql://localhost/DBCode?useUnicode=true&characterEncoding=UTF8";
        this.username = "root";
        this.password = "dombo$co20";
    }
    
    public Connection getConnection() throws SQLException{
        this.conn = DriverManager.getConnection(
                this.url, 
                this.username, 
                this.password);
        return this.conn;
    }
}
