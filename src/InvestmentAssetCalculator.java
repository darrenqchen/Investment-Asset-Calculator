


import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InvestmentAssetCalculator extends Application {

    private BorderPane mainLayout;
    private BorderPane msLayout;
    private Label msLabel
    private Slider msSlider;
    private Label msTickLabel;
    private BorderPane irLayout;
    private Label irLabel;
    private Slider irSlider;
    private Label irTickLabel;
    private VBox sliders;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private LineChart<Number, Number> lineChart;

    public void init() {
        this.mainLayout = new BorderPane();

        // monthly savings slider
        this.msLayout = new BorderPane();

        this.msLabel = new Label("Monthly savings");
        msLayout.setLeft(msLabel);

        this.msSlider = new Slider(25, 250, 25);
        msLayout.setCenter(msSlider);
        msSlider.setShowTickLabels(true);
        msSlider.setShowTickMarks(true);
        msSlider.setSnapToTicks(true);

        this.msTickLabel = new Label("25");
        msLayout.setRight(msTickLabel);

        msSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            msTickLabel.setText(String.valueOf(newVal.intValue()));
            lineChart.getData().clear();
            lineChart.getData().addAll(getSavingsData(), getInterestData());
        });

        // yearly interest rate slider
        this.irLayout = new BorderPane();

        this.irLabel = new Label("Yearly interest rate");
        irLayout.setLeft(irLabel);

        this.irSlider = new Slider(0, 10, 0);
        irLayout.setCenter(irSlider);
        irSlider.setShowTickLabels(true);
        irSlider.setShowTickMarks(true);
        irSlider.setSnapToTicks(true);

        this.irTickLabel = new Label("0");
        irLayout.setRight(irTickLabel);

        irSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            irTickLabel.setText(new DecimalFormat("#.##").format(newVal));
            lineChart.getData().clear();
            lineChart.getData().addAll(getSavingsData(), getInterestData());
        });

        // vbox sliders
        this.sliders = new VBox();
        mainLayout.setTop(sliders);
        sliders.getChildren().addAll(msLayout, irLayout);

        // line chart
        this.xAxis = new NumberAxis(0, 30, 1);
        this.yAxis = new NumberAxis();

        this.lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        mainLayout.setCenter(lineChart);
    }

    public static void main(String[] args) {
        launch(InvestmentAssetCalculator.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Scene scene = new Scene(this.mainLayout, 600, 500);
        window.setScene(scene);
        window.show();
    }

    private XYChart.Series getSavingsData() {
        XYChart.Series data = new XYChart.Series<>();
        data.setName("Savings");
        for (int i = 0; i <= 30; i += 1) {
            data.getData().add(new XYChart.Data(i, 12 * i * Integer.parseInt(msTickLabel.getText())));
        }
        return data;
    }

    private XYChart.Series getInterestData() {
        double num = 0;
        DecimalFormat df = new DecimalFormat("#.###");
        XYChart.Series data = new XYChart.Series<>();
        data.setName("Interest");
        for (int i = 0; i <= 30; i += 1) {
            String temp = df.format((num + 12 * Integer.parseInt(msTickLabel.getText())) * Double.parseDouble(irTickLabel.getText()));
            double doubleTemp = Double.parseDouble(temp);
            data.getData().add(new XYChart.Data(i, doubleTemp));
            num = doubleTemp;
        }
        return data;
    }

}
