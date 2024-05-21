import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

class AddSpotkanieException extends Exception {
    public AddSpotkanieException() {}

    public AddSpotkanieException(String message) {
        super(message);
    }
}

public class Kalendarz {
    private Map<DayOfWeek, ArrayList<Zdarzenie>> dane;

    public Kalendarz() {}

    public Kalendarz(final Map<DayOfWeek, ArrayList<Zdarzenie>> dane) {
        this.dane = dane;
    }

    public Map<DayOfWeek, ArrayList<Zdarzenie>> getDane() {
        return dane;
    }

    public ArrayList<Zdarzenie> getSpotkania(Predicate<Zdarzenie> predykat, DayOfWeek dzien) {
        var zdarzenia = new ArrayList<Zdarzenie>();
        if (dane == null) {
            return null;
        }
        for (var zdarzenie : dane.get(dzien)) {
            if (predykat.test(zdarzenie)) {
                zdarzenia.add(zdarzenie);
            }
        }
        return zdarzenia;
    }

    public void addSpotkanie(final DayOfWeek dzien, final Zdarzenie zdarzenie) throws AddSpotkanieException {
        if (dane == null) {
            dane = new HashMap<DayOfWeek, ArrayList<Zdarzenie>>();
        }

        if (!Zdarzenie.czyKoliduje(zdarzenie)) {
            if (dane.get(dzien) == null) {
                var arr = new ArrayList<Zdarzenie>();
                arr.add(zdarzenie);
                dane.put(dzien, arr);
            } else {
                dane.get(dzien).add(zdarzenie);
            }
        } else {
            throw new AddSpotkanieException("Zdarzenie jest zbyt wcześnie!");
        }
    }
}
