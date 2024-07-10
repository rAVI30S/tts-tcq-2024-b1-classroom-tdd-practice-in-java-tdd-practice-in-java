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

        String delimiter = parseDelimiter(input);
        String numbersStr = extractNumbersString(input, delimiter);

        String[] numbers = splitNumbers(numbersStr, delimiter);
        List<Integer> validNumbers = extractValidNumbers(numbers);

        handleNegatives(validNumbers);

        return calculateSum(validNumbers);
    }

    private String parseDelimiter(String input) {
        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//\\[(.*?)\\]\n").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
            }
        }
        return delimiter;
    }

    private String extractNumbersString(String input, String delimiter) {
        String numbersStr = input;
        if (input.startsWith("//")) {
            numbersStr = input.substring(input.indexOf("\n") + 1);
        }
        return numbersStr.replaceAll("\\[.*?]", delimiter);
    }

    private String[] splitNumbers(String numbersStr, String delimiter) {
        return numbersStr.split(delimiter);
    }

    private List<Integer> extractValidNumbers(String[] numbers) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String num : numbers) {
            int n = Integer.parseInt(num);
            if (n <= 1000) {
                validNumbers.add(n);
            }
        }
        return validNumbers;
    }

    private void handleNegatives(List<Integer> numbers) {
        List<Integer> negatives = findNegatives(numbers);

        if (!negatives.isEmpty()) {
            throwNegativeException(negatives);
        }
    }

    private List<Integer> findNegatives(List<Integer> numbers) {
        List<Integer> negatives = new ArrayList<>();
        for (int num : numbers) {
            if (num < 0) {
                negatives.add(num);
            }
        }
        return negatives;
    }

    private void throwNegativeException(List<Integer> negatives) {
        throw new IllegalArgumentException("Negatives not allowed: " + negatives);
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
