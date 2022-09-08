package personal.investmentCalculator.dataFunction;

public class TotalInterestEarnedFunction implements TriFunction<Double, Double, Double, Double> {
    @Override
    public Double apply(Double endBalance, Double contributionAmount, Double rateOfReturn) {
        return (endBalance + contributionAmount) * rateOfReturn - (endBalance + contributionAmount);
    }
}
