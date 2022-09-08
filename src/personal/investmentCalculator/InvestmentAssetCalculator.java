package personal.investmentCalculator;
/*
TODO:
- Make the graph show the x and y data point if you hover over the point
- Add the different balances (end balance, invested balance, interest accrued)
- Add a table
 */


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Represents the InvestmentAssetCalculator application
 */
public class InvestmentAssetCalculator extends Application {

    private BorderPane mainLayout;
    private LineGraph lineGraph;
    private HBox inputFields;
    private CalculatorField startingAmount;
    private CalculatorField contributionField;
    private ComboBox<String> contributionOption;
    private CalculatorField rateOfReturn;
    private CalculatorField yearsToGrow;
    private Button calculateButton;

    /**
     * Initializes all the variables of the application
     */
    public void init() {
        this.mainLayout = new BorderPane();
        this.lineGraph = new LineGraph();
        mainLayout.setCenter(lineGraph);
        this.inputFields = new HBox();
        this.startingAmount = new CalculatorField("Starting Amount:", "\\d{0,8}");
        this.contributionField = new CalculatorField("Contribution:", "\\d{0,6}");

        this.contributionOption = new ComboBox<>();
        contributionOption.getItems().addAll(
                "Monthly",
                "Yearly");
        contributionOption.getSelectionModel().selectFirst();

        this.rateOfReturn = new CalculatorField("Rate of Return:", "\\d{0,2}(\\.\\d{0,3})?");
        this.yearsToGrow = new CalculatorField("Years to Grow:", "\\d{0,2}");
        this.calculateButton = new Button("Calculate");

        inputFields.getChildren().addAll(
                startingAmount,
                contributionField,
                contributionOption,
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
                            (int) contributionField.getTextToNum(),
                            contributionOption.getValue(),
                            rateOfReturn.getTextToNum(),
                            ytg);
                }
        );
    }

    public static void main(String[] args) {
        launch(InvestmentAssetCalculator.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Scene scene = new Scene(this.mainLayout);
        window.setScene(scene);
        window.show();
    }

}
