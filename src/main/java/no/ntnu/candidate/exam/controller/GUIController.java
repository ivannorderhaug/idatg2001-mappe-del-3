package no.ntnu.candidate.exam.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import no.ntnu.candidate.exam.model.PostalAddress;
import no.ntnu.candidate.exam.model.PostalAddressRegister;

import java.util.List;
import java.util.stream.Collectors;

public class GUIController {

    @FXML
    private TableColumn<PostalAddress, String> colMunicipalityNumber;

    @FXML
    private TableColumn<PostalAddress, String> colPostalCode;

    @FXML
    private TextField searchBar;

    @FXML
    private TableColumn<PostalAddress, String> colMunicipality;

    @FXML
    private TableView<PostalAddress> tableView;

    @FXML
    private TableColumn<PostalAddress, String> colCategory;

    @FXML
    private TableColumn<PostalAddress, String> colTown;

    private PostalAddressRegister par;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        /* Configures Table View */
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colTown.setCellValueFactory(new PropertyValueFactory<>("town"));
        colMunicipalityNumber.setCellValueFactory(new PropertyValueFactory<>("municipalityNumber"));
        colMunicipality.setCellValueFactory(new PropertyValueFactory<>("municipality"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        colPostalCode.setReorderable(false);
        colTown.setReorderable(false);
        colMunicipalityNumber.setReorderable(false);
        colMunicipality.setReorderable(false);
        colCategory.setReorderable(false);

        //Instantiates new PostalAddressRegister
        par = new PostalAddressRegister();
        par.readFromFile("/no/ntnu/candidate/exam/file/Postnummerregister-ansi.txt");

        tableView.setItems(par.getAddresses());

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {

            searchBar.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.ENTER){
                    exactSearch();
                }
            });
            search(newValue);


        });
    }
    /**
     * Search method for finding postal addresses or postal codes that matches the search input exactly.
     */
    @FXML
    void exactSearch(){
        if(!searchBar.getText().equals("") && !searchBar.getText().isEmpty()){
            List<PostalAddress> result = par.getAddresses().stream().filter(
                    postalAddress -> postalAddress.getPostalCode().equalsIgnoreCase(searchBar.getText()) || postalAddress.getTown().equalsIgnoreCase(searchBar.getText())).collect(Collectors.toList());

            tableView.setItems(FXCollections.observableList(result));

        }
    }

    /**
     * Search method for finding postal addresses or postal codes that starts with @param
     * @param s
     */
    void search(String s){

        if(!s.equals("") && !s.isEmpty()){
            List<PostalAddress> result = par.getAddresses().stream().filter(
                    postalAddress -> postalAddress.getPostalCode().startsWith(s.toUpperCase()) || postalAddress.getTown().startsWith(s.toUpperCase())).collect(Collectors.toList());

            tableView.setItems(FXCollections.observableList(result));

        } else {
            //Shows all addresses
            tableView.setItems(par.getAddresses());
        }

    }


}