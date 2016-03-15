import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Styrkeoevelse extends Resultat{
    private int belastning, repitisjoner, sett, resultatID;

    public Styrkeoevelse(int belastning, int repitisjoner, int sett, int resultatID){
        this.belastning=belastning;
        this.repitisjoner=repitisjoner;
        this.sett=sett;
        this.resultatID=resultatID;
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

