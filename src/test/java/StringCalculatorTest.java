import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator sc;

    @BeforeEach
    void setUp()
    {
        sc = new StringCalculatorImpl(new CalculatorImpl());
    }

    @Test
    @DisplayName("기본 예제 테스트")
    void 기본예제(){
        String actual =  "2 + 3 * 4 / 2";
        assertThat(sc.calculateString(actual)).isEqualTo(10);
    }

    @Test
    @DisplayName("기본 예제 테스트 2")
    void 기본예제2(){
        String actual =  "2 - 3 * 4 / 2";
        assertThat(sc.calculateString(actual)).isEqualTo(-2);
    }

    @Test
    @DisplayName("0으로 나눌 때")
    void dividedByZero(){
        String actual =  "2 - 3 * 4 / 0";
        assertThatThrownBy(() -> {
            sc.calculateString(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효하지 않은 인자 개수를 줄 때")
    void 유효하지않은인자(){
        String actual =  "2 -";
        assertThatThrownBy(() -> {
            sc.calculateString(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효하지 않은 숫자를 줄 때")
    void 유효하지않은인자2(){
        String actual =  "- - -";
        assertThatThrownBy(() -> {
            sc.calculateString(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효하지 않은 연산자를 줄 때")
    void 유효하지않은연산자(){
        String actual = "3 ^ 3";
        assertThatThrownBy(() -> {
            sc.calculateString(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}