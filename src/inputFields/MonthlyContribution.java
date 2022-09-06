package inputFields;

/**
 * Represents the contribution you put in every month.
 */
public class MonthlyContribution extends AInputField {
    /**
     * Creates a monthly contribution field.
     */
    public MonthlyContribution() {
        super("Monthly Contribution:");
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                input.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}