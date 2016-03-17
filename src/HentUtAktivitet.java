import java.util.ArrayList;
import java.sql.*;
import java.io.*;
import sqlj.runtime.*;
import sqlj.runtime.ref.*;
import oracle.sqlj.runtime.*;

/**
 * Created by Galina on 17.03.2016.
 */
public class HentUtAktivitet extends DBConn{

    String anavn, abeskrivelse, amaal, aresultat;
    ArrayList amuskelgrupper;

    public String hentAktivitet{
        anavn = readEntry("Hvilken aktivitet vil du hente ut? ");
        try {
            #sql {select navn, beskrivelse, Mål, resultat, muskelgrupper
                    into :anavn, :abeskrivelse, :amaal, :aresultat, :amuskelgrupper
                        from aktivitet where navn=:anavn};
        }
        catch (SQLException se){
            System.out.println("aktiviteten eksisterer ikke: " + anavn);
        }
        System.out.println(anavn + " " + abeskrivelse + " " +
                amaal + " " + aresultat + " " + amuskelgrupper);
    }
}
