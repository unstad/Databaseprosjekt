import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Galina on 14.03.2016.
 */
public class Kondisjon extends Resultat{
    private int lengde, puls, avstand, motstand;

    public Kondisjon(int lengde,int puls, int avstand, int motstand){
        this.lengde=lengde;
        this.puls=puls;
        this.avstand=avstand;
        this.motstand=motstand;
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
