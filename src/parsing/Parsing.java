package parsing;

public class Parsing {
    public static Number parseNumber(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input); // 입력 값에 .이 포함되어 있다면 Double로 파싱
        } else {
            return Integer.parseInt(input); // .이 포함되어 있지 않다면 Integer로 파싱
        }
    }
}
