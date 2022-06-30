import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
            for (Integer i : findNumber(s)) {
                if (i > 1000) i = 0;
                else if (i < 0) {
                    throw new Exception("include all of the negative number provided");
                }
                arr.add(i);
            }
        }
    }

    private static int isDelimiter(String input, String[] delimiters, int i) {
        for (String delimiter : delimiters) {
            int deLength = isDelimiter(input, delimiters, i);
            if (deLength > 0)
                return deLength;
        }
        return 0;
    }

    private static int isDelimiter(String input, String delimiter, int i) {
        if (delimiter.length() > input.length() - i) {
            return 0;
        }
        int index = 0;
        for (int j = i; j < input.length(); j++) {
            if (input.charAt(j) != delimiter.charAt(index))
                return 0;
            index++;
            if (delimiter.length() == index)
                return delimiter.length();
        }
        return delimiter.length();
    }

}
