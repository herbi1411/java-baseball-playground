package baseball;

public class BaseBallGameImpl implements BaseBallGame{

    private String answer;


    @Override
    public void generateAnswer() {
        GenerateAnswer ga = new GenerateAnswerImpl();
        this.answer = ga.generateAnswer();
    }

    @Override
    public void playGame() {

        UserInput ui = new UserInputImpl();
        CheckUserInput cui = new CheckUserInputImpl();
        String temp = "";
        Boolean flag = true;
        InputResultView irv = new InputResultViewImpl();
        CheckInputIsAnswerLogic ciial = new CheckInputIsAnswerLogicImpl();

        while(flag){
            generateAnswer();
            temp = ui.getInput();
            InputCheckInfo info = cui.checkUserInput(temp, answer);
            flag = ciial.checkInputIsSame(info);
        }
    }

    @Override
    public Boolean gameDone() {
        return null;
    }

    public String getAnswer() {
        return answer;
    }

    //test
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
