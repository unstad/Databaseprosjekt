import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program extends Application{
    LocalDateTime dato;
    Scanner scan = new Scanner(System.in);
    String navn, valg, maal, resultat, notat, luftkvalitet, vaer;
    ArrayList muskelgrupper;
    LagAktivitet aktivitet;
    boolean inne;
    int prestasjon, varighet;

    public void main() {
        System.out.println("Hei! Velkommen til treningsdagboken din");
        System.out.println("Skriv 1 hvis du vil opprette en ny aktivitet");
        System.out.println("Skriv 2 hvis du vil registrere et resultat");
        System.out.println("Skriv 3 hvis du vil registrere en treningsøkt");
        System.out.println("Skriv 4 hvis du vil hente ut en aktivitet");
        System.out.println("Skriv 0 hvis du vil avslutte");
        valg = scan.nextLine();
        while(valg=="1" || valg=="2" || valg=="3"){
            if(valg=="1"){
                System.out.println("Hva vil du kalle aktiviteten?");
                navn = scan.nextLine();
                System.out.println("Skriv inn beskrivelse for aktiviteten:");
                String beskrivelse = scan.nextLine();
                System.out.println("Hva er målet for aktiviteten?");
                maal = scan.nextLine();
                System.out.println("Hva er resultatet?");
                resultat = scan.nextLine();
                System.out.println("Hvilke(n) muskelgruppe(r)aktiveres? Tast 0 for å avslutte");
               while (scan.nextLine() != "0"){

                   muskelgrupper.add(scan.nextLine());
               }
                aktivitet = LagAktivitet(navn, beskrivelse, maal,resultat, muskelgrupper);
                //Why??
            }
            //må knyttes til aktivitet, vet ikke hvordan vi skal implementere dette
            else if(valg=="2"){
                /*Resultat result = new resultat(resultatID,oektID,aktivitetNavn));
                System.out.println("Er resultatet for kondisjon eller en styrkeøvelse? Tast 1 for kondisjon, 2 for styrkeøvelse");
                if(scan.NextInt == 1){
                    System.out.println("1:Intervall, 2:Langkjøring");
                    if(scan.NextInt ==1){
                        System.out.println("oppgi informasjon...");
                    }
                    else if(scan.NextInt ==2){
                        System.out.println("Oppgi farten");

                    }
                }*/
            }
            else if(valg=="3"){
                System.out.println("Hva vil du kalle treningen?");
                navn = scan.nextLine();

                System.out.println("Skriv inn notat for treningen:");
                notat = scan.nextLine();
                System.out.println("Hvordan var luftkvaliteten?");
                luftkvalitet = scan.nextLine();
                System.out.println("Hvordan var været?");
                vaer = scan.nextLine();
                System.out.println("Skriv 1 hvis treningen var inne, skriv 0 hvis treningen var ute");
                while(scan.nextInt()!=1 || scan.nextInt()!=0){
                    System.out.println("Velg enten 1 eller 0");
                    System.out.println("Skriv 1 hvis treningen var inne, skriv 0 hvis treningen var ute");
                }
                if(scan.nextInt()==1){
                    inne = true;
                }
                else if(scan.nextInt()==0) {
                    inne = false;
                }
                System.out.println("Ranger prestasjonen din fra 0-9");
                prestasjon = scan.nextInt();
                System.out.println("Hvor lenge varte treningen?[min]");
                varighet = scan.nextInt();
                Treningsoekt navn = new Treningsoekt(notat,dato,luftkvalitet,inne,vaer,prestasjon,varighet);
            }
            else if(valg =="4"){
               HentUtAktivitet.hentAktivitet();
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
