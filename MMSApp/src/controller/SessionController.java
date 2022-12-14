package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import javafx.application.*;
import javafx.scene.image.Image;
import model.*;
import javafx.stage.*;
import javafx.fxml.*;
import javafx.event.*;


public class SessionController extends Controller<Session>
{
    @FXML
    private void login(ActionEvent event) throws Exception
    {
        Stage newStage = new Stage();
        newStage.getIcons().add(new Image("view/img/book.png"));
        ViewLoader.showStage(new Session(), "/view/MMSlogin.fxml", "MMS - SuperMarket Mode", newStage);
    }
    
    @FXML
    private void exit(ActionEvent event)
    {
        Platform.exit();
        System.exit(0);
    }
}
