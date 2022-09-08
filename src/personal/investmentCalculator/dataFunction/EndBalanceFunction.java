package personal.investmentCalculator.dataFunction;

public class EndBalanceFunction implements TriFunction<Double, Double, Double, Double> {

    @Override
    public Double apply(Double startingAmount, Double contributionAmount, Double rateOfReturn) {
        return (startingAmount + contributionAmount) * rateOfReturn;
    }
}
