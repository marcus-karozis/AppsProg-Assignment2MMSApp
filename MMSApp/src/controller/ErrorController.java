package controller;

import au.edu.uts.ap.javafx.Controller;
import model.InputException;
import javafx.scene.control.*;
import javafx.fxml.*;
import javafx.event.*;


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
