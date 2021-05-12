package no.ntnu.candidate.exam;


import no.ntnu.candidate.exam.model.PostalAddress;
import no.ntnu.candidate.exam.model.PostalAddressRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostalAddressRegisterTest {

    private PostalAddress postalAddress;
    private PostalAddressRegister par;

    /**
     * Called before each test is run
     */
    @BeforeEach
    void setUp() {
        postalAddress = new PostalAddress("101", "Testingville", "404", "Land of tests", "P");
        par = new PostalAddressRegister();
    }

    /**
     * Assert that add-method() works by comparing size before with size after - 1
     * @result Test will pass, as size before = size after - 1
     */
    @Test
    void addToRegisterTest() {
        int sizeBefore = par.getAddresses().size();
        par.addPostalAddress(postalAddress);
        int sizeAfter = par.getAddresses().size();
        assertEquals(sizeBefore, sizeAfter-1);
    }

    /**
     * Assert that add-method is nullsafe
     * @result Throws IllegalArgumentException due to null values in parameters
     * @throws IllegalArgumentException
     */
    @Test
    void addToRegisterNullSafeTest() {
        assertThrows(IllegalArgumentException.class, () -> par.addPostalAddress(null));
    }
}
