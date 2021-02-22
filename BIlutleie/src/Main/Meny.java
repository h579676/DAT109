package Main;

import Klasser.*;

import java.util.*;

public class Meny {

    public static void main (String[] args){

        //Bruker test
        Adresse ad = new Adresse("Kniksens Plass 10", 5063, "Brann Stadion");
        Bruker bruker = new Bruker("Thanujan Uthayasangar", "Lothbrok", ad, 90578493, "5638930492749204");

        //BilUtleieselskap test

        List<Bil> biler1 = new ArrayList<Bil>(Arrays.asList((new Bil("EV637462", 300000, "Leaf", "Black", Bilkategori.MELLOMSTOR, true)),
                                                         (new Bil("DK273617", 5000, "Toyota", "Galaxy Blue", Bilkategori.STASJONSVOGN, true))));
        Adresse ad1 = new Adresse("Tante Ulrikkes vei", 4984, "Oslo");

        List<Bil> biler2 = new ArrayList<Bil>(Arrays.asList((new Bil("EK55888", 1000, "Mitsubishi", "Matt Black", Bilkategori.LITEN, true)),
                                                            (new Bil("EK85588", 23000, "Volkswagen", "Grey", Bilkategori.MELLOMSTOR, true))));
        Adresse ad2 = new Adresse("Indre Arna", 5261, "Bergen");


            Adresse adSelskap = new Adresse("Coldstream Avenue", 1189, "Vernon");
            List<Utleie> utleie1 = new ArrayList<Utleie>();
            List<Utleie> utleie2 = new ArrayList<Utleie>();
            Utleiekontor utleier1 = new Utleiekontor(1, ad1, 56848394, biler1, utleie1);
            Utleiekontor utleier2 = new Utleiekontor(2, ad2, 56748329, biler2, utleie2);
            BilUtleieSelskap selskap = new BilUtleieSelskap("CheapRentals", 57382994, adSelskap, new ArrayList<Utleiekontor>(Arrays.asList(utleier1, utleier2)), new ArrayList<Bruker>(Arrays.asList(bruker)));

        Scanner scanner = new Scanner(System.in);



        //Start med innlogging/oppretting av bruker
        int start = start();

        if (start == 1) {
            System.out.println("Kortnummer skrives her:");

            String kort = scanner.nextLine();

            Bruker bruk = BilUtleieSelskap.finnBruker(kort);

            if (bruk != null) {
                //Skriv ut alle områdene du kan hente bil
                selskap.utleiereTilgjengelig();

                //Skriv inn ønsket plass (addresse)
                System.out.println("Skriv utleiers ID av ditt valg: ");

                int valgtID = scanner.nextInt();
                scanner.nextLine();

                //Skriv ut alle bilene i denne ønsket plassen (Utleiekontoret)
                Utleiekontor valgtUtleier = BilUtleieSelskap.finnUtleier(valgtID);
                System.out.println("Tilgjengelige biler vises her: ");
                valgtUtleier.bilerTilgjengelig();
                

                String bilRegi = valgtUtleier.reserver(bruker);
                Bil bil = valgtUtleier.finnBil(bilRegi);

                //Send kvittering og få bruker til å returnere bil
                valgtUtleier.returner(bruker);
  

            } else {
                System.out.println("Buker med dette kortet finnes ikke");
            }

        } else if (start == 2) {

        //Ny bruker
        System.out.println("Venligst skriv inn ditt fornavn: ");
        String fn = scanner.nextLine();

        System.out.println("Venligst skriv inn ditt etternavn: ");
        String en = scanner.nextLine();

        System.out.println("Venligst skriv inn ditt telefonnummer: ");
        int tele = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Venligst skriv inn ditt kortnummer: ");
        String kort = scanner.nextLine();

        //Addressen
        System.out.println("Gate adresset skrives her: ");
        String ga = scanner.nextLine();

        System.out.println("Postnummer skrives her:");
        int pn = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Poststed skrives her: ");
        String ps = scanner.nextLine();

        Adresse brukerAddresse = new Adresse(ga, pn, ps);
        Bruker lagtBruker = new Bruker(fn, en, brukerAddresse, pn, kort);

            //Skriv ut alle områdene du kan hente bil
            selskap.utleiereTilgjengelig();

            //Skriv inn ønsket plass (addresse)
            System.out.println("Venligts skriv inn ID nummeret på utleieren av ditt valg: ");

            int valgtID = scanner.nextInt();
            scanner.nextLine();

            //Skriv ut alle bilene i denne ønsket plassen (Utleiekontoret)
            Utleiekontor valgtUtleier = BilUtleieSelskap.finnUtleier(valgtID);
            System.out.println("Her vises alle tilgjengelige biler: ");
            valgtUtleier.bilerTilgjengelig();

            //Reservere bil
            String bilRegi = valgtUtleier.reserver(bruker);
            Bil bil = valgtUtleier.finnBil(bilRegi);

            //Send kvittering og få bruker til å returnere bil
            valgtUtleier.returner(bruker);

        }

    }

    public static int start(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Tast nummer 1 for login" + "\n" + "Tast nummer 2 for registrering");

            int start = scanner.nextInt();
            scanner.nextLine();
            return start;
    }

}