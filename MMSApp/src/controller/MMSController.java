package controller;


import java.text.*;
import au.edu.uts.ap.javafx.Controller;

import javafx.scene.control.*;
import javafx.scene.text.*;
import model.MMS;
import model.MMSreport;
import javafx.fxml.*;
import javafx.event.*;


public class MMSController extends Controller<MMS>
{
    @FXML
    private TableView<MMSreport> mmsTable;
    @FXML
    private TableColumn<MMSreport, String> nameClm;
    @FXML
    private TableColumn<MMSreport, String> typeClm;
    @FXML
    private TableColumn<MMSreport, String> expenceClm;
    @FXML
    private TableColumn<MMSreport, String> creditClm;
    @FXML
    private TableColumn<MMSreport, String> gasdeductionRateClm;
    @FXML
    private TableColumn<MMSreport, String> deductionRateClm;
    @FXML
    private TableColumn<MMSreport, String> payPerCreditClm;
    @FXML
    private TableColumn<MMSreport, String> dollarAvailableClm;

    @FXML
    private Text totalExpenceTxt;
    @FXML
    private Text totalCreditsTxt;
    @FXML
    private Text gasdeductionTxt;
    @FXML
    private Text deductionTxt;
    @FXML
    private Text ppcTxt;
    @FXML
    private Text dollarAvailableTxt;

    @FXML
    private void initialize()
    {
        mmsTable.setItems(model.reports());
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        expenceClm.setCellValueFactory(cellData -> cellData.getValue().expenseProperty().asString("$%.2f"));
        creditClm.setCellValueFactory(cellData -> cellData.getValue().totalCreditsProperty().asString("%.2f"));
        gasdeductionRateClm.setCellValueFactory(cellData -> cellData.getValue().GasdeductionRateProperty().asString("%.2f"));
        deductionRateClm.setCellValueFactory(cellData -> cellData.getValue().deductionRateProperty().asString("%.2f"));
        payPerCreditClm.setCellValueFactory(cellData -> cellData.getValue().PayPerCreditProperty().asString("%.2f"));
        dollarAvailableClm.setCellValueFactory(cellData -> cellData.getValue().DollarAvailableProperty().asString("$%.2f"));

        mmsTable.prefHeightProperty().bind(stage.heightProperty());
        mmsTable.prefWidthProperty().bind(stage.widthProperty());

        nameClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        typeClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        expenceClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        creditClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        gasdeductionRateClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        deductionRateClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        payPerCreditClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));
        dollarAvailableClm.prefWidthProperty().bind(mmsTable.widthProperty().divide(8));


        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat dollarFormat = new DecimalFormat("$######0.00", dfs);
        DecimalFormat standardFormat = new DecimalFormat("######0.00", dfs);

        totalCreditsTxt.setText(standardFormat.format(model.getTotalCredits()));
        totalExpenceTxt.setText(dollarFormat.format(model.getTotalExpense()));
        gasdeductionTxt.setText(standardFormat.format(model.getAvgGasdeductionRate()));
        ppcTxt.setText(standardFormat.format(model.getAvgPayPerCredit()));
        dollarAvailableTxt.setText(dollarFormat.format(model.getTotalDollarAvailable()));
        deductionTxt.setText(standardFormat.format(model.getAvgdeductionRate()));
    }

    @FXML
    private void close(ActionEvent event)
    {
        stage.close();
    }
}
