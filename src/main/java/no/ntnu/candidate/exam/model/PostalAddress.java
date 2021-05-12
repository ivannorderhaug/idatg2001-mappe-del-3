package no.ntnu.candidate.exam.model;

public class PostalAddress{

    private String postalCode;
    private String town;
    private String municipalityNumber;
    private String municipality;
    private String category;

    /**
     * Constructor for class PostAddress
     * Instantiates new object of class.
     * @param postalCode
     * @param town
     * @param municipalityNumber
     * @param municipality
     * @param category
     */
    public PostalAddress(String postalCode, String town, String municipalityNumber, String municipality, String category) {
        if(!empty(postalCode) && !empty(town) && !empty(municipalityNumber) && !empty(municipality) && !empty(category)) {
            this.postalCode = postalCode;
            this.town = town;
            this.municipalityNumber = municipalityNumber;
            this.municipality = municipality;
            this.category = category;
        } else {
            throw new IllegalArgumentException("Parameters should not be null, nor empty");
        }
    }

    /**
     * Method for validating a string
     * @param s
     * @return
     */
    public static boolean empty(final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
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
    public String getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * Accessor method for county
     * @return county
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Accessor method for category
     * @return category
     */
    public String getCategory() {
        return category;
    }
}
