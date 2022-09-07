//package personal.investmentCalculator;
//
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//
//import java.text.DecimalFormat;
//
///**
// * Represents the investment graph trend.
// */
//public class TrendGraph {
//
//    private NumberAxis xAxis;
//    private NumberAxis yAxis;
//    private LineChart<Number, Number> lineChart;
//
//    /**
//     * Creates a Graph with the given yearsToGrow.
//     *
//     * @param yearsToGrow the end of the xAxis.
//     */
//    public TrendGraph(int yearsToGrow) {
//        this.xAxis = new NumberAxis();
//        xAxis.setLabel("Year");
//        //xAxis.setMinorTickVisible(false);
//        this.yAxis = new NumberAxis();
//        yAxis.setLabel("Dollars ($)");
//        //yAxis.setMinorTickVisible(false);
//        this.lineChart = new LineChart<>(xAxis, yAxis);
//        lineChart.setTitle("Savings Calculator");
//    }
//
//    public XYChart.Series addToChart(int startingAmount, int monthlyContribution, double ror, int yearsToGrow) {
//        double num = 0;
//        DecimalFormat df = new DecimalFormat("#.###");
//        XYChart.Series data = new XYChart.Series<>();
//        data.setName("Assets");
//        for (int i = 0; i <= yearsToGrow; i += 1) {
//            double rateOfReturn = (Double.parseDouble(rorField.getText()) / 100) + 1;
//            String temp = df.format((num + 12 * monthlyContribution) * rateOfReturn);
//            double doubleTemp = Double.parseDouble(temp);
//            data.getData().add(new XYChart.Data(i, doubleTemp));
//            num = doubleTemp;
//        }
//        return data;
//
//    }
//
//}
