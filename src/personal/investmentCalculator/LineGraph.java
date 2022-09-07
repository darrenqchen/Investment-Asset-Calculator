package personal.investmentCalculator;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.text.DecimalFormat;

/**
 * Represents a line graph.
 */
public class LineGraph extends LineChart{

    private NumberAxis xAxis;
    private NumberAxis yAxis;

    private LineGraph(NumberAxis x, NumberAxis y) {
        super(x, y);
        this.setTitle("Savings Calculator");
        this.xAxis = x;
        xAxis.setLabel("Year");
        xAxis.setMinorTickVisible(false);
        this.yAxis = y;
        yAxis.setLabel("Dollars ($)");
        yAxis.setMinorTickVisible(false);
    }
    
    /**
     * Creates LineGraph with the graph initialized.
     */
    public LineGraph() {
        this(new NumberAxis(), new NumberAxis());
    }

    public void setXAxis(int num) {
        xAxis.setUpperBound(num);
    }

    public void addEndBalance(int startingAmount, int monthlyContribution, double ror, int yearsToGrow) {
        double num = startingAmount;
        DecimalFormat df = new DecimalFormat("#.###");
        XYChart.Series data = new XYChart.Series();
        data.setName("Assets");
        data.getData().add(new XYChart.Data(0, startingAmount));
        for (int i = 1; i <= yearsToGrow; i += 1) {
            double rateOfReturn = (ror / 100) + 1;
            String temp = df.format((num + 12 * monthlyContribution) * rateOfReturn);
            double doubleTemp = Double.parseDouble(temp);
            data.getData().add(new XYChart.Data(i, doubleTemp));
            num = doubleTemp;
        }
        this.getData().add(data);
    }

}
