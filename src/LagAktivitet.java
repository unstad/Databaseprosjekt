import java.sql.SQLException;
import java.sql.*;

public class LagAktivitet extends DBConn{
    private Aktivitet aktivitet;
    private String navn, beskrivelse, maal, resultat;
    private Array muskelgrupper;

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
                             String resultat, Array muskelgrupper){
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
