package personal.investmentCalculator;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import personal.investmentCalculator.dataFunction.EndBalanceFunction;
import personal.investmentCalculator.dataFunction.TotalContributionFunction;
import personal.investmentCalculator.dataFunction.TotalInterestEarnedFunction;
import personal.investmentCalculator.dataFunction.TriFunction;

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
        xAxis.setTickUnit(1);
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

    public void addBalances(double startingAmount, double contributionAmount, String contributionOption,
                            double rateOfReturn, int yearsToGrow) {
        // if it's monthly change the contribution amount, if it's yearly, we skip
        if (contributionOption.equals("Monthly")) {
            contributionAmount = 12 * contributionAmount;
        }
        XYChart.Series totalContribution = createData("Total Contribution", new TotalContributionFunction(),
                0, contributionAmount, rateOfReturn, yearsToGrow);
//        XYChart.Series totalInterestEarned = createData("Total Interest Earned", new TotalInterestEarnedFunction(),
//                startingAmount, contributionAmount, rateOfReturn, yearsToGrow);
        XYChart.Series endBalance = createData("End Balance", new EndBalanceFunction(),
                startingAmount, contributionAmount, rateOfReturn, yearsToGrow);
        this.getData().addAll(
                totalContribution,
//                totalInterestEarned
                endBalance
        );
    }

    private XYChart.Series createData(String dataName, TriFunction function, double startingAmount,
                                      double contributionAmount, double rateOfReturn, int yearsToGrow) {
        DecimalFormat df = new DecimalFormat("#.###");
        XYChart.Series data = new XYChart.Series();
        data.setName(dataName);
        // if it's the total interest earned, we set the first value to 0
        if (dataName.equals("End Balance")) {
            data.getData().add(new XYChart.Data(0, startingAmount));
        } else {
            data.getData().add(new XYChart.Data(0, 0));
        }
        for (int i = 1; i <= yearsToGrow; i += 1) {
            double convertedRoR = (rateOfReturn / 100) + 1;
            String temp = df.format(function.apply(startingAmount, contributionAmount, convertedRoR));
            double doubleTemp = Double.parseDouble(temp);
            data.getData().add(new XYChart.Data(i, doubleTemp));
            startingAmount = doubleTemp;
        }
        return data;
    }

    // Need to keep track of the end balance so we can subtract to get the interest data
//    private XYChart.Series createInterestData(String dataName, TriFunction endBalanceFunction,
//                                              TriFunction totalContributionFunction, TriFunction interestFunction,
//                                              double startingAmount, double contributionAmount,
//                                              double rateOfReturn, int yearsToGrow) {
//        DecimalFormat df = new DecimalFormat("#.###");
//        XYChart.Series data = new XYChart.Series();
//        data.setName(dataName);
//        data.getData().add(new XYChart.Data(0, 0));
//        for (int i = 1; i <= yearsToGrow; i += 1) {
//            double convertedRoR = (rateOfReturn / 100) + 1;
//            double endBalance = Double.parseDouble(df.format(endBalanceFunction.apply(startingAmount, contributionAmount, convertedRoR)));
//            double totalContribution =
//            double interest = Double.parseDouble(df.format(endBalanceFunction.apply(endBalance, contributionAmount, convertedRoR)));
//            data.getData().add(new XYChart.Data(i, doubleTemp));
//            startingAmount = doubleTemp;
//        }
//        return data;
//    }

}
