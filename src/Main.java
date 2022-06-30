public class Main {
    public static void main(String[] args) throws Exception {
        String input = Calculator.readFromInputStream("texf.txt");
        String[] delimiters = new String[]{"'"};
        System.out.println(Calculator.calculate(input, delimiters));
    }
}
