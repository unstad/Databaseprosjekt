import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Styrkeoevelse extends Resultat{
    public int belastning, repitisjoner, sett, resultatID;

    public Styrkeoevelse(int resultatID, int oektID, String aktivitetNavn, int repitisjoner, int belastning, int sett, int resultatID1) {
        super(resultatID, oektID, aktivitetNavn);
        this.repitisjoner = repitisjoner;
        this.belastning = belastning;
        this.sett = sett;
    }

    //init: gjør tabellen tilgjenglig
    // Hvordan arve nøkkel??
    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select belastning, repitisjoner, sett" +
                    " from styrkeøvelse where resultatID=" + resultatID);
            while (rs.next()) {
                belastning =  rs.getInt(belastning);
                repitisjoner = rs.getInt(repitisjoner);
                sett = rs.getInt(sett);
            }

        } catch (Exception e) {
            System.out.println("db error during select of Styrkeoevelse= "+e);
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
            stmt.executeUpdate("insert into styrkeøvelse values ("+belastning +","+repitisjoner +","+sett+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Styrkeoevelse="+e);
            return;
        }
    }
}

