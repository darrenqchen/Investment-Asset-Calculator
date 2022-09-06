package inputFields;

/**
 * Represents the rate of return every year.
 */
public class RateOfReturn extends AInputField {
    /**
     * Creates a rate of return field.
     */
    public RateOfReturn() {
        super("Rate of Return:");
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d{0,3})?")) {
                input.setText(oldValue);
            }
        });
    }
}
