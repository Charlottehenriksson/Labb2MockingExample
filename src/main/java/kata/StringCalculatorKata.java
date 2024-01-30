package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculatorKata {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parseDelimiter(parts[0].substring(2));
            String[] numberArray = parts[1].split(delimiter);


            for (String num : numberArray) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negatives.add(n);
                } else if (n <= 1000) {
                    sum += n;
                }
            }
        } else {
            String[] numberArray = numbers.split("[,\n]");

            for (String num : numberArray) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negatives.add(n);
                } else if (n <= 1000) {
                    sum += n;
                }
            }

        }

            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("negatives not allowed: " + negatives);
            }
            return sum;
    }

    private String parseDelimiter(String delimiterPart) {
        if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
            StringBuilder regex = new StringBuilder();
            String[] delimiters = delimiterPart.substring(1, delimiterPart.length() - 1).split("\\]\\[");

            for (String delim : delimiters) {
                regex.append(Pattern.quote(delim)).append("|");
            }

            return regex.toString().substring(0, regex.length() - 1);
        } else {

            return Pattern.quote(delimiterPart);
        }
    }
}