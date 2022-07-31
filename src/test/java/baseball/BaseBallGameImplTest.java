package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameImplTest {
    BaseBallGameImpl bg;

    @BeforeEach
    void init(){
        bg = new BaseBallGameImpl();
    }

    @Test
    @DisplayName("answer 생성 Test")
    void 정답생성(){
        for(int i = 0; i<10; i++)
        {
            bg.generateAnswer();
            System.out.println("bg.getAnswer() = " + bg.getAnswer());
        }
    }

    @Test
    @DisplayName("표준 입력 Test")
    void 표준입력(){
       bg.setAnswer("123");
       b
    }
}