package TddPracticeInJava;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // Default delimiter is comma or newline
        String delimiter = ",|\n";
        String numbersStr = input;

        // Check if custom delimiter is specified
        if (input.startsWith("//")) {
            // Extract delimiter
            Matcher matcher = Pattern.compile("//(.*?)\n").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbersStr = input.substring(input.indexOf("\n") + 1);
            }
        }

        // Split the numbers using delimiter
        String[] numbers = numbersStr.split(delimiter);

        // Handle negatives and sum calculation
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String num : numbers) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                negatives.add(n);
            } else if (n <= 1000) {
                sum += n;
            }
        }

        // Throw exception for negatives
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }
}

