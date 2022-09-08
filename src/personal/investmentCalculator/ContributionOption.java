package personal.investmentCalculator;

import javafx.scene.control.ComboBox;

public class ContributionOption<String> extends ComboBox {

    public ContributionOption() {
        this.getItems().addAll("Monthly", "Yearly");
    }
}
