package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS {

    private TekoalyHelppo tekoaly;

    @Override
    protected void setup() {
        super.setup();
        tekoaly = new TekoalyHelppo();
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