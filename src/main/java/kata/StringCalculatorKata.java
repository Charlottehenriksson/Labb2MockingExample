package kata;

public class StringCalculatorKata {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numberArray = numbers.split(",");
        int sum = 0;
        for (String num : numberArray) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
