import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class LagAktivitet extends DBConn{
    public  Aktivitet aktivitet;
    public String navn, beskrivelse, maal, resultat;
    public Array muskelgrupper;

    public LagAktivitet() {
        connect();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAktivitet="+e);
            return;
        }
    }

    public void LagAktivitet(String navn, String beskrivelse, String maal,
                             String resultat, ArrayList muskelgrupper){
        aktivitet= new Aktivitet(navn, beskrivelse, maal, resultat, muskelgrupper);
    }

    public void fullfør () {
        aktivitet.save(conn);
        try {
            conn.commit();
        } catch (SQLException e) {
            System.out.println("db error during commit of LagAktivitet="+e);
            return;
        }
    }
}
