import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Resultat extends ActiveDomainObject{
    public int resultatID, oektID;
    public String aktivitetNavn;

    public Resultat(int resultatID, int oektID, String aktivitetNavn){
        this.resultatID=resultatID;
        this.oektID=oektID;
        this.aktivitetNavn=aktivitetNavn;
    }
    //init: gjør tabellen tilgjenglig
    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select resultatID, øktID, aktivitetNavn" +
                    " from resultat where resultatID=" + resultatID);
            while (rs.next()) {
                resultatID =  rs.getInt(resultatID);
                oektID = rs.getInt(oektID);
                aktivitetNavn = rs.getString("aktivitetNavn");
            }

        } catch (Exception e) {
            System.out.println("db error during select of Reasultat= "+e);
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
            stmt.executeUpdate("insert into resultat values ("+resultatID +","+oektID +","+aktivitetNavn+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Resultat="+e);
            return;
        }
    }
}
