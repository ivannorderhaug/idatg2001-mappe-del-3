package no.ntnu.candidate.exam.model;

public class PostalAddress{

    private String postalCode;
    private String town;
    private String countyNumber;
    private String county;
    private String category;

    /**
     * Constructor for class PostAddress
     * Instantiates new object of class.
     * @param postalCode
     * @param town
     * @param countyNumber
     * @param county
     * @param category
     */
    public PostalAddress(String postalCode, String town, String countyNumber, String county, String category) {
        if(isValid(postalCode) && isValid(town) && isValid(countyNumber) && isValid(county) && isValid(category)) {
            this.postalCode = postalCode;
            this.town = town;
            this.countyNumber = countyNumber;
            this.county = county;
            this.category = category;
        } else {
            throw new IllegalArgumentException("Invalid parameters");
        }
    }

    /**
     * Method for validating a string
     * @param s
     * @return
     */
    public static boolean isValid( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s != null || !s.trim().isEmpty();
    }

    /**
     * Accessor method for postalCode
     * @return postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Accessor method for city
     * @return city
     */
    public String getTown() {
        return town;
    }

    /**
     * Accessor method for countyNumber
     * @return county number
     */
    public String getCountyNumber() {
        return countyNumber;
    }

    /**
     * Accessor method for county
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * Accessor method for category
     * @return category
     */
    public String getCategory() {
        return category;
    }
}
