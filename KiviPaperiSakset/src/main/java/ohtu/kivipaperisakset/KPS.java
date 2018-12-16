package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 * Created by Daniel Riissanen on 16.12.2018.
 */
public abstract class KPS {

    protected static final Scanner scanner = new Scanner(System.in);

    protected abstract String ekanSiirto();
    protected abstract String tokanSiirto();

    public void pelaa() {
        setup();

        Tuomari tuomari = new Tuomari();
        String ekanSiirto = ekanSiirto();
        String tokanSiirto = tokanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ekanSiirto();
            tokanSiirto = tokanSiirto();
            postRound(ekanSiirto, tokanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected void setup() {}
    protected void postRound(String ekanSiirto, String tokanSiirto) {}

    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
