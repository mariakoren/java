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
    private Map<DayOfWeek, ArrayList<Spotkanie>> dane;

    public Kalendarz() {}

    public Kalendarz(final Map<DayOfWeek, ArrayList<Spotkanie>> dane) {
        this.dane = dane;
    }

    public Map<DayOfWeek, ArrayList<Spotkanie>> getDane() {
        return dane;
    }

    public ArrayList<Spotkanie> getSpotkania(Predicate<Spotkanie> predykat, DayOfWeek dzien) {
        var spotkania = new ArrayList<Spotkanie>();
        if (dane == null) {
            return null;
        }
        for (var spotkanie : dane.get(dzien)) {
            if (predykat.test(spotkanie)) {
                spotkania.add(spotkanie);
            }
        }
        return spotkania;
    }

    public void addSpotkanie(final DayOfWeek dzien, final Spotkanie spotkanie) throws AddSpotkanieException {
        if (dane == null) {
            dane = new HashMap<DayOfWeek, ArrayList<Spotkanie>>();
        }

        if (!Spotkanie.czyKoliduje(spotkanie)) {
            if (dane.get(dzien) == null) {
                var arr = new ArrayList<Spotkanie>();
                arr.add(spotkanie);
                dane.put(dzien, arr);
            } else {
                dane.get(dzien).add(spotkanie);
            }
        } else {
            throw new AddSpotkanieException("Spotkanie jest zbyt wcześnie!");
        }
    }
}
