import java.util.Date;

public class HomePageFeatured extends Listing {

    public HomePageFeatured(String c, String n, Date sd, Date ed, String d) {
        super(c, n, sd, ed, d);
    }

    public String toString() {
        return ("Listing type: " + getClass().getSimpleName() + " " + super.toString());
    }
}