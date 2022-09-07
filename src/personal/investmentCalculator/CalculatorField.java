package personal.investmentCalculator;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Abstract class to represent an InputField.
 */
public class CalculatorField extends VBox {
    protected Label description;
    protected TextField input;

    /**
     * Creates an AInputField with the given label.
     *
     * @param description the label of the field.
     */
    public CalculatorField(String description, String regex) {
        this.description = new Label(description);
        this.input = new TextField();
        this.getChildren().addAll(this.description, this.input);
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(regex)) {
                input.setText(newValue.replaceAll("[^" + regex + "]", ""));
            }
        });
    }

    /**
     * Converts the TextField to a double.
     * Sets the number to 0 if there is nothing.
     * If the decimal point is the last digit, it removes it.
     *
     * @return the number in the TextField
     */
    public double getTextToNum() {
        String text = input.getText();
        if (text.isEmpty()) {
            return 0;
        } else if (text.charAt(text.length() - 1) == '.') {
            text = text.substring(0, text.length() - 1);
        }
        return Double.parseDouble(text);
    }
}
