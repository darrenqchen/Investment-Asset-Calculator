package inputFields;

/**
 * Represents the contribution you put in every month.
 */
public class MonthlyContribution extends AInputField {
    /**
     * Creates a monthly contribution field.
     *
     * @param description the label of the field.
     */
    public MonthlyContribution(String description) {
        super(description);
    }

    @Override
    public void activateField() {
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                input.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}