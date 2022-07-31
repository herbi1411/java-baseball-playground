package baseball;

public class InputResultViewImpl implements InputResultView{
    @Override
    public void printResult(InputCheckInfo info) {
        if (info.getStrike() > 0 && info.getBall() == 0)
            System.out.println(info.getStrike() + "스트라이크");
        else if (info.getStrike() > 0 && info.getBall() > 0)
            System.out.println(info.getStrike() + "스트라이크 " + info.getBall() + "볼");
        else if (info.getStrike() == 0 && info.getBall() > 0)
            System.out.println(info.getBall() + "볼");
        else if (info.getStrike() == 0 && info.getBall() == 0)
            printOut();
    }

    @Override
    public void printOut() {
        System.out.println("아웃입니다.");
    }
}
