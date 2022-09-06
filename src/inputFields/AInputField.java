package inputFields;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Abstract class to represent an InputField.
 */
public abstract class AInputField {
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
}
