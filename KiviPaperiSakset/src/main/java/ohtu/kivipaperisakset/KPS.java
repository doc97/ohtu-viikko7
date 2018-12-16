package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 * Created by Daniel Riissanen on 16.12.2018.
 */
public abstract class KPS {

    protected static final Scanner scanner = new Scanner(System.in);

    private Tuomari tuomari;

    protected abstract String ekanSiirto();
    protected abstract String tokanSiirto();

    public void pelaa() {
        setup();

        String ekanSiirto = ekanSiirto();
        String tokanSiirto = tokanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            kirjaaSiirrot(ekanSiirto, tokanSiirto);
            ekanSiirto = ekanSiirto();
            tokanSiirto = tokanSiirto();
            postRound(ekanSiirto, tokanSiirto);
        }
        printResults();
    }

    protected void setup() {
        tuomari = new Tuomari();
    }

    protected void postRound(String ekanSiirto, String tokanSiirto) {}

    private void kirjaaSiirrot(String ekanSiirto, String tokanSiirto) {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        System.out.println(tuomari);
        System.out.println();
    }

    private void printResults() {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
