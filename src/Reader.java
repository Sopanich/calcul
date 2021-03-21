import java.util.Scanner;

public class Reader {


    private int number1;
    private int number2;
    private char operation;

    public void read() {

        Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] temp = text.split(" ");

        boolean flag = false;
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(temp[0]) || roman[i].equals(temp[2])) {
                flag = true;
                break;
            }
        }

        if (flag) {
            number1 = romanToNumber(temp[0]);
            operation = temp[1].charAt(0);
            number2 = romanToNumber(temp[2]);
            Reader reader = new Reader();
            int result = Calculator.calculate(getVar1(), getVar2(), getOper());
            String s = reader.IntegerToRomanNumeral(result);
            System.out.println(s);
            System.exit(0);
        } else {
            number1 = Integer.parseInt(temp[0]);
            operation = temp[1].charAt(0);
            number2 = Integer.parseInt(temp[2]);
        }
        if ((number1 > 10 || number1 < 1) || (number2 > 10 || number2 < 1)) {
            throw new IllegalArgumentException("Неверный ввод данных");

        }

        boolean flag2 = false;
        for (int i = 0; i < roman.length; i++) {
            if ((roman[i].equals(temp[0]) && arabic[i].equals(temp[2])) || (roman[i].equals(temp[2]) && arabic[i].equals(temp[0]))) {
                flag2 = true;
                break;
            }
        }
        if (flag2){
            throw new IllegalArgumentException("Неверный ввод данных");
        }
    }
    private static int romanToNumber(String roman){
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };

    }
    public int getVar1() {
        return number1;
    }
    public int getVar2() {
        return number2;
    }
    public char getOper() {
        return operation;
    }
    public static String IntegerToRomanNumeral(int input) {

        String s = "";
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
}
