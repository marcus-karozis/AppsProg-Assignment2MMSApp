package controller;

import java.io.Console;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.*;
import javafx.stage.*;
import model.*;
import javafx.fxml.*;
import javafx.event.*;

public class MMSLoginController extends Controller<Session>
{
    @FXML
    private TextField usrTf;
    @FXML
    private PasswordField passTf;
    @FXML
    private Label errorLbl;

    @FXML
    private void initialize()
    {
        errorLbl.setVisible(false);
    }

    @FXML
    private void ok(ActionEvent event) throws Exception
    {
        SuperMarket sm = model.getSuperMarket(usrTf.getText(), passTf.getText());
        if (sm != null)
        {
            errorLbl.setVisible(false);
            passTf.setText("");
            model.setSuperMarket(sm);
            Stage newStage = new Stage();
            newStage.getIcons().add(new Image("view/img/SuperMarket.png"));
            ViewLoader.showStage(sm, "/view/SuperMarket.fxml", "Session Admin: "+ sm.getName(),
                    newStage);

        }
        else
        {
            errorLbl.setVisible(true);
        }
       
    }

    @FXML
    private void cancel(ActionEvent event)
    {
        stage.close();
    }
}

