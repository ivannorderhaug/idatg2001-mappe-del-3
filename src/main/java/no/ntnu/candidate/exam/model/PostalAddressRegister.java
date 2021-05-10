package no.ntnu.candidate.exam.model;

import javafx.collections.ObservableList;

public class PostalAddressRegister {

    private final ObservableList<PostalAddress> par;

    public PostalAddressRegister(ObservableList<PostalAddress> par){
        this.par = par;
    }

    /**
     * Accessor method for postal address list
     * @return par
     */
    public ObservableList<PostalAddress> getPar() {
        return par;
    }
}
