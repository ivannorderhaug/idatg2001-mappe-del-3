package no.ntnu.candidate.exam.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.candidate.exam.model.PostalAddress;
import no.ntnu.candidate.exam.model.PostalAddressRegister;

import java.util.List;
import java.util.stream.Collectors;

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
    private TableColumn<PostalAddress, String> colTown;

    private PostalAddressRegister par;



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        /* Configures Table View */
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colTown.setCellValueFactory(new PropertyValueFactory<>("town"));
        colCountyNumber.setCellValueFactory(new PropertyValueFactory<>("countyNumber"));
        colCounty.setCellValueFactory(new PropertyValueFactory<>("county"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        colPostalCode.setReorderable(false);
        colTown.setReorderable(false);
        colCountyNumber.setReorderable(false);
        colCounty.setReorderable(false);
        colCategory.setReorderable(false);

        //Instantiates new PostalAddressRegister
        par = new PostalAddressRegister();
        par.readFromFile("/no/ntnu/candidate/exam/file/Postnummerregister-ansi.txt");

        tableView.setItems(par.getAddresses());

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            search(newValue);
        });
    }

    /**
     * Search method for finding postal addresses that matches the criteria(parameter).
     * @param parameter
     */
    void search(String parameter){

        if(!parameter.equals("") && !parameter.isEmpty()){
            List<PostalAddress> result = par.getAddresses().stream().filter(
                    postalAddress -> postalAddress.getPostalCode().startsWith(parameter.toUpperCase()) ||
                            postalAddress.getTown().startsWith(parameter.toUpperCase()) ||
                            postalAddress.getCountyNumber().startsWith(parameter.toUpperCase()) ||
                            postalAddress.getCounty().startsWith(parameter.toUpperCase())).collect(Collectors.toList());

            tableView.setItems(FXCollections.observableList(result));

        } else {
            //Shows all addresses
            tableView.setItems(par.getAddresses());
        }

    }


}