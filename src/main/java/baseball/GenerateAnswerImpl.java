package baseball;

import java.util.HashSet;
import java.util.Set;

public class GenerateAnswerImpl implements GenerateAnswer{
    @Override
    public String generateAnswer() {
        String answer = "";
        Set<Integer> m = new HashSet<>();
        while(m.size() < BaseBallNum.DIGITNUM) {
            double dval = Math.random();
            m.add((int) (dval * 10));
        }
        for(int v: m){
            answer += Integer.toString(v);
        }
        answer = changeZeroStart(answer);
        return answer;
    }

    @Override
    public String changeZeroStart(String answer) {
        if (answer.charAt(0) == '0') {
            int changeIdx = (((int)Math.random() * 10) % 2) + 1;
            char temp;

            char[] carr = answer.toCharArray();
            temp = carr[0];
            carr[0] = carr[changeIdx];
            carr[changeIdx] = temp;
            answer = String.valueOf(carr);
        }
        return answer;
    }
}
