import java.time.LocalDateTime;
import java.util.Scanner;

public class Program{
    LocalDateTime dato;
    Scanner scan = new Scanner();
    String navn, valg;

    public void main(){
        System.out.println("Hei! Velkommen til treningsdagboken din");
        System.out.println("Skriv 1 hvis du vil opprette en ny aktivitet");
        System.out.println("Skriv 2 hvis du vil registrere et resultat");
        System.out.println("Skriv 3 hvis du vil registrere en treningsøkt");
        System.out.println("Skriv 4 hvis du vil hente ut en aktivitet");
        System.out.println("Skriv 0 hvis du vil avslutte");
        valg = scan.NextInt
        while(valg==1 || valg==2 || valg==3){
            if(valg==1){
                System.out.println("Hva vil du kalle aktiviteten?");
                navn = scan.nextLine();
                Aktivitet navn = new Aktivitet(navn,beskrivelse,maal,resultat, muskelgrupper);
                System.out.println("Hva vil du kalle aktiviteten?");
                navn.navn = scan.NextLine();
                System.out.println("Skriv inn beskrivelse for aktiviteten:");
                navn.beskrivelse = scan.nextLine();
                System.out.println("Hva er målet for aktiviteten?");
                navn.maal = scan.nextLine();
                System.out.println("Hva er resultatet?");
                navn.resultat = scan.nextLine();
                System.out.println("Hvilke(n) muskelgruppe(r)aktiveres? Tast 0 for å avslutte");
               while (scan.NextLine != '0'){
                   Array muskelgrupper = new Array[];
                   muskelgrupper.add(scan.NextLine);
               }
                navn.muskelgrupper = muskelgrupper;
            }
            else if(valg==2){
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
            else if(valg==3){
                System.out.println("Hva vil du kalle treningen?");
                navn = scan.nextLine();
                Treningsoekt navn = new Treningsoekt(notat,ID,luftkvalitet,inne,vaer,prestasjon,varighet);
                System.out.println("Skriv inn notat for treningen:");
                navn.notat = scan.nextLine();
                System.out.println("Hvordan var luftkvaliteten?");
                navn.luftkvalitet = scan.nextLine();
                System.out.println("Hvordan var været?");
                navn.vaer = scan.nextLine();
                System.out.println("Skriv 1 hvis treningen var inne, skriv 0 hvis treningen var ute");
                while(scan.nextInt()!=1 || scan.nextInt()!=0){
                    System.out.println("Velg enten 1 eller 0");
                    System.out.println("Skriv 1 hvis treningen var inne, skriv 0 hvis treningen var ute");
                }
                if(scan.nextInt()==1){
                    navn.inne = true;
                }
                else if(scan.nextInt()==0) {
                    navn.inne = false;
                }
                System.out.println("Ranger prestasjonen din fra 0-9");
                navn.prestasjon = scan.nextInt();
                System.out.println("Hvor lenge varte treningen?[min]");
                navn.varighet = scan.nextLine();
            }
            else if(valg ==4){
                System.out.println("Hvilken vil du hente ut?");
                navn = scan.NextLine;
                Statement stmt = conn.createStatement();
                stmt.executeQuery("select * from aktivitet where navn = navn"); //TODO
            }
        }
    }

}
