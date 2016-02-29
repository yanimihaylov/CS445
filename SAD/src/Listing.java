import java.util.Date;

public class Listing {

    String category;
    String name;
    Date startDate;
    Date endDate;
    String description;
    int owner;

    public Listing() {
        String name = " ";
        String startDate = " ";
        String endDate = " ";
        String description = " ";
    }

    public Listing(String c, String n, Date sd, Date ed, String desc) {
        category = c;
        name = n;
        startDate = sd;
        endDate = ed;
        description = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String ca) {
        category = ca;
    }

    public String getName() {
        return name;
    }

    public void setName(String na) {
        name = na;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date sDate) {
        startDate = sDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date eDate) {
        endDate = eDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        description = des;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int ow) {
        owner = ow;
    }

    public String toString() {
        return ("\nCategory " + category + "\n " + name + "\n Start date (mm/dd/yy): " + startDate +
                "\n End date (mm/dd/yy): " + endDate +
                "\n Listing description: " + description);
    }
}
