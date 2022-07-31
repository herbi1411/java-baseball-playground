package baseball;

import java.util.Scanner;

public class UserInputImpl implements UserInput{
    private Scanner scanner;

    public UserInputImpl(){
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void inputView() {
        System.out.println("숫자를 입력해 주세요 :");
        String input = getInput();

    }

    @Override
    public String getInput() {

        String input = "";
        Boolean flag = true;
        while (flag){
            inputView();
            input = scanner.nextLine();
            flag = validateUserInput(input);
        }

        return input;
    }

    @Override
    public Boolean validateUserInput(String input) {
        Boolean flag = true;
        if (input.length() != 3)
            flag = false;
        else if (input.charAt(0) == '0')
            flag = false;
        else if (validateUserInputContainsOnlyNumber(input) == false)
            flag = false;
        if (flag == false)
            requestCorrectNumberView();
        return flag;

    }

    @Override
    public Boolean validateUserInputContainsOnlyNumber(String input) {
        try{
            Integer.parseInt(input);
        }catch(IllegalStateException e){
            throw new IllegalArgumentException("Hi~~!");
        }
        return true;
    }

    @Override
    public void requestCorrectNumberView() {
        System.out.println("올바른 숫자를 입력해주세요.");
    }
}
