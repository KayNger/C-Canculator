public class Main {
    public static void main(String[] args) {
        String input = Calculator.readFromInputStream("input.txt");
        String[] delimiters = new String[]{"'"};
        System.out.println(Calculator.calculate(input, delimiters));
    }
}