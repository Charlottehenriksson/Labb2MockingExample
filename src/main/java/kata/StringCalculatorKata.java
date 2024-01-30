package kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorKata {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parts[0].substring(2);
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
}