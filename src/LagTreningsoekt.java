import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class LagTreningsoekt extends DBConn {
    public Treningsoekt treningsøkt;
    public LocalDateTime lid;
    public String notat, luftkvalitet, vaer;
    public boolean inne;
    public int prestasjon, varighet;

    public LagTreningsoekt() {
        connect();
        // La laging av avtale være en transaksjon
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagTreningsoekt="+e);
            return;
        }
    }

    public void LagTreningsøkt (LocalDateTime lid, String notat, String luftkvalitet, String vaer,
                                boolean inne, int prestasjon, int varighet){
        treningsøkt = new Treningsoekt(lid, notat, luftkvalitet, vaer, inne, prestasjon, varighet);

    }

    public void fullfør () {
        treningsøkt.save(conn);
        try {
            conn.commit();
        } catch (SQLException e) {
            System.out.println("db error during commit of LagTreningsoekt="+e);
            return;
        }
    }
}
