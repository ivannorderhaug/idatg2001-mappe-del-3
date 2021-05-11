package no.ntnu.candidate.exam;

import no.ntnu.candidate.exam.model.PostalAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PostAddressTest {

    private PostalAddress postalAddress;

    /**
     * Called before each test is run
     */
    @BeforeEach
    void setUp() {
        postalAddress = new PostalAddress("101", "Testingville", "404", "Land of tests", "P");
    }

    /**
     * Assert that constructor works as intended
     * @result Object will be persisted without any errors
     */
    @Test
    void constructorTest() {
        assertNotNull(postalAddress);
    }

    /**
     * Assert that constructor is nullsafe
     * @result Throws IllegalArgumentException due to null values in parameters
     * @throws IllegalArgumentException
     */
    @Test
    void constructorNullSafeTest() {
        assertThrows(IllegalArgumentException.class, () -> new PostalAddress(null, null, null, null, null));
    }

    /**
     * Assert that accessors retrieves correct information
     * @result Test will pass, as accessors works correctly
     */
    @Test
    void accessorTest(){
        assertSame("101", postalAddress.getPostalCode());
        assertSame("Testingville", postalAddress.getTown());
        assertSame("Land of tests", postalAddress.getMunicipality());
        assertSame("404", postalAddress.getMunicipalityNumber());
        assertSame("P", postalAddress.getCategory());
    }
}
