import java.time.LocalDateTime;
import java.util.Scanner;

public class Program extends Treningsoekt{
    LocalDateTime dato;
    Scanner scan = new Scanner();

    public void main(){
        Treningsoekt trening1 = new Treningsoekt(ID,notat,luftkvalitet,vaer,inne,prestasjon,varighet);
        System.out.println("Hei! Velkommen til treningsdagboken din");
        //System.out.println("Skriv inn dato og tid for treningen:");
        //trening1.ID = scan.nextLine(); //dritt fordi det er dato.
        System.out.println("Skriv inn notat for treningen:");
        trening1.notat = scan.nextLine();
        System.out.println("Hvordan var luftkvaliteten?");
        trening1.luftkvalitet = scan.nextLine();
        System.out.println("Hvordan var været?");
        trening1.vaer = scan.nextLine();
        System.out.println("Skriv 1 hvis treningen var inne, skriv 0 hvis treningen var ute");
        while(scan.nextInt()!=1 || scan.nextInt()!=0){
            System.out.println("Velg enten 1 eller 0");
            System.out.println("Skriv 1 hvis treningen var inne, skriv 0 hvis treningen var ute");
        }
        if(scan.nextInt()==1){
            trening1.inne = true;
        }
        else if(scan.nextInt()==0) {
            trening1.inne = false;
        }
        System.out.println("Ranger prestasjonen din fra 0-9");
        trening1.prestasjon = scan.nextInt();
        System.out.println("Hvor lenge varte treningen?[min]");
    }

}
