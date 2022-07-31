package baseball;

public interface CheckUserInput {
    InputCheckInfo checkUserInput(String s, String answer);
    int checkSameNum(char a, char b);
    int checkContainChar(String a, String b);
}
