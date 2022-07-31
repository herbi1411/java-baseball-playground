package baseball;

import java.util.Scanner;

public class GameDoneLogicImpl implements GameDoneLogic {

    private Boolean gameContinue;
    private Scanner scanner;

    public GameDoneLogicImpl(){
        scanner = new Scanner(System.in);
    }

    @Override
    public Boolean gameDoneLogic() {
        Boolean flag = true;

        while(flag)
        {
            printRestartGame();
            flag = handleUserInput();
        }
        return this.gameContinue;
    }

    @Override
    public void printRestartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public Boolean handleUserInput() {
        int userInput = -1;

        printRestartGame();
        userInput = getUserInput();
        if (userInput != BaseBallNum.GAMECONTINUE && userInput != BaseBallNum.GAMESTOP)
        {
            handleUnexpectedInput();
            return true;
        }
        else if (userInput == BaseBallNum.GAMECONTINUE)
            this.gameContinue = true;
        else if (userInput == BaseBallNum.GAMESTOP)
            this.gameContinue = false;
        return false;
    }

    @Override
    public int getUserInput() {
        int input = scanner.nextInt();
        return input;
    }

    @Override
    public void handleUnexpectedInput() {
        System.out.println("0 또는 1을 입력해주세요");
    }
}
