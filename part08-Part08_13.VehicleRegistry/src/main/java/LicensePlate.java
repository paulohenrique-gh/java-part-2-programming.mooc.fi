
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof LicensePlate)) return false;
        
        LicensePlate comparedObject = (LicensePlate) object;

        if (this.liNumber != comparedObject.liNumber) return false;
        if (this.country != comparedObject.country) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return this.liNumber.hashCode() + this.country.hashCode();
    }

}
