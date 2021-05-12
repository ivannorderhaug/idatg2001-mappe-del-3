package no.ntnu.candidate.exam.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.ntnu.candidate.exam.App;

import java.io.*;

public class PostalAddressRegister {

    private final ObservableList<PostalAddress> par;

    /**
     * Constructor for class PostalAddressRegister.
     * Instantiates a new object of class.
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

    /**
     * Method for adding to register
     */
    public void addPostalAddress(PostalAddress pa){
        if(pa != null){
            par.add(pa);
        } else {
            throw new IllegalArgumentException("Parameter cannot be null!");
        }
    }
    /**
     *
     * Method for reading from file, and adding entries to register
     * @param path
     */
    public void readFromFile(String path){
        InputStream is = App.class.getResourceAsStream(path);

        if(is != null) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(is));

                String cols;
                while ((cols = br.readLine()) != null) {
                    String[] fields = cols.split("\t");
                    if(fields.length == 5) {
                        addPostalAddress(new PostalAddress(fields[0], fields[1], fields[2], fields[3], fields[4]));
                    }
                }
            }catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
