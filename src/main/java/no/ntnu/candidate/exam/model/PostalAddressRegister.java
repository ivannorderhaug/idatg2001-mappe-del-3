package no.ntnu.candidate.exam.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
     * Method for reading from file, and adding entries to register
     * @param path
     */
    public void readFromFile(String path){
        File file = new File(path);

        if(file != null) {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));

                String cols;
                while ((cols = br.readLine()) != null) {
                    String[] fields = cols.split("\t");
                    par.add(new PostalAddress(fields[0], fields[1],fields[2],fields[3],fields[4]));
                }
            }catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
