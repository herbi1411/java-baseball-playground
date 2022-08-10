package baseball;

import java.util.Objects;

import static baseball.StaticVariables.*;

public class Ball {
    private final int position;
    private final int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
        if (position < 0 || position >= BALL_NUM)
            throw new IllegalArgumentException("허용된 위치값을 초과했습니다.");
        if (num < MIN_NUM || num > MAX_NUM)
            throw new IllegalArgumentException("허용된 숫자를 초과했습니다.");
    }

    public BallStatus ballStatus(Ball b) {
        if (this.equals(b))
            return BallStatus.STRIKE;
        else if (b.sameNum(num))
            return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    public boolean sameNum(int num){
        return this.num == num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && num == ball.num;
    }
}
