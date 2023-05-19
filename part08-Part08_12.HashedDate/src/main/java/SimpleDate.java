
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        
        if (!(object instanceof SimpleDate)) return false;

        if (object == this) return true;

        SimpleDate comparedObject = (SimpleDate) object;

        if (comparedObject.day != this.day) return false;
        if (comparedObject.month != this.month) return false;
        if (comparedObject.year != this.year) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return this.day * (this.month + this.day) * this.month * (this.year + this.month);
    }
}
