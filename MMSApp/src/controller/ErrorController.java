package controller;

import au.edu.uts.ap.javafx.Controller;
import model.InputException;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.InputEvent;
import javafx.scene.text.*;
import model.InputException;
import model.Membership;
import model.SuperMarket;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;

public class ErrorController extends Controller<InputException>
{
    @FXML
    private Label errorLbl;

    @FXML
    private void initialize()
    {
        errorLbl.setText(model.getMessage());
    }

    @FXML
    private void okay(ActionEvent event)
    {
        stage.close();
    }
}
