import java.time.LocalTime;

enum Status {
    BRAK,
    PLANOWANE,
    POTWIERDZONE,
    REALIZOWANE,
    WYKONANE
}

public final class Zadanie extends Zdarzenie{
    private final Status status;

    public Zadanie(final String opis, final LocalTime czasStart, final LocalTime czasKoniec, final Status status) {
        this.opis       = opis;
        this.czasStart  = czasStart;
        this.czasKoniec = czasKoniec;
        this.status  = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Zadanie " + getOpis() +
                " zaczyna się o " + getCzasStart() +
                " ma koniec o " + getCzasKoniec() +
                " ma status " + getStatus();

    }
}
