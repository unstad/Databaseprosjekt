import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kondisjon extends Resultat{
    public int lengde, puls, avstand, motstand;

    public Kondisjon(int resultatID, int oektID, String aktivitetNavn, int puls, int lengde, int avstand, int motstand) {
        super(resultatID, oektID, aktivitetNavn);
        this.puls = puls;
        this.lengde = lengde;
        this.avstand = avstand;
        this.motstand = motstand;
        this.resultatID = resultatID;
    }

    //init: gjør tabellen tilgjenglig
    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select lengde_tid, puls, avstand, stigning_motstand_terreng" +
                    " from kondisjon where resultatID=" + resultatID);
            while (rs.next()) {
                lengde =  rs.getInt(lengde);
                puls = rs.getInt(puls);
                avstand = rs.getInt(avstand);
                motstand=rs.getInt(motstand)
            }

        } catch (Exception e) {
            System.out.println("db error during select of Kondisjon= "+e);
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
            stmt.executeUpdate("insert into kondisjon values ("+lengde +","+puls +","+avstand+", "+motstand+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Kondisjon="+e);
            return;
        }
    }
}

}
