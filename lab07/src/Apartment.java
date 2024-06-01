import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public final class Apartment extends  PlaceToLive{
    private double nrFloor;
    private String nrApartment;

    public Apartment(String street, String nrBuilding, String nrApartment, String location, String zipcode, double area, double nrFloor, double price, LocalDate offerEffectiveDate) {
        this.street = street;
        this.nrBuilding = nrBuilding;
        this.nrApartment = nrApartment;
        this.location = location;
        this.zipCode = zipcode;
        this.area = area;
        this.nrFloor = nrFloor;
        this.price = price;
        this.offerEffectiveDate = offerEffectiveDate;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNrBuilding() {
        return nrBuilding;
    }

    public void setNrBuilding(String nrBuilding) {
        this.nrBuilding = nrBuilding;
    }

    public String getNrApartment() {
        return nrApartment;
    }

    public void setNrApartment(String nrApartment) {
        this.nrApartment = nrApartment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZipcode() {
        return zipCode;
    }

    public void setZipcode(String zipcode) {
        this.zipCode = zipcode;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getNrFloor() {
        return nrFloor;
    }

    public void setNrFloor(double nrFloor) {
        this.nrFloor = nrFloor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getOfferEffectiveDate() {
        return offerEffectiveDate;
    }

    public void setOfferEffectiveDate(LocalDate offerEffectiveDate) {
        this.offerEffectiveDate = offerEffectiveDate;
    }

    @Override
    public String toString() {
        return "Apartment " +
                "street='" + street + '\'' +
                ", nrBuilding=" + nrBuilding +
                ", nrApartment=" + nrApartment +
                ", location='" + location + '\'' +
                ", zipcode='" + zipCode + '\'' +
                ", area=" + area +
                ", nrFloor=" + nrFloor +
                ", price=" + price +
                ", offerEffectiveDate='" + offerEffectiveDate + '\'';
    }



}
