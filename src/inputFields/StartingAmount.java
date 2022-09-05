package inputFields;

/**
 * Represents the starting amount you put in.
 */
public class StartingAmount extends AInputField {

    /**
     * Creates a starting amount field.
     *
     * @param description the label of the field.
     */
    public StartingAmount(String description) {
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
