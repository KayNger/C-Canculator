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
            if (arr.stream().count() == 0) {
                return 0;
            }
            return arr.stream().reduce(0, Integer::sum);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void handleCharacter(String input, String[] delimiters) throws Exception {
        ArrayList<String> arrString = new ArrayList<>();
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int delimiterLength = isDelimiter(input, delimiters, i);
            if (delimiterLength > 0) {
                arrString.add(sb.toString());
                sb.setLength(0);
                i = i + delimiterLength - 1;
            } else {
                if (i == input.length() -1 && != sb.toString().isEmpty()) {
                    arrString.add(sb.toString());
                } else {
                    sb.append(c);
                }
            }
        }

        for (String s : arrString) {
            for (Integer i : findNumber(S)) {
                if (i > 1000) i = 0;
                else if (i < 0) {
                    throw new Exception("include all of the negative number provided");
                }
                arr.add(i);
            }
        }
    }

    

}
