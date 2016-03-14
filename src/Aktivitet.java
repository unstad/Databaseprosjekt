import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Created by Galina on 14.03.2016.
 */
public class Aktivitet extends ActiveDomainObject{
    private String navn;
    private String beskrivelse;
    private String maal;
    private String resultat;
    private Array muskelgrupper;


    public Aktivitet(String navn, String beskrivelse, String maal,
                     String resultat, Array muskelgrupper){
        this.navn=navn;
        this.beskrivelse=beskrivelse;
        this.maal=maal;
        this.resultat=resultat;
        this.muskelgrupper=muskelgrupper;
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
                muskelgrupper = rs.getArray("muskelgrupper");
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
