/*
TODO:
- Make the TextFields only take in numbers
- Make all the numbers go only to 3 decimal places
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class InvestmentAssetCalculator extends Application {

    private BorderPane mainLayout;
    // Line Chart
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private LineChart<Number, Number> lineChart;
    // Input Fields
    private HBox inputFields;
    // Starting Amount
    private VBox startingAmount;
    private Label startingAmountLabel;
    private TextField startingAmountField;
    // Yearly Contribution
    private VBox monthlyContribution;
    private Label monthlyContributionLabel;
    private TextField monthlyContributionField;
    // Rate of Return
    private VBox ror;
    private Label rorLabel;
    private TextField rorField;
    // Years to Grow
    private VBox yearsToGrow;
    private Label yearsToGrowLabel;
    private TextField yearsToGrowField;
    // Calculate Button
    private Button calculateButton;

    public void init() {
        this.mainLayout = new BorderPane();
        // Line Chart
        this.xAxis = new NumberAxis();
        xAxis.setLabel("Year");
        this.yAxis = new NumberAxis();
        yAxis.setLabel("Dollars ($)");
        this.lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        mainLayout.setCenter(lineChart);
        // Input Fields
        this.inputFields = new HBox();
        // Starting Amount
        this.startingAmount = new VBox();
        this.startingAmountLabel = new Label("Starting Amount:");
        this.startingAmountField = new TextField();
        startingAmount.getChildren().addAll(startingAmountLabel, startingAmountField);
        // Monthly Contribution
        this.monthlyContribution = new VBox();
        this.monthlyContributionLabel = new Label("Monthly Contribution:");
        this.monthlyContributionField = new TextField();
        monthlyContribution.getChildren().addAll(monthlyContributionLabel, monthlyContributionField);
        // Rate of Return
        this.ror = new VBox();
        this.rorLabel = new Label("Rate of Return:");
        this.rorField = new TextField();
        ror.getChildren().addAll(rorLabel, rorField);
        // Years to Grow
        this.yearsToGrow = new VBox();
        this.yearsToGrowLabel = new Label("Years to Grow:");
        this.yearsToGrowField = new TextField();
        yearsToGrow.getChildren().addAll(yearsToGrowLabel, yearsToGrowField);
        // Calculate Button
        this.calculateButton = new Button("Calculate");



        inputFields.getChildren().addAll(startingAmount, monthlyContribution, ror, yearsToGrow, calculateButton);
        mainLayout.setTop(inputFields);
        calculateButton.setOnAction((event) -> {
            lineChart.getData().clear();
            XYChart.Series data = addToChart(Double.parseDouble(startingAmountField.getText()), Double.parseDouble(monthlyContributionField.getText()), Double.parseDouble(rorField.getText()), Integer.parseInt(yearsToGrowField.getText()));
            lineChart.getData().add(data);
                }
        );
    }

    public static void main(String[] args) {
        launch(InvestmentAssetCalculator.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Scene scene = new Scene(this.mainLayout, 600, 500);
        window.setScene(scene);
        window.show();
    }

    private XYChart.Series addToChart(double startingAmount, double monthlyContribution, double ror, int yearsToGrow) {
        double num = 0;
        DecimalFormat df = new DecimalFormat("#.###");
        XYChart.Series data = new XYChart.Series<>();
        data.setName("Assets");
        for (int i = 0; i <= yearsToGrow; i += 1) {
            double rateOfReturn = (Double.parseDouble(rorField.getText()) / 100) + 1;
            String temp = df.format((num + 12 * Integer.parseInt(monthlyContributionField.getText())) * rateOfReturn);
            double doubleTemp = Double.parseDouble(temp);
            data.getData().add(new XYChart.Data(i, doubleTemp));
            num = doubleTemp;
        }
        return data;

    }

}
