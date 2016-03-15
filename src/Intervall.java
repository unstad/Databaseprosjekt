import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Intervall extends Kondisjon{

    public int pauselengde, arbeidslengde, pausefart, arbeidsfart, repetisjoner;


    public Intervall(int resultatID, int oektID, String aktivitetNavn, int puls, int lengde, int avstand, int motstand, int pauselengde, int arbeidslengde, int pausefart, int arbeidsfart, int repetisjoner) {
        super(resultatID, oektID, aktivitetNavn, puls, lengde, avstand, motstand);
        this.pauselengde = pauselengde;
        this.arbeidslengde = arbeidslengde;
        this.pausefart = pausefart;
        this.arbeidsfart = arbeidsfart;
        this.repetisjoner = repetisjoner;
    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select pauselengde, arbeidslengde, pausefart, arbeidsfart, repetisjoner" +
                    " from intervall where resultatID=" + resultatID);
            while (rs.next()) {
                pauselengde = rs.getInt(pauselengde);
                arbeidslengde = rs.getInt(arbeidslengde);
                pausefart = rs.getInt(pausefart);
                arbeidsfart = rs.getInt(arbeidsfart);
                repetisjoner = rs.getInt(repetisjoner);
            }

        } catch (Exception e) {
            System.out.println("db error during select of intervall= "+e);
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
            stmt.executeUpdate("insert into intervall values ("+pauselengde +","+arbeidslengde +","+pausefart+", "+arbeidsfart+","+repetisjoner+")");
        } catch (Exception e) {
            System.out.println("db error during insert of intervall="+e);
            return;
        }
    }
}