package baseball;

public interface GameDoneLogic {
    Boolean gameDoneLogic();
    void printRestartGame();
    Boolean handleUserInput();
    int getUserInput();
    void handleUnexpectedInput();
}
