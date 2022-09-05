package inputFields;

/**
 * Represents the rate of return every year.
 */
public class RateOfReturn extends AInputField {
    /**
     * Creates a rate of return field.
     *
     * @param description the label of the field.
     */
    public RateOfReturn(String description) {
        super(description);
    }

    @Override
    public void activateField() {
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d{0,3})?")) {
                input.setText(oldValue);
            }
        });

    }
}
