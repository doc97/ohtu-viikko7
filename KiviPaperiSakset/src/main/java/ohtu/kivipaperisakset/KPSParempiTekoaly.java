package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPS {

    private TekoalyParannettu tekoaly;

    @Override
    protected void setup() {
        tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected void postRound(String ekanSiirto, String tokanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }

    @Override
    protected String ekanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    @Override
    protected String tokanSiirto() {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }
}
