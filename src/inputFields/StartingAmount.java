package inputFields;

/**
 * Represents the starting amount you put in.
 */
public class StartingAmount extends AInputField {

    /**
     * Creates a starting amount field.
     */
    public StartingAmount() {
        super("Starting Amount:");
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                input.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
