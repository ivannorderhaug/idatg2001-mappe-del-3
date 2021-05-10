package no.ntnu.candidate.exam.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.candidate.exam.model.PostalAddress;
import no.ntnu.candidate.exam.model.PostalAddressRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GUIController {

    @FXML
    private TableColumn<PostalAddress, String> colCountyNumber;

    @FXML
    private TableColumn<PostalAddress, String> colPostalCode;

    @FXML
    private TextField searchBar;

    @FXML
    private TableColumn<PostalAddress, String> colCounty;

    @FXML
    private TableView<PostalAddress> tableView;

    @FXML
    private TableColumn<PostalAddress, String> colCategory;

    @FXML
    private TableColumn<PostalAddress, String> colCity;

    private PostalAddressRegister par;

    @FXML
    void initialize() {
        /* Configures Table View */
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colCountyNumber.setCellValueFactory(new PropertyValueFactory<>("countyNumber"));
        colCounty.setCellValueFactory(new PropertyValueFactory<>("county"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        colPostalCode.setReorderable(false);
        colCity.setReorderable(false);
        colCountyNumber.setReorderable(false);
        colCounty.setReorderable(false);
        colCategory.setReorderable(false);

        //Instantiates new PostalAddressRegister
        par = new PostalAddressRegister();

        readFromFile();

        tableView.setItems(par.getAddresses());
    }

    private void readFromFile(){
        File file = new File("src/main/resources/no/ntnu/candidate/exam/file/Postnummerregister-ansi.txt");

        if(file != null) {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));

                String cols;
                while ((cols = br.readLine()) != null) {
                    String[] fields = cols.split("\t");
                    par.getAddresses().add(new PostalAddress(fields[0], fields[1],fields[2],fields[3],fields[4]));
                }
            }catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}