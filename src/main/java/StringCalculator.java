public interface StringCalculator {
    void readLineAndCalculate();
    int calculateNum(CalculationInfo info);
    int calculateString(String s);
    int getNumFromSubString(String s);
    void checkDivideByZero(CalculationInfo info);
    void checkValidString(String[] values);
    void checkValidOperator(CalculationInfo info);
    void hanldleInvalidNum();
}
