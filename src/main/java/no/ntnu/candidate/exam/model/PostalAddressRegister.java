package no.ntnu.candidate.exam.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PostalAddressRegister {

    private final ObservableList<PostalAddress> par;

    /**
     * Constructor for class PostalAddressRegister.
     * Instantiates new object of class.
     */
    public PostalAddressRegister(){
        par = FXCollections.observableArrayList();
    }

    /**
     * Accessor method for postal address list
     * @return par
     */
    public ObservableList<PostalAddress> getAddresses() {
        return par;
    }

}
