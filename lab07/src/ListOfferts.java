import java.util.ArrayList;
import java.util.function.Predicate;


public class ListOfferts {
    private ArrayList<PlaceToLive> data;

    public ArrayList<PlaceToLive> getData() {
        return data;
    }

    public void addPlaceToLive(final PlaceToLive place){
        if (data == null) {
            data = new ArrayList<PlaceToLive>();
        }
        data.add(place);

    }


    public ArrayList<PlaceToLive> getPlaceToLive(Predicate<PlaceToLive> predykat) {
        var places = new ArrayList<PlaceToLive>();
        if (data == null) {
            return null;
        }
        for (var place : data) {
            if (predykat.test(place)) {
                places.add(place);
            }
        }
        return places;
    }
}
