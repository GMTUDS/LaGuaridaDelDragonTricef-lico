package LaGuaridadelDragon;
/**
 *
 * @author nn
 */
public class NivelTesoro {
    private Tesoro tesoro;
    private int nivel;

    public NivelTesoro(Tesoro tesoro, int nivel) {
        this.tesoro = tesoro;
        this.nivel = nivel;
    }

    public Tesoro getTesoro() {
        return tesoro;
    }

    public int getNivel() {
        return nivel;
    }
}


