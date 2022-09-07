//package personal.investmentCalculator.inputFields;
//
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
//
//public class InputGroup {
//
//    private HBox inputFields;
//    private AInputField startingAmount;
//    private AInputField monthlyContribution;
//    private AInputField rateOfReturn;
//    private AInputField yearsToGrow;
//    private Button calculateButton;
//
//    public InputGroup() {
//        this.inputFields = new HBox();
//        this.startingAmount = new StartingAmount();
//        this.monthlyContribution = new MonthlyContribution();
//        this.rateOfReturn = new RateOfReturn();
//        this.yearsToGrow = new YearsToGrow();
//        this.calculateButton = new Button("Calculate");
//        inputFields.getChildren().addAll(startingAmount.getBox(), monthlyContribution.getBox(), rateOfReturn.getBox(), yearsToGrow.getBox(), calculateButton);
//        inputFields.setAlignment(Pos.BOTTOM_CENTER);
//        inputFields.setSpacing(10);
//        inputFields.setPadding(new Insets(0, 10, 0, 10));
//        calculateButton.setOnAction((event) -> {
//                    int ytg = Integer.parseInt(yearsToGrow.getText());
//                    TrendGraph graph = new TrendGraph()
//                    // CHECK WHY I COMMENTED THE NEXT 4 LINES OUT
//                    xAxis = new NumberAxis(0, ytg, 1);
//                    NumberAxis yAxis = new NumberAxis();
//                    lineChart = new LineChart<>(xAxis, yAxis);
//                    lineChart.getData().clear();
//                    XYChart.Series data = addToChart(Integer.parseInt(startingAmountField.getText()), Integer.parseInt(monthlyContributionField.getText()), removeDecimalLastDigit(rorField.getText()), ytg);
//                    lineChart.getData().add(data);
//                }
//        );
//    }
//
//}
