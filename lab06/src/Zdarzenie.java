import java.time.LocalTime;

sealed abstract class Zdarzenie permits Zadanie, Spotkanie {
    protected String opis;
    protected LocalTime czasStart;
    protected LocalTime czasKoniec;

    public static final LocalTime NAJWCZESNIEJSZE_ZDARZENIE = LocalTime.of(8, 0);

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzasStart() {
        return czasStart;
    }

    public LocalTime getCzasKoniec() {
        return czasKoniec;
    }


    public static boolean czyKoliduje(final Zdarzenie zdarzenie) {
        return
        zdarzenie.getCzasStart().isBefore(NAJWCZESNIEJSZE_ZDARZENIE);
    }
}
