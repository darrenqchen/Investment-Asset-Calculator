package personal.investmentCalculator.inputFields;

/**
 * Represents how long you want the investment to grow.
 */
public class YearsToGrow extends AInputField {
    /**
     * Creates a years to grow field.
     */
    public YearsToGrow() {
        super("Years to Grow:");
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                input.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
