/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ~FakeFaker~
 */
public class ConnectionClass {
    public Connection connection;
    public Connection getConnection(){
        String dbname = "Restaurant";
        String username ="root";
        String password ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname+username+password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection ;
    }
}
