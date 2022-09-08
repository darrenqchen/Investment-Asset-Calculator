package personal.investmentCalculator;

import javafx.scene.control.ComboBox;

/**
 * Represents a ComboBox for the monthly or yearly option.
 *
 * @param <String> Makes sure it is a String.
 */
public class ContributionOption<String> extends ComboBox {

    /**
     * Creates a ContributionOption with the monthly and yearly option already in there.
     */
    public ContributionOption() {
        this.getItems().addAll(
                "Monthly",
                "Yearly");
        this.getSelectionModel().selectFirst();
    }
}
