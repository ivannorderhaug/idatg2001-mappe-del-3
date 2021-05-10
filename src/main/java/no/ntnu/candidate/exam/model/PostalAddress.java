package no.ntnu.candidate.exam.model;

public class PostalAddress {

    private String postalCode;
    private String city;
    private String countyNumber;
    private String county;
    private String category;

    /**
     * Constructor for class PostAddress
     * Instantiates new object of class.
     * @param postalCode
     * @param city
     * @param countyNumber
     * @param county
     * @param category
     */
    public PostalAddress(String postalCode, String city, String countyNumber, String county, String category) {
        if(isValid(postalCode) && isValid(city) && isValid(countyNumber) && isValid(county) && isValid(category)) {
            this.postalCode = postalCode;
            this.city = city;
            this.countyNumber = countyNumber;
            this.county = county;
            this.category = category;
        } else {
            throw new IllegalArgumentException("Invalid parameters,");
        }
    }

    public static boolean isValid( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s != null || !s.trim().isEmpty();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountyNumber() {
        return countyNumber;
    }

    public String getCounty() {
        return county;
    }

    public String getCategory() {
        return category;
    }
}
