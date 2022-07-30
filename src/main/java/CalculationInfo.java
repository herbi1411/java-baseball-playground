public class CalculationInfo {
    private int x;
    private int y;
    private String operator;

    public CalculationInfo(int x, String operator, int y) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }
}
