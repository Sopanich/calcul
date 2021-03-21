public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.read();
        int result = Calculator.calculate(reader.getVar1(), reader.getVar2(), reader.getOper());
        System.out.println(result);
        }
    }

