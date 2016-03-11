/**
 * Created by k_unstad on 11.03.2016.
 */

import java.io.*;
import java.sql.*;

public class anerIkkeHvaJegSkalKalleDenne {

    //Laster JDBC driver, men vet enda ikke hvor vi får driveren
    // fra(dette er bare en eksempelfil)
    public static void main (String args []) throws SQLException, IOException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException x){
            System.out.println("Driver could not be loaded");
        }
    }

}
