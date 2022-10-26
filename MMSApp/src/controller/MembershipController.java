package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.text.*;
import model.InputException;
import model.Membership;
import model.SuperMarket;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;

public class MembershipController extends Controller<Membership>
{
    private Validator v = new Validator();


    @FXML
    private TextField nameTf;
    @FXML
    private TextField emailTf;
    @FXML
    private TextField phoneTf;
    @FXML
    private TextField addressTf;
    @FXML
    private TextField idTf;
    @FXML
    private TextField expenceTf;
    @FXML
    private Text typeTxt;


    @FXML
    private Button addBtn;
    @FXML
    private Button updateBtn;

    @FXML
    private void initialize()
    {
        if(model.getName() == null)
        {
            updateBtn.setDisable(true);
        }
        else
        {
            addBtn.setDisable(true);
            nameTf.setText(model.getName());
            emailTf.setText(model.getEmail());
            phoneTf.setText(model.getPhone());
            addressTf.setText(model.getAddress());
            idTf.setText(model.getID());
            expenceTf.setText(String.valueOf(model.getexpense()));
            typeTxt.setText(model.getType());
        }
    }

    @FXML
    private void add(ActionEvent event) throws Exception
    {
        double expence;
        if (expenceTf.getText().isEmpty())
        {
            expence = 0;
        }
        else
        {
            expence = Double.valueOf(expenceTf.getText());
        }

        if (v.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(),
                idTf.getText(), expence))
        {
            model.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), expence);
            model.getSuperMarket().addMembership(model);
            stage.close();
        }
        else
        {
            v.generateErrors(nameTf.getText(), emailTf.getText(), phoneTf.getText(),
                    addressTf.getText(), idTf.getText(), expence);
            Stage newStage = new Stage();
            newStage.getIcons().add(new Image("view/img/error.png"));
            ViewLoader.showStage(new InputException(String.join("", v.errors())), "/view/error.fxml", "Input Exceptions", 
                    newStage);
            v.clear();
        }
    }
    
    @FXML
    private void update(ActionEvent event) throws Exception
    {
        double expence;
        if (expenceTf.getText().isEmpty())
        {
            expence = 0;
        }
        else
        {
            expence = Double.valueOf(expenceTf.getText());
        }

        if (v.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(),
                idTf.getText(), expence))
        {
            model.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(),
                    addressTf.getText(), idTf.getText(), expence);
            stage.close();
        }
        else
        {
            v.generateErrors(nameTf.getText(), emailTf.getText(), phoneTf.getText(),
                    addressTf.getText(), idTf.getText(), expence);
            Stage newStage = new Stage();
            newStage.getIcons().add(new Image("view/img/error.png"));
            ViewLoader.showStage(new InputException(String.join("", v.errors())),
                    "/view/error.fxml", "Input Exceptions", newStage);
            v.clear();
        }
    }
    
    @FXML
    private void close(ActionEvent event)
    {
        stage.close();
    }
}
