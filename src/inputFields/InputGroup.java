package inputFields;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class InputGroup {

    private HBox inputFields;
    private AInputField startingAmount;
    private AInputField monthlyContribution;
    private AInputField rateOfReturn;
    private AInputField yearsToGrow;
    private Button calculateButton;

    public InputGroup() {
        this.inputFields = new HBox();
        this.startingAmount = new StartingAmount();
        this.monthlyContribution = new MonthlyContribution();
        this.rateOfReturn = new RateOfReturn();
        this.yearsToGrow = new YearsToGrow();
        this.calculateButton = new Button("Calculate");
        inputFields.getChildren().addAll(startingAmount, monthlyContribution, ror, yearsToGrow, calculateButton);
        inputFields.setAlignment(Pos.BOTTOM_CENTER);
        inputFields.setSpacing(10);
        inputFields.setPadding(new Insets(0, 10, 0, 10));
    }

}
