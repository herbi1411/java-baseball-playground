package baseball;

public class Ball {
    private final int position;
    private final int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
        if (position < 0 || position > 2)
            throw new IllegalArgumentException("허용된 위치값을 초과했습니다.");
        if (num < 1 || num > 9)
            throw new IllegalArgumentException("허용된 숫자를 초과했습니다.");
    }

    public BallStatus ballStatus(Ball b) {
        if (this.position == b.getPosition() && this.num == b.getNum())
            return BallStatus.STRIKE;
        else if (this.num == b.getNum())
            return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    public int getPosition() {
        return position;
    }

    public int getNum() {
        return num;
    }
}
