package personal.investmentCalculator;
/*
TODO:
- Add a yearly option too
- Make the graph show the x and y data point if you hover over the point
- Add a table
- Switch to an OO design
 */


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class OLDInvestmentAssetCalculator extends Application {

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
        //xAxis.setMinorTickVisible(false);
        this.yAxis = new NumberAxis();
        yAxis.setLabel("Dollars ($)");
        //yAxis.setMinorTickVisible(false);
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
        this.rorLabel = new Label("Rate of Return (%):");
        this.rorField = new TextField();
        ror.getChildren().addAll(rorLabel, rorField);
        // Years to Grow
        this.yearsToGrow = new VBox();
        this.yearsToGrowLabel = new Label("Years to Grow:");
        this.yearsToGrowField = new TextField();
        yearsToGrow.getChildren().addAll(yearsToGrowLabel, yearsToGrowField);
        //Calculate Button
        this.calculateButton = new Button("Calculate");

        inputFields.getChildren().addAll(startingAmount, monthlyContribution, ror, yearsToGrow, calculateButton);
        inputFields.setAlignment(Pos.BOTTOM_CENTER);
        inputFields.setSpacing(10);
        inputFields.setPadding(new Insets(0, 10, 0, 10));
        mainLayout.setTop(inputFields);

        startingAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,8}")) {
                startingAmountField.setText(oldValue);
            }
        });

        monthlyContributionField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,6}")) {
                monthlyContributionField.setText(oldValue);
            }
        });
        rorField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,2}(\\.\\d{0,3})?")) {
                rorField.setText(oldValue);
            }
        });

        yearsToGrowField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,2}")) {
                yearsToGrowField.setText(oldValue);
            }
        });

        calculateButton.setOnAction((event) -> {
                    int ytg = (int) zeroIfEmpty(yearsToGrowField.getText());
                    xAxis = new NumberAxis(0, ytg, 1);
                    yAxis = yAxis;
                    lineChart = new LineChart<>(xAxis, yAxis);
                    lineChart.getData().clear();
                    XYChart.Series data = addToChart((int) zeroIfEmpty(startingAmountField.getText()), (int) zeroIfEmpty(monthlyContributionField.getText()), zeroIfEmpty(rorField.getText()), ytg);
                    lineChart.getData().add(data);
                    mainLayout.setCenter(lineChart);
                }
        );

    }

    public static void main(String[] args) {
        launch(OLDInvestmentAssetCalculator.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Scene scene = new Scene(this.mainLayout);
        window.setScene(scene);
        window.show();
    }

    private XYChart.Series addToChart(int startingAmount, int monthlyContribution, double ror, int yearsToGrow) {
        double num = startingAmount;
        DecimalFormat df = new DecimalFormat("#.###");
        XYChart.Series data = new XYChart.Series();
        data.setName("Assets");
        data.getData().add(new XYChart.Data(0, startingAmount));
        for (int i = 1; i <= yearsToGrow; i += 1) {
            double rateOfReturn = (ror / 100) + 1;
            String temp = df.format((num + 12 * monthlyContribution) * rateOfReturn);
            double doubleTemp = Double.parseDouble(temp);
            data.getData().add(new XYChart.Data(i, doubleTemp));
            num = doubleTemp;
        }
        return data;

    }

    private double removeDecimalLastDigit(String text) {
        if (text.charAt(text.length() - 1) == '.') {
            text = text.substring(0, text.length() - 1);
        }
        return Double.parseDouble(text);
    }

    private double zeroIfEmpty(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(text);
    }

}
