import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Langkjoering extends Kondisjon {

    public int fart;

    public Langkjoering(int resultatID, int oektID, String aktivitetNavn, int puls, int lengde, int avstand, int motstand, int fart) {
        super(resultatID, oektID, aktivitetNavn, puls, lengde, avstand, motstand);
        this.fart = fart;
    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select fart" +
                    " from langkjoering where resultatID=" + resultatID);
            while (rs.next()) {
                fart = rs.getInt(fart);
            }

        } catch (Exception e) {
            System.out.println("db error during select of langkjoering= "+e);
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
            stmt.executeUpdate("insert into langkjoering value ("+fart+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Kondisjon="+e);
            return;
        }
    }
}
