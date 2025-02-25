package parsing;

public class Parsing {
    public static Number parseNumber(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input);
        } else {
            return Integer.parseInt(input);
        }
    }
}
