package baseball;

public class CheckUserInputImpl implements CheckUserInput{

    @Override
    public InputCheckInfo checkUserInput(String s, String answer) {
        int strike = 0;
        int ball = 0;
        char[] sarr = s.toCharArray();
        char[] ansarr = answer.toCharArray();
        for (int i = 0; i< sarr.length; i++) {
            strike += checkSameNum(sarr[i], ansarr[i]);
            ball += checkContainChar(s.substring(i, i + 1), answer);
        }
        ball -= strike;
        InputCheckInfo info = new InputCheckInfo(strike, ball);
        return info;
    }

    @Override
    public int checkSameNum(char a, char b) {
        if (a == b)
            return 1;
        return 0;
    }

    @Override
    public int checkContainChar(String a, String b) {
        if (b.contains(a))
            return 1;
        return 0;
    }
}
