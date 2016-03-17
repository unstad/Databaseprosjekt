import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.sqlj.runtime.*;
import java.util.Scanner;

import sqlj.runtime.ref.*;
import oracle.sqlj.runtime.*;

/**
 * Created by Galina on 17.03.2016.
 */
public class HentUtAktivitet extends ActiveDomainObject{

    String anavn, abeskrivelse, amaal, aresultat;
    ArrayList amuskelgrupper;
    Scanner scan = new Scanner(System.in);


   // public static DefaultContext{
    //    Connection conn = DriverManager.getConnection("com.mysql.jdbc.Driver", "root", "datdat")
     //   throws SQLException;
    //}

    //Ser på eksempel i boka som skal være skrevet i java, men får masse feil??

    public String hentAktivitet(){

    }

    @Override
    public void initialize(Connection conn) {
        System.out.println("Hvilken aktivitet vil du hente ut? ");
        anavn = scan.nextLine();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select navn, beskrivelse, Mål, resultat, muskelgrupper," +
                    " from aktivitet where navn=" + anavn);
            while (rs.next()) {
                anavn = rs.getString("navn");
                abeskrivelse = rs.getString("beskrivelse");
                amaal = rs.getString("Mål");
                aresultat = rs.getString("resultat");
                amuskelgrupper = rs.getArrayList("muskelgrupper"); // må modifisere i databasen, noe annen grunn til at han klager?
            }
        }
        catch (SQLException se){
            System.out.println("aktiviteten eksisterer ikke: " + anavn);
        }
        System.out.println(anavn + " " + abeskrivelse + " " +
                amaal + " " + aresultat + " " + amuskelgrupper);
    }

    @Override
    public void refresh(Connection conn) {

    }

    @Override
    public void save(Connection conn) {

    }
}
