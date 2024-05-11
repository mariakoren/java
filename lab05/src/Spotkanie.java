import java.time.LocalTime;

enum Priorytet {
    BRAK,
    NORMALNE,
    WYSOKIE,
    NAJWYŻSZE
}

public class Spotkanie {
    private String opis;
    private LocalTime czasStart;
    private LocalTime czasKoniec;
    private Priorytet priorytet;
    public static final LocalTime NAJWCZESNIEJSZE_SPOTKANIE = LocalTime.of(8, 0);

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

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzasStart() {
        return czasStart;
    }

    public LocalTime getCzasKoniec() {
        return czasKoniec;
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

    public static boolean czyKoliduje(final Spotkanie spotkanie) {
        return spotkanie.getCzasStart().isBefore(NAJWCZESNIEJSZE_SPOTKANIE);
    }
}
