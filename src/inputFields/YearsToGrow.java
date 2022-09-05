package inputFields;

/**
 * Represents how long you want the investment to grow.
 */
public class YearsToGrow extends AInputField {
    /**
     * Creates a years to grow field.
     *
     * @param description the label of the field.
     */
    public YearsToGrow(String description) {
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
