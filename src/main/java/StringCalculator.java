public interface StringCalculator {

    int calculateNum(CalculationInfo info);
    int calculateString(String s);
    int getNumFromSubString(String s);
    void checkDivideByZero(CalculationInfo info);
    void checkValidString(String[] values);
    void checkValidOperator(CalculationInfo info);
    void hanldleInvalidNum();
}
