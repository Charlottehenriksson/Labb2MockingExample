package kata;

public class StringCalculatorKata {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n",2);
            String delimiter = parts[0].substring(2);
            String[] numberArray = parts[1].split(delimiter);
            int sum = 0;
            for (String num : numberArray) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }

        String[] numberArray = numbers.split("[,\n]");
        int sum = 0;
        for (String num : numberArray) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
