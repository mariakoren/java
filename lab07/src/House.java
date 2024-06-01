import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public final class House extends PlaceToLive {
    private double plotArea;

    public House(String street, String nrBuilding, String location, String zipCode, double area, double price, double plotArea, LocalDate offerEffectiveDate) {
        this.street = street;
        this.nrBuilding = nrBuilding;
        this.location = location;
        this.zipCode = zipCode;
        this.area = area;
        this.price = price;
        this.plotArea = plotArea;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(double plotArea) {
        this.plotArea = plotArea;
    }

    public LocalDate getOfferEffectiveDate() {
        return offerEffectiveDate;
    }

    public void setOfferEffectiveDate(LocalDate offerEffectiveDate) {
        this.offerEffectiveDate = offerEffectiveDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "House " +
                "street='" + street + '\'' +
                ", nrBuilding=" + nrBuilding +
                ", location='" + location + '\'' +
                ", zipcode='" + zipCode + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", plotArea=" + plotArea +
                ", offerEffectiveDate=" + offerEffectiveDate.format(formatter);
    }

}
