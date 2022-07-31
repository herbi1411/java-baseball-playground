package baseball;

public interface UserInput {
    void inputView();
    String getInput();
    Boolean validateUserInput(String input);
    Boolean validateUserInputContainsOnlyNumber(String input);
    void requestCorrectNumberView();
}
