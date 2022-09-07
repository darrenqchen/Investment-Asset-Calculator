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
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InvestmentAssetCalculator extends Application {

    private BorderPane mainLayout;
    private LineGraph lineGraph;
    private HBox inputFields;
    private CalculatorField startingAmount;
    private CalculatorField monthlyContribution;
    private CalculatorField rateOfReturn;
    private CalculatorField yearsToGrow;
    private Button calculateButton;

    public void init() {
        this.mainLayout = new BorderPane();
        this.lineGraph = new LineGraph();
        mainLayout.setCenter(lineGraph);
        this.inputFields = new HBox();
        this.startingAmount = new CalculatorField("Starting Amount:", "\\d{0,8}");
        this.monthlyContribution = new CalculatorField("Monthly Contribution:", "\\d{0,6}");
        this.rateOfReturn = new CalculatorField("Rate of Return:", "\\d{0,2}(\\.\\d{0,3})?");
        this.yearsToGrow = new CalculatorField("Years to Grow:", "\\d{0,2}");
        this.calculateButton = new Button("Calculate");

        inputFields.getChildren().addAll(
                startingAmount,
                monthlyContribution,
                rateOfReturn,
                yearsToGrow,
                calculateButton);

        inputFields.setAlignment(Pos.BOTTOM_CENTER);
        inputFields.setSpacing(10);
        inputFields.setPadding(new Insets(0, 10, 0, 10));
        mainLayout.setTop(inputFields);

        calculateButton.setOnAction((event) -> {
                    int ytg = (int) yearsToGrow.getTextToNum();
                    lineGraph.setXAxis(ytg);
                    lineGraph.getData().clear();
                    lineGraph.addEndBalance(
                            (int) startingAmount.getTextToNum(),
                            (int) monthlyContribution.getTextToNum(),
                            rateOfReturn.getTextToNum(),
                            ytg);
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

}
