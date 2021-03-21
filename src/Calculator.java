
public class Calculator {
    private Calculator(){}
    public static int calculate(int number1, int number2, char operation){
        int result = 0;
        switch (operation){
            case '+': result = number1 + number2; break;
            case '-': result = number1 - number2; break;
            case '*': result = number1 * number2; break;
            case '/': result = number1 / number2; break;
            default:
        }
        return result;
    }
}
