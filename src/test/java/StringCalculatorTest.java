import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator sc;

    @BeforeEach
    void setUp()
    {
        sc = new StringCalculatorImpl(new CalculatorImpl());

    }


    String setStream(@NotNull String ip){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(ip.getBytes());
        System.setIn(in);
        sc.readLineAndCalculate();
        return out.toString();
    }

    @Test
    @DisplayName("기본 예제 테스트")
    void 기본예제(){
        String actual =  "2 + 3 * 4 / 2";
        assertThat(setStream(actual)).isEqualTo("10");
    }

    @Test
    @DisplayName("기본 예제 테스트 2")
    void 기본예제2(){
        String actual =  "2 - 3 * 4 / 2";
        assertThat(setStream(actual)).isEqualTo("-2");
    }

    @Test
    @DisplayName("0으로 나눌 때")
    void dividedByZero(){
        String actual =  "2 - 3 * 4 / 0";
        assertThatThrownBy(() -> {
            setStream(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효하지 않은 인자 개수를 줄 때")
    void 유효하지않은인자(){
        String actual =  "2 -";
        assertThatThrownBy(() -> {
            setStream(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효하지 않은 숫자를 줄 때")
    void 유효하지않은인자2(){
        String actual =  "- - -";
        assertThatThrownBy(() -> {
            setStream(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효하지 않은 연산자를 줄 때")
    void 유효하지않은연산자(){
        String actual = "3 ^ 3";
        assertThatThrownBy(() -> {
            setStream(actual);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}