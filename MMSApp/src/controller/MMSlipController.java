package controller;

import java.text.DecimalFormat;
import java.text.*;
import java.util.*;
import au.edu.uts.ap.javafx.Controller;

import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.MMSreport;
import model.Membership;
import model.SuperMarket;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;

public class MMSlipController extends Controller<MMSreport>
{
    @FXML
    private Text totalCreditsTxt;
    @FXML
    private Text totalExpenceTxt;
    @FXML
    private Text gasdeductionTxt;
    @FXML
    private Text ppcTxt;
    @FXML
    private Text dollarAvailableTxt;
    @FXML
    private Text deductionTxt;

    @FXML
    private void initialize()
    {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat dollarFormat = new DecimalFormat("$######0.00", dfs);
        DecimalFormat standardFormat = new DecimalFormat("######0.00", dfs);

        totalCreditsTxt.setText(standardFormat.format(model.gettotalCredits()));
        totalExpenceTxt.setText(dollarFormat.format(model.getexpense()));
        gasdeductionTxt.setText(standardFormat.format(model.getGasdeductionRate()));
        ppcTxt.setText(standardFormat.format(model.getPayPerCredit()));
        dollarAvailableTxt.setText(dollarFormat.format(model.getDollarAvailable()));
        deductionTxt.setText(standardFormat.format(model.getdeductionRate()));
    }

    @FXML
    private void close(ActionEvent event)
    {
        stage.close();
    }
}
