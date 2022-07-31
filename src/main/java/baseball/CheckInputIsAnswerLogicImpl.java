package baseball;

public class CheckInputIsAnswerLogicImpl implements CheckInputIsAnswerLogic{
    @Override
    public Boolean checkInputIsSame(InputCheckInfo info) {
        InputResultView irv = new InputResultViewImpl();
        irv.printResult(info);
        if (info.getStrike() == BaseBallNum.DIGITNUM) {
            GameDoneLogic gdl = new GameDoneLogicImpl();
            return gdl.gameDoneLogic();
        }
        return false;
    }
}
