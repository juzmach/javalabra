package gladiaattorit.pelilogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juzmach
 */
public class Joukkue {

    /**
     * Joukkueen nimi
     */
    private String nimi;
    /**
     * Lista joukkueen gladiaattoreista
     */
    private List<Gladiaattori> gladiaattorit;
    
    /**
     *
     * @param nimi
     */
    public Joukkue(String nimi) {
        this.nimi = nimi;
        this.gladiaattorit = new ArrayList<Gladiaattori>();
    }

    /**
     *
     * @return Joukkueen nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *
     * @return Joukkueen koko
     */
    public int getJoukkueenKoko() {
        if (gladiaattorit.isEmpty()) {
            return 0;
        }
        return gladiaattorit.size();
    }

    /**
     * Lisää joukkueeseen yhden gladiaattorin, jos kyseistä gladiaattoria ei
     * löydy vielä joukkueesta.
     *
     * @param lisattava
     */
    public void lisaaGladiaattori(Gladiaattori lisattava) {
        if (!this.gladiaattorit.contains(lisattava)) {
            this.gladiaattorit.add(lisattava);
        }
    }

    /**
     * Hakee gladiaattorin nimen mukaan
     *
     * @param gladiaattorinNimi
     * @return Gladiaattori, jolla parametrina annettu nimi
     */
    public Gladiaattori haeGladiaattori(String gladiaattorinNimi) {
        if (!gladiaattorit.isEmpty()) {
            for (Gladiaattori gladiaattori : this.gladiaattorit) {
                if (gladiaattori.getNimi().equals(gladiaattorinNimi.toUpperCase())) {
                    return gladiaattori;
                }
            }
        }
        return null;
    }

    /**
     * Hakee gladiaattorin pelinumeron mukaan
     *
     * @param peliNumero
     * @return Gladiaattorin, jolla parametrina annettu pelinumero
     */
    public Gladiaattori haeGladiaattori(int peliNumero) {
        if (!gladiaattorit.isEmpty()) {
            for (Gladiaattori gladiaattori : this.gladiaattorit) {
                if (gladiaattori.getPeliNumero() == peliNumero) {
                    return gladiaattori;
                }
            }
        }
        return null;
    }

    /**
     *
     * @return boolean-arvo, joka kertoo onko koko joukkue kuollut
     */
    public boolean onkoJoukkueKuollut() {
        boolean joukkueKuollut = true;
        for (Gladiaattori gladiaattori : gladiaattorit) {
            if (gladiaattori.isElossa()) {
                joukkueKuollut = false;
                break;
            }
        }
        return joukkueKuollut;
    }

    /**
     *
     * @return Lista gladiaattoreista
     */
    public List<Gladiaattori> getGladiaattorit() {
        return gladiaattorit;
    }

    /**
     * Palauttaa Joukkueen String-tulosteen hakemalla jokaisen gladiaattorin String-tulosteen.
     * @return Joukkueen String-tuloste
     */
    @Override
    public String toString() {
        String tuloste = this.nimi + "\n";
        for (Gladiaattori gladiaattori : gladiaattorit) {
            if (gladiaattori.isElossa()) {
                tuloste += gladiaattori.toString() + "\n";
            }
        }
        return tuloste;
    }
}
