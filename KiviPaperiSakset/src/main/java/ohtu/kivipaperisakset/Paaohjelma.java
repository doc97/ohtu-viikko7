package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Character, Peli> modes;

    public static void main(String[] args) {
        initializeGameModes();

        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            isRunning = handleResponse();
        }
    }

    private static void initializeGameModes() {
        modes = new HashMap<>();
        modes.put('a', new KPSPelaajaVsPelaaja());
        modes.put('b', new KPSTekoaly());
        modes.put('c', new KPSParempiTekoaly());
    }

    private static void printMenu() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }

    private static boolean handleResponse() {
        String vastaus = Paaohjelma.scanner.nextLine();
        Peli peli = getPelimuoto(vastaus);
        if (peli == null)
            return false;

        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        peli.pelaa();
        return true;
    }

    private static Peli getPelimuoto(String response) {
        if (response.isEmpty())
            return null;
        return modes.get(response.toLowerCase().charAt(response.length() - 1));
    }
}
