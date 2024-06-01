import java.time.LocalDate;

public abstract sealed class PlaceToLive permits Apartment, House {
    protected String street;
    protected String nrBuilding;

    protected String location;
    protected String zipCode;
    protected double area;
    protected double price;
    protected LocalDate offerEffectiveDate;


}
