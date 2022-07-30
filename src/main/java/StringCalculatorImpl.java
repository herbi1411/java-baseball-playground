import java.util.Scanner;

public class StringCalculatorImpl implements  StringCalculator{

    private Calculator calculator;
    public StringCalculatorImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void readLineAndCalculate() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.print(calculateString(s));
        scanner.close();
    }

    @Override
    public int calculateNum(CalculationInfo info) {
        if (info.getOperator().equals("*"))
            return calculator.multiply(info.getX(), info.getY());
        else if (info.getOperator().equals("+"))
            return calculator.add(info.getX(), info.getY());
        else if (info.getOperator().equals("-"))
            return calculator.subtract(info.getX(), info.getY());
        else if (info.getOperator().equals("/")){
            checkDivideByZero(info);
            return calculator.divide(info.getX(), info.getY());
        }
        return -1;
    }

    @Override
    public int calculateString(String s) {
        int ans;
        String[] values = s.split(" ");

        checkValidString(values);
        ans = getNumFromSubString(values[0]);
        for(int i = 1; i < values.length; i+=2){
            CalculationInfo ci = new CalculationInfo(ans, values[i], getNumFromSubString(values[i + 1]));
            checkValidOperator(ci);
            ans = calculateNum(ci);
        }

        return ans;
    }

    @Override
    public int getNumFromSubString(String s) {
        int rt = 0;
        try{
            rt = Integer.parseInt(s);
        }catch(NumberFormatException e){
            hanldleInvalidNum();
        }
        return rt;
    }

    @Override
    public void checkDivideByZero(CalculationInfo info) {
        if (info.getY() == 0 && info.getOperator().equals("/")) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    @Override
    public void checkValidString(String[] values) {
        if (values.length % 2 == 0)
            throw new IllegalArgumentException("유효하지 않은 인자 갯수입니다.");
    }

    @Override
    public void checkValidOperator(CalculationInfo info) {
        String operators = "+-*/";
        if (operators.contains(info.getOperator()) == false)
            throw new IllegalArgumentException("유효하지 않은 연산자 입니다.");
    }

    @Override
    public void hanldleInvalidNum() {
        throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
    }


    public static void main(String[] args) {
        StringCalculator sc = new StringCalculatorImpl(new CalculatorImpl());
        sc.readLineAndCalculate();
    }

}
