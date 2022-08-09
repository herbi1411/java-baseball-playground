package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ballTest {
    @Test
    void 스트라이크() {
        Ball a = new Ball(0, 1);
        Ball b = new Ball(0, 1);
        assertThat(a.ballStatus(b)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Ball a = new Ball(0, 1);
        Ball b = new Ball(2, 1);
        assertThat(a.ballStatus(b)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 나싱() {
        Ball a = new Ball(0, 1);
        Ball b = new Ball(2, 3);
        assertThat(a.ballStatus(b)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 허용되지않는위치값() {
        assertThatThrownBy(() -> {
            new Ball(4, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 허용되지않는숫자() {
        assertThatThrownBy(() -> {new Ball(0, 0);}).isInstanceOf(IllegalArgumentException.class);
    }
}
