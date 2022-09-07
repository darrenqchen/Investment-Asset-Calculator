package personal.investmentCalculator.inputFields;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Abstract class to represent an InputField.
 */
public abstract class AInputField extends Node {
    protected VBox inputGroup;
    protected Label description;
    protected TextField input;

    /**
     * Creates an AInputField with the given label.
     *
     * @param description the label of the field.
     */
    public AInputField(String description) {
        this.inputGroup = new VBox();
        this.description = new Label(description);
        this.input = new TextField();
        this.inputGroup.getChildren().addAll(this.description, this.input);
    }

    public String getText() {
        return this.input.getText();
    }
    public double removeDecimalLastDigit(String text) {
        if (text.charAt(text.length() - 1) == '.') {
            text = text.substring(0, text.length() - 1);
        }
        return Double.parseDouble(text);
    }

    public Parent getBox() {
        return inputGroup;
    }
}
