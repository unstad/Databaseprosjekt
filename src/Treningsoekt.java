import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;

public class Treningsoekt extends ActiveDomainObject{
    LocalDateTime ID;
    String notat, luftkvalitet, vaer;
    boolean inne;
    int prestasjon, varighet;

    public Treningsoekt(LocalDateTime ID, String notat, String luftkvalitet, String vaer,
                        boolean inne, int prestasjon, int varighet) {
        this.ID = ID;
        this.notat = notat;
        this.luftkvalitet = luftkvalitet;
        this.vaer = vaer;
        this.inne = inne;
        this.prestasjon = prestasjon;
        this.varighet = varighet;
    }

//init: gjør tabellen tilgjenglig
    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select ID, notat, luftkvalitet, vaer, inne, prestasjon, varighet" +
                                                " from treningsøkt where ID=" + ID);
            while (rs.next()) {
                notat =  rs.getString("notat");
                luftkvalitet = rs.getString("luftkvalitet");
                vaer = rs.getString("vaer");
                prestasjon = rs.getInt(prestasjon);
                varighet = rs.getInt(varighet);
            }

        } catch (Exception e) {
            System.out.println("db error during select of avtale= "+e);
            return;
        }

    }

    @Override
    public void refresh (Connection conn) {
        initialize (conn);
    }


// setter inn verdier i sql skjema (bruker sql syntaks)

    @Override
    public void save (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into treningsøkt values ("+ID+","+notat +","+luftkvalitet+","+vaer+","+inne+","
                    +prestasjon+","+varighet+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Avtale="+e);
            return;
        }
    }
}

