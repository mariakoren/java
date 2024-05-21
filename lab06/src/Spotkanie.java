import java.time.LocalTime;

enum Priorytet {
    BRAK,
    NORMALNE,
    WYSOKIE,
    NAJWYŻSZE
}

public final class Spotkanie extends Zdarzenie {

    private Priorytet priorytet;

    public Spotkanie(final String opis, final LocalTime czasStart, final LocalTime czasKoniec, final Priorytet priorytet) {
        this.opis       = opis;
        this.czasStart  = czasStart;
        this.czasKoniec = czasKoniec;
        this.priorytet  = priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie " + getOpis() +
                " zaczyna się o " + getCzasStart() +
                " ma koniec o " + getCzasKoniec() +
                " ma priorytet " + getPriorytet();

    }



    public Priorytet getPriorytet() {
        return priorytet;
    }

    public void setOpis(final String opis) {
        this.opis = opis;
    }

    public void setCzasStart(final LocalTime czasStart) {
        this.czasStart = czasStart;
    }

    public void setCzasKoniec(final LocalTime czasKoniec) {
        this.czasKoniec = czasKoniec;
    }

    public void setPriorytet(final Priorytet priorytet) {
        this.priorytet = priorytet;
    }

}
