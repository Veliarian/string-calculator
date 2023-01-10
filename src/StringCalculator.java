import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (!numbers.isEmpty()) {
            if (numbers.contains(",")) {
                return sum(numbers, ",\n");
            } else if (numbers.startsWith("//")) {
                String[] rows = numbers.split("\n");
                return sum(rows[1], rows[0]
                        .replaceAll("[\\//\\[\\]]", ""));
            } else {
                return Integer.parseInt(numbers);
            }
        } else {
            return 0;
        }
    }

    private int sum(String text, String splitter) {
        String[] symbols = text.split("[" + splitter + "]");
        return Arrays.stream(symbols).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
