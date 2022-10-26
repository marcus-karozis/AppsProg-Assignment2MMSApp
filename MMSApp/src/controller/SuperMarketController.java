package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.*;
import model.MMS;
import model.MMSreport;
import model.Membership;
import model.SuperMarket;
import javafx.fxml.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.*;
import javafx.stage.*;


public class SuperMarketController extends Controller<SuperMarket>
{
    @FXML
    private TableView<Membership> smTable;
    @FXML
    private TableColumn<Membership, String> nameClm;
    @FXML
    private TableColumn<Membership, String> emailClm;
    @FXML
    private TableColumn<Membership, String> phoneClm;

    @FXML
    private TextField nameFilterTf;
    @FXML
    private TextField emailFilterTf;

    @FXML
    private Button deleteBtn;
    @FXML
    private Button selectBtn;
    @FXML
    private Button slipBtn;

    @FXML
    private void initialize()
    {
        smTable.setItems(model.getMemberships());
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailClm.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneClm.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

        nameFilterTf.textProperty()
                .addListener((o, oldFilter, newFilter) -> model.filterList(newFilter, "*"));
        emailFilterTf.textProperty()
                .addListener((o, oldFilter, newFilter) -> model.filterList("*", newFilter));

        smTable.prefHeightProperty().bind(stage.heightProperty());
        smTable.prefWidthProperty().bind(stage.widthProperty());

        nameClm.prefWidthProperty().bind(smTable.widthProperty().divide(3));
        emailClm.prefWidthProperty().bind(smTable.widthProperty().divide(3));
        phoneClm.prefWidthProperty().bind(smTable.widthProperty().divide(3));
        
        smTable.getSelectionModel().selectedItemProperty().addListener(
            (o, oldMem, newMem) -> deleteBtn.setDisable(model.getMemberships() == null));
        smTable.getSelectionModel().selectedItemProperty().addListener(
            (o, oldMem, newMem) -> selectBtn.setDisable(model.getMemberships() == null));
        smTable.getSelectionModel().selectedItemProperty().addListener(
            (o, oldMem, newMem) -> slipBtn.setDisable(model.getMemberships() == null));
    }
    
    @FXML
    private void add(ActionEvent event) throws Exception
    {
        Membership newMember = new Membership(null, null, null, null, null, 0);
        newMember.setSuperMarket(model);
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("view/img/edit.png"));
        ViewLoader.showStage(newMember, "/view/Membership.fxml", "Adding New Membership",
                newStage);
    }
    
    @FXML
    private void delete(ActionEvent event)
    {
        model.removeMembership(smTable.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void select(ActionEvent event) throws Exception
    {
        smTable.getSelectionModel().getSelectedItem().setSuperMarket(model);
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("view/img/edit.png"));
        ViewLoader.showStage(smTable.getSelectionModel()
                .getSelectedItem(), "/view/Membership.fxml", "Accessing File: "+smTable.getSelectionModel().getSelectedItem().getName(),
                newStage);
    }
    
    @FXML
    private void slip(ActionEvent event) throws Exception
    {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("view/img/edit.png"));
        ViewLoader.showStage(new MMSreport(smTable.getSelectionModel()
                .getSelectedItem()), "/view/slip.fxml", 
                smTable.getSelectionModel().getSelectedItem().getName()+" SLIP Report",
                newStage);
    }
    
    @FXML
    private void report(ActionEvent event) throws Exception
    {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("view/img/uts.jpeg"));
        ViewLoader.showStage(new MMS(model), "/view/mms.fxml", "MMS Report",
                newStage);
    }
    
    @FXML
    private void close(ActionEvent event)
    {
        stage.close();
    }

}
