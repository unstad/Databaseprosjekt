import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Array.*;

public class Aktivitet extends ActiveDomainObject{
    public String navn;
    public String beskrivelse;
    public String maal;
    public String resultat;
    public Array muskelgrupper;


    public Aktivitet(String navn, String beskrivelse, String maal,
                     String resultat, ArrayList muskelgrupper){
        this.navn=navn;
        this.beskrivelse=beskrivelse;
        this.maal=maal;
        this.resultat=resultat;
        this.muskelgrupper= (Array) muskelgrupper;
    }

    //init: gjør tabellen tilgjenglig
    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select navn, beskrivelse, Mål, resultat, muskelgrupper," +
                    " from aktivitet where navn=" + navn);
            while (rs.next()) {
                navn =  rs.getString("navn");
                beskrivelse = rs.getString("beskrivelse");
                maal = rs.getString("Mål");
                resultat = rs.getString("resultat");
                muskelgrupper = rs.getArrayList("muskelgrupper"); // må modifisere i databasen, noe annen grunn til at han klager?
            }

        } catch (Exception e) {
            System.out.println("db error during select of aktivitet= "+e);
            return;
        }

    }

    @Override
    public void refresh (Connection conn) {
        initialize (conn);
    }

    @Override
    public void save (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into treningsøkt values ("+navn +","+beskrivelse +","+maal+","+resultat+","
                    +muskelgrupper+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Aktivitet="+e);
            return;
        }
    }
}
