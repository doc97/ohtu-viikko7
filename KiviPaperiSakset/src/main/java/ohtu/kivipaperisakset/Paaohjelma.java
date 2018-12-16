package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            Pelimuoto peli = getPelimuoto(vastaus);
            if (peli == null)
                break;

            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }
    }

    private static Pelimuoto getPelimuoto(String type) {
        if (type.endsWith("a"))
            return new KPSPelaajaVsPelaaja();
        else if (type.endsWith("b"))
            return new KPSTekoaly();
        else if (type.endsWith("c"))
            return new KPSParempiTekoaly();
        else
            return null;
    }
}
