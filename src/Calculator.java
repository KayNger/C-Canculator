import java.io.*;
import java.util.ArrayList;

public class Calculator {
    static ArrayList<Integer> arr = new ArrayList<>();

    public static String readFromInputStream(String path) {
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
           }
            return resultStringBuilder.toString();
        } catch (Exception e) {
            e.toString();
        }
        return "";
    }

    public static int calculate(String input,String[] delimiters) throws Exception {
        handleCharacter(input, delimiters);
        try {

        }
    }
}
