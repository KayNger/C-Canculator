import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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


    public static int calculate(String input, String[] delimiters) {
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

    private static void handleCharacter(String input, String[] delimiters) {
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
                if (i = input.length() - 1 && ! sb.toString().isEmpty()) {
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
                    throw new Exception("includes all of the negative numbers provided");
                }
                arr.add(i);
            }
        }
    }

    private static List<Integer> findNumber(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(stringToSearch);
        ArrayList<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }
        List<Integer> arrInteger = new ArrayList<>();
        for (String s : integerList) {
            arrInteger.add(Integer.parseInt(s));
        }
        return arrInteger;
    }


    private static int isDelimiter(String input, String delimiters, int i) {
        if (delimiters.length() > input.length() - i) {
            return 0;
        }
        int index = 0;
        for (int j = i; j < input.length(); j++) {
            if (input.charAt(j) != delimiters.charAt(index))
                return 0;
            index++;
            if (delimiters.length() == index)
                return delimiters.length();
        }
        return delimiters.length();
    }

}
