package ohtu.kivipaperisakset;

public class TekoalyHelppo implements Tekoaly {

    private int siirto;
    private String[] siirrot;

    public TekoalyHelppo() {
        siirto = 0;
        siirrot = new String[] { "k", "p", "s" };
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;
        return siirrot[siirto];
    }

    @Override
    public void asetaSiirto(String ekanSiirto) { }
}
